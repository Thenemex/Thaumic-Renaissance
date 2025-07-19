package tcreborn.model.research;

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

import static tcreborn.model.ArrayCollector.getMagicalLogsToPlanks;
import static tcreborn.model.config.ConfigOreDict.*;
import static thaumcraft.api.aspects.Aspect.*;

public class WoodCrucibleInstrumentumRecipes extends AResearch {

    protected Aspects magical, stick;

    public WoodCrucibleInstrumentumRecipes() {
        super(ConfigTab.lumberjack, "WOODCRUCIBLEINSTRUMENTUMRECIPES", Items.flint);
    }

    @Override
    public void init() {
        this.magical = new Aspects(new Aspect[]{TOOL, TREE, CRAFT, ENTROPY}, 2, 5, 1, 2);
        this.stick = new Aspects(new Aspect[]{TOOL, TREE, ENTROPY}, 1, 1, 1);
        this.setResearchAspects(new Aspect[]{TOOL, TREE, EARTH}, 6, 3, 3);
        this.setNewResearch(3, -4).setPages(newTextPage(1),
                new ResearchPage(addRecipesMagicalPlanks()),
                new ResearchPage(addRecipesMagicalSticks()));
    }

    protected CrucibleRecipe[] addRecipesMagicalPlanks() {
        CrucibleRecipe[] recipes = CrucibleAdder.addMultipleRecipe(tag, magical, getMagicalLogsToPlanks(), expert ? 9 : 20, getOres(magicalLogsTag));
        return Arrays.copyOfRange(recipes, 0, 2);
    }
    protected CrucibleRecipe[] addRecipesMagicalSticks() {
        CrucibleRecipe[] recipes = CrucibleAdder.addMultipleSingleRecipe(tag, stick, new ItemStack(Items.stick, expert ? 9 : 20), getOres(magicalPlanksTag));
        return Arrays.copyOfRange(recipes, 0, 2);
    }

    @Override
    public void setResearchProperties() {
        this.research.setParents("WOODCRUCIBLERECIPES").setConcealed().setSecondary();
    }
}
