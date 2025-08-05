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

public class WoodCrucibleMagicalRecipes extends AResearch {

    protected Aspects magical, stick;

    public WoodCrucibleMagicalRecipes() {
        super(ConfigTab.lumberjack, "WOODCRUCIBLEMAGICALRECIPES", findItemTC("blockWoodenDevice", 6));
    }

    @Override
    public void init() {
        this.magical = new Aspects(new Aspect[]{MAGIC, TREE, CRAFT, ENTROPY}, 1, 5, 1, 3);
        this.stick = new Aspects(new Aspect[]{MAGIC, TREE, ENTROPY}, 1, 1, 1);
        this.setResearchAspects(new Aspect[]{MAGIC, TREE, EARTH}, 6, 3, 3);
        this.setNewResearch(1, -4).setPages(newTextPage(1),
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
