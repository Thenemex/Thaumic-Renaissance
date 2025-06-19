package tcreborn.model.config;

import tcreborn.api.events.WandEventHandler;
import tcreborn.model.events.WoodCompoundRecipesHandler;

public class ConfigEvents {

    public static WandEventHandler woodCompoundHandler;

    public static void init() {
        woodCompoundHandler = new WoodCompoundRecipesHandler();
    }
}
