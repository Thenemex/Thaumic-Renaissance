package tcreborn.model.integrations;

import nemexlib.api.integrations.ACompat;
import net.glease.tc4tweak.ConfigurationHandler;
import tcreborn.model.config.ConfigResearch;

public class Thaumcraft4TweaksCompat extends ACompat {

    public Thaumcraft4TweaksCompat(String mod) {
        super(mod);
    }

    @Override
    public void loadIntegration() {
        // Setting the value to what the TC4 Tweaks config entry is set for
        ConfigResearch.isArcaneCheckingWorkbenchRecipes = ConfigurationHandler.INSTANCE.isCheckWorkbenchRecipes();
    }


}
