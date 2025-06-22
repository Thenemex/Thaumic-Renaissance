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

    /**
     * Register wand triggers on blocks to the Thaumcraft 4 Registry
     * <p>Each block will be given an event number incremented at each loop</p>
     * <p>Exemple : blocks[0] will have event = 0, block[1] will have event = 1 ...</p>
     * @param blocks The blocks that trigger the event
     * @throws ParameterIsNullOrEmpty If blocks is null or empty
     */
    public void registerTriggerEvent(BlockType[] blocks) {
        if (blocks == null || blocks.length == 0) throw new ParameterIsNullOrEmpty();
        for (int i = 0; i < blocks.length; i++)
            registerTriggerEvent(blocks[i], i);
    }
    /**
     * Register wand triggers on block to the Thaumcraft 4 Registry
     * @param block The block that trigger the event
     * @param event The event number
     * @throws ParameterIsNullOrEmpty If block is null
     */
    public void registerTriggerEvent(BlockType block, int event) {
        if (block == null) throw new ParameterIsNullOrEmpty();
        WandTriggerRegistry.registerWandBlockTrigger(this, event, block.block(), block.meta(), modID);
    }
    /**
     * Register wand triggers on block to the Thaumcraft 4 Registry
     * <p>Event number will be set to 0</p>
     * @param block The block that trigger the event
     * @throws ParameterIsNullOrEmpty If blocks is null
     */
    public void registerTriggerEvent(BlockType block) {
        registerTriggerEvent(block, 0);
    }
    /**
     * Register wand triggers on block to the Thaumcraft 4 Registry
     * <p>The block metadata will be set to 0</p>
     * @param block The block that trigger the event
     * @param event The event number
     * @throws ParameterIsNullOrEmpty If block is null
     */
    public void registerTriggerEvent(Block block, int event) {
        if (block == null) throw new ParameterIsNullOrEmpty();
        WandTriggerRegistry.registerWandBlockTrigger(this, event, block, 0, modID);
    }
    /**
     * Register wand triggers on block to the Thaumcraft 4 Registry
     * <p>The block metadata AND event number will be set to 0</p>
     * @param block The block that trigger the event
     * @throws ParameterIsNullOrEmpty If block is null
     */
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
