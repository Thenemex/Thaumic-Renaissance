package tcreborn.model.research.light;

import nemexlib.api.recipes.RecipeFinder;
import nemexlib.api.recipes.workbench.WorkbenchAdder;
import nemexlib.api.thaumcraft.research.AResearch;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import tcreborn.config.Config;
import tcreborn.model.config.ConfigTab;
import thaumcraft.api.research.ResearchPage;

public class TorchBasicRecipes extends AResearch {
    public TorchBasicRecipes() {
        super(ConfigTab.lumberjack, "TORCHBASICRECIPES", Blocks.torch);
    }

    @Override
    public void init() {
        this.setNewResearch(2, 0).setPages(new ResearchPage(research.getPageTag(1)),
                new ResearchPage(getTorchRecipe()));
        if (Config.glowstoneTorches) this.addPage(new ResearchPage(addGlowstoneTorchRecipe()));
    }

    protected IRecipe getTorchRecipe() {
        return RecipeFinder.findRecipeAmount(new ItemStack(Blocks.torch, 4));
    }
    protected IRecipe addGlowstoneTorchRecipe() {
        return WorkbenchAdder.addRecipe(new ItemStack(Blocks.torch, Config.glowstoneTorchesOutput),false, "G", "S", 'G', Items.glowstone_dust, 'S', Items.stick);
    }

    @Override
    public void setResearchProperties() {
        this.research.setAutoUnlock().setRound();
    }
}
