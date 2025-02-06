package com.bioxx.tfc.Items.ItemBlocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.bioxx.tfc.api.Constant.Global;

public class ItemLeatherRack extends ItemTerraBlock {

    public ItemLeatherRack(Block block) {
        super(block);
    }

    @Override
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
        float hitX, float hitY, float hitZ, int metadata) {
        if (!world.setBlock(x, y, z, blockInstance, 0, 3)) {
            return false;
        }

        if (world.getBlock(x, y, z) == blockInstance) {
            blockInstance.onBlockPlacedBy(world, x, y, z, player, stack);
            blockInstance.onPostBlockPlaced(world, x, y, z, 0);
        }

        return true;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i < Global.WOOD_ALL.length; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
