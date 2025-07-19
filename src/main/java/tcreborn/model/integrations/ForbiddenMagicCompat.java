package tcreborn.model.integrations;

import nemexlib.api.integrations.ACompat;
import nemexlib.api.items.ItemFinder;
import nemexlib.api.recipes.workbench.WorkbenchRemover;
import net.minecraft.item.ItemStack;
import tcreborn.model.ArrayCollector;

public class ForbiddenMagicCompat extends ACompat {

    public ForbiddenMagicCompat(String mod) {
        super(mod);
    }

    public void loadIntegration() {
        ItemStack log, plank;
        ArrayCollector.addMagicalBlockLog(ItemFinder.findBlock(mod, "TaintLog"));
        log = ItemFinder.findItem(mod, "TaintLog"); // Tainted Log
        plank = ItemFinder.findItem(mod, "TaintPlank"); // Tainted Planks
        WorkbenchRemover.i().removeItem(plank);
        ArrayCollector.addMagicalLogAndPlank(log, plank);
        ArrayCollector.addMagicalPlank(plank);
    }
}
