package tcreborn.model.config;

import nemexlib.api.thaumcraft.API;
import net.minecraft.util.ResourceLocation;

public class ConfigTab {

    public static final String lumberjack = "LUMBERJACK";

    public static void init() {
        API.newCategory(lumberjack, new ResourceLocation("thaumcraft", "textures/items/elementalaxe.png"));
    }
}
