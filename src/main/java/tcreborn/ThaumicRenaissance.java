package tcreborn;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import tcreborn.api.recipes.RecipeRemover;
import tcreborn.config.Config;
import tcreborn.model.ArrayCollector;
import tcreborn.model.config.ConfigIntegrations;
import tcreborn.model.config.ConfigOreDict;
import tcreborn.model.config.ConfigResearch;

import java.io.File;

@Mod(modid = "Thaumic Renaissance", dependencies = "required-after:Thaumcraft@[4.2.3.5,)", useMetadata = true)
public class ThaumicRenaissance {

    public static final String modID = "TCReborn";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.init(new File(event.getModConfigurationDirectory(), modID));
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent ignoredEvent) {
        ArrayCollector.init();
        ConfigOreDict.init();
        RecipeRemover.refresh();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent ignoredEvent) {
        ConfigIntegrations.init();
        ConfigResearch.init();
    }
}
