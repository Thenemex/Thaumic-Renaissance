package tcreborn.api.integrations;

import tcreborn.api.util.Logger;

public abstract class ACompat {

    protected final String mod;

    public ACompat(String mod) {
        this.mod = mod;
        init();
        Logger.logInfo("Successfully loaded integration for mod : ".concat(mod));
    }

    public void init() {
        loadLogsPlanksSticks();
    }

    public void loadLogsPlanksSticks() {};
}
