package tcreborn.api.thaumcraft.research;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tcreborn.api.events.WandEventHandler;
import tcreborn.api.thaumcraft.API;
import tcreborn.api.thaumcraft.aspects.Aspects;
import tcreborn.api.util.exceptions.FieldIsNull;
import tcreborn.api.util.exceptions.ParameterIsNullOrEmpty;
import tcreborn.config.Config;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.research.ResearchPage;

import java.util.Arrays;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public abstract class AResearch {

    protected final String tab, tag;
    protected final boolean expert;
    protected final ItemStack icon;
    protected WandEventHandler handler;
    protected Aspects aspects;
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
    public abstract void setResearchProperties();
    public void removeRecipes() {}

    public Aspects getAspects() throws FieldIsNull {
        if (aspects == null) throw new FieldIsNull();
        return aspects;
    }
    public AResearch setResearchAspects(Aspect aspect, int amount) {
        this.aspects = new Aspects(aspect, amount);
        return this;
    }
    public AResearch setResearchAspects(Aspect[] aspects, int ... amounts) {
        this.aspects = new Aspects(aspects, amounts);
        return this;
    }
    public AResearch setResearchAspects(Aspects aspects) {
        this.aspects = aspects;
        return this;
    }

    public AResearch setNewResearch(int x, int y, int complexity) {
        this.research = API.newResearch(tag, tab, aspects, x, y, complexity, icon);
        this.setResearchProperties();
        return this.register();
    }

    public AResearch setPages(ResearchPage ... pages) {
        this.research.setPages(pages);
        return this;
    }
    public AResearch addPage(ResearchPage ... pages) {
        if (pages == null || pages.length == 0) throw new ParameterIsNullOrEmpty();
        int oldLength = getNbPages();
        int newLength = oldLength + pages.length;
        ResearchPage[] newPages = Arrays.copyOf(research.getPages(), newLength);
        System.arraycopy(pages, 0, newPages, oldLength, pages.length);
        this.setPages(newPages);
        return this;
    }
    public int getNbPages() {
        return research.getPages().length;
    }

    public WandEventHandler getHandler() throws FieldIsNull {
        if (handler == null) throw new FieldIsNull();
        return handler;
    }
    public AResearch setHandler(WandEventHandler handler) {
        this.handler = handler;
        return this;
    }

    protected AResearch register() {
        research.registerResearchItem();
        return this;
    }
}
