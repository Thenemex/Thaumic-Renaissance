package tcreborn.model.config;

import tcreborn.config.Config;
import tcreborn.model.research.WoodBasicRecipes;

public class ConfigResearch {

    public static void init() {
        if (Config.expertWoodRecipesEnabled) {
            ConfigTab.initTab_LUMBERJACK();
            new WoodBasicRecipes();
        }
        // Add new AResearch here
    }
}
