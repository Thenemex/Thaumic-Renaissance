package tcreborn;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import tcreborn.api.recipes.workbench.RecipeRemover;
import tcreborn.config.Config;
import tcreborn.model.ArrayCollector;
import tcreborn.model.config.ConfigIntegrations;
import tcreborn.model.config.ConfigOreDict;
import tcreborn.model.config.ConfigResearch;

import java.io.File;

@Mod(modid = "Thaumic Renaissance", useMetadata = true, dependencies = "required-after:Thaumcraft@[4.2.3.5,);" +
                "after:ForbiddenMagic;" +
                "after:TaintedMagic;" +
                "after:thaumicbases")
public class ThaumicRenaissance {

    public static final String modID = "TCReborn";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.init(new File(event.getModConfigurationDirectory(), modID));
    }
    @Mod.EventHandler @SuppressWarnings("EmptyMethod")
    public void init(FMLInitializationEvent ignoredEvent) {}
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent ignoredEvent) {
        RecipeRemover.refresh();
        ArrayCollector.init();
        ConfigIntegrations.init();
        ConfigOreDict.init();

        ConfigResearch.init();
    }
}
