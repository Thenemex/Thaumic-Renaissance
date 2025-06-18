package tcreborn.api.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tcreborn.api.items.types.BlockType;
import tcreborn.api.util.exceptions.BlockOrItemDoesNotExist;
import thaumcraft.common.Thaumcraft;

@SuppressWarnings("unused")
public class ItemFinder {

    public static ItemStack findItem(String mod, String itemName, int meta) {
        Item item = GameRegistry.findItem(mod, itemName);
        if (item == null) throw new BlockOrItemDoesNotExist(mod, itemName, meta);
        return new ItemStack(item, 1 , meta);
    }
    public static ItemStack findItem(String mod, String itemName) {
        return findItem(mod, itemName, 0);
    }

    public static ItemStack findItemTC(String itemName, int meta) {
        return findItem(Thaumcraft.MODID, itemName, meta);
    }
    public static ItemStack findItemTC(String itemName) {
        return findItemTC(itemName, 0);
    }

    public static BlockType findBlock(String mod, String blockName, int meta) {
        Block block = GameRegistry.findBlock(mod, blockName);
        if (block == null) throw new BlockOrItemDoesNotExist(mod, blockName, meta);
        return new BlockType(block, meta);
    }
    public static BlockType findBlock(String mod, String blockName) {
        return findBlock(mod, blockName, 0);
    }

    public static BlockType findBlockTC(String blockName, int meta) {
        return findBlock(Thaumcraft.MODID, blockName, meta);
    }
    public static BlockType findBlockTC(String blockName) {
        return findBlockTC(blockName, 0);
    }

}
