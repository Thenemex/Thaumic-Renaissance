package tcreborn.api.integrations;

public abstract class ACompat {

    protected final String mod;

    public ACompat(String mod) {
        this.mod = mod;
        init();
    }

    public void init() {
        loadLogsPlanksSticks();
    }

    public abstract void loadLogsPlanksSticks();
}
