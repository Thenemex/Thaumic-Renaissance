package tcreborn.api.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.api.wands.IWandTriggerManager;

public abstract class WandEventManager implements IWandTriggerManager {

    /**
     * Code executed when input block from compound recipe is matched
     * @param world The world
     * @param wand The held wand item
     * @param player The Player
     * @param x The x coordinate of the targeted block
     * @param y The y coordinate of the targeted block
     * @param z The z coordinate of the targeted block
     * @param side The side of the targeted block
     * @param event The event number (will be ignored by code, just set it to 0)
     * @return True is the trigger have been executed properly, false if not
     */
    @Override
    public abstract boolean performTrigger(World world, ItemStack wand, EntityPlayer player, int x, int y, int z, int side, int event);
}
