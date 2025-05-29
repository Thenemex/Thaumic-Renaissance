package tcreborn.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

import static tcreborn.ThaumicRenaissance.modID;

public class Config {

    private static Configuration config;
    public static File configDir;
    public static boolean expertWoodRecipesEnabled;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void init(File configFolder) {
        configDir = configFolder;
        configDir.mkdirs();
        config = new Configuration(new File(configDir, modID.concat(".cfg")));
        config.load();
        loadConfig();
        config.save();
    }

    private static void loadConfig() {
        String expertCat = "Expert";
        config.addCustomCategoryComment(expertCat, "You can disable/enable expert configurations from the mod.");
        expertWoodRecipesEnabled = config.get(expertCat,"Planks/Sticks recipes", true).getBoolean(true);
    }
}
