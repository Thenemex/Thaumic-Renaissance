package tcreborn.model.config;

import tcreborn.model.research.*;

import static tcreborn.config.Config.expertWoodRecipesEnabled;

public class ConfigResearch {

    public static void init() {
        ConfigTab.initTab_LUMBERJACK();
        if (expertWoodRecipesEnabled) new WoodBasicRecipes();
        new WoodArcaneRecipes();
        new WoodCrucibleRecipes();
        new WoodCrucibleMagicalRecipes();
        new WoodCompoundRecipes();
    }
        // Add new AResearch here
}
