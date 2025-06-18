package tcreborn.model.integrations;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tcreborn.api.integrations.ACompat;
import tcreborn.api.items.ItemFinder;
import tcreborn.api.recipes.workbench.WorkbenchRemover;
import tcreborn.model.ArrayCollector;

public class ThaumicBasesCompat extends ACompat {

    public ThaumicBasesCompat(String mod) {
        super(mod);
    }

    @Override
    public void loadLogsPlanksSticks() {
        for (int i = 0; i < 3; i++) // Peaceful, Nether and Ender wood
            ArrayCollector.addMagicalLogAndBlock(ItemFinder.findBlock(mod, "genLogs", i));
        ArrayCollector.addPlankResultOfMagical(
                new ItemStack(Blocks.planks, 1, 2),
                new ItemStack(Blocks.planks, 1, 1));
        ItemStack plank = ItemFinder.findItem(mod, "enderPlanks");
        WorkbenchRemover.i().removeItem(plank);
        ArrayCollector.addSameMagicalResultPlank(plank); // Ender Planks
    }
}
