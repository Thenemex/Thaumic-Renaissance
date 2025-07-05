package tcreborn.api.integrations;

import tcreborn.api.util.Logger;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Compat:".concat(mod);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ACompat)) return false;
        ACompat aCompat = (ACompat) o;
        return Objects.equals(mod, aCompat.mod);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(mod);
    }
}
