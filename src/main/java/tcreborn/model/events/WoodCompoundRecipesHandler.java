package tcreborn.model.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tcreborn.api.events.WandEventHandler;
import tcreborn.config.Config;
import tcreborn.model.ArrayCollector;
import thaumcraft.common.items.wands.ItemWandCasting;

public class WoodCompoundRecipesHandler extends WandEventHandler {

    public WoodCompoundRecipesHandler() {
        super(ArrayCollector.getMundaneBlockLogs());
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
    }

    protected ItemStack getDrops(int event) {
        int amount = Config.expertWoodRecipesEnabled ? 1 : 6;
        return ArrayCollector.getMundanePlank(event, amount);
    }
}
