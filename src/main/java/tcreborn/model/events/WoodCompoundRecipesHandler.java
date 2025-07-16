package tcreborn.model.events;

import net.minecraft.item.ItemStack;
import tcreborn.api.events.SingleBlockWithDropsHandler;
import tcreborn.config.Config;
import tcreborn.model.ArrayCollector;

public class WoodCompoundRecipesHandler extends SingleBlockWithDropsHandler {

    public WoodCompoundRecipesHandler() {
        super(ArrayCollector.getMundaneBlockLogs());
    }

    protected ItemStack getDrops(int event, boolean upgrade) {
        int amount = upgrade ? Config.expertWoodRecipesEnabled ? 1 : 5 : Config.expertWoodRecipesEnabled ? 2 : 6;
        return ArrayCollector.getMundanePlank(event, amount);
    }
}
