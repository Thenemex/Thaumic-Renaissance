package tcreborn.api.thaumcraft.research;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tcreborn.api.thaumcraft.API;
import tcreborn.api.thaumcraft.aspects.Aspects;
import tcreborn.config.Config;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.research.ResearchPage;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public abstract class AResearch {

    protected final String tab, tag;
    protected final boolean expert;
    protected Aspects aspects;
    protected final ItemStack icon;
    protected Research research;

    public AResearch(String tab, String tag, ItemStack icon) {
        this.tab = tab;
        this.tag = tag;
        this.icon = icon;
        this.expert = Config.expertWoodRecipesEnabled;
        removeRecipes();
        init();
    }

    public AResearch(String tab, String tag, Block block) {
        this(tab, tag, new ItemStack(block));
    }
    public AResearch(String tab, String tag, Block block, int meta) {
        this(tab, tag, new ItemStack(block, 1, meta));
    }
    public AResearch(String tab, String tag, Item item) {
        this(tab, tag, new ItemStack(item));
    }
    public AResearch(String tab, String tag, Item item, int meta) {
        this(tab, tag, new ItemStack(item, 1, meta));
    }

    public abstract void init();

    public AResearch setResearchAspects(Aspect aspect, int amount) {
        this.aspects = new Aspects(aspect, amount);
        return this;
    }
    public AResearch setResearchAspects(Aspect[] aspects, int ... amounts) {
        this.aspects = new Aspects(aspects, amounts);
        return this;
    }

    public AResearch setNewResearch(int x, int y, int complexity) {
        this.research = API.newResearch(tag, tab, aspects, x, y, complexity, icon);
        this.setResearchProperties();
        return this.register();
    }

    public void removeRecipes() {}

    public void setPages(ResearchPage ... pages) {
        research.setPages(pages);
    }
    public abstract void setResearchProperties();

    private AResearch register() {
        research.registerResearchItem();
        return this;
    }
}
