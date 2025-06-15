package tcreborn.model.research;

import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.research.ResearchPage;

import static tcreborn.api.items.ItemFinder.findItemTC;
import static thaumcraft.api.aspects.Aspect.*;

public class WoodCrucibleMagicalRecipes extends AResearch {

    public WoodCrucibleMagicalRecipes() {
        super(ConfigTab.lumberjack, "WOODCRUCIBLEMAGICALRECIPES", findItemTC("blockMagicalLog"));
    }

    @Override
    public void init() {
        this.setResearchAspects(new Aspect[]{MAGIC, TREE, EARTH}, 6, 3, 3);
        this.setNewResearch(3, -4, 1);
        this.setPages(new ResearchPage(research.getPageTag(1)));
        // ToDo Move all researchs to the left, so non-expert looks great without spacing
    }

    @Override
    public void setResearchProperties() {
        this.research.setParents("WOODCRUCIBLERECIPES").setConcealed().setSecondary();
    }
}
