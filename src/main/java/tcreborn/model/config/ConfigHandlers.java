package tcreborn.model.config;

import tcreborn.api.events.SingleBlockWithDropsHandler;
import tcreborn.model.events.WoodCompoundMagicalRecipesHandler;
import tcreborn.model.events.WoodCompoundRecipesHandler;

public class ConfigHandlers {

    public static SingleBlockWithDropsHandler mundaneWoodCompoundHandler, magicalWoodCompoundHandler;

    public static void init() {
        mundaneWoodCompoundHandler = new WoodCompoundRecipesHandler();
        magicalWoodCompoundHandler = new WoodCompoundMagicalRecipesHandler("WOODCOMPOUNDMAGICALRECIPES");
    }
}
