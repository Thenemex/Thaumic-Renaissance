package tcreborn.model.research.wood;

import nemexlib.api.recipes.crucible.CrucibleAdder;
import nemexlib.api.thaumcraft.aspects.Aspects;
import nemexlib.api.thaumcraft.research.AResearch;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.research.ResearchPage;

import java.util.Arrays;

import static nemexlib.api.items.ItemFinder.findItemTC;
import static tcreborn.model.ArrayCollector.getMagicalLogsToPlanks;
import static tcreborn.model.config.ConfigOreDict.*;
import static thaumcraft.api.aspects.Aspect.*;

public class WoodCrucibleRecipes extends AResearch {

    protected Aspects mundane, magical, stick;

    public WoodCrucibleRecipes() {
        super(ConfigTab.lumberjack, "WOODCRUCIBLERECIPES", findItemTC("blockMetalDevice"));
    }

    @Override
    public void init() {
        this.mundane = new Aspects(new Aspect[]{TREE, CRAFT, ENTROPY}, 3, 1, 1);
        this.magical = new Aspects(new Aspect[]{TREE, CRAFT, ENTROPY}, 4, 2, 2);
        this.stick = new Aspects(new Aspect[]{TREE, ENTROPY}, 1, 2);
        this.setResearchAspects(new Aspect[]{TREE, MAGIC, EARTH}, 6, 3, 3);
        this.setNewResearch(2, -2, 1).setPages(newTextPage(1),
                new ResearchPage(addRecipesMundanePlanks()),
                new ResearchPage(addRecipesMundaneSticks()),
                new ResearchPage(addRecipesMagicalPlanks()),
                new ResearchPage(addRecipesMagicalSticks()));
        // Recipes already removed in WoodBasicRecipes
    }

    protected CrucibleRecipe[] addRecipesMundanePlanks() {
        CrucibleRecipe[] recipes = CrucibleAdder.addMultipleRecipe(tag, mundane, getOres(mundanePlanksTag), expert ? 4 : 10, getOres(mundaneLogsTag));
        return Arrays.copyOfRange(recipes, 0, 6);
    }
    protected CrucibleRecipe[] addRecipesMundaneSticks() {
        CrucibleRecipe[] recipes = CrucibleAdder.addMultipleSingleRecipe(tag, stick, new ItemStack(Items.stick, expert ? 4 : 10), getOres(mundanePlanksTag));
        return Arrays.copyOfRange(recipes, 0, 6);
    }
    protected CrucibleRecipe[] addRecipesMagicalPlanks() {
        CrucibleRecipe[] recipes = CrucibleAdder.addMultipleRecipe(tag, magical, getMagicalLogsToPlanks(), expert ? 6 : 15, getOres(magicalLogsTag));
        return Arrays.copyOfRange(recipes, 0, 2);
    }
    protected CrucibleRecipe[] addRecipesMagicalSticks() {
        CrucibleRecipe[] recipes = CrucibleAdder.addMultipleSingleRecipe(tag, stick, new ItemStack(Items.stick, expert ? 6 : 15), getOres(magicalPlanksTag));
        return Arrays.copyOfRange(recipes, 0, 2);
    }

    @Override
    public void setResearchProperties() {
        this.research.setParents("WOODARCANERECIPES");
    }
}
