package tcreborn.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

import static tcreborn.ThaumicRenaissance.modName;

public class Config {

    private static Configuration config;
    public static File configDir;
    public static boolean expertWoodRecipesEnabled;
    public static boolean forbiddenMagicCompat, taintedMagicCompat, thaumicBasesCompat;

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
        expertWoodRecipesEnabled = newEntry(expertCat,"Planks/Sticks recipes");
        config.addCustomCategoryComment(integCat, "You can disable/enable mod integrations here.");
        forbiddenMagicCompat = newEntry(integCat, "Forbidden Magic");
        taintedMagicCompat = newEntry(integCat, "Tainted Magic");
        thaumicBasesCompat = newEntry(integCat, "Thaumic Bases");
    }

    public static boolean newEntry(String tag, String key) {
        return config.get(tag, key, true).getBoolean(true);
    }
}
