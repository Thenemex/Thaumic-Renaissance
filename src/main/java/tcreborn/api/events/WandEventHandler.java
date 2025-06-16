package tcreborn.api.events;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.api.wands.IWandTriggerManager;
import thaumcraft.api.wands.WandTriggerRegistry;
import thaumcraft.common.lib.research.ResearchManager;

import static tcreborn.ThaumicRenaissance.modID;

@SuppressWarnings("unused")
public abstract class WandEventHandler implements IWandTriggerManager {

    /**
     * Constructor for handler.
     * <p>You must use registerTriggerEvent() in your class constructor, to make the handler work</p>
     */
    public WandEventHandler() {}

    /**
     * Register the event to the Thaumcraft 4 registry
     */
    public void registerTriggerEvent(Block target, int meta) {
        WandTriggerRegistry.registerWandBlockTrigger(this, 0, target, meta, modID);
    }
    /**
     * Register the event to the Thaumcraft 4 registry
     */
    public void registerTriggerEvent(Block target) {
        registerTriggerEvent(target, 0);
    }

    /**
     * Tests if the player had done a specific research
     * @param player The player
     * @param tag The research tag
     * @return True if the research is done, else false
     */
    protected boolean isResearchComplete(EntityPlayer player, String tag) {
        return ResearchManager.isResearchComplete(player.getCommandSenderName(), tag);
    }

    /**
     * Code executed when input block from compound recipe is matched
     * @param world The world
     * @param wand The held wand item
     * @param player The Player
     * @param x The x coordinate of the targeted block
     * @param y The y coordinate of the targeted block
     * @param z The z coordinate of the targeted block
     * @param side The side of the targeted block
     * @param event The event unique number
     * @return True is the trigger have been executed properly, false if not
     */
    @Override
    public abstract boolean performTrigger(World world, ItemStack wand, EntityPlayer player, int x, int y, int z, int side, int event);
}
