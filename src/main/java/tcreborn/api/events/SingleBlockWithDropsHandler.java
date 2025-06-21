package tcreborn.api.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tcreborn.api.items.types.BlockType;
import thaumcraft.common.items.wands.ItemWandCasting;

public abstract class SingleBlockWithDropsHandler extends WandEventHandler {

    protected String researchTag;

    /**
     * Constructor for the Handler.
     * <p>This specific handler type, will delete the trigger blocks and make them drop specific items.</p>
     * @param researchTag The researchTag (can be null)
     * @param triggers The trigger blocks
     */
    public SingleBlockWithDropsHandler(String researchTag, BlockType ... triggers) {
        super(triggers);
        if (researchTag != null) this.researchTag = researchTag;
    }
    /**
     * Constructor for the Handler
     * @param triggers The trigger blocks
     */
    public SingleBlockWithDropsHandler(BlockType ... triggers) {
        this(null, triggers);
    }

    @Override
    public boolean performTrigger(World world, ItemStack wand, EntityPlayer player, int x, int y, int z, int side, int event) {
        return dropWoodPlanks(world, wand, player, x, y, z, event);
    }
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
