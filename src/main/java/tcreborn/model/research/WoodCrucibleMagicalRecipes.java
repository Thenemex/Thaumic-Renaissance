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

import static tcreborn.api.items.ItemFinder.findItemTC;
import static tcreborn.model.ArrayCollector.getMagicalLogsToPlanks;
import static tcreborn.model.config.ConfigOreDict.*;
import static thaumcraft.api.aspects.Aspect.*;

public class WoodCrucibleMagicalRecipes extends AResearch {

    protected Aspects magical;

    public WoodCrucibleMagicalRecipes() {
        super(ConfigTab.lumberjack, "WOODCRUCIBLEMAGICALRECIPES", findItemTC("blockMagicalLog"));
    }

    @Override
    public void init() {
        this.magical = new Aspects(new Aspect[]{MAGIC, TREE, CRAFT, ENTROPY}, 1, 5, 1, 3);
        this.setResearchAspects(new Aspect[]{MAGIC, TREE, EARTH}, 6, 3, 3);
        this.setNewResearch(1, -4, 1);
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
