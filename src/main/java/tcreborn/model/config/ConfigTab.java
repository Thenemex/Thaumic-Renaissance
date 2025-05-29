package tcreborn.model.config;

import net.minecraft.util.ResourceLocation;
import tcreborn.api.thaumcraft.API;

public class ConfigTab {

    public static final String tabLumberjack = "LUMBERJACK";

    public static void initTab_LUMBERJACK() {
        API.newCategory(tabLumberjack, new ResourceLocation("minecraft", "textures/items/stone_axe.png"));
    }
}
