package com.bioxx.tfc.Blocks.Terrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.bioxx.tfc.Blocks.BlockTerraContainer;
import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Core.TFC_Sounds;
import com.bioxx.tfc.Entities.EntityFallingBlockTFC;
import com.bioxx.tfc.TileEntities.TEPartial;
import com.bioxx.tfc.api.Enums.TFCDirection;
import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.TFCOptions;
import com.bioxx.tfc.api.Util.ByteCoord;
import com.bioxx.tfc.api.Util.CollapseData;
import com.bioxx.tfc.api.Util.CollapseList;

public class BlockCollapsible extends BlockTerraContainer {

    public Block dropBlock;
    public static boolean fallInstantly;

    protected BlockCollapsible(Material material, Block block) {
        super(material);
        this.dropBlock = block;
        this.setCreativeTab(TFCTabs.TFC_BUILDING);
    }

    protected BlockCollapsible(Material material) {
        super(material);
        this.dropBlock = Blocks.air;
        this.setCreativeTab(TFCTabs.TFC_BUILDING);
    }

    public int[] getDropBlock(World world, int x, int y, int z) {
        int[] data = new int[2];
        data[0] = Block.getIdFromBlock(dropBlock);
        data[1] = world.getBlockMetadata(x, y, z);
        return data;
    }

    public static boolean canFallBelow(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        if (block.isAir(world, x, y, z)) return true;
        if (block == Blocks.fire) return true;
        if (block == TFCBlocks.tallGrass) return true;
        if (block == TFCBlocks.torch) return true;
        if (block == TFCBlocks.smokeRack) return true;
        if (block == TFCBlocks.toolRack) return true;

        if (block == Blocks.bedrock) return false;
        if (block == TFCBlocks.charcoal) return false;
        if (block == TFCBlocks.molten) return false;

        if (!block.isOpaqueCube() && !block.renderAsNormalBlock() && !world.isSideSolid(x, y, z, ForgeDirection.UP))
            return true;

        Material material = block.getMaterial();
        return material == Material.water || material == Material.lava;
    }

