package tcreborn;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import tcreborn.api.recipes.RecipeRemover;
import tests.Tests;

@Mod(modid = "Thaumic Renaissance", dependencies = "required-after:Thaumcraft@[4.2.3.5,)", useMetadata = true)
public class ThaumicRenaissance {

    public static final String modID = "TCReborn";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent ignoredEvent) {
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent ignoredEvent) {
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent ignoredEvent) {
        RecipeRemover.refresh();
        Tests.init();
    }
}
