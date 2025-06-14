package tcreborn;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import tcreborn.config.Config;
import tcreborn.model.ArrayCollector;
import tcreborn.model.config.ConfigIntegrations;
import tcreborn.model.config.ConfigOreDict;
import tcreborn.model.config.ConfigResearch;

import static tcreborn.ThaumicRenaissance.modID;
import static tcreborn.ThaumicRenaissance.dependencies;

import java.io.File;

@Mod(modid = modID, useMetadata = true, dependencies = dependencies)
public class ThaumicRenaissance {

    public static final String modID = "TCReborn", modName = "ThaumicRenaissance";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.init(new File(event.getModConfigurationDirectory(), modName));
    }
    @Mod.EventHandler @SuppressWarnings("EmptyMethod")
    public void init(FMLInitializationEvent ignoredEvent) {
        ArrayCollector.init();
        ConfigOreDict.init();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent ignoredEvent) {
        ConfigIntegrations.init();
        ConfigResearch.init();
    }

    public static final String dependencies = "required-after:Thaumcraft@[4.2.3.5,);after:ForbiddenMagic;after:TaintedMagic;after:thaumicbases";
}
