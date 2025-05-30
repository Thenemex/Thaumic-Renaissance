package tcreborn.model.integrations;

import net.minecraft.item.ItemStack;
import tcreborn.api.integrations.ACompat;
import tcreborn.api.items.ItemFinder;
import tcreborn.model.ArrayCollector;

public class ForbiddenMagicCompat extends ACompat {

    public ForbiddenMagicCompat(String mod) {
        super(mod);
    }

    @Override
    public void init() {
        ItemStack plank = ItemFinder.findItem(mod, "TaintPlank");
        ItemStack log = ItemFinder.findItem(mod, "TaintLog");
        ArrayCollector.addMundaneLogAndPlank(log, plank);
        ArrayCollector.addMagicalPlank(plank);
    }
}
