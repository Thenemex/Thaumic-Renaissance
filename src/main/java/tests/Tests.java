package tests;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import tcreborn.api.API;
import tcreborn.api.recipes.RecipeRemover;
import tcreborn.api.research.Research;
import thaumcraft.api.research.ResearchPage;

public class Tests {

    public static final String tabName = "LUMBERJACK";

    public static void init() {
        // Making new tab test
        API.newCategory(tabName, new ResourceLocation("minecraft", "textures/items/stone_axe.png"));
        // Making new research
        Research res = API.newResearch("WOODBASICRECIPES", tabName, null, 0, 0, 1, new ItemStack(Blocks.planks));
        res.setPages(new ResearchPage(res.getPage(1))).setAutoUnlock().setRound().registerResearchItem();
        RecipeRemover.removeItem(new ItemStack(Blocks.planks));
        // ToDo Remove wood recipes, re add them in HashMap and loop on them for adding them to page
    }
}
