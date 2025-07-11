package tcreborn.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

import static tcreborn.ThaumicRenaissance.modName;

public class Config {

    private static Configuration config;
    public static File configDir;
    public static boolean expertWoodRecipesEnabled;
    public static boolean forbiddenMagicCompat, taintedMagicCompat, thaumicBasesCompat, twilightForestCompat, thaumcraft4TweaksCompat;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void init(File configFolder) {
        configDir = configFolder;
        configDir.mkdirs();
        config = new Configuration(new File(configDir, modName.concat(".cfg")));
        config.load();
        loadConfig();
        config.save();
    }

    private static void loadConfig() {
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

    public static boolean newEntry(String tag, String key) {
        return newEntry(tag, key, true);
    }
    public static boolean newEntry(String tag, String key, boolean enabled) {
        return config.get(tag, key, enabled).getBoolean(enabled);
    }
}
