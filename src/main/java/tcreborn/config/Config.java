package tcreborn.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import nemexlib.config.AConfig;

import static tcreborn.ThaumicRenaissance.modName;

public class Config extends AConfig {

    public static boolean expertWoodRecipesEnabled;
    public static boolean forbiddenMagicCompat, taintedMagicCompat, thaumicBasesCompat, twilightForestCompat, thaumcraft4TweaksCompat;
    public static boolean glowstoneTorches;
    public static int glowstoneTorchesOutput;

    public Config(FMLPreInitializationEvent event, String version) {
        super(event, modName, modName, version);
    }

    @Override
    protected void loadConfig() {
        String integCat = "Integrations", expertCat = "Expert", additRecipes = "Additionnal-Recipes";
        config.addCustomCategoryComment(expertCat, "You can disable/enable expert configurations from the mod here.");
        expertWoodRecipesEnabled = newEntry(expertCat,"Planks/Sticks recipes", false);

        config.addCustomCategoryComment(integCat, "You can disable/enable mod integrations here.");
        forbiddenMagicCompat = newEntry(integCat, "Forbidden Magic");
        taintedMagicCompat = newEntry(integCat, "Tainted Magic");
        thaumicBasesCompat = newEntry(integCat, "Thaumic Bases");
        twilightForestCompat = newEntry(integCat, "Twilight Forest");
        thaumcraft4TweaksCompat = newEntry(integCat, "Thaumcraft 4 Tweaks");

        config.addCustomCategoryComment(additRecipes, "You can disable/enable additionnal recipes here.");
        glowstoneTorches = newEntry(additRecipes, "Glowstone Torches", "Allows for crafting torches from stick and glowstone");
        glowstoneTorchesOutput = newEntry(additRecipes, "Glowstone Torches output", 5);
    }
}
