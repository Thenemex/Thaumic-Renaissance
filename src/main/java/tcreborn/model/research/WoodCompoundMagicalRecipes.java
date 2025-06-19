package tcreborn.model.research;

import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.research.ResearchPage;

import static tcreborn.api.items.ItemFinder.findItemTC;
import static thaumcraft.api.aspects.Aspect.*;

public class WoodCompoundMagicalRecipes extends AResearch {

    public WoodCompoundMagicalRecipes() {
        super(ConfigTab.lumberjack, "WOODCOMPOUNDMAGICALRECIPES", findItemTC("blockMagicalLog"));
    }

    @Override
    public void init() {
        this.setResearchAspects(new Aspect[]{TREE, MAGIC, TOOL, EARTH},6, 3, 3, 3);
        this.setNewResearch(2, 2, 1);
        this.setPages(new ResearchPage(research.getPageTag(1)));
    }

    @Override
    public void setResearchProperties() {
        this.research.setParents("WOODCOMPOUNDRECIPES").setConcealed().setItemTriggers(
                findItemTC("blockMagicalLog")); // Greatwood Log
    }
}
