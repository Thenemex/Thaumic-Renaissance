package tcreborn.model.integrations;

import nemexlib.api.integrations.ACompat;
import nemexlib.api.items.types.BlockType;
import nemexlib.api.recipes.workbench.WorkbenchAdder;
import nemexlib.api.recipes.workbench.WorkbenchRemover;
import net.minecraft.item.ItemStack;
import tcreborn.model.config.ConfigResearch;

import static nemexlib.api.items.ItemFinder.findBlock;
import static nemexlib.api.items.ItemFinder.findItem;
import static tcreborn.model.ArrayCollector.*;

public class TwilightForestCompat extends ACompat {

    public TwilightForestCompat(String mod) {
        super(mod);
    }

    protected void patchTowerwoodPlanksRecipe() {
        ItemStack towerwoodPlanks = findItem(mod, "tile.TFTowerStone", 0);
        WorkbenchRemover.i().removeMeta(towerwoodPlanks);
        WorkbenchAdder.addRecipe(towerwoodPlanks, true, findItem(mod, "tile.TFLog", 3));
    }

    @Override
    public void loadIntegration() {
        BlockType log, plank;
        for (int i = 0; i <= 3; i++) {
            log = findBlock(mod, "tile.TFLog", i);
            plank = findBlock(mod, "tile.TFPlank", i);
            WorkbenchRemover.i().removeItem(plank.toItemStack());
            addMundaneLogAndPlank(log.toItemStack(), plank.toItemStack());
            addMundaneBlockLog(log);
        }
        for (int i = 0; i <= 3; i++) {
            log = findBlock(mod, "tile.TFMagicLog", i);
            plank = findBlock(mod, "tile.TFPlank", i + 4);
            WorkbenchRemover.i().removeItem(plank.toItemStack());
            addMagicalLogAndBlock(log);
            addSameMagicalResultPlank(plank.toItemStack());
        }

        if (!ConfigResearch.isArcaneCheckingWorkbenchRecipes)
            patchTowerwoodPlanksRecipe();
    }
}
