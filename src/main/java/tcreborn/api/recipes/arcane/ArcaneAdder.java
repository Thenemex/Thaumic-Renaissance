package tcreborn.api.recipes.arcane;

import net.minecraft.item.ItemStack;
import tcreborn.api.items.DeepCopy;
import tcreborn.api.util.exceptions.ParameterArraysSizeException;
import tcreborn.api.util.exceptions.ParameterIsNullOrEmpty;
import tcreborn.api.thaumcraft.aspects.Aspects;
import tcreborn.api.util.exceptions.ParameterValueIsNegativeOrZero;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.IArcaneRecipe;

import java.util.ArrayList;

public class ArcaneAdder {

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
        if (isShapeless) return ThaumcraftApi.addShapelessArcaneCraftingRecipe(tag, output, aspects, recipe);
        else return ThaumcraftApi.addArcaneCraftingRecipe(tag, output, aspects, recipe);
    }

    /**
     * Adds multiple recipes
     * <p>Will follow this pattern : input[0] -> output[0],  input[1] -> output[1] ...</p>
     * @param tag Research's tag
     * @param aspects Wand's vis used
     * @param output The output items
     * @param input The recipe structures
     * @return The recipes generated
     */
    public static IArcaneRecipe[] addMultipleArcane(String tag, Aspects aspects, boolean isShapeless, ItemStack[] output, ArrayList<Object[]> input) {
        if (output.length != input.size()) throw new ParameterArraysSizeException(output.length, input.size());
        IArcaneRecipe[] recipes = new IArcaneRecipe[output.length];
        for (int i = 0; i < output.length; i++)
            recipes[i] = addArcane(tag, aspects, output[i], isShapeless, input.get(i));
        return recipes;
    }

    /**
     * Adds multiple recipes, with possibility to edit the amount of output
     * <p>Will follow this pattern : input[0] -> output[0],  input[1] -> output[1] ...</p>
     * @param tag Research's tag
     * @param aspects Wand's vis used
     * @param output The output items
     * @param nb The number of output items wanted
     * @param input The recipe structures
     * @return The recipes generated
     */
    public static IArcaneRecipe[] addMultipleArcane(String tag, Aspects aspects, ItemStack[] output, int nb, ArrayList<Object[]> input) {
        if (nb < 1) throw new ParameterValueIsNegativeOrZero(nb);
        return addMultipleArcane(tag, aspects, false, DeepCopy.i(output, nb), input);
    }

    /**
     * Adds multiple recipes, with possibility to edit the amount of output ; and to make it shapeless
     * <p>Will follow this pattern : input[0] -> output[0],  input[1] -> output[1] ...</p>
     * @param tag Research's tag
     * @param aspects Wand's vis used
     * @param isShapeless If true, the recipe will be shapeless
     * @param output The output items
     * @param nb The number of output items wanted
     * @param input The recipe structures
     * @return The recipes generated
     */
    public static IArcaneRecipe[] addMultipleArcane(String tag, Aspects aspects, boolean isShapeless, ItemStack[] output, int nb, ArrayList<Object[]> input) {
        return addMultipleArcane(tag, aspects, isShapeless, DeepCopy.i(output, nb), input);
    }

    /**
     * Adds recipes that contain items into another unique item (with same aspects for every recipe).
     * <p>The method will set the recipe as for exemple : input[0] -> output, input[1] -> output ...</p>
     * @param tag Research's tag
     * @param aspects Wand's vis used
     * @param output The single output
     * @param input The recipe structures
     * @return The recipes generated
     */
    public static IArcaneRecipe[] addMultipleSingleArcane(String tag, Aspects aspects, ItemStack output, ArrayList<Object[]> input) {
        IArcaneRecipe[] recipes = new IArcaneRecipe[input.size()];
        for (int i = 0; i < input.size(); i++)
            recipes[i] = addArcane(tag, aspects, output, false, input.get(i));
        return recipes;
    }


}
