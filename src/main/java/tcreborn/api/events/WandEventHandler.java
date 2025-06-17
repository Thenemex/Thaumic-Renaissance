package tcreborn.api.events;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tcreborn.api.items.types.BlockType;
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

    public void registerTriggerEvent(BlockType log, int event) {
        WandTriggerRegistry.registerWandBlockTrigger(this, event, log.block(), log.meta(), modID);
    }
    public void registerTriggerEvent(BlockType log) {
        registerTriggerEvent(log, 0);
    }
    public void registerTriggerEvent(Block target, int event) {
        WandTriggerRegistry.registerWandBlockTrigger(this, event, target, 0, modID);
    }
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
