package tcreborn.model.config;

import cpw.mods.fml.common.Loader;
import tcreborn.model.integrations.ForbiddenMagicCompat;
import tcreborn.model.integrations.TaintedMagicCompat;
import tcreborn.model.integrations.Thaumcraft4TweaksCompat;
import tcreborn.model.integrations.ThaumicBasesCompat;

import static tcreborn.config.Config.*;

public class ConfigIntegrations {

    private static final String forbiddenMagic = "ForbiddenMagic", taintedMagic = "TaintedMagic", thaumicBases = "thaumicbases", thaumcraft4Tweaks = "tc4tweak";

    public static void init() {
        if (modIsLoaded(forbiddenMagic, forbiddenMagicCompat))
            new ForbiddenMagicCompat(forbiddenMagic);
        if (modIsLoaded(taintedMagic, taintedMagicCompat))
            new TaintedMagicCompat(taintedMagic);
        if (modIsLoaded(thaumicBases, thaumicBasesCompat))
            new ThaumicBasesCompat(thaumicBases);
        if (modIsLoaded(thaumcraft4Tweaks, thaumcraft4TweaksCompat));
            new Thaumcraft4TweaksCompat(thaumcraft4Tweaks);
    }

    public static boolean modIsLoaded(String mod, boolean config) {
        return Loader.isModLoaded(mod) && config;
    }
}
