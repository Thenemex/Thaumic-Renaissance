package tcreborn.model.config;

import cpw.mods.fml.common.Loader;
import tcreborn.config.Config;
import tcreborn.model.integrations.ForbiddenMagicCompat;

public class ConfigIntegrations {

    private static final String forbiddenMagic = "ForbiddenMagic";

    public static void init() {
        if (modIsLoaded(forbiddenMagic, Config.forbiddenMagicCompat))
            new ForbiddenMagicCompat(forbiddenMagic);
    }

    public static boolean modIsLoaded(String mod, boolean config) {
        return Loader.isModLoaded(mod) && config;
    }
}
