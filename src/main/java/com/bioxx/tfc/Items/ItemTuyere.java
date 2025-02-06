package com.bioxx.tfc.Items;

public class ItemTuyere extends ItemTerra {

    public int blockMeta;

    public ItemTuyere(int maxDam, int meta) {
        super();
        this.hasSubtypes = false;
        this.setMaxDurability(maxDam);
        setFolder("tools/");
        blockMeta = meta;
    }
}
