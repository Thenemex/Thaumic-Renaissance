package tcreborn.model.config;

import nemexlib.api.events.SingleBlockWithDropsHandler;
import nemexlib.api.items.types.BlockType;
import tcreborn.model.ArrayCollector;
import tcreborn.model.events.WoodCompoundMagicalRecipesHandler;
import tcreborn.model.events.WoodCompoundRecipesHandler;

public class ConfigHandlers {

    public static SingleBlockWithDropsHandler mundaneWoodCompoundHandler, magicalWoodCompoundHandler;

    public static void init() {
        mundaneWoodCompoundHandler = new WoodCompoundRecipesHandler();
        magicalWoodCompoundHandler = new WoodCompoundMagicalRecipesHandler("WOODCOMPOUNDMAGICALRECIPES");
        patchRotatedMundaneLogs();
    }

    protected static void patchRotatedMundaneLogs() {
        // We consider any mundane wood log have his rotated selves at metadata +4 and +8
        int i = 0;
        for (BlockType V : ArrayCollector.getMundaneBlockLogs()) {
            BlockType U = new BlockType(V);
            mundaneWoodCompoundHandler.registerTriggerEvent(U.addMeta(4), i);
            mundaneWoodCompoundHandler.registerTriggerEvent(U.addMeta(4), i++);
        }
    }
}
