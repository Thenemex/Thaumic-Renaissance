package tcreborn.model.research;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tcreborn.api.recipes.mystical.CompoundAdder;
import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigHandlers;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.research.ResearchPage;

import java.util.List;

import static tcreborn.api.items.ItemFinder.findItemTC;
import static thaumcraft.api.aspects.Aspect.*;

@SuppressWarnings("rawtypes")
public class WoodCompoundRecipes extends AResearch {

    public WoodCompoundRecipes() {
        super(ConfigTab.lumberjack, "WOODCOMPOUNDRECIPES", Blocks.log);
    }

    @Override
    public void init() {
        this.setHandler(ConfigHandlers.mundaneWoodCompoundHandler);
        this.setResearchAspects(new Aspect[]{TREE, CRAFT, EARTH, ENTROPY}, 6, 3, 1, 1);
        this.setNewResearch(0, 1, 2).setPages(newTextPage(1),
                new ResearchPage(addRecipeMundanePlank()));
    }

    protected List addRecipeMundanePlank() {
        return CompoundAdder.addCompoundRecipe(tag, null, 1, 2, 1,
                findItemTC("WandCasting"), new ItemStack(Blocks.log));
    }

    @Override
    public void setResearchProperties() {
        this.research.setAutoUnlock().setRound();
    }
}
