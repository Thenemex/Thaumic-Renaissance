package tcreborn.api;

import net.minecraft.item.ItemStack;
import tcreborn.api.thaumcraft.Research;
import thaumcraft.api.aspects.AspectList;

public abstract class AResearch {

    protected String tab, tag;
    protected AspectList aspects = null;
    protected ItemStack icon;
    protected Research research;

    public void setTabTag(String tab, String tag) {
        this.tab = tab;
        this.tag = tag;
    }
    public void setResearchAspects(AspectList aspects) {
        this.aspects = aspects;
    }
    public void setIcon(ItemStack icon) {
        this.icon = icon;
    }
    public void setNewResearch(int x, int y, int complexity) {
        this.research = API.newResearch(tag, tab, aspects, x, y, complexity, icon);
    }

}
