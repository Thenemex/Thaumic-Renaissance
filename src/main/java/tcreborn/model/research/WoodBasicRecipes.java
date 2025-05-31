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

import java.util.ArrayList;

import static tcreborn.model.config.ConfigOreDict.*;

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
        // Example for Object : new Object[]{"CRC","RRR","CRC", 'C', Blocks.coal_block, 'R', Items.redstone}); // Gives x8 output
        return RecipeAdder.addMultipleSingleShapelessRecipes(getOres(mundanePlanksTag), getOres(mundaneLogsTag));
    }
    private IRecipe[] addRecipesStickMundane() {
        ArrayList<Object[]> recipes = new ArrayList<>(getOres(mundanePlanksTag).length);
        for (ItemStack plank : getOres(mundanePlanksTag))
            recipes.add(new Object[]{"P ", "P ", 'P', plank});
        return RecipeAdder.addMultipleSingleRecipes(new ItemStack(Items.stick), false, recipes);
    }
    private IRecipe[] addRecipesPlanksMagical() {
        //ToDo return RecipeAdder.addMultipleSingleShapelessRecipes(getOres(), )
        return null;
    }

    @Override
    public void setResearchProperties() {
        this.research.setAutoUnlock().setRound();
    }
}
