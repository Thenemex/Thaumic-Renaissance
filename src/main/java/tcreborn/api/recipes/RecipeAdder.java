package tcreborn.api.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import tcreborn.api.exceptions.ParameterIsNull;
import tcreborn.api.exceptions.ParameterArraysSizeException;

import java.util.ArrayList;

public class RecipeAdder {

    /**
     * Adds a single recipe from multiple items
     * @param output The output ItemStack
     * @param isShapeless if the recipe is shapeless or not
     * @param recipe The whole recipe object structure
     * @return The recipe generated
     */
    public static IRecipe addRecipe(ItemStack output, boolean isShapeless, Object ... recipe) {
        if (output == null || recipe == null || recipe.length == 0) throw new ParameterIsNull();
        // Example for Object : new Object[]{"CRC","RRR","CRC", 'C', Blocks.coal_block, 'R', Items.redstone}); // Gives x8 output
        if (isShapeless) GameRegistry.addShapelessRecipe(output, recipe);
        else GameRegistry.addShapedRecipe(output, recipe);
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
        for (ItemStack input : inputs) {
            recipes.add(addRecipe(output, true, input));
        }
        return recipes.toArray(new IRecipe[0]);
    }
    /**
     * Adds recipes that contains one item into another.
     * <p>The method will set the recipe as for exemple : input [0] = output[0], etc ...</p>
     * @param output The output items
     * @param input The input items
     * @return The recipes generated
     */
    public static IRecipe[] addMultipleSingleShapelessRecipes(ItemStack[] output, ItemStack[] input) {
        if (output.length != input.length) throw new ParameterArraysSizeException(output.length, input.length);
        IRecipe[] recipes = new IRecipe[output.length];
        for (int i = 0; i < output.length; i++)
            recipes[i] = addRecipe(output[i], true, input[i]);
        return recipes;
    }
}
