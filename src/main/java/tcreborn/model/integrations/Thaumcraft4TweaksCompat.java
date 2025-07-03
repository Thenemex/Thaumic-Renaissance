package tcreborn.model.integrations;

import net.glease.tc4tweak.ConfigurationHandler;
import tcreborn.api.integrations.ACompat;
import tcreborn.model.config.ConfigResearch;

public class Thaumcraft4TweaksCompat extends ACompat {

    public Thaumcraft4TweaksCompat(String mod) {
        super(mod);
        if (!ConfigurationHandler.INSTANCE.isCheckWorkbenchRecipes())
            changeWoodArcaneRecipes();
    }

    public void changeWoodArcaneRecipes() {
        ConfigResearch.isArcaneCheckingVanillaWorkbenchRecipes = false;
    }
}
