package tcreborn.model.config;

import cpw.mods.fml.common.Loader;
import tcreborn.model.integrations.*;

import static tcreborn.config.Config.*;

public class ConfigIntegrations {

    protected static final String forbiddenMagic = "ForbiddenMagic",
            taintedMagic = "TaintedMagic",
            thaumicBases = "thaumicbases",
            twilightForest = "TwilightForest",
            thaumcraft4Tweaks = "tc4tweak";

    public static void init() {
        if (modIsLoaded(thaumcraft4Tweaks, thaumcraft4TweaksCompat))
            new Thaumcraft4TweaksCompat(thaumcraft4Tweaks);
        if (modIsLoaded(forbiddenMagic, forbiddenMagicCompat))
            new ForbiddenMagicCompat(forbiddenMagic);
        if (modIsLoaded(taintedMagic, taintedMagicCompat))
            new TaintedMagicCompat(taintedMagic);
        if (modIsLoaded(thaumicBases, thaumicBasesCompat))
            new ThaumicBasesCompat(thaumicBases);
        if (modIsLoaded(twilightForest, twilightForestCompat))
            new TwilightForestCompat(twilightForest);
    }

    public static boolean modIsLoaded(String mod, boolean config) {
        return Loader.isModLoaded(mod) && config;
    }
}
