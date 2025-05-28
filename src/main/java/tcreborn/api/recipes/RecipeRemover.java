package tcreborn.api.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import tcreborn.api.Logger;

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
            remove(r, condition);
        }
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
            remove(r, condition);
        }
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
            remove(r, condition);
        }
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
            remove(r, condition);
        }
    }


    /**
     * Remove a recipe if it suits the condition
     * @param r The recipe to check
     * @param condition The condition
     */
    private static void remove(IRecipe r, boolean condition) {
        // Not null + Same Item + Same Meta
        if (condition)
            recipesToRemove.add(r);
        for (Object removedRecipe : recipesToRemove) {
            recipes.remove(removedRecipe);
            Logger.logInfo("Removed ", recipesToRemove.size(), " recipes");
        }
        recipesToRemove.clear();
    }

    /**
     * Refresh the list of recipes.
     * <p>Method to call when all recipes are initialized</p>
     */
    @SuppressWarnings("rawtypes")
    public static List refresh() {
        return recipes = CraftingManager.getInstance().getRecipeList();
    }
}
