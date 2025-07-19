package tcreborn.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import nemexlib.config.AConfig;

import static tcreborn.ThaumicRenaissance.modName;

public class Config extends AConfig {

    public static boolean expertWoodRecipesEnabled;
    public static boolean forbiddenMagicCompat, taintedMagicCompat, thaumicBasesCompat, twilightForestCompat, thaumcraft4TweaksCompat;

    public Config(FMLPreInitializationEvent event, String version) {
        super(event, modName, modName, version);
    }

    @Override
    protected void loadConfig() {
        String integCat = "Integrations", expertCat = "Expert";
        config.addCustomCategoryComment(expertCat, "You can disable/enable expert configurations from the mod here.");
        expertWoodRecipesEnabled = newEntry(expertCat,"Planks/Sticks recipes", false);
        config.addCustomCategoryComment(integCat, "You can disable/enable mod integrations here.");
        forbiddenMagicCompat = newEntry(integCat, "Forbidden Magic");
        taintedMagicCompat = newEntry(integCat, "Tainted Magic");
        thaumicBasesCompat = newEntry(integCat, "Thaumic Bases");
        twilightForestCompat = newEntry(integCat, "Twilight Forest");
        thaumcraft4TweaksCompat = newEntry(integCat, "Thaumcraft 4 Tweaks");
    }
}
