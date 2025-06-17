package tcreborn.model.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tcreborn.api.events.WandEventHandler;
import tcreborn.api.items.DeepCopy;
import tcreborn.api.items.types.BlockType;
import tcreborn.config.Config;
import thaumcraft.common.items.wands.ItemWandCasting;

import static tcreborn.model.ArrayCollector.getMundaneBlockLogs;
import static tcreborn.model.config.ConfigOreDict.*;

public class WoodCompoundRecipesHandler extends WandEventHandler {

    public WoodCompoundRecipesHandler() {
        int i = 0;
        for (BlockType log : getMundaneBlockLogs())
            registerTriggerEvent(log, i++);
    }

    @Override
    public boolean performTrigger(World world, ItemStack wand, EntityPlayer player, int x, int y, int z, int side, int event) {
        return dropWoodPlanks(world, wand, x, y, z, event);
    }

    protected boolean dropWoodPlanks(World world, ItemStack heldItem,  int x, int y, int z, int event) {
        if (world.isRemote) return false;
        ItemWandCasting wand = (ItemWandCasting) heldItem.getItem();
        if (wand.getFocus(heldItem) != null) return false; // Needs no focus equipped on the wand
        // Code for editing world
        world.setBlockToAir(x, y, z);
        ItemStack item = getDrops(event);
        EntityItem drops = new EntityItem(world, (float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F, item);
        world.spawnEntityInWorld(drops);
        return true;
        // ToDo : Make the research go auto-unlocked in Lumberjack Tab
        // ToDo : Review idea for 1.5 amount drop for expert mode
        // ToDo : Add condition for research done or not in performTrigger()
    }

    protected ItemStack getDrops(int event) {
        return DeepCopy.i(getOres(mundanePlanksTag)[event],
                Config.expertWoodRecipesEnabled ? 1 : 5);
    }
}
