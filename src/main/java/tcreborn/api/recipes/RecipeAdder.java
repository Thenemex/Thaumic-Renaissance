package tcreborn.api.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import tcreborn.api.exceptions.ParameterIsNullOrEmpty;
import tcreborn.api.exceptions.ParameterArraysSizeException;

import java.util.ArrayList;

public class RecipeAdder {
// Example for Object : new Object[]{"CRC","RRR","CRC", 'C', Blocks.coal_block, 'R', Items.redstone}); // Gives x8 output
    /**
     * Adds a single recipe from multiple items
     * @param output The output ItemStack
     * @param isShapeless if the recipe is shapeless or not
     * @param recipes The whole recipe object structure
     * @return The recipe generated
     */
    public static IRecipe addRecipe(ItemStack output, boolean isShapeless, Object ... recipes) {
        if (output == null || recipes == null || recipes.length == 0) throw new ParameterIsNullOrEmpty();
        if (isShapeless) GameRegistry.addShapelessRecipe(output, recipes);
        else GameRegistry.addShapedRecipe(output, recipes);
        return RecipeRemover.getLastRecipeAdded();
    }

    /**
     * Adds recipes that contain one unique item into the same output.
     * @param output The single output of the recipe
     * @param inputs The inputs, likely from OreDictionnary
     * @return The recipes generated
     */
    public static IRecipe[] addSingleRecipes(ItemStack output, boolean isShapeless, ItemStack ... inputs) {
        ArrayList<IRecipe> recipes = new ArrayList<>(inputs.length);
        for (ItemStack input : inputs)
            recipes.add(addRecipe(output, isShapeless, input));
        return recipes.toArray(new IRecipe[0]);
    }

    /**
     * Adds multiple recipes that contain multiple items into the same output
     * @param output The output items
     * @param isShapeless if the recipe is shapeless or not
     * @param input The inputs items & recipe
     * @return The recipes generated
     */
    public static IRecipe[] addMultipleSingleRecipes(ItemStack output, boolean isShapeless, ArrayList<Object[]> input) {
        IRecipe[] recipes = new IRecipe[input.size()];
        for (int i = 0; i < recipes.length; i++)
            recipes[i] = addRecipe(output, isShapeless, input.get(i));
        return recipes;
    }

    /**
     * Adds recipes that contain one item into another.
     * <p>The method will set the recipe as for exemple : input[0] -> output[0], etc ...</p>
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
