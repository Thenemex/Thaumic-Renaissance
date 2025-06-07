package tcreborn.api.recipes.arcane;

import net.minecraft.item.ItemStack;
import tcreborn.api.recipes.RecipeManager;
import tcreborn.api.util.exceptions.ParameterArraysSizeException;
import tcreborn.api.util.exceptions.ParameterIsNullOrEmpty;
import tcreborn.api.thaumcraft.aspects.Aspects;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;

public class ArcaneAdder {
// Example for Object : new Object[]{"CRC","RRR","CRC", 'C', Blocks.coal_block, 'R', Items.redstone});

    /**
     * Adds a single arcane recipe from multiple items
     * @param tag Research's tag
     * @param aspects Wand's vis used
     * @param output The output ItemStack
     * @param recipe The whole recipe object structure
     * @return The recipe generated
     */
    public static IArcaneRecipe addArcane(String tag, Aspects aspects, ItemStack output, boolean isShapeless , Object ... recipe) {
        if (tag == null || aspects == null || output == null || recipe == null || recipe.length == 0) throw new ParameterIsNullOrEmpty();
        if (isShapeless) RecipeManager.i().addRecipe(new ShapelessArcaneRecipe(tag, output, aspects, recipe));
        else RecipeManager.i().addRecipe(new ShapedArcaneRecipe(tag, output, aspects, recipe));
        return (IArcaneRecipe) RecipeManager.i().getLastRecipeAdded();
    }

    /**
     * Adds recipes that contain only one item into another (with same aspects for every recipe).
     * <p>The method will set the recipe as for exemple : input[0] -> output[0], input[1] -> output[1] ...</p>
     * @param tag Research's tag
     * @param aspects Wand's vis used
     * @param output The output items
     * @param input The input items
     * @return The recipes generated
     */
    public static IArcaneRecipe[] addMultipleSingleSingleShapelessRecipes(String tag, Aspects aspects, ItemStack[] output, ItemStack[] input) {
        if (output.length != input.length) throw new ParameterArraysSizeException(output.length, input.length);
        IArcaneRecipe[] recipes = new IArcaneRecipe[output.length];
        for (int i = 0; i < output.length; i++)
            recipes[i] = addArcane(tag, aspects, output[i], true, input[i]);
        return recipes;
    }


}
