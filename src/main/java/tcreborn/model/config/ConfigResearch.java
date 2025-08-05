package tcreborn.model.config;

import tcreborn.model.research.light.TorchBasicRecipes;
import tcreborn.model.research.wood.*;

import static tcreborn.config.Config.expertWoodRecipesEnabled;

public class ConfigResearch {

    public static boolean isArcaneCheckingWorkbenchRecipes = true;

    public static void init() {
        ConfigTab.init();
        initLumberjack();
    }

    protected static void initLumberjack() {
        if (expertWoodRecipesEnabled) new WoodBasicRecipes();
        new WoodArcaneRecipes();
        new WoodCrucibleRecipes();
        new WoodCrucibleMagicalRecipes();
        new WoodCrucibleInstrumentumRecipes();
        new WoodCompoundRecipes();
        new WoodCompoundMagicalRecipes();
        new WoodCompoundUpgradeRecipes();
        new WoodCompoundMagicalUpgradeRecipes();

        new TorchBasicRecipes();
    }
}
