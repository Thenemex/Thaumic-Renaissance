package tcreborn.api.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import tcreborn.api.Logger;

import java.util.List;

public class RecipeRemover {

    @SuppressWarnings("rawtypes")
    private static List recipes;

    public static void remove(ItemStack output) {
        Logger.logInfo(recipes.size());
        for (Object recipe : recipes) {
            IRecipe r = (IRecipe) recipe;
            if (r.getRecipeOutput() == null && r.getRecipeOutput().equals(output))
                recipes.remove(recipe);
        }
    }

    /**
     * Refresh the list of recipes
     */
    public static void refresh() {
        recipes = CraftingManager.getInstance().getRecipeList();
    }
}
