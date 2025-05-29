package tcreborn.api.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import tcreborn.api.Logger;

public class RecipeAdder {

    public static IRecipe addRecipe(ItemStack output, boolean isShapeless, Object ... recipe) {
        // Example for Object : new Object[]{"CRC","RRR","CRC", 'C', Blocks.coal_block, 'R', Items.redstone}); // Gives x8 output
        if (isShapeless) GameRegistry.addShapelessRecipe(output, recipe);
        else GameRegistry.addShapedRecipe(output, recipe);
        Logger.logInfo("Recipe added for ", output.getItem().getUnlocalizedName(), ":", output.getItemDamage());
        return RecipeRemover.getLastRecipeAdded();
    }
}
