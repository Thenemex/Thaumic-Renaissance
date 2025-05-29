package tcreborn.api.thaumcraft;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchPage;

public abstract class AResearch {

    protected final String tab, tag;
    protected AspectList aspects = null;
    protected final ItemStack icon;
    protected Research research;

    public AResearch(String tab, String tag, ItemStack icon) {
        this.tab = tab;
        this.tag = tag;
        this.icon = icon;
        init();
    }

    public abstract void init();

    public AResearch setResearchAspects(AspectList aspects) {
        this.aspects = aspects;
        return this;
    }
    public AResearch setNewResearch(int x, int y, int complexity) {
        this.research = API.newResearch(tag, tab, aspects, x, y, complexity, icon);
        return this.register();
    }
    public abstract void removeRecipes();
    public abstract IRecipe[] addRecipes();
    public AResearch setPages(ResearchPage ... pages) {
        research.setPages(pages);
        return this;
    }
    public abstract void setResearchProperties();

    private AResearch register() {
        research.registerResearchItem();
        return this;
    }

}
