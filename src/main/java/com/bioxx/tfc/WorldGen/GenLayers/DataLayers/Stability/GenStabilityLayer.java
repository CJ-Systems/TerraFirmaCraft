package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Stability;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import net.minecraft.world.WorldType;

import com.bioxx.tfc.TerraFirmaCraft;
import com.bioxx.tfc.WorldGen.DataLayer;
import com.bioxx.tfc.WorldGen.GenLayers.GenLayerFuzzyZoomTFC;
import com.bioxx.tfc.WorldGen.GenLayers.GenLayerSmoothTFC;
import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
import com.bioxx.tfc.WorldGen.GenLayers.GenLayerVoronoiZoomTFC;
import com.bioxx.tfc.WorldGen.GenLayers.GenLayerZoomTFC;

public abstract class GenStabilityLayer extends GenLayerTFC {

    public static GenLayerTFC initialize(long par0, WorldType par2WorldType) {
        GenLayerTFC continent = genContinent(par0);
        drawImage(512, continent, "Stability 0");
        continent = GenLayerZoomTFC.magnify(1000L, continent, 2);
        continent = new GenLayerSmoothTFC(1000L, continent);
        drawImage(512, continent, "Stability 1");
        for (int zoomLevel = 0; zoomLevel < 4; ++zoomLevel) {
            continent = new GenLayerZoomTFC(1000 + zoomLevel, continent);
            drawImage(512, continent, "Stability 2-" + zoomLevel);
        }

        GenLayerSmoothTFC finalCont = new GenLayerSmoothTFC(1000L, continent);
        drawImage(512, finalCont, "Stability 3");
        GenLayerVoronoiZoomTFC voronoiZoom = new GenLayerVoronoiZoomTFC(10L, finalCont);
        voronoiZoom.initWorldGenSeed(par0);
        return voronoiZoom;
    }

    public static GenLayerTFC genContinent(long seed) {
        GenLayerTFC continent = new GenLayerStabilityInit(1L + seed);
        continent = new GenLayerFuzzyZoomTFC(2000L, continent);
        // continent = new GenLayerAddIslandTFC(1L, continent);
        continent = new GenLayerZoomTFC(2001L, continent);
        // continent = new GenLayerAddIslandTFC(2L, continent);
        continent = new GenLayerZoomTFC(2002L, continent);
        // continent = new GenLayerAddIslandTFC(3L, continent);
        continent = new GenLayerZoomTFC(2003L, continent);
        // continent = new GenLayerAddIslandTFC(4L, continent);
        return continent;
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
                    int id = DataLayer.layers[ints[x * size + z]].data1;
                    graphics.setColor(Color.getColor("", ((id * 255) << 16) + ((id * 255) << 8) + (id * 255)));
                    graphics.drawRect(x, z, 1, 1);
                }
            }
            TerraFirmaCraft.LOG.info(name + ".bmp");
            ImageIO.write(outBitmap, "BMP", outFile);
        } catch (Exception e) {
            TerraFirmaCraft.LOG.catching(e);
        }
    }

    public GenStabilityLayer(long par1) {
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
