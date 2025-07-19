package tcreborn.model.research;

import nemexlib.api.recipes.workbench.WorkbenchAdder;
import nemexlib.api.recipes.workbench.WorkbenchRemover;
import nemexlib.api.thaumcraft.research.AResearch;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.research.ResearchPage;

import java.util.ArrayList;
import java.util.Arrays;

import static nemexlib.api.items.ItemFinder.findItemTC;
import static tcreborn.model.ArrayCollector.getMagicalLogsToPlanks;
import static tcreborn.model.config.ConfigOreDict.*;

public class WoodBasicRecipes extends AResearch {

    public WoodBasicRecipes() {
        super(ConfigTab.lumberjack, "WOODBASICRECIPES", Blocks.crafting_table);
    }

    @Override
    public void init() {
        this.setNewResearch(-2, 0).setPages(new ResearchPage(research.getPageTag(1)),
                new ResearchPage(addRecipesMundanePlanks()),
                new ResearchPage(addRecipesMundaneSticks()),
                new ResearchPage(addRecipesMagicalPlanks()),
                new ResearchPage(addRecipesMagicalSticks()));
    }

    @Override
    public void removeRecipes() {
        WorkbenchRemover.i().removeItem(new ItemStack(Blocks.planks)); // Remove all vanilla planks recipes
        WorkbenchRemover.i().removeItem(new ItemStack(Items.stick)); // Remove all stick recipes
        WorkbenchRemover.i().removeMeta(findItemTC("blockWoodenDevice", 6)); // Remove Greatwood Plank recipe
        WorkbenchRemover.i().removeMeta(findItemTC("blockWoodenDevice", 7)); // Remove Silverwood Plank recipe
    }

    protected IRecipe[] addRecipesMundanePlanks() {
        IRecipe[] recipes = WorkbenchAdder.addMultipleSingleShapelessRecipes(getOres(mundanePlanksTag), getOres(mundaneLogsTag));
        return Arrays.copyOfRange(recipes, 0, 6);
    }
    protected IRecipe[] addRecipesMundaneSticks() {
        ArrayList<Object[]> inputRecipes = new ArrayList<>(getOres(mundanePlanksTag).length);
        for (ItemStack plank : getOres(mundanePlanksTag))
            inputRecipes.add(new Object[]{"P ", "P ", 'P', plank});
        IRecipe[] recipes = WorkbenchAdder.addMultipleSingleRecipes(new ItemStack(Items.stick), false, inputRecipes);
        return Arrays.copyOfRange(recipes, 0, 6);
    }
    protected IRecipe[] addRecipesMagicalPlanks() {
        IRecipe[] recipes = WorkbenchAdder.addMultipleSingleShapelessRecipes(getMagicalLogsToPlanks(), 2, getOres(magicalLogsTag));
        return Arrays.copyOfRange(recipes, 0, 2);
    }
    protected IRecipe[] addRecipesMagicalSticks() {
        ArrayList<Object[]> inputRecipes = new ArrayList<>(getOres(magicalPlanksTag).length);
        for (ItemStack plank : getOres(magicalPlanksTag))
            inputRecipes.add(new Object[]{"P ", "P ", 'P', plank});
        IRecipe[] recipes = WorkbenchAdder.addMultipleSingleRecipes(new ItemStack(Items.stick, 2), false, inputRecipes);
        return Arrays.copyOfRange(recipes, 0, 2);
    }

    @Override
    public void setResearchProperties() {
        this.research.setAutoUnlock().setRound();
    }
}
