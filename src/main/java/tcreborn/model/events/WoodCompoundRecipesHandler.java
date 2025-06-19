package tcreborn.model.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tcreborn.api.events.WandEventHandler;
import tcreborn.api.items.types.BlockType;
import tcreborn.config.Config;
import tcreborn.model.ArrayCollector;
import thaumcraft.common.items.wands.ItemWandCasting;

import static tcreborn.model.ArrayCollector.getMundaneBlockLogs;

public class WoodCompoundRecipesHandler extends WandEventHandler {

    public WoodCompoundRecipesHandler() {
        int i = 0;
        for (BlockType log : getMundaneBlockLogs())
            registerTriggerEvent(log, i++);
    }

    @Override
    public boolean performTrigger(World world, ItemStack wand, EntityPlayer player, int x, int y, int z, int side, int event) {
        return dropWoodPlanks(world, wand, player, x, y, z, event);
    }

    protected boolean dropWoodPlanks(World world, ItemStack heldItem, EntityPlayer player, int x, int y, int z, int event) {
        if (world.isRemote) return false;
        ItemWandCasting wand = (ItemWandCasting) heldItem.getItem();
        if (wand.getFocus(heldItem) != null) return false; // Needs no focus equipped on the wand
        if (!player.isSneaking()) return false; // Player needs to be sneaking
        // Code for editing world
        world.setBlockToAir(x, y, z);
        ItemStack item = getDrops(event);
        EntityItem drops = new EntityItem(world, (float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F, item);
        world.spawnEntityInWorld(drops);
        return true;
        // ToDo : Review idea for 1.5 amount drop for expert mode
        // ToDo : Add condition for research done or not in performTrigger()
    }

    protected ItemStack getDrops(int event) {
        int amount = Config.expertWoodRecipesEnabled ? 1 : 5;
        return ArrayCollector.getMundanePlank(event, amount);
    }
}
