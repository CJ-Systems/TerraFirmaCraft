package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Rock;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.bioxx.tfc.TerraFirmaCraft;
import com.bioxx.tfc.WorldGen.DataLayer;
import com.bioxx.tfc.WorldGen.GenLayers.GenLayerFuzzyZoomTFC;
import com.bioxx.tfc.WorldGen.GenLayers.GenLayerSmoothTFC;
import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
import com.bioxx.tfc.WorldGen.GenLayers.GenLayerVoronoiZoomTFC;
import com.bioxx.tfc.WorldGen.GenLayers.GenLayerZoomTFC;

public abstract class GenRockLayer extends GenLayerTFC {

    public static GenLayerTFC initialize(long par0, DataLayer[] rocks) {
        GenLayerTFC layer = new GenLayerRockInit(1L, rocks);
        drawImage(512, layer, "Rock 0");
        layer = new GenLayerFuzzyZoomTFC(2000L, layer);
        drawImage(512, layer, "Rock 1");
        // layer = new GenLayerAddRock(1L, layer);
        drawImage(512, layer, "Rock 2");
        layer = new GenLayerZoomTFC(2001L, layer);
        // layer = new GenLayerAddRock(2L, layer);
        drawImage(512, layer, "Rock 3");
        layer = new GenLayerZoomTFC(2002L, layer);
        // layer = new GenLayerAddRock(3L, layer);
        drawImage(512, layer, "Rock 4");
        layer = new GenLayerZoomTFC(2003L, layer);
        // layer = new GenLayerAddRock(4L, layer);
        drawImage(512, layer, "Rock 5");
        layer = new GenLayerSmoothTFC(1000L, layer);
        drawImage(512, layer, "Rock 6");
        for (int zoomLevel = 0; zoomLevel < 5; ++zoomLevel) {
            layer = new GenLayerZoomTFC(1000 + zoomLevel, layer);
            drawImage(512, layer, "Rock " + (7 + zoomLevel));
        }

        GenLayerSmoothTFC smoothedLayer = new GenLayerSmoothTFC(1000L, layer);
        GenLayerVoronoiZoomTFC voronoiLayer = new GenLayerVoronoiZoomTFC(10L, smoothedLayer);
        drawImage(512, layer, "Rock Final");
        smoothedLayer.initWorldGenSeed(par0);
        voronoiLayer.initWorldGenSeed(par0);
        return voronoiLayer;
    }

    private static boolean shouldDraw;

    public static void drawImage(int size, GenLayerTFC genlayer, String name) {
        if (!shouldDraw) return;
        try {
            File outFile = new File(name + ".bmp");
            if (outFile.exists()) return;
            int[] ints = genlayer.getInts(0, 0, size, size);
            BufferedImage outBitmap = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = (Graphics2D) outBitmap.getGraphics();
            graphics.clearRect(0, 0, size, size);
            TerraFirmaCraft.LOG.info(name + ".bmp");
            for (int x = 0; x < size; x++) {
                for (int z = 0; z < size; z++) {
                    int id = ints[x * size + z];
                    int color = ((id * 8) << 16) + ((id * 8) << 8) + (id * 8);
                    graphics.setColor(Color.getColor("", color));
                    graphics.drawRect(x, z, 1, 1);
                }
            }
            TerraFirmaCraft.LOG.info(name + ".bmp");
            ImageIO.write(outBitmap, "BMP", outFile);
        } catch (Exception e) {
            TerraFirmaCraft.LOG.catching(e);
        }
    }

    public GenRockLayer(long par1) {
        super(par1);
    }

    /**
     * Initialize layer's local worldGenSeed based on its own baseSeed and the world's global seed (passed in as an
     * argument).
     */
    @Override
    public void initWorldGenSeed(long par1) {
        worldGenSeed = par1;
        if (this.parent != null) parent.initWorldGenSeed(par1);

        worldGenSeed *= worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        worldGenSeed += baseSeed;
        worldGenSeed *= worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        worldGenSeed += baseSeed;
        worldGenSeed *= worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        worldGenSeed += baseSeed;
    }

    /**
     * Initialize layer's current chunkSeed based on the local worldGenSeed and the (x,z) chunk coordinates.
     */
    @Override
    public void initChunkSeed(long par1, long par3) {
        chunkSeed = worldGenSeed;
        chunkSeed *= chunkSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += par1;
        chunkSeed *= chunkSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += par3;
        chunkSeed *= chunkSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += par1;
        chunkSeed *= chunkSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += par3;
    }

    /**
     * returns a LCG pseudo random number from [0, x). Args: int x
     */
    @Override
    protected int nextInt(int par1) {
        int var2 = (int) ((this.chunkSeed >> 24) % par1);
        if (var2 < 0) var2 += par1;

        chunkSeed *= chunkSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += worldGenSeed;
        return var2;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    @Override
    public abstract int[] getInts(int var1, int var2, int var3, int var4);
}
