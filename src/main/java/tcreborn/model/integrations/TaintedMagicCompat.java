package tcreborn.model.integrations;

import nemexlib.api.integrations.ACompat;
import nemexlib.api.items.ItemFinder;
import nemexlib.api.recipes.workbench.WorkbenchRemover;
import net.minecraft.item.ItemStack;
import tcreborn.model.ArrayCollector;

public class TaintedMagicCompat extends ACompat {

    public TaintedMagicCompat(String mod) {
        super(mod);
    }

    @Override
    public void loadIntegration() {
        ItemStack log, plank;
        ArrayCollector.addMagicalBlockLog(ItemFinder.findBlock(mod, "BlockWarpwoodLog"));
        log = ItemFinder.findItem(mod, "BlockWarpwoodLog"); // Warpwood Log
        plank = ItemFinder.findItem(mod, "BlockWarpwoodPlanks"); // Warpwood Planks
        WorkbenchRemover.i().removeItem(plank);
        ArrayCollector.addMagicalLogAndPlank(log, plank);
        ArrayCollector.addMagicalPlank(plank);
    }
}
