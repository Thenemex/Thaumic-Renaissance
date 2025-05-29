package tcreborn.model.research;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import tcreborn.api.thaumcraft.API;
import tcreborn.api.thaumcraft.AResearch;
import tcreborn.api.recipes.RecipeAdder;
import tcreborn.api.recipes.RecipeRemover;
import thaumcraft.api.research.ResearchPage;

public class WoodBasicRecipes extends AResearch {

    public WoodBasicRecipes() {
        super("LUMBERJACK", "WOODBASICRECIPES", new ItemStack(Blocks.planks));
    }

    @Override
    public void init() {
        API.newCategory(tab, new ResourceLocation("minecraft", "textures/items/stone_axe.png"));
        // ToDo Abstract API Tabs
        this.setNewResearch(0, 0, 1).setResearchProperties();
        this.setPages(new ResearchPage(research.getPage(1)), new ResearchPage(addRecipes())).removeRecipes();
    }

    @Override
    public void removeRecipes() {
        RecipeRemover.removeItem(new ItemStack(Blocks.planks)); // Remove all vanilla planks recipes
    }
    @Override
    public IRecipe[] addRecipes() {
        IRecipe[] recipes = new IRecipe[6];
        for (int i = 0; i < 6; i++) // 1 Log = 1 Plank
            if (i < 4)
                recipes[i] = RecipeAdder.addRecipe(
                        new ItemStack(Blocks.planks, 1, i), true,
                        new ItemStack(Blocks.log, 1, i));
            else
                recipes[i] = RecipeAdder.addRecipe(
                        new ItemStack(Blocks.planks, 1, i), true,
                        new ItemStack(Blocks.log2, 1, i - 4));
        return recipes;
    }

    @Override
    public void setResearchProperties() {
        this.research.setAutoUnlock().setRound();
    }
}
