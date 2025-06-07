package tcreborn.api.recipes.workbench;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeRemover {

    @SuppressWarnings("rawtypes")
    public static List recipes;
    private static final ArrayList<Object> recipesToRemove = new ArrayList<>();

    /**
     * Remove all recipes that have the ItemStack as output.
     * <p>This method checks : Item</p>
     */
    public static void removeItem(ItemStack output) {
        for (Object recipe : recipes) {
            IRecipe r = (IRecipe) recipe;
            boolean condition = r.getRecipeOutput() != null
                    && r.getRecipeOutput().getItem().equals(output.getItem());
            if (condition) recipesToRemove.add(r);
        }
        removeFoundRecipes();
    }
    /**
     * Remove all recipes that have the ItemStack as output.
     * <p>This method checks : Item and Amount</p>
     */
    public static void removeAmount(ItemStack output) {
        for (Object recipe : recipes) {
            IRecipe r = (IRecipe) recipe;
            boolean condition = r.getRecipeOutput() != null
                    && r.getRecipeOutput().getItem().equals(output.getItem())
                    && r.getRecipeOutput().stackSize == output.stackSize;
            if (condition) recipesToRemove.add(r);
        }
        removeFoundRecipes();
    }
    /**
     * Remove all recipes that have the ItemStack as output.
     * <p>This method checks : Item and metadata.</p>
     */
    public static void removeMeta(ItemStack output) {
        for (Object recipe : recipes) {
            IRecipe r = (IRecipe) recipe;
            boolean condition = r.getRecipeOutput() != null
                    && r.getRecipeOutput().getItem().equals(output.getItem())
                    && r.getRecipeOutput().getItemDamage() == output.getItemDamage();
            if (condition) recipesToRemove.add(r);
        }
        removeFoundRecipes();
    }
    /**
     * Remove all recipes that have the ItemStack as output.
     * <p>This method checks : Item, metadata, amount.</p>
     */
    public static void removePrecise(ItemStack output) {
        for (Object recipe : recipes) {
            IRecipe r = (IRecipe) recipe;
            boolean condition = r.getRecipeOutput() != null
                    && r.getRecipeOutput().getItem().equals(output.getItem())
                    && r.getRecipeOutput().stackSize == output.stackSize
                    && r.getRecipeOutput().getItemDamage() == output.getItemDamage();
            if (condition) recipesToRemove.add(r);
        }
        removeFoundRecipes();
    }

    /**
     * Remove all recipes found by the other methods from the recipes list from CraftingManager.
     */
    private static void removeFoundRecipes() {
        for (Object removedRecipe : recipesToRemove)
            recipes.remove(removedRecipe);
        recipesToRemove.clear();
    }

    /**
     * Refresh the list of recipes from CraftingManager.
     * <p>Method to call when all recipes are initialized</p>
     * @return The recipes list refreshed
     */
    @SuppressWarnings("rawtypes")
    public static List refresh() {
        return recipes = CraftingManager.getInstance().getRecipeList();
    }

    /**
     * Returns the last recipe added to the CraftingManager.
     * @return The last object of the recipes list
     */
    public static IRecipe getLastRecipeAdded() {
        return (IRecipe) refresh().get(recipes.size() - 1);
    }
}
