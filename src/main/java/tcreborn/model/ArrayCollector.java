package tcreborn.model;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ArrayCollector {

    public static final int nbMundane = 6;
    public static ItemStack[] mundaneLogs, mundanePlanks, magicalLogs, magicalPlanks;

    static {
        mundaneLogs = new ItemStack[nbMundane];
        mundanePlanks = new ItemStack[nbMundane];
        for (int i = 0; i < 6; i++) { // Add all metadata of vanilla logs/planks
            mundanePlanks[i] = new ItemStack(Blocks.planks, 1, i);
            if (i < 4)
                mundaneLogs[i] = new ItemStack(Blocks.log, 1, i);
            else
                mundaneLogs[i] = new ItemStack(Blocks.log2, 1, i - 4);
        }
    }
}
