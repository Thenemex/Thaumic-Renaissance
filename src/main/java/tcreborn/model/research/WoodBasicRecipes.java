package tcreborn.model.research;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.api.recipes.RecipeAdder;
import tcreborn.api.recipes.RecipeRemover;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.research.ResearchPage;

import static tcreborn.model.ArrayCollector.*;
import static tcreborn.model.config.ConfigOreDict.getOres;
import static tcreborn.model.config.ConfigOreDict.mundanePlanksTag;

public class WoodBasicRecipes extends AResearch {

    public WoodBasicRecipes() {
        super(ConfigTab.tabLumberjack, "WOODBASICRECIPES", new ItemStack(Blocks.planks));
    }

    @Override
    public void init() {
        this.setNewResearch(0, 0, 1).setResearchProperties();
        this.removeRecipes();
        this.setPages(new ResearchPage(research.getPage(1)),
                new ResearchPage(addRecipes()),
                new ResearchPage(addRecipesStickMundane()));
    }

    @Override
    public void removeRecipes() {
        RecipeRemover.removeItem(new ItemStack(Blocks.planks)); // Remove all vanilla planks recipes
        RecipeRemover.removeItem(new ItemStack(Items.stick)); // Remove all stick recipes
    }
    @Override
    public IRecipe[] addRecipes() {
        return RecipeAdder.addMultipleSingleShapelessRecipes(getMundanePlanks(), getMundaneLogs());
    }
    private IRecipe[] addRecipesStickMundane() {
        return RecipeAdder.addSingleShapelessRecipes(new ItemStack(Items.stick), getOres(mundanePlanksTag));
    }

    @Override
    public void setResearchProperties() {
        this.research.setAutoUnlock().setRound();
    }
}
