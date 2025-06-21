package tcreborn.model;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tcreborn.api.items.DeepCopy;
import tcreborn.api.items.types.BlockType;
import tcreborn.api.util.Logger;
import tcreborn.api.util.exceptions.ParameterIsNullOrEmpty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static tcreborn.api.items.ItemFinder.findBlockTC;
import static tcreborn.api.items.ItemFinder.findItemTC;

@SuppressWarnings("unused")
public class ArrayCollector {

    private static final ArrayList<ItemStack> mundaneLogs, mundanePlanks, magicalLogs, magicalPlanks, magicalLogsToPlanks;
    private static final ArrayList<BlockType> mundaneBlockLogs, magicalBlockLogs;
    private static final HashMap<Integer, ItemStack> mundaneLogToPlankMap, magicalLogToPlankMap;
    static {
        mundanePlanks = new ArrayList<>();
        mundaneLogs = new ArrayList<>();
        magicalLogs = new ArrayList<>();
        magicalPlanks = new ArrayList<>();
        magicalLogsToPlanks = new ArrayList<>();

        mundaneBlockLogs = new ArrayList<>();
        magicalBlockLogs = new ArrayList<>();

        mundaneLogToPlankMap = new HashMap<>();
        magicalLogToPlankMap = new HashMap<>();
    }

    public static void init() {
        // Add all metadata of vanilla logs/planks
        ItemStack log;
        Block block;
        for (int i = 0; i < 6; i++) {
            block = i < 4 ? Blocks.log : Blocks.log2;
            int meta = i < 4 ? i : i - 4;
            log = new ItemStack(block, 1, meta);
            addMundaneLogAndPlank(log, new ItemStack(Blocks.planks, 1, i));
            addMundaneBlockLog(block, meta);
        }
        // Adding Magical Logs & Planks - Other will be added by integrated mods
        addMagicalLogAndBlock(findBlockTC("blockMagicalLog", 0)); // Greatwood Log
        addMagicalLogAndBlock(findBlockTC("blockMagicalLog", 1)); // Silverwood Log
        addSameMagicalResultPlank(findItemTC("blockWoodenDevice", 6)); // Greatwood Planks
        addSameMagicalResultPlank(findItemTC("blockWoodenDevice", 7)); // Silverwood Planks
    }

    public static void initMap() {
        int i = 0;
        for (ItemStack plank : mundanePlanks)
            mundaneLogToPlankMap.put(i++, plank);
        i = 0;
        for (ItemStack plank : magicalLogsToPlanks)
            magicalLogToPlankMap.put(i++, plank);
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
    public static void addMagicalLogAndBlock(BlockType ... logs) {
        for (BlockType V : logs) {
            addMagicalBlockLog(V);
            addMagicalLog(new ItemStack(V.block(), 1, V.meta()));
        }
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

    public static void addMundaneBlockLog(Block block, int meta) {
        mundaneBlockLogs.add(new BlockType(block, meta));
    }
    public static void addMundaneBlockLog(BlockType block) {
        mundaneBlockLogs.add(block);
    }
    public static void addMagicalBlockLog(Block block, int meta) {
        magicalBlockLogs.add(new BlockType(block, meta));
    }
    public static void addMagicalBlockLog(BlockType block) {
        magicalBlockLogs.add(block);
    }

    public static BlockType[] getMundaneBlockLogs() {
        return mundaneBlockLogs.toArray(new BlockType[0]);
    }
    public static BlockType[] getMagicalBlockLogs() {
        return magicalBlockLogs.toArray(new BlockType[0]);
    }

    public static ItemStack getMundanePlank(int keyEvent, int amount) {
        return DeepCopy.i(mundaneLogToPlankMap.get(keyEvent), amount);
    }
    public static ItemStack getMagicalPlank(int keyEvent, int amount) {
        return DeepCopy.i(magicalLogToPlankMap.get(keyEvent), amount);
    }

}
