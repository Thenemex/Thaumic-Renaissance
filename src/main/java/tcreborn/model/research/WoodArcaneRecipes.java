package tcreborn.model.research;

import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.research.ResearchPage;

import static tcreborn.api.items.ItemFinder.findItemTC;
import static thaumcraft.api.aspects.Aspect.*;

public class WoodArcaneRecipes extends AResearch {

    public WoodArcaneRecipes() {
        super(ConfigTab.lumberjack, "WOODARCANERECIPES", findItemTC("blockTable", 15));
    }

    @Override
    public void init() {
        this.setResearchAspects(new Aspect[]{EARTH}, 3);
        this.setNewResearch(2,-1, 1).setResearchProperties();
        this.setPages(new ResearchPage(research.getPageTag(1)));
        // ToDo Pages
    }

    @Override
    public void setResearchProperties() {
        this.research.setSecondary().setSiblings("WOODBASICRECIPES");
    }
}
