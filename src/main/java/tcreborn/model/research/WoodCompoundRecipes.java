package tcreborn.model.research;

import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.research.ResearchPage;

import static tcreborn.api.items.ItemFinder.findItemTC;
import static thaumcraft.api.aspects.Aspect.*;

public class WoodCompoundRecipes extends AResearch {

    public WoodCompoundRecipes() {
        super(ConfigTab.lumberjack, "WOODCOMPOUNDRECIPES", findItemTC("WandCasting"));
    }

    @Override
    public void init() {
        this.setResearchAspects(new Aspect[]{TREE, CRAFT, EARTH, ENTROPY}, 6, 3, 1, 1);
        this.setNewResearch(5, 0, 2);
        this.setPages(new ResearchPage(research.getPageTag(1)));
    }

    @Override
    public void setResearchProperties() {
        this.research.setParents("WOODCRUCIBLERECIPES").setSpecial();
    }
}
