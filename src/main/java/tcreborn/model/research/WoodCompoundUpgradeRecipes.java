package tcreborn.model.research;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tcreborn.api.recipes.mystical.CompoundAdder;
import tcreborn.api.thaumcraft.aspects.Aspects;
import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.research.ResearchPage;

import java.util.List;

import static tcreborn.api.items.ItemFinder.findItemTC;
import static tcreborn.model.config.ConfigHandlers.mundaneWoodCompoundHandler;
import static thaumcraft.api.aspects.Aspect.*;

@SuppressWarnings("rawtypes")
public class WoodCompoundUpgradeRecipes extends AResearch {

    public WoodCompoundUpgradeRecipes() {
        super(ConfigTab.lumberjack, "WOODCOMPOUNDUPGRADERECIPES", Blocks.planks);
    }

    @Override
    public void init() {
        this.setHandler(mundaneWoodCompoundHandler.setUpgradeResearchTag(tag).setVis(new Aspects(ENTROPY, 1)));
        this.setResearchAspects(new Aspect[]{TREE, TOOL, EARTH, ENTROPY}, 6, 3, 3, 6);
        this.setNewResearch(3, 4).setPages(newTextPage(1),
                new ResearchPage(addRecipeMundanePlank()));
    }

    protected List addRecipeMundanePlank(){
        return CompoundAdder.addCompoundRecipe(tag, new Aspects(ENTROPY, 1), 1, 2, 1,
                findItemTC("WandCasting"), new ItemStack(Blocks.log));
    }

    @Override
    public void setResearchProperties() {
        this.research.setParents("WOODCOMPOUNDMAGICALRECIPES").setParentsHidden("WOODARCANERECIPES").setConcealed().setSecondary();
    }
}
