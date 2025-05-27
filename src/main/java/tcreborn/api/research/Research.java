package tcreborn.api.research;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;

import static tcreborn.ThaumicRenaissance.modID;

public class Research extends ResearchItem {

    /**
     * Create a new research in the Thaumonomicon, and registers it
     * @param tag Research tag
     * @param tab Thaumonomicon tab
     * @param aspects Research Aspects
     * @param x Row position
     * @param y Column position
     * @param complexity Research complexity
     * @param icon The item's icon
     */
    public Research(String tag, String tab, AspectList aspects, int x, int y, int complexity, ItemStack icon) {
        super(tag, tab, aspects, x, y, complexity, icon);
    }

    /**
     * Adds warp to a research
     * @param warp The amount of warp
     */
    public Research addWarp(int warp) {
        ThaumcraftApi.addWarpToResearch(key, warp);
        return this;
    }

    @Override
    public String getName() {
        return StatCollector.translateToLocal(getPrefix().concat("name.").concat(key));
    }
    @Override
    public String getText() {
        return StatCollector.translateToLocal(getPrefix().concat("text.").concat(key));
    }

    public String getPage(int number) {
        return getPrefix().concat("page.").concat(key).concat(".").concat(String.valueOf(number));
    }

    private static String getPrefix() {
        return modID.toLowerCase().concat("_research_");
    }
}
