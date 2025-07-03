package tcreborn.model.integrations;

import net.glease.tc4tweak.ConfigurationHandler;
import tcreborn.api.integrations.ACompat;
import tcreborn.model.config.ConfigResearch;

public class Thaumcraft4TweaksCompat extends ACompat {

    public Thaumcraft4TweaksCompat(String mod) {
        super(mod);
        // Setting the value to what the TC4 Tweaks config entry is set for
        ConfigResearch.isArcaneCheckingWorkbenchRecipes = ConfigurationHandler.INSTANCE.isCheckWorkbenchRecipes();
    }

}
