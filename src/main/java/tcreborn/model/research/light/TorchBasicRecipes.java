package tcreborn.model.research.light;

import nemexlib.api.recipes.RecipeFinder;
import nemexlib.api.thaumcraft.research.AResearch;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.research.ResearchPage;

public class TorchBasicRecipes extends AResearch {
    public TorchBasicRecipes() {
        super(ConfigTab.lumberjack, "TORCHBASICRECIPES", Blocks.torch);
    }

    @Override
    public void init() {
        this.setNewResearch(2, 0).setPages(new ResearchPage(research.getPageTag(1)),
                new ResearchPage(getTorchRecipe()));
    }

    protected IRecipe getTorchRecipe() {
        return RecipeFinder.findRecipeAmount(new ItemStack(Blocks.torch, 4));
    }

    @Override
    public void setResearchProperties() {
        this.research.setAutoUnlock().setRound();
    }
}
