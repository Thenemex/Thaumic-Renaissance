package tcreborn.model.config;

import tcreborn.model.research.*;

import static tcreborn.config.Config.expertWoodRecipesEnabled;

public class ConfigResearch {

    public static void init() {
        initLumberjackResearches();
        // Add new AResearch here
    }

    protected static void initLumberjackResearches() {
        ConfigTab.initTab_LUMBERJACK();
        if (expertWoodRecipesEnabled) new WoodBasicRecipes();
        new WoodArcaneRecipes();
        new WoodCrucibleRecipes();
        new WoodCrucibleMagicalRecipes();
        new WoodCompoundRecipes();
        new WoodCompoundMagicalRecipes();
    }
}
