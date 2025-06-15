package tcreborn.model.research;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tcreborn.api.recipes.crucible.CrucibleAdder;
import tcreborn.api.thaumcraft.aspects.Aspects;
import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.research.ResearchPage;

import java.util.Arrays;

import static tcreborn.api.items.ItemFinder.findItemTC;
import static tcreborn.model.ArrayCollector.getMagicalLogsToPlanks;
import static tcreborn.model.config.ConfigOreDict.*;
import static thaumcraft.api.aspects.Aspect.*;

public class WoodCrucibleRecipes extends AResearch {

    protected Aspects mundane, magical;

    public WoodCrucibleRecipes() {
        super(ConfigTab.lumberjack, "WOODCRUCIBLERECIPES", findItemTC("blockMetalDevice"));
    }

    @Override
    public void init() {
        this.mundane = new Aspects(new Aspect[]{TREE, CRAFT, ENTROPY}, 3, 1, 1);
        this.magical = new Aspects(new Aspect[]{TREE, CRAFT, ENTROPY}, 4, 2, 2);
        this.setResearchAspects(new Aspect[]{TREE, MAGIC, EARTH}, 6, 3, 3);
        this.setNewResearch(2, -2, 1);
        this.setPages(new ResearchPage(research.getPageTag(1)),
                new ResearchPage(addRecipesMundanePlanks()),
                new ResearchPage(addRecipesMundaneSticks()),
                new ResearchPage(addRecipesMagicalPlanks()),
                new ResearchPage(addRecipesMagicalSticks()));
        // Recipes already removed in WoodBasicRecipes
    }

    protected CrucibleRecipe[] addRecipesMundanePlanks() {
         return CrucibleAdder.addMultipleRecipe(tag, mundane, getOres(mundanePlanksTag), expert ? 4 : 10, getOres(mundaneLogsTag));
    }
    protected CrucibleRecipe[] addRecipesMundaneSticks() {
        return CrucibleAdder.addMultipleSingleRecipe(tag, mundane, new ItemStack(Items.stick, expert ? 4 : 10), getOres(mundanePlanksTag));
    }
    protected CrucibleRecipe[] addRecipesMagicalPlanks() {
        CrucibleRecipe[] recipes = CrucibleAdder.addMultipleRecipe(tag, magical, getMagicalLogsToPlanks(), expert ? 6 : 15, getOres(magicalLogsTag));
        return Arrays.copyOfRange(recipes, 0, 2);
    }
    protected CrucibleRecipe[] addRecipesMagicalSticks() {
        CrucibleRecipe[] recipes = CrucibleAdder.addMultipleSingleRecipe(tag, magical, new ItemStack(Items.stick, expert ? 6 : 15), getOres(magicalPlanksTag));
        return Arrays.copyOfRange(recipes, 0, 2);
    }

    @Override
    public void setResearchProperties() {
        this.research.setParents("WOODARCANERECIPES").setItemTriggers(
                new ItemStack(Blocks.log, 1, 0), // Oak Log
                new ItemStack(Blocks.planks, 1, 0), // Oak Plank
                new ItemStack(Items.stick)); // Stick
    }
}
