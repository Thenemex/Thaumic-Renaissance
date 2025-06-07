package tcreborn.api.recipes;

import thaumcraft.api.crafting.IArcaneRecipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class RecipeManager implements Iterable<Object>{

    private static final RecipeManager instance = new RecipeManager();
    /**
     * Will only contains modded recipes from Thaumcraft 4
     */
    private final ArrayList<Object> recipes = new ArrayList<>();

    /**
     * Return the static instance
     * @return The singleton
     */
    public static RecipeManager i() {
        return instance;
    }

    /**
     * Register an arcane recipe to the collection
     * @param recipes The recipe(s)
     */
    public void addRecipe(IArcaneRecipe ... recipes) {
        Collections.addAll(this.recipes, recipes);
    }

    /**
     * Returns the last recipe added to the collection
     * @return The last recipe added
     */
    public Object getLastRecipeAdded() {
        if (recipes.isEmpty()) return null;
        return recipes.get(recipes.size() - 1);
    }

    @Override @SuppressWarnings("NullableProblems")
    public Iterator<Object> iterator() {
        return recipes.iterator();
    }
}
