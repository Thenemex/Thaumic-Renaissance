package tcreborn.model.integrations;

import net.minecraft.item.ItemStack;
import tcreborn.api.integrations.ACompat;
import tcreborn.api.items.ItemFinder;
import tcreborn.api.recipes.workbench.RecipeRemover;
import tcreborn.model.ArrayCollector;

public class ForbiddenMagicCompat extends ACompat {

    public ForbiddenMagicCompat(String mod) {
        super(mod);
    }

    public void loadLogsPlanksSticks() {
        ItemStack log, plank;
        log = ItemFinder.findItem(mod, "TaintLog"); // Tainted Log
        plank = ItemFinder.findItem(mod, "TaintPlank"); // Tainted Planks
        RecipeRemover.removeItem(plank);
        ArrayCollector.addMagicalLogAndPlank(log, plank);
        ArrayCollector.addMagicalPlank(plank);
    }
}
