package tcreborn.model.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tcreborn.api.events.WandEventHandler;
import thaumcraft.common.items.wands.ItemWandCasting;

public class WoodCompoundRecipesHandler extends WandEventHandler {

    public WoodCompoundRecipesHandler() {
        registerTriggerEvent(Blocks.log);
    }

    @Override
    public boolean performTrigger(World world, ItemStack wand, EntityPlayer player, int x, int y, int z, int side, int ignored) {
        return dropWoodPlanks(world, wand, x, y, z);
    }

    protected boolean dropWoodPlanks(World world, ItemStack heldItem,  int x, int y, int z) {
        if (world.isRemote) return false;
        ItemWandCasting wand = (ItemWandCasting) heldItem.getItem();
        if (wand.getFocus(heldItem) != null) return false; // Needs no focus equipped on the wand
        // Code for editing world
        world.setBlockToAir(x, y, z);
        world.playSoundEffect((double) x + 0.5, (double) y + 0.5, (double) z + 0.5, "random.break", 1.0F, 1.0F);
        EntityItem drops = new EntityItem(world, (float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F, new ItemStack(Blocks.planks, 3));
        world.spawnEntityInWorld(drops);
        return true;
        // ToDo : Working with all mundane wood logs/planks
        // ToDo : Make recipes for sticks, from all mundane planks
        // ToDo : Add a fancy wood breaking sound
        // ToDo : Consume aspects from the wand
        // ToDo : Add testing for CompoundAdder -> Throw exception when x*y*z != List.size()
        // ToDo : Add condition for research done or not in performTrigger()
    }
}
