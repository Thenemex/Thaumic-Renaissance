package tcreborn.api.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tcreborn.api.items.types.BlockType;
import tcreborn.api.util.exceptions.ParameterIsNullOrEmpty;
import thaumcraft.common.items.wands.ItemWandCasting;

/**
 * Class for handling events linked to wands. Have to be instantiated in AResearch class fields.
 * <p>It's a specific handler with pre-made code, that will destroy the targeted block and drop some items.</p>
 * <p>You extend this class, and code the two main things linked to it :</p>
 * <p> - Registering blocks + event number, for triggering the method "performTrigger()" when targeted block is matched.</p>
 * <p> - Coding the method getDrops() ; it will return the items that will be dropped by destroying the block in performTrigger().
 * Be smart when registering your blocks, as the event number will be in the same order.</p>
 */
public abstract class SingleBlockWithDropsHandler extends WandEventHandler {

    protected String researchTag;

    /**
     * Constructor for the Handler.
     * <p>This specific handler type, will delete the trigger blocks and make them drop specific items.</p>
     * <p>Each block will receive an unique incremented event number.</p>
     * <p>Exemple : blocks[0] -> event = 0, blocks[1] -> event = 1 ... </p>
     * @param researchTag The researchTag : the trigger event won't be performed if the player didn't research that one yet (can be null)
     * @param blocks The trigger blocks
     * @throws ParameterIsNullOrEmpty If blocks is null or empty
     */
    public SingleBlockWithDropsHandler(String researchTag, BlockType ... blocks) {
        super(blocks);
        if (researchTag != null) this.researchTag = researchTag;
    }
    /**
     * Constructor for the Handler
     * @param blocks The trigger blocks
     * @throws ParameterIsNullOrEmpty If blocks is null or empty
     */
    public SingleBlockWithDropsHandler(BlockType ... blocks) {
        this(null, blocks);
    }

    /**
     * Code executed when registered trigger block is matched
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
    public boolean performTrigger(World world, ItemStack wand, EntityPlayer player, int x, int y, int z, int side, int event) {
        return dropWoodPlanks(world, wand, player, x, y, z, event);
    }

    /**
     * Private method called by performTrigger()
     * <p>Mainly used for code splitting</p>
     */
    protected boolean dropWoodPlanks(World world, ItemStack heldItem, EntityPlayer player, int x, int y, int z, int event) {
        if (world.isRemote) return false;
        if (researchTag != null)
            if (!isResearchComplete(player, researchTag)) return false; // Needs research to perform recipe
        ItemWandCasting wand = (ItemWandCasting) heldItem.getItem();
        if (wand.getFocus(heldItem) != null) return false; // Needs no focus equipped on the wand
        if (!player.isSneaking()) return false; // Player needs to be sneaking
        // Code for editing world
        world.setBlockToAir(x, y, z);
        ItemStack item = getDrops(event);
        EntityItem drops = new EntityItem(world, (float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F, item);
        world.spawnEntityInWorld(drops);
        return true;
        // ToDo Make the handler work with all block faces/orientations
    }

    /**
     * Method to implement in child class.
     * <p>the triggered blocks will drop exactly the ItemStack returned.</p>
     * @param event The event number (can be ignored depending on your needs)
     * @return The items that will be dropped on trigger
     */
    protected abstract ItemStack getDrops(int event);
}
