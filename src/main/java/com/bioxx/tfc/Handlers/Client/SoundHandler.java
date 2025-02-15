package com.bioxx.tfc.Handlers.Client;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.PlaySoundEvent17;

import com.bioxx.tfc.Reference;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SoundHandler {

    private ISound iSound;

    @SubscribeEvent
    public void onSound17(PlaySoundEvent17 event) {
        if (event.sound != null && event.category != null
            && event.category.getCategoryName()
                .equalsIgnoreCase("music")) {
            if (event.manager.isSoundPlaying(iSound)) event.result = null;
            else {
                iSound = PositionedSoundRecord
                    .createPositionedSoundRecord(new ResourceLocation(Reference.MOD_ID + ":music.tfc"));
                event.result = iSound;
            }
        }
    }
}
