package tcreborn.api.recipes.mystical;

import tcreborn.api.thaumcraft.aspects.Aspects;
import tcreborn.api.util.exceptions.CompoundRecipeSizeIsDifferentFromStructure;
import tcreborn.api.util.exceptions.ParameterIsNullOrEmpty;
import thaumcraft.common.config.ConfigResearch;

import java.util.Arrays;
import java.util.List;


@SuppressWarnings("rawtypes")
public class CompoundAdder {

    public static List addCompoundRecipe(String tag, Aspects aspects, int width, int height, int length, Object ... structure) {
        if (tag == null || structure == null || structure.length == 0) throw new ParameterIsNullOrEmpty();
        if (width * height * length != structure.length) throw new CompoundRecipeSizeIsDifferentFromStructure(width * height * length, structure.length);
        return registerRecipe(tag, Arrays.asList(aspects, width, height, length, Arrays.asList(structure)));
    }

    protected static List registerRecipe(String key, List recipe) {
        ConfigResearch.recipes.put(key, recipe);
        return recipe;
    }
}
