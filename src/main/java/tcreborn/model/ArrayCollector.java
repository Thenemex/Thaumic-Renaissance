package tcreborn.model;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tcreborn.api.exceptions.ParameterIsNullOrEmpty;
import thaumcraft.common.Thaumcraft;

import java.util.ArrayList;
import java.util.Arrays;

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
        for (int i = 0; i < 6; i++)
            if (i < 4)
                addMundaneLogAndPlank(
                        new ItemStack(Blocks.log, 1, i),
                        new ItemStack(Blocks.planks, 1, i));
            else
                addMundaneLogAndPlank(
                        new ItemStack(Blocks.log2, 1, i - 4),
                        new ItemStack(Blocks.planks, 1, i));
        // Adding Magical Logs & Planks - Other will be added by integrated mods
        addMagicalLog(findItem(Thaumcraft.MODID, "blockMagicalLog", 0)); // Greatwood Log
        addMagicalLog(findItem(Thaumcraft.MODID, "blockMagicalLog", 1)); // Silverwood Log
        addSameMagicalResultPlank(findItem(Thaumcraft.MODID, "blockWoodenDevice", 6)); // Greatwood Planks
        addSameMagicalResultPlank(findItem(Thaumcraft.MODID, "blockWoodenDevice", 7)); // Silverwood Planks
    }

    public static void addMundaneLogAndPlank(ItemStack log, ItemStack plank) {
        mundaneLogs.add(log);
        mundanePlanks.add(plank);
    }
    public static void addMagicalLogAndPlank(ItemStack log, ItemStack plank) {
        addMagicalLog(log);
        addPlankResultOfMagical(plank);
    }
    public static void addMagicalLog(ItemStack ... logs) {
        if (logs == null || logs.length == 0) throw new ParameterIsNullOrEmpty();
        magicalLogs.addAll(Arrays.asList(logs));
    }
    public static void addMagicalPlank(ItemStack ... planks) {
        if (planks == null || planks.length == 0) throw new ParameterIsNullOrEmpty();
        magicalPlanks.addAll(Arrays.asList(planks));
    }
    public static void addMagicalAndResultPlank(ItemStack magicalPlank, ItemStack resultPlank) {
        addMagicalPlank(magicalPlank);
        addPlankResultOfMagical(resultPlank);
    }
    public static void addSameMagicalResultPlank(ItemStack plank) {
        addMagicalAndResultPlank(plank, plank);
    }
    public static void addPlankResultOfMagical(ItemStack ... planks) {
        if (planks == null || planks.length == 0) throw new ParameterIsNullOrEmpty();
        magicalLogsToPlanks.addAll(Arrays.asList(planks));
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
