package tcreborn.model.config;

import tcreborn.config.Config;
import tcreborn.model.research.WoodArcaneRecipes;
import tcreborn.model.research.WoodBasicRecipes;
import tcreborn.model.research.WoodCrucibleRecipes;

public class ConfigResearch {

    public static void init() {
        if (Config.expertWoodRecipesEnabled) {
            ConfigTab.initTab_LUMBERJACK();
            new WoodBasicRecipes();
            new WoodArcaneRecipes();
            new WoodCrucibleRecipes();
        }
        // Add new AResearch here
    }
}
