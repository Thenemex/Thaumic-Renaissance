package tcreborn.model.research.wood;

import nemexlib.api.recipes.mystical.CompoundAdder;
import nemexlib.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigHandlers;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.research.ResearchPage;

import java.util.List;

import static nemexlib.api.items.ItemFinder.findItemTC;
import static thaumcraft.api.aspects.Aspect.*;

@SuppressWarnings("rawtypes")
public class WoodCompoundMagicalRecipes extends AResearch {

    public WoodCompoundMagicalRecipes() {
        super(ConfigTab.lumberjack, "WOODCOMPOUNDMAGICALRECIPES", findItemTC("blockMagicalLog"));
    }

    @Override
    public void init() {
        this.setHandler(ConfigHandlers.magicalWoodCompoundHandler);
        this.setResearchAspects(new Aspect[]{TREE, MAGIC, TOOL, EARTH},6, 3, 3, 3);
        this.setNewResearch(2, 2, 1).setPages(newTextPage(1),
                new ResearchPage(addRecipeMagicalPlank()));
    }

    protected List addRecipeMagicalPlank() {
        return CompoundAdder.addCompoundRecipe(tag, null, 1, 2, 1,
                findItemTC("WandCasting"), findItemTC("blockMagicalLog"));
    }

    @Override
    public void setResearchProperties() {
        this.research.setParents("WOODCOMPOUNDRECIPES").setConcealed();
    }
}
