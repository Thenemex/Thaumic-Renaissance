package tcreborn.api;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import tcreborn.api.thaumcraft.Research;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;

public class API {

    /**
     * Create a new tab in the Thaumonomicon, with the default TC4 background
     * @param tag Tab tag
     * @param icon The icon
     */
    public static void newCategory(String tag, ResourceLocation icon) {
        ResearchCategories.registerCategory(tag, icon, new ResourceLocation("thaumcraft","textures/gui/gui_researchback.png"));
    }

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
    public static Research newResearch(String tag, String tab, AspectList aspects, int x, int y, int complexity, ItemStack icon) {
        return new Research(tag, tab, aspects, x, y, complexity, icon);
    }


}
