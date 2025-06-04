package tcreborn.model.config;

import net.minecraft.util.ResourceLocation;
import tcreborn.api.thaumcraft.API;

public class ConfigTab {

    public static final String lumberjack = "LUMBERJACK";

    public static void initTab_LUMBERJACK() {
        API.newCategory(lumberjack, new ResourceLocation("thaumcraft", "textures/items/elementalaxe.png"));
    }
}
