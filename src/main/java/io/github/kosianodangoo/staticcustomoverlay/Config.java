package io.github.kosianodangoo.staticcustomoverlay;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.List;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> TEXTURE_LOCATION_STRINGS = BUILDER.comment("A list of texture location to render as overlay.").defineListAllowEmpty("textures", List.of("minecraft:textures/gui/title/minecraft.png"), (Object str) -> true);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static List<ResourceLocation> textures = List.of();

    @SubscribeEvent
    static void onLoad(ModConfigEvent event) {
        textures = TEXTURE_LOCATION_STRINGS.get().stream().map(ResourceLocation::new).toList();
    }
}
