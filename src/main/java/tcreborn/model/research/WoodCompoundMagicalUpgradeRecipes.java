package tcreborn.model.research;

import tcreborn.api.recipes.mystical.CompoundAdder;
import tcreborn.api.thaumcraft.aspects.Aspects;
import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.research.ResearchPage;

import java.util.List;

import static tcreborn.api.items.ItemFinder.findItemTC;
import static tcreborn.model.config.ConfigHandlers.magicalWoodCompoundHandler;
import static thaumcraft.api.aspects.Aspect.*;

@SuppressWarnings("rawtypes")
public class WoodCompoundMagicalUpgradeRecipes extends AResearch {

    public WoodCompoundMagicalUpgradeRecipes() {
        super(ConfigTab.lumberjack, "WOODCOMPOUNDMAGICALUPGRADERECIPES", findItemTC("blockWoodenDevice", 6));
    }

    @Override
    public void init() {
        this.setHandler(magicalWoodCompoundHandler.setUpgradeResearchTag(tag).setVis(new Aspects(ENTROPY, 2)));
        this.setResearchAspects(new Aspect[]{MAGIC, TREE, TOOL, EARTH, ENTROPY}, 6, 6, 3, 3, 3);
        this.setNewResearch(1, 4).setPages(newTextPage(1),
                new ResearchPage(addRecipeMagicalPlank()));
    }

    protected List addRecipeMagicalPlank(){
        return CompoundAdder.addCompoundRecipe(tag, new Aspects(ENTROPY, 2), 1, 2, 1,
                findItemTC("WandCasting"), findItemTC("blockMagicalLog"));
    }

    @Override
    public void setResearchProperties() {
        this.research.setParents("WOODCOMPOUNDMAGICALRECIPES").setParentsHidden("WOODCOMPOUNDUPGRADERECIPES").setConcealed().setSecondary();
    }
}
