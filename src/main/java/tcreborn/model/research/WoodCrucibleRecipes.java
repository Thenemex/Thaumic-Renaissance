package tcreborn.model.research;

import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.research.ResearchPage;

import static tcreborn.api.items.ItemFinder.findItemTC;
import static thaumcraft.api.aspects.Aspect.*;

public class WoodCrucibleRecipes extends AResearch {

    public WoodCrucibleRecipes() {
        super(ConfigTab.lumberjack, "WOODCRUCIBLERECIPES", findItemTC("blockMetalDevice", 0));
    }

    @Override
    public void init() {
        this.setResearchAspects(new Aspect[]{TREE, MAGIC, EARTH}, 6, 3, 3);
        this.setNewResearch(4, -2, 1);
        this.setPages(new ResearchPage(research.getPageTag(1)));
        // Recipes already removed in WoodBasicRecipes
    }

    @Override
    public void setResearchProperties() {
        this.research.setParents("WOODARCANERECIPES");
    }
}
