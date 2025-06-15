package tcreborn.model.config;

import tcreborn.model.research.WoodArcaneRecipes;
import tcreborn.model.research.WoodBasicRecipes;
import tcreborn.model.research.WoodCrucibleMagicalRecipes;
import tcreborn.model.research.WoodCrucibleRecipes;

import static tcreborn.config.Config.expertWoodRecipesEnabled;

public class ConfigResearch {

    public static void init() {
        ConfigTab.initTab_LUMBERJACK();
        if (expertWoodRecipesEnabled) new WoodBasicRecipes();
        new WoodArcaneRecipes();
        new WoodCrucibleRecipes();
        new WoodCrucibleMagicalRecipes();
    }
        // Add new AResearch here
}
