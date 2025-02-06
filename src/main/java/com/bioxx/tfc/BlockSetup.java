package com.bioxx.tfc;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

import com.bioxx.tfc.Blocks.BlockBloom;
import com.bioxx.tfc.Blocks.BlockCharcoal;
import com.bioxx.tfc.Blocks.BlockCrop;
import com.bioxx.tfc.Blocks.BlockDetailed;
import com.bioxx.tfc.Blocks.BlockFarmland;
import com.bioxx.tfc.Blocks.BlockFireBrick;
import com.bioxx.tfc.Blocks.BlockIngotPile;
import com.bioxx.tfc.Blocks.BlockLogPile;
import com.bioxx.tfc.Blocks.BlockMetalSheet;
import com.bioxx.tfc.Blocks.BlockMetalTrapDoor;
import com.bioxx.tfc.Blocks.BlockMolten;
import com.bioxx.tfc.Blocks.BlockPlanks;
import com.bioxx.tfc.Blocks.BlockPlanks2;
import com.bioxx.tfc.Blocks.BlockSlab;
import com.bioxx.tfc.Blocks.BlockSmoke;
import com.bioxx.tfc.Blocks.BlockSmokeRack;
import com.bioxx.tfc.Blocks.BlockStair;
import com.bioxx.tfc.Blocks.BlockStalactite;
import com.bioxx.tfc.Blocks.BlockSulfur;
import com.bioxx.tfc.Blocks.BlockThatch;
import com.bioxx.tfc.Blocks.BlockWoodConstruct;
import com.bioxx.tfc.Blocks.BlockWoodSupport;
import com.bioxx.tfc.Blocks.BlockWoodSupport2;
import com.bioxx.tfc.Blocks.BlockWorldItem;
import com.bioxx.tfc.Blocks.Devices.BlockAnvil;
import com.bioxx.tfc.Blocks.Devices.BlockBarrel;
import com.bioxx.tfc.Blocks.Devices.BlockBellows;
import com.bioxx.tfc.Blocks.Devices.BlockBlastFurnace;
import com.bioxx.tfc.Blocks.Devices.BlockChestTFC;
import com.bioxx.tfc.Blocks.Devices.BlockCrucible;
import com.bioxx.tfc.Blocks.Devices.BlockEarlyBloomery;
import com.bioxx.tfc.Blocks.Devices.BlockFirepit;
import com.bioxx.tfc.Blocks.Devices.BlockFoodPrep;
import com.bioxx.tfc.Blocks.Devices.BlockForge;
import com.bioxx.tfc.Blocks.Devices.BlockGrill;
import com.bioxx.tfc.Blocks.Devices.BlockHopper;
import com.bioxx.tfc.Blocks.Devices.BlockLargeVessel;
import com.bioxx.tfc.Blocks.Devices.BlockLeatherRack;
import com.bioxx.tfc.Blocks.Devices.BlockLoom;
import com.bioxx.tfc.Blocks.Devices.BlockNestBox;
import com.bioxx.tfc.Blocks.Devices.BlockOilLamp;
import com.bioxx.tfc.Blocks.Devices.BlockPottery;
import com.bioxx.tfc.Blocks.Devices.BlockQuern;
import com.bioxx.tfc.Blocks.Devices.BlockSluice;
import com.bioxx.tfc.Blocks.Devices.BlockSpawnMeter;
import com.bioxx.tfc.Blocks.Devices.BlockStand;
import com.bioxx.tfc.Blocks.Devices.BlockStand2;
import com.bioxx.tfc.Blocks.Devices.BlockToolRack;
import com.bioxx.tfc.Blocks.Devices.BlockWorkbench;
import com.bioxx.tfc.Blocks.Flora.BlockBerryBush;
import com.bioxx.tfc.Blocks.Flora.BlockFlora;
import com.bioxx.tfc.Blocks.Flora.BlockFlower;
import com.bioxx.tfc.Blocks.Flora.BlockFlower2;
import com.bioxx.tfc.Blocks.Flora.BlockFruitLeaves;
import com.bioxx.tfc.Blocks.Flora.BlockFruitWood;
import com.bioxx.tfc.Blocks.Flora.BlockLogHoriz;
import com.bioxx.tfc.Blocks.Flora.BlockLogHoriz2;
import com.bioxx.tfc.Blocks.Flora.BlockLogNatural;
import com.bioxx.tfc.Blocks.Flora.BlockLogNatural2;
import com.bioxx.tfc.Blocks.Flora.BlockLogVert;
import com.bioxx.tfc.Blocks.Flora.BlockLogVert2;
import com.bioxx.tfc.Blocks.Flora.BlockSapling;
import com.bioxx.tfc.Blocks.Flora.BlockSapling2;
import com.bioxx.tfc.Blocks.Flora.BlockWaterPlant;
import com.bioxx.tfc.Blocks.Liquids.BlockFreshWater;
import com.bioxx.tfc.Blocks.Liquids.BlockHotWater;
import com.bioxx.tfc.Blocks.Liquids.BlockHotWaterStatic;
import com.bioxx.tfc.Blocks.Liquids.BlockLava;
import com.bioxx.tfc.Blocks.Liquids.BlockLiquidStatic;
import com.bioxx.tfc.Blocks.Liquids.BlockSaltWater;
import com.bioxx.tfc.Blocks.Terrain.BlockClay;
import com.bioxx.tfc.Blocks.Terrain.BlockClayGrass;
import com.bioxx.tfc.Blocks.Terrain.BlockDirt;
import com.bioxx.tfc.Blocks.Terrain.BlockDryGrass;
import com.bioxx.tfc.Blocks.Terrain.BlockFungi;
import com.bioxx.tfc.Blocks.Terrain.BlockGrass;
import com.bioxx.tfc.Blocks.Terrain.BlockGravel;
import com.bioxx.tfc.Blocks.Terrain.BlockIgEx;
import com.bioxx.tfc.Blocks.Terrain.BlockIgExBrick;
import com.bioxx.tfc.Blocks.Terrain.BlockIgExCobble;
import com.bioxx.tfc.Blocks.Terrain.BlockIgExSmooth;
import com.bioxx.tfc.Blocks.Terrain.BlockIgIn;
import com.bioxx.tfc.Blocks.Terrain.BlockIgInBrick;
import com.bioxx.tfc.Blocks.Terrain.BlockIgInCobble;
import com.bioxx.tfc.Blocks.Terrain.BlockIgInSmooth;
import com.bioxx.tfc.Blocks.Terrain.BlockMM;
import com.bioxx.tfc.Blocks.Terrain.BlockMMBrick;
import com.bioxx.tfc.Blocks.Terrain.BlockMMCobble;
import com.bioxx.tfc.Blocks.Terrain.BlockMMSmooth;
import com.bioxx.tfc.Blocks.Terrain.BlockMoss;
import com.bioxx.tfc.Blocks.Terrain.BlockOre;
import com.bioxx.tfc.Blocks.Terrain.BlockOre2;
import com.bioxx.tfc.Blocks.Terrain.BlockOre3;
import com.bioxx.tfc.Blocks.Terrain.BlockPeat;
import com.bioxx.tfc.Blocks.Terrain.BlockPeatGrass;
import com.bioxx.tfc.Blocks.Terrain.BlockSand;
import com.bioxx.tfc.Blocks.Terrain.BlockSed;
import com.bioxx.tfc.Blocks.Terrain.BlockSedBrick;
import com.bioxx.tfc.Blocks.Terrain.BlockSedCobble;
import com.bioxx.tfc.Blocks.Terrain.BlockSedSmooth;
import com.bioxx.tfc.Blocks.Vanilla.BlockBed;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomBookshelf;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomButtonWood;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomCactus;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomDoor;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomFenceGate;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomFenceGate2;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomFlowerPot;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomIce;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomLeaves;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomLeaves2;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomLilyPad;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomPumpkin;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomReed;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomSnow;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomTallGrass;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomVine;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomWall;
import com.bioxx.tfc.Blocks.Vanilla.BlockTFCFence;
import com.bioxx.tfc.Blocks.Vanilla.BlockTFCFence2;
import com.bioxx.tfc.Blocks.Vanilla.BlockTorch;
import com.bioxx.tfc.Blocks.Vanilla.BlockTorchOff;
import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Items.ItemBlocks.ItemAnvil1;
import com.bioxx.tfc.Items.ItemBlocks.ItemAnvil2;
import com.bioxx.tfc.Items.ItemBlocks.ItemArmourStand;
import com.bioxx.tfc.Items.ItemBlocks.ItemArmourStand2;
import com.bioxx.tfc.Items.ItemBlocks.ItemBarrels;
import com.bioxx.tfc.Items.ItemBlocks.ItemBellows;
import com.bioxx.tfc.Items.ItemBlocks.ItemBerryBush;
import com.bioxx.tfc.Items.ItemBlocks.ItemChest;
import com.bioxx.tfc.Items.ItemBlocks.ItemCrucible;
import com.bioxx.tfc.Items.ItemBlocks.ItemCustomLilyPad;
import com.bioxx.tfc.Items.ItemBlocks.ItemCustomTallGrass;
import com.bioxx.tfc.Items.ItemBlocks.ItemCustomWood;
import com.bioxx.tfc.Items.ItemBlocks.ItemCustomWood2;
import com.bioxx.tfc.Items.ItemBlocks.ItemCustomWoodH;
import com.bioxx.tfc.Items.ItemBlocks.ItemCustomWoodH2;
import com.bioxx.tfc.Items.ItemBlocks.ItemCustomWoodH3;
import com.bioxx.tfc.Items.ItemBlocks.ItemFence;
import com.bioxx.tfc.Items.ItemBlocks.ItemFence2;
import com.bioxx.tfc.Items.ItemBlocks.ItemFenceGate;
import com.bioxx.tfc.Items.ItemBlocks.ItemFenceGate2;
import com.bioxx.tfc.Items.ItemBlocks.ItemFlora;
import com.bioxx.tfc.Items.ItemBlocks.ItemFlowers;
import com.bioxx.tfc.Items.ItemBlocks.ItemFlowers2;
import com.bioxx.tfc.Items.ItemBlocks.ItemFungi;
import com.bioxx.tfc.Items.ItemBlocks.ItemGrill;
import com.bioxx.tfc.Items.ItemBlocks.ItemLargeVessel;
import com.bioxx.tfc.Items.ItemBlocks.ItemLooms;
import com.bioxx.tfc.Items.ItemBlocks.ItemMetalTrapDoor;
import com.bioxx.tfc.Items.ItemBlocks.ItemOilLamp;
import com.bioxx.tfc.Items.ItemBlocks.ItemSapling;
import com.bioxx.tfc.Items.ItemBlocks.ItemSapling2;
import com.bioxx.tfc.Items.ItemBlocks.ItemSoil;
import com.bioxx.tfc.Items.ItemBlocks.ItemStone;
import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;
import com.bioxx.tfc.Items.ItemBlocks.ItemToolRack;
import com.bioxx.tfc.Items.ItemBlocks.ItemTorch;
import com.bioxx.tfc.Items.ItemBlocks.ItemVine;
import com.bioxx.tfc.Items.ItemBlocks.ItemWoodSupport;
import com.bioxx.tfc.Items.ItemBlocks.ItemWoodSupport2;
import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.TFCFluids;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockSetup extends TFCBlocks {

    public static void registerBlocks() {
        GameRegistry.registerBlock(ore, "Ore1");
        GameRegistry.registerBlock(ore2, "Ore2");
        GameRegistry.registerBlock(ore3, "Ore3");
        GameRegistry.registerBlock(stoneIgIn, ItemStone.class, "StoneIgIn");
        GameRegistry.registerBlock(stoneIgEx, ItemStone.class, "StoneIgEx");
        GameRegistry.registerBlock(stoneSed, ItemStone.class, "StoneSed");
        GameRegistry.registerBlock(stoneMM, ItemStone.class, "StoneMM");

        GameRegistry.registerBlock(stoneIgInCobble, ItemStone.class, "StoneIgInCobble");
        GameRegistry.registerBlock(stoneIgExCobble, ItemStone.class, "StoneIgExCobble");
        GameRegistry.registerBlock(stoneSedCobble, ItemStone.class, "StoneSedCobble");
        GameRegistry.registerBlock(stoneMMCobble, ItemStone.class, "StoneMMCobble");
        GameRegistry.registerBlock(stoneIgInSmooth, ItemStone.class, "StoneIgInSmooth");
        GameRegistry.registerBlock(stoneIgExSmooth, ItemStone.class, "StoneIgExSmooth");
        GameRegistry.registerBlock(stoneSedSmooth, ItemStone.class, "StoneSedSmooth");
        GameRegistry.registerBlock(stoneMMSmooth, ItemStone.class, "StoneMMSmooth");
        GameRegistry.registerBlock(stoneIgInBrick, ItemStone.class, "StoneIgInBrick");
        GameRegistry.registerBlock(stoneIgExBrick, ItemStone.class, "StoneIgExBrick");
        GameRegistry.registerBlock(stoneSedBrick, ItemStone.class, "StoneSedBrick");
        GameRegistry.registerBlock(stoneMMBrick, ItemStone.class, "StoneMMBrick");

        GameRegistry.registerBlock(dirt, ItemSoil.class, "Dirt");
        GameRegistry.registerBlock(dirt2, ItemSoil.class, "Dirt2");
        GameRegistry.registerBlock(sand, ItemSoil.class, "Sand");
        GameRegistry.registerBlock(sand2, ItemSoil.class, "Sand2");
        GameRegistry.registerBlock(clay, ItemSoil.class, "Clay");
        GameRegistry.registerBlock(clay2, ItemSoil.class, "Clay2");
        GameRegistry.registerBlock(grass, ItemSoil.class, "Grass");
        GameRegistry.registerBlock(grass2, ItemSoil.class, "Grass2");
        GameRegistry.registerBlock(clayGrass, ItemSoil.class, "ClayGrass");
        GameRegistry.registerBlock(clayGrass2, ItemSoil.class, "ClayGrass2");
        GameRegistry.registerBlock(peatGrass, ItemSoil.class, "PeatGrass");
        GameRegistry.registerBlock(peat, ItemSoil.class, "Peat");
        GameRegistry.registerBlock(dryGrass, ItemSoil.class, "DryGrass");
        GameRegistry.registerBlock(dryGrass2, ItemSoil.class, "DryGrass2");
        GameRegistry.registerBlock(tallGrass, ItemCustomTallGrass.class, "TallGrass");
        GameRegistry.registerBlock(worldItem, "LooseRock");
        GameRegistry.registerBlock(logPile, "LogPile");
        GameRegistry.registerBlock(charcoal, "Charcoal");
        GameRegistry.registerBlock(detailed, "Detailed");

        GameRegistry.registerBlock(tilledSoil, ItemSoil.class, "tilledSoil");
        GameRegistry.registerBlock(tilledSoil2, ItemSoil.class, "tilledSoil2");

        GameRegistry.registerBlock(woodSupportV, ItemWoodSupport.class, "WoodSupportV");
        GameRegistry.registerBlock(woodSupportH, ItemWoodSupport.class, "WoodSupportH");
        GameRegistry.registerBlock(woodSupportV2, ItemWoodSupport2.class, "WoodSupportV2");
        GameRegistry.registerBlock(woodSupportH2, ItemWoodSupport2.class, "WoodSupportH2");
        GameRegistry.registerBlock(sulfur, "Sulfur");
        GameRegistry.registerBlock(logNatural, ItemCustomWood.class, "log");
        GameRegistry.registerBlock(logNatural2, ItemCustomWood2.class, "log2");
        GameRegistry.registerBlock(leaves, ItemCustomWood.class, "leaves");
        GameRegistry.registerBlock(leaves2, ItemCustomWood2.class, "leaves2");
        GameRegistry.registerBlock(sapling, ItemSapling.class, "sapling");
        GameRegistry.registerBlock(sapling2, ItemSapling2.class, "sapling2");
        GameRegistry.registerBlock(planks, ItemCustomWood.class, "planks");
        GameRegistry.registerBlock(planks2, ItemCustomWood2.class, "planks2");

        GameRegistry.registerBlock(firepit, "Firepit");
        GameRegistry.registerBlock(bellows, ItemBellows.class, "Bellows");
        GameRegistry.registerBlock(anvil, ItemAnvil1.class, "Anvil");
        GameRegistry.registerBlock(anvil2, ItemAnvil2.class, "Anvil2");
        GameRegistry.registerBlock(forge, "Forge");

        GameRegistry.registerBlock(molten, "Molten");
        GameRegistry.registerBlock(blastFurnace, ItemTerraBlock.class, "Bloomery");
        GameRegistry.registerBlock(bloomery, ItemTerraBlock.class, "EarlyBloomery");
        GameRegistry.registerBlock(sluice, "Sluice");
        GameRegistry.registerBlock(bloom, "Bloom");

        GameRegistry.registerBlock(fruitTreeWood, "fruitTreeWood");
        GameRegistry.registerBlock(fruitTreeLeaves, "fruitTreeLeaves");
        GameRegistry.registerBlock(fruitTreeLeaves2, "fruitTreeLeaves2");

        GameRegistry.registerBlock(stoneStairs, "stoneStairs");
        GameRegistry.registerBlock(stoneSlabs, "stoneSlabs");
        GameRegistry.registerBlock(stoneStalac, "stoneStalac");

        GameRegistry.registerBlock(woodConstruct, "WoodConstruct");
        GameRegistry.registerBlock(woodVert, ItemCustomWood.class, "WoodVert");
        GameRegistry.registerBlock(woodVert2, ItemCustomWood2.class, "WoodVert2");
        GameRegistry.registerBlock(woodHoriz, ItemCustomWoodH.class, "WoodHoriz");
        GameRegistry.registerBlock(woodHoriz2, ItemCustomWoodH2.class, "WoodHoriz2");
        GameRegistry.registerBlock(woodHoriz3, ItemCustomWoodH3.class, "WoodHoriz3");
        GameRegistry.registerBlock(woodHoriz4, "WoodHoriz4");

        GameRegistry.registerBlock(toolRack, ItemToolRack.class, "ToolRack");
        GameRegistry.registerBlock(spawnMeter, ItemTerraBlock.class, "SpawnMeter");
        GameRegistry.registerBlock(foodPrep, "FoodPrep");
        GameRegistry.registerBlock(quern, ItemTerraBlock.class, "Quern");
        GameRegistry.registerBlock(wallCobbleIgIn, ItemStone.class, "WallCobbleIgIn");
        GameRegistry.registerBlock(wallCobbleIgEx, ItemStone.class, "WallCobbleIgEx");
        GameRegistry.registerBlock(wallCobbleSed, ItemStone.class, "WallCobbleSed");
        GameRegistry.registerBlock(wallCobbleMM, ItemStone.class, "WallCobbleMM");
        GameRegistry.registerBlock(wallRawIgIn, ItemStone.class, "WallRawIgIn");
        GameRegistry.registerBlock(wallRawIgEx, ItemStone.class, "WallRawIgEx");
        GameRegistry.registerBlock(wallRawSed, ItemStone.class, "WallRawSed");
        GameRegistry.registerBlock(wallRawMM, ItemStone.class, "WallRawMM");
        GameRegistry.registerBlock(wallBrickIgIn, ItemStone.class, "WallBrickIgIn");
        GameRegistry.registerBlock(wallBrickIgEx, ItemStone.class, "WallBrickIgEx");
        GameRegistry.registerBlock(wallBrickSed, ItemStone.class, "WallBrickSed");
        GameRegistry.registerBlock(wallBrickMM, ItemStone.class, "WallBrickMM");
        GameRegistry.registerBlock(wallSmoothIgIn, ItemStone.class, "WallSmoothIgIn");
        GameRegistry.registerBlock(wallSmoothIgEx, ItemStone.class, "WallSmoothIgEx");
        GameRegistry.registerBlock(wallSmoothSed, ItemStone.class, "WallSmoothSed");
        GameRegistry.registerBlock(wallSmoothMM, ItemStone.class, "WallSmoothMM");

        GameRegistry.registerBlock(saltWater, "SaltWater");
        GameRegistry.registerBlock(saltWaterStationary, "SaltWaterStationary");
        GameRegistry.registerBlock(freshWater, "FreshWater");
        GameRegistry.registerBlock(freshWaterStationary, "FreshWaterStationary");
        GameRegistry.registerBlock(hotWater, "HotWater");
        GameRegistry.registerBlock(hotWaterStationary, "HotWaterStationary");
        GameRegistry.registerBlock(lava, "Lava");
        GameRegistry.registerBlock(lavaStationary, "LavaStationary");
        GameRegistry.registerBlock(ice, "Ice");

        GameRegistry.registerBlock(waterPlant, "SeaGrassStill");

        GameRegistry.registerBlock(fireBrick, "FireBrick");
        GameRegistry.registerBlock(metalSheet, "MetalSheet");

        // Wooden Doors
        for (int i = 0; i < Global.WOOD_ALL.length; i++)
            GameRegistry.registerBlock(doors[i], "Door" + Global.WOOD_ALL[i].replaceAll(" ", ""));

        GameRegistry.registerBlock(ingotPile, "IngotPile");
        GameRegistry.registerBlock(barrel, ItemBarrels.class, "Barrel");
        GameRegistry.registerBlock(loom, ItemLooms.class, "Loom");
        GameRegistry.registerBlock(moss, "Moss");

        GameRegistry.registerBlock(flora, ItemFlora.class, "Flora");
        GameRegistry.registerBlock(pottery, "ClayPottery");
        GameRegistry.registerBlock(thatch, ItemTerraBlock.class, "Thatch");
        GameRegistry.registerBlock(crucible, ItemCrucible.class, "Crucible");
        GameRegistry.registerBlock(nestBox, ItemTerraBlock.class, "NestBox");
        GameRegistry.registerBlock(fence, ItemFence.class, "Fence");
        GameRegistry.registerBlock(fence2, ItemFence2.class, "Fence2");
        GameRegistry.registerBlock(fenceGate, ItemFenceGate.class, "FenceGate");
        GameRegistry.registerBlock(fenceGate2, ItemFenceGate2.class, "FenceGate2");
        GameRegistry.registerBlock(strawHideBed, "StrawHideBed");
        GameRegistry.registerBlock(armorStand, ItemArmourStand.class, "ArmourStand");
        GameRegistry.registerBlock(armorStand2, ItemArmourStand2.class, "ArmourStand2");
        GameRegistry.registerBlock(berryBush, ItemBerryBush.class, "BerryBush");
        GameRegistry.registerBlock(crops, "Crops");
        GameRegistry.registerBlock(lilyPad, ItemCustomLilyPad.class, "LilyPad");
        GameRegistry.registerBlock(flowers, ItemFlowers.class, "Flowers");
        GameRegistry.registerBlock(flowers2, ItemFlowers2.class, "Flowers2");
        GameRegistry.registerBlock(fungi, ItemFungi.class, "Fungi");
        GameRegistry.registerBlock(bookshelf, ItemTerraBlock.class, "Bookshelf");
        GameRegistry.registerBlock(torch, ItemTorch.class, "Torch");
        GameRegistry.registerBlock(torchOff, "TorchOff");
        GameRegistry.registerBlock(chest, ItemChest.class, "Chest TFC");
        GameRegistry.registerBlock(workbench, ItemTerraBlock.class, "Workbench");
        GameRegistry.registerBlock(cactus, ItemTerraBlock.class, "Cactus");
        GameRegistry.registerBlock(reeds, "Reeds");
        GameRegistry.registerBlock(pumpkin, ItemTerraBlock.class, "Pumpkin");
        GameRegistry.registerBlock(litPumpkin, ItemTerraBlock.class, "LitPumpkin");
        GameRegistry.registerBlock(buttonWood, "ButtonWood");
        GameRegistry.registerBlock(vine, ItemVine.class, "Vine");
        GameRegistry.registerBlock(leatherRack, "LeatherRack");
        GameRegistry.registerBlock(gravel, ItemSoil.class, "Gravel");
        GameRegistry.registerBlock(gravel2, ItemSoil.class, "Gravel2");

        GameRegistry.registerBlock(grill, ItemGrill.class, "Grill");
        GameRegistry.registerBlock(metalTrapDoor, ItemMetalTrapDoor.class, "MetalTrapDoor");
        GameRegistry.registerBlock(vessel, ItemLargeVessel.class, "Vessel");
        GameRegistry.registerBlock(smoke, "Smoke");
        GameRegistry.registerBlock(smokeRack, "SmokeRack");
        GameRegistry.registerBlock(snow, "Snow");
        GameRegistry.registerBlock(oilLamp, ItemOilLamp.class, "OilLamp");
        GameRegistry.registerBlock(hopper, "Hopper");
        GameRegistry.registerBlock(flowerPot, "FlowerPot");
    }

    public static void loadBlocks() {
        TerraFirmaCraft.LOG.info(
            new StringBuilder().append("Loading Blocks")
                .toString());

        // Remove Items from Creative Tabs
        Blocks.double_wooden_slab.setCreativeTab(null);
        Blocks.wooden_slab.setCreativeTab(null);
        Blocks.spruce_stairs.setCreativeTab(null);
        Blocks.birch_stairs.setCreativeTab(null);
        Blocks.jungle_stairs.setCreativeTab(null);
        Blocks.waterlily.setCreativeTab(null);
        Blocks.tallgrass.setCreativeTab(null);
        Blocks.yellow_flower.setCreativeTab(null);
        Blocks.red_flower.setCreativeTab(null);
        Blocks.brown_mushroom.setCreativeTab(null);
        Blocks.red_mushroom.setCreativeTab(null);
        Blocks.bookshelf.setCreativeTab(null);
        Blocks.torch.setCreativeTab(null);
        Blocks.chest.setCreativeTab(null);
        Blocks.planks.setCreativeTab(null);
        Blocks.crafting_table.setCreativeTab(null);
        Blocks.cactus.setCreativeTab(null);
        Blocks.reeds.setCreativeTab(null);
        Blocks.pumpkin.setCreativeTab(null);
        Blocks.lit_pumpkin.setCreativeTab(null);
        Blocks.wooden_button.setCreativeTab(null);
        Blocks.ice.setCreativeTab(null);
        Blocks.vine.setCreativeTab(null);
        Blocks.flower_pot.setCreativeTab(null);

        bookshelf = new BlockCustomBookshelf().setHardness(1.5F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("Bookshelf")
            .setTextureName("bookshelf");
        torch = new BlockTorch().setHardness(0.0F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("Torch")
            .setTextureName("torch_on");
        torchOff = new BlockTorchOff().setHardness(0.0F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("TorchOff")
            .setTextureName("torch_on");
        chest = new BlockChestTFC().setHardness(2.5F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("Chest");
        workbench = new BlockWorkbench().setHardness(2.5F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("Workbench")
            .setTextureName("crafting_table");
        cactus = new BlockCustomCactus().setHardness(0.4F)
            .setStepSound(Block.soundTypeCloth)
            .setUnlocalizedName("Cactus")
            .setTextureName("cactus");
        reeds = new BlockCustomReed().setHardness(0.0F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("Reeds")
            .setTextureName("reeds");
        pumpkin = new BlockCustomPumpkin(false).setHardness(1.0F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("Pumpkin")
            .setTextureName("pumpkin");
        litPumpkin = new BlockCustomPumpkin(true).setHardness(1.0F)
            .setStepSound(Block.soundTypeWood)
            .setLightLevel(1.0F)
            .setUnlocalizedName("LitPumpkin")
            .setTextureName("pumpkin");
        buttonWood = new BlockCustomButtonWood().setHardness(0.5F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("ButtonWood");
        vine = new BlockCustomVine().setHardness(0.2F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("Vine")
            .setTextureName("vine");

        // This is not used anywhere
        // Block.blockRegistry.addObject(Block.getIdFromBlock(Blocks.oak_stairs), "oak_stairs", (new
        // BlockStair(Material.wood)).setUnlocalizedName("stairsWood"));

        /*
         * Block.blockRegistry.addObject(Block.getIdFromBlock(Blocks.snow_layer), "snow_layer",
         * (new BlockCustomSnow()).setHardness(0.1F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow").
         * setLightOpacity(1).setTextureName("snow"));
         */
        // Snow = (Block)Block.blockRegistry.getObject("snow_layer");
        snow = new BlockCustomSnow().setHardness(0.1F)
            .setStepSound(Block.soundTypeSnow)
            .setUnlocalizedName("snow")
            .setLightOpacity(0)
            .setTextureName("snow");
        Blocks.snow_layer = snow;
        stoneIgInCobble = new BlockIgInCobble(Material.rock).setHardness(16F)
            .setUnlocalizedName("IgInRockCobble");
        stoneIgIn = new BlockIgIn(Material.rock).setHardness(8F)
            .setUnlocalizedName("IgInRock");
        stoneIgInSmooth = new BlockIgInSmooth().setHardness(16F)
            .setUnlocalizedName("IgInRockSmooth");
        stoneIgInBrick = new BlockIgInBrick().setHardness(16F)
            .setUnlocalizedName("IgInRockBrick");

        stoneSedCobble = new BlockSedCobble(Material.rock).setHardness(14F)
            .setUnlocalizedName("SedRockCobble");
        stoneSed = new BlockSed(Material.rock).setHardness(7F)
            .setUnlocalizedName("SedRock");
        stoneSedSmooth = new BlockSedSmooth().setHardness(14F)
            .setUnlocalizedName("SedRockSmooth");
        stoneSedBrick = new BlockSedBrick().setHardness(14F)
            .setUnlocalizedName("SedRockBrick");

        stoneIgExCobble = new BlockIgExCobble(Material.rock).setHardness(16F)
            .setUnlocalizedName("IgExRockCobble");
        stoneIgEx = new BlockIgEx(Material.rock).setHardness(8F)
            .setUnlocalizedName("IgExRock");
        stoneIgExSmooth = new BlockIgExSmooth().setHardness(16F)
            .setUnlocalizedName("IgExRockSmooth");
        stoneIgExBrick = new BlockIgExBrick().setHardness(16F)
            .setUnlocalizedName("IgExRockBrick");

        stoneMMCobble = new BlockMMCobble(Material.rock).setHardness(15F)
            .setUnlocalizedName("MMRockCobble");
        stoneMM = new BlockMM(Material.rock).setHardness(8F)
            .setUnlocalizedName("MMRock");
        stoneMMSmooth = new BlockMMSmooth().setHardness(15F)
            .setUnlocalizedName("MMRockSmooth");
        stoneMMBrick = new BlockMMBrick().setHardness(15F)
            .setUnlocalizedName("MMRockBrick");

        dirt = new BlockDirt(0).setHardness(2F)
            .setStepSound(Block.soundTypeGravel)
            .setUnlocalizedName("dirt");

        dirt2 = new BlockDirt(16).setHardness(2F)
            .setStepSound(Block.soundTypeGravel)
            .setUnlocalizedName("dirt");
        clay = new BlockClay(0).setHardness(3F)
            .setStepSound(Block.soundTypeGravel)
            .setUnlocalizedName("clay");
        clay2 = new BlockClay(16).setHardness(3F)
            .setStepSound(Block.soundTypeGravel)
            .setUnlocalizedName("clay");
        clayGrass = new BlockClayGrass(0).setHardness(3F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("ClayGrass");
        clayGrass2 = new BlockClayGrass(16).setHardness(3F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("ClayGrass");
        grass = new BlockGrass().setHardness(3F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("Grass");
        grass2 = new BlockGrass(16).setHardness(3F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("Grass");
        peat = new BlockPeat().setHardness(3F)
            .setStepSound(Block.soundTypeGravel)
            .setUnlocalizedName("Peat");
        peatGrass = new BlockPeatGrass().setHardness(3F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("PeatGrass");
        dryGrass = new BlockDryGrass(0).setHardness(3F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("DryGrass");
        dryGrass2 = new BlockDryGrass(16).setHardness(3F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("DryGrass");
        tallGrass = new BlockCustomTallGrass().setHardness(0.0F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("TallGrass");
        sand = new BlockSand(0).setHardness(0.5F)
            .setStepSound(Block.soundTypeSand)
            .setUnlocalizedName("sand");
        sand2 = new BlockSand(16).setHardness(0.5F)
            .setStepSound(Block.soundTypeSand)
            .setUnlocalizedName("sand");

        ore = new BlockOre(Material.rock).setHardness(10F)
            .setResistance(10F)
            .setUnlocalizedName("Ore");
        ore2 = new BlockOre2(Material.rock).setHardness(10F)
            .setResistance(10F)
            .setUnlocalizedName("Ore");
        ore3 = new BlockOre3(Material.rock).setHardness(10F)
            .setResistance(10F)
            .setUnlocalizedName("Ore");
        worldItem = new BlockWorldItem().setHardness(0.05F)
            .setResistance(1F)
            .setUnlocalizedName("LooseRock");
        sulfur = new BlockSulfur(Material.rock).setUnlocalizedName("Sulfur")
            .setHardness(0.5F)
            .setResistance(1F);

        logPile = new BlockLogPile().setHardness(10F)
            .setResistance(1F)
            .setUnlocalizedName("LogPile");
        woodSupportV = new BlockWoodSupport(Material.wood).setUnlocalizedName("WoodSupportV")
            .setHardness(0.5F)
            .setResistance(1F);
        woodSupportH = new BlockWoodSupport(Material.wood).setUnlocalizedName("WoodSupportH")
            .setHardness(0.5F)
            .setResistance(1F);
        woodSupportV2 = new BlockWoodSupport2(Material.wood).setUnlocalizedName("WoodSupportV2")
            .setHardness(0.5F)
            .setResistance(1F);
        woodSupportH2 = new BlockWoodSupport2(Material.wood).setUnlocalizedName("WoodSupportH2")
            .setHardness(0.5F)
            .setResistance(1F);

        tilledSoil = new BlockFarmland(TFCBlocks.dirt, 0).setHardness(2F)
            .setStepSound(Block.soundTypeGravel)
            .setUnlocalizedName("tilledSoil");
        tilledSoil2 = new BlockFarmland(TFCBlocks.dirt2, 16).setHardness(2F)
            .setStepSound(Block.soundTypeGravel)
            .setUnlocalizedName("tilledSoil");

        fruitTreeWood = new BlockFruitWood().setUnlocalizedName("fruitTreeWood")
            .setHardness(5.5F)
            .setResistance(2F);
        fruitTreeLeaves = new BlockFruitLeaves(0).setUnlocalizedName("fruitTreeLeaves")
            .setHardness(0.5F)
            .setResistance(1F)
            .setStepSound(Block.soundTypeGrass);
        fruitTreeLeaves2 = new BlockFruitLeaves(8).setUnlocalizedName("fruitTreeLeaves2")
            .setHardness(0.5F)
            .setResistance(1F)
            .setStepSound(Block.soundTypeGrass);

        woodConstruct = new BlockWoodConstruct().setHardness(4F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("WoodConstruct");

        firepit = new BlockFirepit().setUnlocalizedName("Firepit")
            .setHardness(1)
            .setLightLevel(0F);
        bellows = new BlockBellows(Material.wood).setUnlocalizedName("Bellows")
            .setHardness(2);
        forge = new BlockForge().setUnlocalizedName("Forge")
            .setHardness(20)
            .setLightLevel(0F);
        anvil = new BlockAnvil().setUnlocalizedName("Anvil")
            .setHardness(3)
            .setResistance(100F);
        anvil2 = new BlockAnvil(8).setUnlocalizedName("Anvil2")
            .setHardness(3)
            .setResistance(100F);

        molten = new BlockMolten().setUnlocalizedName("Molten")
            .setHardness(20);
        blastFurnace = new BlockBlastFurnace().setUnlocalizedName("BlastFurnace")
            .setHardness(20)
            .setLightLevel(0F);
        bloomery = new BlockEarlyBloomery().setUnlocalizedName("EarlyBloomery")
            .setHardness(20)
            .setLightLevel(0F);
        bloom = new BlockBloom().setUnlocalizedName("Bloom")
            .setHardness(20)
            .setLightLevel(0F);
        sluice = new BlockSluice().setUnlocalizedName("Sluice")
            .setHardness(2F)
            .setResistance(20F);

        stoneStairs = new BlockStair(Material.rock).setUnlocalizedName("stoneStairs")
            .setHardness(10);
        stoneSlabs = new BlockSlab().setUnlocalizedName("stoneSlabs")
            .setHardness(10);
        stoneStalac = new BlockStalactite().setUnlocalizedName("stoneStalac")
            .setHardness(5);

        charcoal = new BlockCharcoal().setHardness(3F)
            .setResistance(10F)
            .setUnlocalizedName("Charcoal");

        detailed = new BlockDetailed().setUnlocalizedName("StoneDetailed")
            .setHardness(10);

        planks = new BlockPlanks(Material.wood).setHardness(4.0F)
            .setResistance(5.0F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("wood");
        planks2 = new BlockPlanks2(Material.wood).setHardness(4.0F)
            .setResistance(5.0F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("wood2");
        leaves = new BlockCustomLeaves().setHardness(0.2F)
            .setLightOpacity(1)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("leaves")
            .setCreativeTab(TFCTabs.TFC_DECORATION);
        leaves2 = new BlockCustomLeaves2().setHardness(0.2F)
            .setLightOpacity(1)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("leaves2");
        sapling = new BlockSapling().setHardness(0.0F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("sapling");
        sapling2 = new BlockSapling2().setHardness(0.0F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("sapling2");

        logNatural = new BlockLogNatural().setHardness(50.0F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("log");
        logNatural2 = new BlockLogNatural2().setHardness(50.0F)
            .setStepSound(Block.soundTypeWood)
            .setUnlocalizedName("log2");
        woodVert = new BlockLogVert().setUnlocalizedName("WoodVert")
            .setHardness(20)
            .setResistance(15F)
            .setStepSound(Block.soundTypeWood);
        woodVert2 = new BlockLogVert2().setUnlocalizedName("WoodVert2")
            .setHardness(20)
            .setResistance(15F)
            .setStepSound(Block.soundTypeWood);
        woodHoriz = new BlockLogHoriz(0).setUnlocalizedName("WoodHoriz")
            .setHardness(20)
            .setResistance(15F)
            .setStepSound(Block.soundTypeWood);
        woodHoriz2 = new BlockLogHoriz(8).setUnlocalizedName("WoodHoriz2")
            .setHardness(20)
            .setResistance(15F)
            .setStepSound(Block.soundTypeWood);
        woodHoriz3 = new BlockLogHoriz2(0).setUnlocalizedName("WoodHoriz3")
            .setHardness(20)
            .setResistance(15F)
            .setStepSound(Block.soundTypeWood);
        // Use 8 instead of 0 if Global.WOOD_ALL.length > 24
        woodHoriz4 = new BlockLogHoriz2(/* 8 */0).setUnlocalizedName("WoodHoriz4")
            .setHardness(20)
            .setResistance(15F)
            .setStepSound(Block.soundTypeWood);

        toolRack = new BlockToolRack().setHardness(3F)
            .setUnlocalizedName("Toolrack");
        spawnMeter = new BlockSpawnMeter().setHardness(3F)
            .setUnlocalizedName("SpawnMeter");
        foodPrep = new BlockFoodPrep().setHardness(1F)
            .setUnlocalizedName("FoodPrep");
        quern = new BlockQuern().setHardness(3F)
            .setUnlocalizedName("Quern");

        wallCobbleIgIn = new BlockCustomWall(stoneIgInCobble, 3).setUnlocalizedName("WallCobble");
        wallCobbleIgEx = new BlockCustomWall(stoneIgExCobble, 4).setUnlocalizedName("WallCobble");
        wallCobbleSed = new BlockCustomWall(stoneSedCobble, 8).setUnlocalizedName("WallCobble");
        wallCobbleMM = new BlockCustomWall(stoneMMCobble, 6).setUnlocalizedName("WallCobble");
        wallRawIgIn = new BlockCustomWall(stoneIgIn, 3).setUnlocalizedName("WallRaw");
        wallRawIgEx = new BlockCustomWall(stoneIgEx, 4).setUnlocalizedName("WallRaw");
        wallRawSed = new BlockCustomWall(stoneSed, 8).setUnlocalizedName("WallRaw");
        wallRawMM = new BlockCustomWall(stoneMM, 6).setUnlocalizedName("WallRaw");
        wallBrickIgIn = new BlockCustomWall(stoneIgInBrick, 3).setUnlocalizedName("WallBrick");
        wallBrickIgEx = new BlockCustomWall(stoneIgExBrick, 4).setUnlocalizedName("WallBrick");
        wallBrickSed = new BlockCustomWall(stoneSedBrick, 8).setUnlocalizedName("WallBrick");
        wallBrickMM = new BlockCustomWall(stoneMMBrick, 6).setUnlocalizedName("WallBrick");
        wallSmoothIgIn = new BlockCustomWall(stoneIgInSmooth, 3).setUnlocalizedName("WallSmooth");
        wallSmoothIgEx = new BlockCustomWall(stoneIgExSmooth, 4).setUnlocalizedName("WallSmooth");
        wallSmoothSed = new BlockCustomWall(stoneSedSmooth, 8).setUnlocalizedName("WallSmooth");
        wallSmoothMM = new BlockCustomWall(stoneMMSmooth, 6).setUnlocalizedName("WallSmooth");

        // Wooden Doors
        for (int i = 0; i < Global.WOOD_ALL.length; i++)
            doors[i] = new BlockCustomDoor(i * 2).setUnlocalizedName("Door " + Global.WOOD_ALL[i]);

        ingotPile = new BlockIngotPile().setUnlocalizedName("ingotpile")
            .setHardness(3);

        barrel = new BlockBarrel().setUnlocalizedName("Barrel")
            .setHardness(2);
        loom = new BlockLoom().setUnlocalizedName("Loom")
            .setHardness(2);
        thatch = new BlockThatch().setUnlocalizedName("Thatch")
            .setHardness(1)
            .setStepSound(Block.soundTypeGrass)
            .setCreativeTab(TFCTabs.TFC_BUILDING);
        moss = new BlockMoss().setUnlocalizedName("Moss")
            .setHardness(1)
            .setStepSound(Block.soundTypeGrass);

        flora = new BlockFlora().setUnlocalizedName("Flora")
            .setHardness(0.1f)
            .setStepSound(Block.soundTypeGrass);
        pottery = new BlockPottery().setUnlocalizedName("Pottery")
            .setHardness(1.0f);

        crucible = new BlockCrucible().setUnlocalizedName("Crucible")
            .setHardness(4.0f);

        nestBox = new BlockNestBox().setUnlocalizedName("NestBox")
            .setHardness(1);

        fence = new BlockTFCFence("Fence", Material.wood).setUnlocalizedName("FenceTFC")
            .setHardness(2);
        fenceGate = new BlockCustomFenceGate().setUnlocalizedName("FenceGateTFC")
            .setHardness(2);
        fence2 = new BlockTFCFence2("Fence2", Material.wood).setUnlocalizedName("FenceTFC")
            .setHardness(2);
        fenceGate2 = new BlockCustomFenceGate2().setUnlocalizedName("FenceGateTFC")
            .setHardness(2);
        strawHideBed = new BlockBed().setUnlocalizedName("StrawHideBed")
            .setHardness(1)
            .setCreativeTab(null);
        armorStand = new BlockStand().setUnlocalizedName("ArmourStand")
            .setHardness(2);
        armorStand2 = new BlockStand2().setUnlocalizedName("ArmourStand")
            .setHardness(2);

        berryBush = new BlockBerryBush().setUnlocalizedName("BerryBush")
            .setHardness(0.3f)
            .setStepSound(Block.soundTypeGrass);
        crops = new BlockCrop().setUnlocalizedName("crops")
            .setHardness(0.3F)
            .setStepSound(Block.soundTypeGrass);
        lilyPad = new BlockCustomLilyPad().setHardness(0.0F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("LilyPad")
            .setTextureName("waterlily");
        flowers = new BlockFlower().setHardness(0.0F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("Flowers");
        flowers2 = new BlockFlower2().setHardness(0.0F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("Flowers2");
        fungi = new BlockFungi().setHardness(0.0F)
            .setStepSound(Block.soundTypeGrass)
            .setUnlocalizedName("Fungi");

        saltWater = new BlockSaltWater(TFCFluids.SALTWATER).setHardness(100.0F)
            .setLightOpacity(3)
            .setUnlocalizedName("SaltWater");
        saltWaterStationary = new BlockLiquidStatic(TFCFluids.SALTWATER, Material.water, saltWater).setHardness(100.0F)
            .setLightOpacity(3)
            .setUnlocalizedName("SaltWaterStationary");

        freshWater = new BlockFreshWater(TFCFluids.FRESHWATER).setHardness(100.0F)
            .setLightOpacity(3)
            .setUnlocalizedName("FreshWater");
        freshWaterStationary = new BlockLiquidStatic(TFCFluids.FRESHWATER, Material.water, freshWater)
            .setHardness(100.0F)
            .setLightOpacity(3)
            .setUnlocalizedName("FreshWaterStationary");

        hotWater = new BlockHotWater(TFCFluids.HOTWATER).setHardness(100.0F)
            .setLightOpacity(3)
            .setUnlocalizedName("HotWater");
        hotWaterStationary = new BlockHotWaterStatic(TFCFluids.HOTWATER, Material.water, hotWater).setHardness(100.0F)
            .setLightOpacity(3)
            .setUnlocalizedName("HotWaterStationary");

        lava = new BlockLava().setHardness(0.0F)
            .setLightLevel(1.0F)
            .setLightOpacity(255)
            .setUnlocalizedName("Lava");
        lavaStationary = new BlockLiquidStatic(TFCFluids.LAVA, Material.lava, lava).setHardness(0.0F)
            .setLightLevel(1.0F)
            .setLightOpacity(255)
            .setUnlocalizedName("LavaStationary");
        ice = new BlockCustomIce().setHardness(0.5F)
            .setLightOpacity(3)
            .setStepSound(Block.soundTypeGlass)
            .setUnlocalizedName("Ice")
            .setTextureName("ice");

        waterPlant = new BlockWaterPlant(0).setUnlocalizedName("SeaGrassStill")
            .setHardness(0.5f)
            .setStepSound(Block.soundTypeGravel);

        fireBrick = new BlockFireBrick().setUnlocalizedName("FireBrick")
            .setHardness(8);
        metalSheet = new BlockMetalSheet().setUnlocalizedName("MetalSheet")
            .setHardness(80);
        leatherRack = new BlockLeatherRack().setUnlocalizedName("LeatherRack")
            .setHardness(1);

        gravel = new BlockGravel(0).setHardness(2F)
            .setStepSound(Block.soundTypeGravel)
            .setUnlocalizedName("gravel");
        gravel2 = new BlockGravel(16).setHardness(2F)
            .setStepSound(Block.soundTypeGravel)
            .setUnlocalizedName("gravel");

        grill = new BlockGrill().setHardness(2F)
            .setUnlocalizedName("Grill");
        metalTrapDoor = new BlockMetalTrapDoor().setHardness(2F)
            .setUnlocalizedName("MetalTrapDoor");
        vessel = new BlockLargeVessel().setHardness(1F)
            .setUnlocalizedName("Vessel");
        smoke = new BlockSmoke().setHardness(0F)
            .setUnlocalizedName("Smoke");
        smokeRack = new BlockSmokeRack().setHardness(0F)
            .setUnlocalizedName("SmokeRack");

        oilLamp = new BlockOilLamp().setHardness(1F)
            .setUnlocalizedName("OilLamp");
        hopper = new BlockHopper().setHardness(2F)
            .setUnlocalizedName("Hopper");
        flowerPot = new BlockCustomFlowerPot().setHardness(0.0F)
            .setStepSound(Block.soundTypeStone)
            .setUnlocalizedName("FlowerPot")
            .setTextureName("flower_pot");

        stoneIgIn.setHarvestLevel("pickaxe", 0);
        stoneIgEx.setHarvestLevel("pickaxe", 0);
        stoneSed.setHarvestLevel("pickaxe", 0);
        stoneMM.setHarvestLevel("pickaxe", 0);
        stoneStalac.setHarvestLevel("pickaxe", 0);
        detailed.setHarvestLevel("pickaxe", 0);
        ore.setHarvestLevel("pickaxe", 1);
        ore2.setHarvestLevel("pickaxe", 1);
        ore3.setHarvestLevel("pickaxe", 1);

        dirt.setHarvestLevel("shovel", 0);
        dirt2.setHarvestLevel("shovel", 0);
        grass.setHarvestLevel("shovel", 0);
        grass2.setHarvestLevel("shovel", 0);
        dryGrass.setHarvestLevel("shovel", 0);
        dryGrass2.setHarvestLevel("shovel", 0);
        clay.setHarvestLevel("shovel", 0);
        clay2.setHarvestLevel("shovel", 0);
        clayGrass.setHarvestLevel("shovel", 0);
        clayGrass2.setHarvestLevel("shovel", 0);
        peat.setHarvestLevel("shovel", 0);
        peatGrass.setHarvestLevel("shovel", 0);
        sand.setHarvestLevel("shovel", 0);
        sand2.setHarvestLevel("shovel", 0);
        charcoal.setHarvestLevel("shovel", 0);
        gravel.setHarvestLevel("shovel", 0);
        gravel2.setHarvestLevel("shovel", 0);
        waterPlant.setHarvestLevel("shovel", 0);
        tilledSoil.setHarvestLevel("shovel", 0);
        tilledSoil2.setHarvestLevel("shovel", 0);

        detailed.setHarvestLevel("axe", 0);
        Blocks.oak_stairs.setHarvestLevel("axe", 0);
        woodConstruct.setHarvestLevel("axe", 0);
        logNatural.setHarvestLevel("axe", 1);
        logNatural2.setHarvestLevel("axe", 1);
        woodHoriz.setHarvestLevel("axe", 1);
        woodHoriz2.setHarvestLevel("axe", 1);
        woodHoriz3.setHarvestLevel("axe", 1);
        woodHoriz4.setHarvestLevel("axe", 1);
        woodVert.setHarvestLevel("axe", 1);
        woodVert2.setHarvestLevel("axe", 1);

        logNatural.setHarvestLevel("hammer", 1);
        logNatural2.setHarvestLevel("hammer", 1);
        woodHoriz.setHarvestLevel("hammer", 1);
        woodHoriz2.setHarvestLevel("hammer", 1);
        woodHoriz3.setHarvestLevel("hammer", 1);
        woodHoriz4.setHarvestLevel("hammer", 1);
        woodVert.setHarvestLevel("hammer", 1);
        woodVert2.setHarvestLevel("hammer", 1);
    }

    public static void setupFire() {
        Blocks.fire.setFireInfo(logNatural, 5, 5);
        Blocks.fire.setFireInfo(logNatural2, 5, 5);
        Blocks.fire.setFireInfo(woodSupportV, 5, 20);
        Blocks.fire.setFireInfo(woodSupportV2, 5, 20);
        Blocks.fire.setFireInfo(woodSupportH, 5, 20);
        Blocks.fire.setFireInfo(woodSupportH2, 5, 20);
        Blocks.fire.setFireInfo(leaves, 20, 20);
        Blocks.fire.setFireInfo(leaves2, 20, 20);
        Blocks.fire.setFireInfo(fruitTreeWood, 5, 20);
        Blocks.fire.setFireInfo(fruitTreeLeaves, 20, 20);
        Blocks.fire.setFireInfo(fruitTreeLeaves2, 20, 20);
        Blocks.fire.setFireInfo(fence, 5, 20);
        Blocks.fire.setFireInfo(fence2, 5, 20);
        Blocks.fire.setFireInfo(fenceGate, 5, 20);
        Blocks.fire.setFireInfo(fenceGate2, 5, 20);
        Blocks.fire.setFireInfo(chest, 5, 20);
        Blocks.fire.setFireInfo(strawHideBed, 20, 20);
        Blocks.fire.setFireInfo(thatch, 20, 20);
        Blocks.fire.setFireInfo(woodVert, 5, 5);
        Blocks.fire.setFireInfo(woodVert2, 5, 5);
        Blocks.fire.setFireInfo(woodHoriz, 5, 5);
        Blocks.fire.setFireInfo(woodHoriz2, 5, 5);
        Blocks.fire.setFireInfo(woodHoriz3, 5, 5);
        Blocks.fire.setFireInfo(woodHoriz4, 5, 5);
        Blocks.fire.setFireInfo(planks, 5, 20);
        Blocks.fire.setFireInfo(planks2, 5, 20);
        Blocks.fire.setFireInfo(woodConstruct, 5, 20);
        Blocks.fire.setFireInfo(berryBush, 20, 20);
        Blocks.fire.setFireInfo(barrel, 5, 20);
        Blocks.fire.setFireInfo(crops, 20, 20);
        Blocks.fire.setFireInfo(logPile, 10, 10);
        // Blocks.fire.setFireInfo(Charcoal, 100, 20);
        for (int i = 0; i < Global.WOOD_ALL.length; i++) Blocks.fire.setFireInfo(doors[i], 5, 20);
    }
}
