package tcreborn.model.research;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tcreborn.api.recipes.arcane.ArcaneAdder;
import tcreborn.api.thaumcraft.aspects.Aspects;
import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.research.ResearchPage;

import java.util.ArrayList;
import java.util.Arrays;

import static tcreborn.api.items.ItemFinder.findItemTC;
import static tcreborn.model.ArrayCollector.getMagicalLogsToPlanks;
import static tcreborn.model.config.ConfigOreDict.*;
import static thaumcraft.api.aspects.Aspect.*;

public class WoodArcaneRecipes extends AResearch {

    public WoodArcaneRecipes() {
        super(ConfigTab.lumberjack, "WOODARCANERECIPES", findItemTC("blockTable", 15));
    }

    @Override
    public void init() {
        this.setResearchAspects(EARTH, 3);
        this.setNewResearch(0,-1, 1);
        this.setPages(new ResearchPage(research.getPageTag(1)),
                new ResearchPage(addRecipesMundanePlanks()),
                new ResearchPage(addRecipesMundaneSticks()),
                new ResearchPage(addRecipesMagicalPlanks()),
                new ResearchPage(addRecipesMagicalSticks()));
        // Recipes already removed in WoodBasicRecipes
    }

    protected IArcaneRecipe[] addRecipesMundanePlanks() {
        ArrayList<Object[]> recipes = new ArrayList<>(getOres(mundaneLogsTag).length);
        for (ItemStack log : getOres(mundaneLogsTag))
            recipes.add(new Object[]{"LL", "LL", 'L', log});
        return ArcaneAdder.addMultipleArcane(tag, new Aspects(ENTROPY, 1), getOres(mundanePlanksTag), expert ? 8 : 24, recipes);
    }
    protected IArcaneRecipe[] addRecipesMundaneSticks() {
        ArrayList<Object[]> recipes = new ArrayList<>(getOres(mundanePlanksTag).length);
        for (ItemStack plank : getOres(mundanePlanksTag))
            recipes.add(new Object[]{" P", "P ", 'P', plank});
        return ArcaneAdder.addMultipleSingleArcane(tag, new Aspects(ENTROPY, 1), new ItemStack(Items.stick, expert ? 2 : 6), recipes);
    }
    protected IArcaneRecipe[] addRecipesMagicalPlanks() {
        ArrayList<Object[]> inputRecipes = new ArrayList<>(getOres(magicalLogsTag).length);
        for (ItemStack log : getOres(magicalLogsTag))
            inputRecipes.add(new Object[]{"LL", "LL", 'L', log});
        IArcaneRecipe[] recipes = ArcaneAdder.addMultipleArcane(tag, new Aspects(ENTROPY, 2), getMagicalLogsToPlanks(), expert ? 12 : 32, inputRecipes);
        return Arrays.copyOfRange(recipes, 0, 2);
    }
    protected IArcaneRecipe[] addRecipesMagicalSticks() {
        ArrayList<Object[]> inputRecipes = new ArrayList<>(getOres(magicalPlanksTag).length);
        for (ItemStack plank : getOres(magicalPlanksTag))
            inputRecipes.add(new Object[]{" P", "P ", 'P', plank});
        IArcaneRecipe[] recipes = ArcaneAdder.addMultipleSingleArcane(tag, new Aspects(ENTROPY, 1), new ItemStack(Items.stick, expert ? 3 : 8), inputRecipes);
        return Arrays.copyOfRange(recipes, 0, 2);
    }

    @Override
    public void setResearchProperties() {
        if (expert) this.research.setParents("WOODBASICRECIPES");
        this.research.setSecondary();
    }
}
