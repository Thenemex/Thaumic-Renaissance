package tcreborn.model.config;

import nemexlib.api.thaumcraft.research.Research;
import tcreborn.ThaumicRenaissance;
import tcreborn.model.research.*;

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
    }
}
