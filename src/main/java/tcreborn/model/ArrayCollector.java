package tcreborn.model;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

import static tcreborn.api.items.ItemFinder.findItem;

public class ArrayCollector {

    private static final ArrayList<ItemStack> mundaneLogs, mundanePlanks, magicalLogs, magicalPlanks, magicalLogsToPlanks;

    static {
        mundanePlanks = new ArrayList<>();
        mundaneLogs = new ArrayList<>();
        magicalLogs = new ArrayList<>();
        magicalPlanks = new ArrayList<>();
        magicalLogsToPlanks = new ArrayList<>();
    }

    public static void init() {
        // Add all metadata of vanilla logs/planks
        for (int i = 0; i < 6; i++) {
            mundanePlanks.add(new ItemStack(Blocks.planks, 1, i));
            if (i < 4)
                mundaneLogs.add(new ItemStack(Blocks.log, 1, i));
            else
                mundaneLogs.add(new ItemStack(Blocks.log2, 1, i - 4));
        }
        // Adding Magical Logs
        ArrayList<ItemStack> list = new ArrayList<>();
        list.add(findItem("thaumcraft", "tile.blockMagicalLog", 0)); // Greatwood
        list.add(findItem("thaumcraft", "tile.blockMagicalLog", 1)); // Silverwood
    }

    public static void addMundaneLogAndPlank(ItemStack log, ItemStack plank) {
        mundaneLogs.add(log);
        mundanePlanks.add(plank);
    }
    public static void addMagicalLogAndPlank(ItemStack log, ItemStack plank) {
        magicalLogs.add(log);
        magicalLogsToPlanks.add(plank);
    }
    public static void addMagicalPlank(ItemStack plank) {
        magicalPlanks.add(plank);
    }

    public static ItemStack[] getMundaneLogs() {
        return mundaneLogs.toArray(new ItemStack[0]);
    }
    public static ItemStack[] getMundanePlanks() {
        return mundanePlanks.toArray(new ItemStack[0]);
    }
    public static ItemStack[] getMagicalLogs() {
        return magicalLogs.toArray(new ItemStack[0]);
    }
    public static ItemStack[] getMagicalPlanks() {
        return magicalPlanks.toArray(new ItemStack[0]);
    }
    public static ItemStack[] getMagicalLogsToPlanks() {
        return magicalLogsToPlanks.toArray(new ItemStack[0]);
    }
}
