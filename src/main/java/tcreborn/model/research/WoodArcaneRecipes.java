package tcreborn.model.research;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tcreborn.api.recipes.arcane.ArcaneAdder;
import tcreborn.api.thaumcraft.aspects.Aspects;
import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigResearch;
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

    protected boolean isArcanePluginOn;

    public WoodArcaneRecipes() {
        super(ConfigTab.lumberjack, "WOODARCANERECIPES", findItemTC("blockTable", 15));
    }

    @Override
    public void init() {
        this.isArcanePluginOn = !ConfigResearch.isArcaneCheckingWorkbenchRecipes;
        this.setResearchAspects(EARTH, 3);
        this.setNewResearch(0,-1);
        this.setPages(new ResearchPage(research.getPageTag(1)),
                new ResearchPage(addRecipesMundanePlanks()),
                new ResearchPage(addRecipesMundaneSticks()),
                new ResearchPage(addRecipesMagicalPlanks()),
                new ResearchPage(addRecipesMagicalSticks()));
        // Recipes already removed in WoodBasicRecipes
    }

    protected IArcaneRecipe[] addRecipesMundanePlanks() {
        ArrayList<Object[]> inputRecipes = new ArrayList<>(getOres(mundaneLogsTag).length);
        for (ItemStack log : getOres(mundaneLogsTag))
            inputRecipes.add(isArcanePluginOn ? new Object[]{log} : new Object[]{"LL", "LL", 'L', log});
        IArcaneRecipe[] recipes = ArcaneAdder.addMultipleArcane(tag, new Aspects(ENTROPY, 1), isArcanePluginOn, getOres(mundanePlanksTag), isArcanePluginOn ? (expert ? 2 : 6) : (expert ? 8 : 24), inputRecipes);
        return Arrays.copyOfRange(recipes, 0, 6);
    }
    protected IArcaneRecipe[] addRecipesMundaneSticks() {
        ArrayList<Object[]> inputRecipes = new ArrayList<>(getOres(mundanePlanksTag).length);
        for (ItemStack plank : getOres(mundanePlanksTag))
            inputRecipes.add(isArcanePluginOn ? new Object[]{"P", "P", 'P', plank} : new Object[]{" P", "P ", 'P', plank});
        IArcaneRecipe[] recipes = ArcaneAdder.addMultipleSingleArcane(tag, new Aspects(ENTROPY, 1), new ItemStack(Items.stick, expert ? 2 : 6), inputRecipes);
        return Arrays.copyOfRange(recipes, 0, 6);
    }
    protected IArcaneRecipe[] addRecipesMagicalPlanks() {
        ArrayList<Object[]> inputRecipes = new ArrayList<>(getOres(magicalLogsTag).length);
        for (ItemStack log : getOres(magicalLogsTag))
            inputRecipes.add(isArcanePluginOn ? new Object[]{log} : new Object[]{"LL", "LL", 'L', log});
        IArcaneRecipe[] recipes = ArcaneAdder.addMultipleArcane(tag, new Aspects(ENTROPY, 2), isArcanePluginOn, getMagicalLogsToPlanks(), isArcanePluginOn ? (expert ? 3 : 8) :(expert ? 12 : 32), inputRecipes);
        return Arrays.copyOfRange(recipes, 0, 2);
    }
    protected IArcaneRecipe[] addRecipesMagicalSticks() {
        ArrayList<Object[]> inputRecipes = new ArrayList<>(getOres(magicalPlanksTag).length);
        for (ItemStack plank : getOres(magicalPlanksTag))
            inputRecipes.add(isArcanePluginOn ? new Object[]{"P", "P", 'P', plank} : new Object[]{" P", "P ", 'P', plank});
        IArcaneRecipe[] recipes = ArcaneAdder.addMultipleSingleArcane(tag, new Aspects(ENTROPY, 1), new ItemStack(Items.stick, expert ? 3 : 8), inputRecipes);
        return Arrays.copyOfRange(recipes, 0, 2);
    }

    @Override
    public void setResearchProperties() {
        if (expert) this.research.setParents("WOODBASICRECIPES");
        this.research.setSecondary();
    }
}
