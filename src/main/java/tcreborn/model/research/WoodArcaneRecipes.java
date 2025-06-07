package tcreborn.model.research;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tcreborn.api.recipes.arcane.ArcaneAdder;
import tcreborn.api.thaumcraft.aspects.Aspects;
import tcreborn.api.thaumcraft.research.AResearch;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.research.ResearchPage;

import java.util.ArrayList;

import static tcreborn.api.items.ItemFinder.findItemTC;
import static tcreborn.model.config.ConfigOreDict.*;
import static thaumcraft.api.aspects.Aspect.*;

public class WoodArcaneRecipes extends AResearch {

    public WoodArcaneRecipes() {
        super(ConfigTab.lumberjack, "WOODARCANERECIPES", findItemTC("blockTable", 15));
    }

    @Override
    public void init() {
        this.setResearchAspects(new Aspect[]{EARTH}, 3);
        this.setNewResearch(2,-1, 1).setResearchProperties();
        this.setPages(new ResearchPage(research.getPageTag(1)),
                new ResearchPage(addRecipesMundanePlanks()),
                new ResearchPage(addRecipesMundaneSticks()));
        // Recipes already removed in WoodBasicRecipes
    }

    protected IArcaneRecipe[] addRecipesMundanePlanks() {
        ArrayList<Object[]> recipes = new ArrayList<>(getOres(mundaneLogsTag).length);
        for (ItemStack log : getOres(mundaneLogsTag))
            recipes.add(new Object[]{"LL", "LL", 'L', log});
        return ArcaneAdder.addMultipleArcane(tag, new Aspects(ENTROPY, 1), getOres(mundanePlanksTag), 8, recipes);
    }
    protected IArcaneRecipe[] addRecipesMundaneSticks() {
        ArrayList<Object[]> recipes = new ArrayList<>(getOres(mundanePlanksTag).length);
        for (ItemStack plank : getOres(mundanePlanksTag))
            recipes.add(new Object[]{" P", "P ", 'P', plank});
        return ArcaneAdder.addMultipleSingleArcane(tag, new Aspects(ENTROPY, 1), new ItemStack(Items.stick, 2), recipes);
    }
    //private IArcaneRecipe[] addRecipesMagicalPlanks() {}
    //private IArcaneRecipe[] addRecipesMagicalSticks() {}


    @Override
    public void setResearchProperties() {
        this.research.setSecondary().setSiblings("WOODBASICRECIPES");
    }
}