    public void dropCarvedStone(World world, int x, int y, int z) {
        if (world.getBlock(x + 1, y, z)
            .isOpaqueCube()) return;
        else if (world.getBlock(x - 1, y, z)
            .isOpaqueCube()) return;
        else if (world.getBlock(x, y, z + 1)
            .isOpaqueCube()) return;
        else if (world.getBlock(x, y, z - 1)
            .isOpaqueCube()) return;
        else if (world.getBlock(x, y + 1, z)
            .isOpaqueCube()) return;
        else if (world.getBlock(x, y - 1, z)
            .isOpaqueCube()) return;

        dropBlockAsItem(world, x, y, z, new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
        world.setBlockToAir(x, y, z);
    }

    /*
     * public Boolean hasNaturalSupport(World world, int x, int y, int z)
     * {
     * //Make sure that the block beneath the one we're checking is not a solid, if it is then return true and don't
     * waste time here.
     * if(!world.isAirBlock(x, y - 1, z))
     * return true;
     * if(world.getBlock(x + 1, y, z).isOpaqueCube())
     * {
     * if(world.getBlock(x + 1, y - 1, z).isOpaqueCube() && world.getBlock(x + 1, y - 2, z).isOpaqueCube())
     * return true;
     * }
     * if(world.getBlock(x - 1, y, z).isOpaqueCube())
     * {
     * if(world.getBlock(x - 1, y - 1, z).isOpaqueCube() && world.getBlock(x - 1, y - 2, z).isOpaqueCube())
     * return true;
     * }
     * if(world.getBlock(x, y, z + 1).isOpaqueCube())
     * {
     * if(world.getBlock(x, y - 1, z + 1).isOpaqueCube() && world.getBlock(x, y - 2, z + 1).isOpaqueCube())
     * return true;
     * }
     * if(world.getBlock(x, y, z - 1).isOpaqueCube())
     * {
     * if(world.getBlock(x, y - 1, z - 1).isOpaqueCube() && world.getBlock(x, y - 2, z - 1).isOpaqueCube())
     * return true;
     * }
     * //Diagonals
     * if(world.getBlock(x + 1, y, z - 1).isOpaqueCube())
     * {
     * if(world.getBlock(x + 1, y - 1, z - 1).isOpaqueCube())
     * return true;
     * }
     * if(world.getBlock(x - 1, y, z - 1).isOpaqueCube())
     * {
     * if(world.getBlock(x - 1, y - 1, z - 1).isOpaqueCube())
     * return true;
     * }
     * if(world.getBlock(x + 1, y, z + 1).isOpaqueCube())
     * {
     * if(world.getBlock(x + 1, y - 1, z + 1).isOpaqueCube())
     * return true;
     * }
     * if(world.getBlock(x - 1, y, z + 1).isOpaqueCube())
     * {
     * if(world.getBlock(x - 1, y - 1, z + 1).isOpaqueCube())
     * return true;
     * }
     * return false;
     * }
     */

    public static void updateTickCollapsible(World world, int i, int j, int k, Random random, Block us,
        boolean checkForSupport) {
        if (world.isRemote) return;

        if (canFallBelow(world, i, j - 1, k)) {
            if (checkForSupport && isNearSupport(world, i, j, k, 4, 0)) return; // Inside the if so it's only called
                                                                                // when needed.
            tryToFall(world, i, j, k, us);
            return;
        }

        int airSides = 0;
        boolean sides[] = new boolean[4];

        if (world.isAirBlock(i + 1, j, k)) {
            airSides++;
            if (canFallBelow(world, i + 1, j - 1, k)) sides[0] = true;
        }
        if (world.isAirBlock(i, j, k + 1)) {
            airSides++;
            if (canFallBelow(world, i, j - 1, k + 1)) sides[1] = true;
        }
        if (world.isAirBlock(i - 1, j, k)) {
            airSides++;
            if (canFallBelow(world, i - 1, j - 1, k)) sides[2] = true;
        }
        if (world.isAirBlock(i, j, k - 1)) {
            airSides++;
            if (canFallBelow(world, i, j - 1, k - 1)) sides[3] = true;
        }

        if (airSides > 2 && (sides[0] || sides[1] || sides[2] || sides[3])) {
            if (checkForSupport && isNearSupport(world, i, j, k, 4, 0)) return; // Inside the if so it's only called
                                                                                // when needed.
            int meta = world.getBlockMetadata(i, j, k);
            world.setBlockToAir(i, j, k);
            int rng = random.nextInt(4); // Pick a random number (0->3)
            while (!sides[rng]) // Pick the next side that is available.
            {
                rng = (rng + 1) % 4;
            }
            switch (rng) {
                case 0: {
                    world.setBlock(i + 1, j, k, us, meta, 0x2);
                    tryToFall(world, i + 1, j, k, us);
                    break;
                }
                case 1: {
                    world.setBlock(i, j, k + 1, us, meta, 0x2);
                    tryToFall(world, i, j, k + 1, us);
                    break;
                }
                case 2: {
                    world.setBlock(i - 1, j, k, us, meta, 0x2);
                    tryToFall(world, i - 1, j, k, us);
                    break;
                }
                case 3: {
                    world.setBlock(i, j, k - 1, us, meta, 0x2);
                    tryToFall(world, i, j, k - 1, us);
                    break;
                }
            }
        }
    }

    public static Boolean isNearSupport(World world, int i, int j, int k, int range, float collapseChance) {
        if (world == null) return false; // Adding world null check due to OpenEye NPE report.
        if (!world.doChunksNearChunkExist(i, j, k, range + 1)) return true; // If chunks are not loaded, assume it's
                                                                            // supported.
        for (int y = -1; y <= 1; y++) // This chunk is loaded, shortcut vertical support.
        {
            if (TFC_Core.isVertSupport(world.getBlock(i, j + y, k))) {
                return true;
            }
        }
        for (int x = -range; x <= range; x++) {
            for (int z = -range; z <= range; z++) {
                for (int y = -1; y <= 1; y++) {
                    if (TFC_Core.isHorizSupport(world.getBlock(i + x, j + y, k + z))) {
                        // Might still collapse
                        if (world.rand.nextFloat() < collapseChance / 100f) {
                            world.setBlockToAir(i + x, j + y, k + z);
                        } else {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public Boolean isUnderLoad(World world, int i, int j, int k) {
        for (int x = 1; x <= TFCOptions.minimumRockLoad; x++) {
            if (!world.getBlock(i, j + x, k)
                .isOpaqueCube()) return false;
        }
        return true;
    }

    public Boolean tryToCollapse(World world, int x, int y, int z, float collapseChance) {
        if (world.isRemote) return false;

        int[] drop = getDropBlock(world, x, y, z);
        Block fallingBlock = Block.getBlockById(drop[0]);

        if (fallingBlock == Blocks.air) return false;

        if (world.getBlock(x, y, z) == Blocks.bedrock || world.getBlock(x, y, z) == fallingBlock) return false;

        int fallingBlockMeta = drop[1];
        if (canFallBelow(world, x, y - 1, z) && isUnderLoad(world, x, y, z)
            && !isNearSupport(world, x, y, z, 4, collapseChance)) {
            if (fallingBlock != null) {
                EntityFallingBlockTFC ent = new EntityFallingBlockTFC(
                    world,
                    x + 0.5F,
                    y + 0.5F,
                    z + 0.5F,
                    fallingBlock,
                    fallingBlockMeta);

                // Cobble generated from caving in raw stone has different metadata for different drops/hardness.
                if (this instanceof BlockStone) ent = new EntityFallingBlockTFC(
                    world,
                    x + 0.5F,
                    y + 0.5F,
                    z + 0.5F,
                    fallingBlock,
                    fallingBlockMeta + 8);

                ent.aliveTimer/* fallTime */ = -5000;
                world.spawnEntityInWorld(ent);
                Random r = new Random(x * y + z);
                if (r.nextInt(100) > 90) {
                    world.playSoundAtEntity(ent, TFC_Sounds.FALLININGROCKLONG, 1.0F, 0.8F + (r.nextFloat() / 2));
                }
            }

            if (world.getBlock(x, y, z) instanceof BlockOre && !TFCOptions.enableCaveInsDestroyOre) {
                TFC_Core.setBlockToAirWithDrops(world, x, y, z);
            } else {
                world.setBlockToAir(x, y, z);
            }

            if (world.getBlock(x, y - 1, z) == TFCBlocks.stoneSlabs
                && ((TEPartial) world.getTileEntity(x, y - 1, z)).blockType == this
                && ((TEPartial) world.getTileEntity(x, y - 1, z)).metaID == fallingBlockMeta) {
                world.setBlockToAir(x, y - 1, z);

                if (world.getBlock(x, y - 2, z) == TFCBlocks.stoneSlabs
                    && ((TEPartial) world.getTileEntity(x, y - 2, z)).blockType == this
                    && ((TEPartial) world.getTileEntity(x, y - 2, z)).metaID == fallingBlockMeta) {
                    world.setBlockToAir(x, y - 2, z);

                    if (world.getBlock(x, y - 3, z) == TFCBlocks.stoneSlabs
                        && ((TEPartial) world.getTileEntity(x, y - 3, z)).blockType == this
                        && ((TEPartial) world.getTileEntity(x, y - 3, z)).metaID == fallingBlockMeta)
                        world.setBlockToAir(x, y - 3, z);
                }
            }

            return true;
        }
        return false;
    }

    public static void tryToFall(World world, int x, int y, int z, Block block) {
        if (world.isRemote) return;

        int meta = world.getBlockMetadata(x, y, z);
        if (canFallBelow(world, x, y - 1, z) && y >= 0
            && (block instanceof BlockSand || !isNearSupport(world, x, y, z, 4, 0))) {
            if (!fallInstantly && world.checkChunksExist(x - 32, y - 32, z - 32, x + 32, y + 32, z + 32)) {
                if (!world.isRemote) {
                    EntityFallingBlockTFC entityfallingblock = new EntityFallingBlockTFC(
                        world,
                        x + 0.5F,
                        y + 0.5F,
                        z + 0.5F,
                        block,
                        meta);
                    world.spawnEntityInWorld(entityfallingblock);
                    if (block instanceof BlockCobble) world.playSoundAtEntity(
                        entityfallingblock,
                        TFC_Sounds.FALLININGROCKSHORT,
                        1.0F,
                        0.8F + (world.rand.nextFloat() / 2));
                    else world.playSoundAtEntity(
                        entityfallingblock,
                        TFC_Sounds.FALLININGDIRTSHORT,
                        1.0F,
                        0.8F + (world.rand.nextFloat() / 2));
                }
            } else {
                world.setBlockToAir(x, y, z);

                while (canFallBelow(world, x, y - 1, z) && y > 0) {
                    --y;
                }

                if (y > 0) {
                    world.setBlock(x, y, z, block, meta, 0x2);
                }
            }
        }
    }

    @Override
    public void harvestBlock(World world, EntityPlayer entityplayer, int x, int y, int z, int meta) {
        // float seismicModifier = 0.2f;
        float softModifier = 0.1f;
        // TFCBiome biome = (TFCBiome) world.getBiomeGenForCoords(x, z);
        int finalCollapseRatio = TFCOptions.initialCollapseRatio > 0 ? TFCOptions.initialCollapseRatio : 10; // Set to
                                                                                                             // default
                                                                                                             // if
                                                                                                             // invalid
                                                                                                             // value is
                                                                                                             // entered
                                                                                                             // in
                                                                                                             // config.

        // Make sure that the player gets exhausted from harvesting this block since we override the vanilla method
        if (entityplayer != null) {
            entityplayer.addStat(StatList.mineBlockStatArray[getIdFromBlock(this)], 1);
            entityplayer.addExhaustion(0.075F);
        }

        // If we are in a soft sedimentary rock layer then we increase the chance of a collapse by 10%
        if (this == TFCBlocks.stoneSed) finalCollapseRatio -= finalCollapseRatio * softModifier;

        // First we check the rng to see if a collapse is going to occur
        if (TFCOptions.enableCaveIns && world.rand.nextInt(finalCollapseRatio) == 0) {
            // Now we look for a suitable block nearby to act as the epicenter
            int counter = 0;
            while (counter < 100) {
                int scanX = -4 + world.rand.nextInt(9);
                int scanY = -2 + world.rand.nextInt(5);
                int scanZ = -4 + world.rand.nextInt(9);
                if (world.getBlock(x + scanX, y + scanY, z + scanZ) instanceof BlockCollapsible
                    && ((BlockCollapsible) world.getBlock(x + scanX, y + scanY, z + scanZ))
                        .tryToCollapse(world, x + scanX, y + scanY, z + scanZ, 0)) {
                    triggerCollapse(world, entityplayer, x + scanX, y + scanY, z + scanZ, meta);
                    return;
                }
                counter++;
            }
        }
    }

    /**
     * This is called when a collapse is definitely happening on a block.
     *
     * @param world
     * @param entityplayer
     * @param i
     * @param j
     * @param k
     * @param meta
     */
    public void triggerCollapse(World world, EntityPlayer entityplayer, int i, int j, int k, int meta) {
        // ArrayList<ByteCoord> collapseMap = getCollapseMap(world, i, j, k);
        int height = 4;
        int range = 5 + world.rand.nextInt(31);
        for (int y = -4; y <= 1; y++) {
            for (int x = -range; x <= range; x++) {
                for (int z = -range; z <= range; z++) {
                    double distSqrd = Math.pow(i - (i + x), 2) + Math.pow(j - (j + y), 2) + Math.pow(k - (k + z), 2);

                    if (world.rand.nextInt(100) < TFCOptions.propogateCollapseChance && distSqrd < 1225) {
                        if (world.getBlock(i + x, j + y, k + z) instanceof BlockCollapsible
                            && ((BlockCollapsible) world.getBlock(i + x, j + y, k + z))
                                .tryToCollapse(world, i + x, j + y, k + z, 1)) {
                            int done = 0;
                            while (done < height) {
                                done++;
                                if (world.getBlock(i + x, j + y, k + z) instanceof BlockCollapsible
                                    && world.rand.nextInt(100) < TFCOptions.propogateCollapseChance) {
                                    ((BlockCollapsible) world.getBlock(i + x, j + y, k + z))
                                        .tryToCollapse(world, i + x, j + y + done, k + z, 1);
                                } else {
                                    done = height;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * The coordinates given are the coordinates of the epicenter of the collapse
     *
     * @return This is a list of all coordinates which should collapse vertically, radiating outward from the epicenter
     */
    public List<ByteCoord> getCollapseMap(World world, int i, int j, int k) {
        // int checks = 0;
        ArrayList<ByteCoord> map = new ArrayList<ByteCoord>();
        ArrayList<ByteCoord> checkedmap = new ArrayList<ByteCoord>();
        CollapseList<CollapseData> checkQueue = new CollapseList<CollapseData>();
        final float incrementChance = 2.5f;
        final float incrementChanceDiag = 3.5f;

        int worldX;
        int worldY;
        int worldZ;
        int localX;
        int localY;
        int localZ;
        // We already know that the epicenter is going to collapse so we add it to our final map
        map.add(new ByteCoord(0, 0, 0));
        // Now we add each of the blocks around it so that the initial collapse tries to propogate in each direction
        checkQueue.add(new CollapseData(new ByteCoord(1, 0, 0), TFCOptions.propogateCollapseChance, TFCDirection.EAST));
        checkQueue
            .add(new CollapseData(new ByteCoord(-1, 0, 0), TFCOptions.propogateCollapseChance, TFCDirection.WEST));
        checkQueue
            .add(new CollapseData(new ByteCoord(1, 0, 1), TFCOptions.propogateCollapseChance, TFCDirection.NORTHEAST));
        checkQueue
            .add(new CollapseData(new ByteCoord(1, 0, -1), TFCOptions.propogateCollapseChance, TFCDirection.SOUTHEAST));
        checkQueue
            .add(new CollapseData(new ByteCoord(-1, 0, 1), TFCOptions.propogateCollapseChance, TFCDirection.NORTHWEST));
        checkQueue.add(
            new CollapseData(new ByteCoord(-1, 0, -1), TFCOptions.propogateCollapseChance, TFCDirection.SOUTHWEST));
        checkQueue
            .add(new CollapseData(new ByteCoord(0, 0, 1), TFCOptions.propogateCollapseChance, TFCDirection.SOUTH));
        checkQueue
            .add(new CollapseData(new ByteCoord(0, 0, -1), TFCOptions.propogateCollapseChance, TFCDirection.NORTH));

        while (checkQueue.peek() != null) {
            CollapseData block = checkQueue.peek();
            if (!checkedmap.contains(block) && world.rand.nextFloat() < block.collapseChance / 100f) {
                // checks++;
                // TerraFirmaCraft.log.info("Number of block checks: " + checks + " | Queue Length: " +
                // checkQueue.size());
                worldX = block.coords.x + i;
                worldY = block.coords.y + j;
                worldZ = block.coords.z + k;
                localX = block.coords.x;
                localY = block.coords.y;
                localZ = block.coords.z;
                if (world.isAirBlock(worldX, worldY, worldZ) /* && localY < 4 */) checkQueue.add(
                    checkedmap,
                    new CollapseData(
                        new ByteCoord(localX + 0, localY + 1, localZ + 0),
                        block.collapseChance - incrementChance * 4,
                        TFCDirection.UP));
                else if (world.getBlock(worldX, worldY, worldZ) instanceof BlockCollapsible
                    && ((BlockCollapsible) world.getBlock(worldX, worldY, worldZ))
                        .tryToCollapse(world, worldX, worldY, worldZ, block.collapseChance)) {
                            map.add(block.coords);

                            switch (block.direction) {
                                case NORTH: {
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ - 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.NORTH));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.EAST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX - 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.WEST));
                                    break;
                                }
                                case SOUTH: {
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ + 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.SOUTH));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.EAST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX - 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.WEST));
                                    break;
                                }
                                case EAST: {
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ + 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.SOUTH));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.EAST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ - 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.NORTH));
                                    break;
                                }
                                case WEST: {
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ + 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.SOUTH));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX - 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.WEST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ - 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.NORTH));
                                    break;
                                }
                                case SOUTHEAST: {
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 1, localY + 0, localZ - 1),
                                            block.collapseChance - incrementChanceDiag,
                                            TFCDirection.SOUTHEAST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ + 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.SOUTH));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.EAST));
                                    break;
                                }
                                case SOUTHWEST: {
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX - 1, localY + 0, localZ - 1),
                                            block.collapseChance - incrementChanceDiag,
                                            TFCDirection.SOUTHWEST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ + 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.SOUTH));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX - 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.WEST));
                                    break;
                                }
                                case NORTHEAST: {
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 1, localY + 0, localZ + 1),
                                            block.collapseChance - incrementChanceDiag,
                                            TFCDirection.NORTHEAST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.EAST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ - 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.NORTH));
                                    break;
                                }
                                case NORTHWEST: {
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX - 1, localY + 0, localZ + 1),
                                            block.collapseChance - incrementChanceDiag,
                                            TFCDirection.NORTHWEST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ - 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.NORTH));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX - 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.WEST));
                                    break;
                                }
                                default: {
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.EAST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX - 1, localY + 0, localZ + 0),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.WEST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 1, localY + 0, localZ + 1),
                                            block.collapseChance - incrementChanceDiag,
                                            TFCDirection.NORTHEAST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 1, localY + 0, localZ - 1),
                                            block.collapseChance - incrementChanceDiag,
                                            TFCDirection.SOUTHEAST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX - 1, localY + 0, localZ + 1),
                                            block.collapseChance - incrementChanceDiag,
                                            TFCDirection.NORTHWEST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX - 1, localY + 0, localZ - 1),
                                            block.collapseChance - incrementChanceDiag,
                                            TFCDirection.SOUTHWEST));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ + 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.SOUTH));
                                    checkQueue.add(
                                        checkedmap,
                                        new CollapseData(
                                            new ByteCoord(localX + 0, localY + 0, localZ - 1),
                                            block.collapseChance - incrementChance,
                                            TFCDirection.NORTH));
                                    break;
                                }
                            }
                        }
            }
            checkedmap.add(block.coords);
            checkQueue.removeFirst();
        }
        return map;
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion ex) {
        harvestBlock(world, null, x, y, z, world.getBlockMetadata(x, y, z));
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockAccess w, int x, int y, int z) {
        return false;
    }
}
