package com.bioxx.tfc.Blocks.Terrain;

import net.minecraft.client.renderer.texture.IIconRegister;

import com.bioxx.tfc.Reference;

public class BlockDryGrass extends BlockGrass {

    public BlockDryGrass(int texOff) {
        super(texOff);
    }

    @Override
    public void registerIcons(IIconRegister registerer) {
        super.registerIcons(registerer);
        grassTopTexture = registerer.registerIcon(Reference.MOD_ID + ":" + "GrassSparseOverlay");
        iconGrassSideOverlay = registerer.registerIcon(Reference.MOD_ID + ":" + "GrassSideSparse");
    }
}
