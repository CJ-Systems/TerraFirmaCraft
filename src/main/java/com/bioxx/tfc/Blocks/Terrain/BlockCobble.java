package com.bioxx.tfc.Blocks.Terrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.bioxx.tfc.Blocks.BlockTerra;
import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Items.Tools.ItemHammer;
import com.bioxx.tfc.Reference;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Tools.IToolChisel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCobble extends BlockTerra {

    protected BlockCobble(Material material) {
        super(material);
        this.setCreativeTab(TFCTabs.TFC_BUILDING);
    }

    @Override
    public int tickRate(World p_149738_1_) {
        // return super.tickRate(p_149738_1_);
        return 20;
    }

    protected String[] names;
    protected IIcon[] icons;
    protected int looseStart;

    @SideOnly(Side.CLIENT)
    @Override
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i < names.length; i++) list.add(new ItemStack(this, 1, i));
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        // Cobblestone generated from cave ins drops loose rocks instead of the block.
        if (meta > 7) return TFCItems.looseRock;
        else return Item.getItemFromBlock(this);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random rand) {
        return rand.nextInt(2) + 1;
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        // Natural cobblestone drops multiple rocks, crafted cobblestone drops one block.
        int count = metadata > 7 ? this.quantityDropped(world.rand) : 1;

        for (int i = 0; i < count; i++) {
            Item item = getItemDropped(metadata, world.rand, fortune);

            if (item != null) {
                if (metadata > 7) {
                    // Need to take the "natural cobble" metadata mod 8 to get the correct rock item.
                    int meta = looseStart + (metadata % 8);
                    ret.add(new ItemStack(item, 1, meta));
                } else ret.add(new ItemStack(item, 1, damageDropped(metadata)));
            }
        }
        return ret;
    }

    /**
     * Returns the block hardness at a location. Args: world, x, y, z
     */
    @Override
    public float getBlockHardness(World world, int x, int y, int z) {
        // Cobblestone generated from cave ins have half the block hardness, same as raw stone.
        if (world.getBlockMetadata(x, y, z) > 7) return this.blockHardness / 2;
        else return this.blockHardness;
    }

    /*
     * Mapping from metadata value to damage value
     */
    @Override
    public int damageDropped(int i) {
        return i & 7;
    }

    @Override
    public IIcon getIcon(int i, int j) {
        if ((j & 7) >= icons.length) return icons[0];
        return icons[j & 7];
    }

    @Override
    public void registerIcons(IIconRegister iconRegisterer) {
        for (int i = 0; i < names.length; i++)
            icons[i] = iconRegisterer.registerIcon(Reference.MOD_ID + ":" + "rocks/" + names[i] + " Cobble");
    }

    @Override
    public void onBlockAdded(World world, int i, int j, int k) {
        world.scheduleBlockUpdate(i, j, k, this, tickRate(world));
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l) {}

    @Override
    public void onNeighborBlockChange(World world, int i, int j, int k, Block l) {
        world.scheduleBlockUpdate(i, j, k, this, tickRate(world));
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float par7,
        float par8, float par9) {
        boolean hasHammer = false;
        for (int i = 0; i < 9; i++) {
            if (entityplayer.inventory.mainInventory[i] != null
                && entityplayer.inventory.mainInventory[i].getItem() instanceof ItemHammer) hasHammer = true;
        }
        if (entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem()
            .getItem() instanceof IToolChisel
            && hasHammer
            && !world.isRemote
            && ((IToolChisel) entityplayer.getCurrentEquippedItem()
                .getItem()).canChisel(entityplayer, x, y, z)) {
            Block id = world.getBlock(x, y, z);
            byte meta = (byte) world.getBlockMetadata(x, y, z);

            return ((IToolChisel) entityplayer.getCurrentEquippedItem()
                .getItem()).onUsed(world, entityplayer, x, y, z, id, meta, side, par7, par8, par9);
        }
        return false;
    }

    @Override
    public void updateTick(World world, int i, int j, int k, Random random) {
        BlockCollapsible.updateTickCollapsible(world, i, j, k, random, this, true);
    }
}
