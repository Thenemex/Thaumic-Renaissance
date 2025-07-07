package tcreborn.model.config;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import tcreborn.api.oredict.AOreDict;

import static tcreborn.model.ArrayCollector.*;

public class ConfigOreDict {

    public static final String mundaneLogsTag = "mundaneLogs",
            mundanePlanksTag = "mundanePlanks",
            magicalLogsTag = "magicalLogs",
            magicalPlanksTag = "magicalPlanks";

    public static void init() {
        new AOreDict(mundaneLogsTag, getMundaneLogs());
        new AOreDict(mundanePlanksTag, getMundanePlanks());
        new AOreDict(magicalLogsTag, getMagicalLogs());
        new AOreDict(magicalPlanksTag, getMagicalPlanks());
    }

    public static ItemStack[] getOres(String name) {
        return OreDictionary.getOres(name).toArray(new ItemStack[0]);
    }
}
