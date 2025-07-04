package tcreborn.model.research;

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

import static tcreborn.model.ArrayCollector.getMagicalLogsToPlanks;
import static tcreborn.model.config.ConfigOreDict.*;
import static thaumcraft.api.aspects.Aspect.*;
import static thaumcraft.api.aspects.Aspect.ENTROPY;

public class WoodCrucibleInstrumentumRecipes extends AResearch {

    protected Aspects magical;

    public WoodCrucibleInstrumentumRecipes() {
        super(ConfigTab.lumberjack, "WOODCRUCIBLEINSTRUMENTUMRECIPES", Items.flint);
    }

    @Override
    public void init() {
        this.magical = new Aspects(new Aspect[]{TOOL, TREE, CRAFT, ENTROPY}, 2, 5, 1, 2);
        this.setResearchAspects(new Aspect[]{TOOL, TREE, EARTH}, 6, 3, 3);
        this.setNewResearch(3, -4, 1);
        this.setPages(new ResearchPage(research.getPageTag(1)),
                new ResearchPage(addRecipesMagicalPlanks()),
                new ResearchPage(addRecipesMagicalSticks()));
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
        this.research.setParents("WOODCRUCIBLERECIPES").setConcealed().setSecondary();
    }
}
