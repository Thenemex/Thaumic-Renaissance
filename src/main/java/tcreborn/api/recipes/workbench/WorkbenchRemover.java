package tcreborn.api.recipes.workbench;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import tcreborn.api.recipes.RecipeRemover;
import tcreborn.api.util.exceptions.ParameterIsNullOrEmpty;

public class WorkbenchRemover extends RecipeRemover {

    protected WorkbenchRemover() {
        super();
    }

    /**
     * Remove all recipes that have the ItemStack as output.
     * <p>This method checks : Item</p>
     */
    public void removeItem(ItemStack output) {
        if (recipes == null || output == null || recipes.isEmpty()) throw new ParameterIsNullOrEmpty();
        this.refresh();
        for (Object recipe : recipes) {
            IRecipe r = (IRecipe) recipe;
            boolean condition = r.getRecipeOutput() != null
                    && r.getRecipeOutput().getItem().equals(output.getItem());
            if (condition) this.recipesToRemove.add(r);
        }
        removeFoundRecipes();
    }
    /**
     * Remove all recipes that have the ItemStack as output.
     * <p>This method checks : Item and Amount</p>
     */
    public void removeAmount(ItemStack output) {
        if (recipes == null || output == null || recipes.isEmpty()) throw new ParameterIsNullOrEmpty();
        this.refresh();
        for (Object recipe : recipes) {
            IRecipe r = (IRecipe) recipe;
            boolean condition = r.getRecipeOutput() != null
                    && r.getRecipeOutput().getItem().equals(output.getItem())
                    && r.getRecipeOutput().stackSize == output.stackSize;
            if (condition) this.recipesToRemove.add(r);
        }
        removeFoundRecipes();
    }
    /**
     * Remove all recipes that have the ItemStack as output.
     * <p>This method checks : Item and metadata.</p>
     */
    public void removeMeta(ItemStack output) {
        if (recipes == null || output == null || recipes.isEmpty()) throw new ParameterIsNullOrEmpty();
        this.refresh();
        for (Object recipe : recipes) {
            IRecipe r = (IRecipe) recipe;
            boolean condition = r.getRecipeOutput() != null
                    && r.getRecipeOutput().getItem().equals(output.getItem())
                    && r.getRecipeOutput().getItemDamage() == output.getItemDamage();
            if (condition) this.recipesToRemove.add(r);
        }
        removeFoundRecipes();
    }
    /**
     * Remove all recipes that have the ItemStack as output.
     * <p>This method checks : Item, metadata, amount.</p>
     */
    public void removePrecise(ItemStack output) {
        if (recipes == null || output == null || recipes.isEmpty()) throw new ParameterIsNullOrEmpty();
        this.refresh();
        for (Object recipe : recipes) {
            IRecipe r = (IRecipe) recipe;
            boolean condition = r.getRecipeOutput() != null
                    && r.getRecipeOutput().getItem().equals(output.getItem())
                    && r.getRecipeOutput().stackSize == output.stackSize
                    && r.getRecipeOutput().getItemDamage() == output.getItemDamage();
            if (condition) this.recipesToRemove.add(r);
        }
        removeFoundRecipes();
    }

    /**
     * Refresh the collection with the vanilla recipes
     */
    public void refresh() {
        recipes = CraftingManager.getInstance().getRecipeList();
    }
}
