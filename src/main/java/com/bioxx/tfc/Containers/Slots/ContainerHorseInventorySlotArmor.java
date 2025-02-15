package com.bioxx.tfc.Containers.Slots;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.bioxx.tfc.Containers.ContainerHorseInventoryTFC;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerHorseInventorySlotArmor extends Slot {

    private final EntityHorse horse;

    // private final ContainerHorseInventoryTFC horseContainer;

    public ContainerHorseInventorySlotArmor(ContainerHorseInventoryTFC containerHorseInv, IInventory horseInv, int i,
        int j, int k, EntityHorse entityHorse) {
        super(horseInv, i, j, k);
        // this.horseContainer = containerHorseInv;
        this.horse = entityHorse;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return super.isItemValid(itemStack) && horse.canWearArmor()/* Standard Horse */
            && EntityHorse.func_146085_a(itemStack.getItem()/* Item is Horse Armor */);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean canBeHovered() // No clue what this is for
    {
        return this.horse.canWearArmor();
    }
}
