package tcreborn.model.integrations;

import net.minecraft.item.ItemStack;
import tcreborn.api.integrations.ACompat;
import tcreborn.api.items.ItemFinder;
import tcreborn.model.ArrayCollector;

public class TaintedMagicCompat extends ACompat {

    public TaintedMagicCompat(String mod) {
        super(mod);
    }

    @Override
    public void loadLogsPlanksSticks() {
        ItemStack log, plank;
        log = ItemFinder.findItem(mod, "BlockWarpwoodLog"); // Warpwood Log
        plank = ItemFinder.findItem(mod, "BlockWarpwoodPlanks"); // Warpwood Planks
        ArrayCollector.addMagicalLogAndPlank(log, plank);
        ArrayCollector.addMagicalPlank(plank);
    }
}
