package tcreborn.api.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tcreborn.api.util.exceptions.ParameterIsNullOrEmpty;
import thaumcraft.common.Thaumcraft;

public class ItemFinder {

    public static ItemStack findItem(String mod, String itemName, int meta) {
        Item item = GameRegistry.findItem(mod, itemName);
        if (item == null) throw new ParameterIsNullOrEmpty();
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

}
