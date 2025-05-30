package tcreborn.api.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import tcreborn.api.Logger;

import java.util.ArrayList;

public class RecipeAdder {

    public static IRecipe addRecipe(ItemStack output, boolean isShapeless, Object ... recipe) {
        // Example for Object : new Object[]{"CRC","RRR","CRC", 'C', Blocks.coal_block, 'R', Items.redstone}); // Gives x8 output
        if (isShapeless) GameRegistry.addShapelessRecipe(output, recipe);
        else GameRegistry.addShapedRecipe(output, recipe);
        Logger.logInfo("Recipe added for ", output.getItem().getUnlocalizedName(), ":", output.getItemDamage());
        return RecipeRemover.getLastRecipeAdded();
    }

    /**
     * Adds recipes that contains one unique item into another.
     * @param output The single output of the recipe
     * @param inputs The inputs, likely from OreDictionnary
     * @return The recipes generated
     */
    public static IRecipe[] addSingleShapelessRecipes(ItemStack output, ItemStack ... inputs) {
        ArrayList<IRecipe> recipes = new ArrayList<>(inputs.length);
        for (ItemStack input : inputs)
            recipes.add(addRecipe(output, true, input));
        return recipes.toArray(new IRecipe[0]);
    }
}
