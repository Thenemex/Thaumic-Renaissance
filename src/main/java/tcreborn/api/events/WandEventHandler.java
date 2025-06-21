package tcreborn.api.events;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tcreborn.api.items.types.BlockType;
import tcreborn.api.util.exceptions.ParameterIsNullOrEmpty;
import thaumcraft.api.wands.IWandTriggerManager;
import thaumcraft.api.wands.WandTriggerRegistry;
import thaumcraft.common.lib.research.ResearchManager;

import static tcreborn.ThaumicRenaissance.modID;

@SuppressWarnings({"unused", "SameParameterValue"})
public abstract class WandEventHandler implements IWandTriggerManager {

    /**
     * Constructor for handler.
     * <p>You must use registerTriggerEvent() in your class constructor, to make the handler work</p>
     */
    public WandEventHandler() {}

    /**
     * Constructor for handler.
     * <p>Will automatic register all blocks from argument array as triggerEvents</p>
     * <p>Each one will get a unique event number, starting from 0 and getting incremented by one with each register done.</p>
     * @param blocks The triggers to be registered
     */
    public WandEventHandler(BlockType[] blocks) {
        registerTriggerEvent(blocks);
    }

    public void registerTriggerEvent(BlockType[] blocks) {
        if (blocks == null || blocks.length == 0) throw new ParameterIsNullOrEmpty();
        for (int i = 0; i < blocks.length; i++)
            registerTriggerEvent(blocks[i], i);
    }
    public void registerTriggerEvent(BlockType block, int event) {
        if (block == null) throw new ParameterIsNullOrEmpty();
        WandTriggerRegistry.registerWandBlockTrigger(this, event, block.block(), block.meta(), modID);
    }
    public void registerTriggerEvent(BlockType block) {
        registerTriggerEvent(block, 0);
    }
    public void registerTriggerEvent(Block block, int event) {
        if (block == null) throw new ParameterIsNullOrEmpty();
        WandTriggerRegistry.registerWandBlockTrigger(this, event, block, 0, modID);
    }
    public void registerTriggerEvent(Block block) {
        registerTriggerEvent(block, 0);
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
