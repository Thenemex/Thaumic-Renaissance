package tcreborn.api.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class RecipeAdder {

    public static IRecipe addRecipe(ItemStack output, boolean isShapeless, Object ... recipe) {
        // GameRegistry.addRecipe(new ItemStack(blockTable, 8), new Object[]{"CRC","RRR","CRC", 'C', Blocks.coal_block, 'R', Items.redstone}); // Gives x8 output
        if (isShapeless) GameRegistry.addShapelessRecipe(output, recipe);
        else GameRegistry.addShapedRecipe(output, recipe);
        return getLastRecipeAdded();
    }

    public static IRecipe getLastRecipeAdded() {
        return (IRecipe) RecipeRemover.refresh().get(RecipeRemover.recipes.size() - 1);
    }
}
