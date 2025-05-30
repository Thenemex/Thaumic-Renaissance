package tcreborn.model.config;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import tcreborn.api.oredict.AOreDict;
import tcreborn.model.ArrayCollector;

public class ConfigOreDict {

    public static String mundanePlanksTag = "mundanePlanks", magicalPlanksTag = "magicalPlanks";

    public static void init() {
        new AOreDict(mundanePlanksTag, ArrayCollector.mundanePlanks);
        //new AOreDict(magicalPlanksTag, ArrayCollector.magicalPlanks);
        // ToDo Do a class to store all planks array for easier oredict
    }

    public static ItemStack[] getOres(String name) {
        return OreDictionary.getOres(name).toArray(new ItemStack[0]);
    }
}
