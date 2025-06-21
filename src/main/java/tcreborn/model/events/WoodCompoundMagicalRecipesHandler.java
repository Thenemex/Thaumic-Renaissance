package tcreborn.model.events;

import net.minecraft.item.ItemStack;
import tcreborn.api.events.SingleBlockWithDropsHandler;
import tcreborn.config.Config;
import tcreborn.model.ArrayCollector;

public class WoodCompoundMagicalRecipesHandler extends SingleBlockWithDropsHandler {

    public WoodCompoundMagicalRecipesHandler(String researchTag) {
        super(researchTag, ArrayCollector.getMagicalBlockLogs());
    }

    protected ItemStack getDrops(int event) {
        int amount = Config.expertWoodRecipesEnabled ? 2 : 6;
        return ArrayCollector.getMagicalPlank(event, amount);
    }
}
