package tests;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import tcreborn.api.API;
import tcreborn.api.recipes.RecipeAdder;
import tcreborn.api.recipes.RecipeRemover;
import tcreborn.api.thaumcraft.Research;
import thaumcraft.api.research.ResearchPage;

import java.util.ArrayList;

public class Tests {

    public static final String tabName = "LUMBERJACK";

    public static void init() {
        // Making new tab test
        API.newCategory(tabName, new ResourceLocation("minecraft", "textures/items/stone_axe.png"));
        // Making new research
        Research res = API.newResearch("WOODBASICRECIPES", tabName, null, 0, 0, 1, new ItemStack(Blocks.planks));
        res.setPages(new ResearchPage(res.getPage(1))).setAutoUnlock().setRound().registerResearchItem();
        RecipeRemover.removeItem(new ItemStack(Blocks.planks)); // Remove all planks recipes
        ArrayList<IRecipe> recipes = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) { // 1 Log = 1 Plank
            if (i < 4)
                 recipes.add(RecipeAdder.addRecipe(
                        new ItemStack(Blocks.planks, 1, i), true,
                        new ItemStack(Blocks.log, 1, i)));
            else recipes.add(RecipeAdder.addRecipe(
                        new ItemStack(Blocks.planks, 1, i), true,
                        new ItemStack(Blocks.log2, 1, i - 4)));
            recipes.add(RecipeRemover.getLastRecipeAdded());
        }
        // ToDo Remove wood recipes, re add them in HashMap and loop on them for adding them to page
    }
}
