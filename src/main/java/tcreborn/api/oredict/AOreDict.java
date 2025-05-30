package tcreborn.api.oredict;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class AOreDict {

    public AOreDict(String name, ItemStack ... ores) {
        OreDictionary.getOres(name, true);
        for (ItemStack ore : ores)
            OreDictionary.registerOre(name, ore);
    }
}
