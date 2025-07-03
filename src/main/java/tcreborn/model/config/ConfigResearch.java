package tcreborn.model.config;

import tcreborn.model.research.*;

import static tcreborn.config.Config.expertWoodRecipesEnabled;

public class ConfigResearch {

    public static boolean isArcaneCheckingWorkbenchRecipes = true;

    public static void init() {
        initLumberjack();
        // Add new AResearch here
    }

    protected static void initLumberjack() {
        if (expertWoodRecipesEnabled) new WoodBasicRecipes();
        new WoodArcaneRecipes();
        new WoodCrucibleRecipes();
        new WoodCrucibleMagicalRecipes();
        new WoodCompoundRecipes();
        new WoodCompoundMagicalRecipes();
    }
}
