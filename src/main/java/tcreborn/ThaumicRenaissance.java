package tcreborn;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import nemexlib.config.AConfig;
import tcreborn.config.Config;
import tcreborn.model.ArrayCollector;
import tcreborn.model.config.*;

import static tcreborn.ThaumicRenaissance.modID;
import static tcreborn.ThaumicRenaissance.dependencies;

@SuppressWarnings("unused")
@Mod(modid = modID, useMetadata = true, version = "1.5.0.3", dependencies = dependencies)
public class ThaumicRenaissance {

    public static final String modID = "TCReborn", modName = "ThaumicRenaissance";
    public static AConfig config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config = new Config(event, "1.1").init(); // Init config
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent ignoredEvent) {
        ArrayCollector.init(); // Initializing arrays with data, for easier code
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent ignoredEvent) {
        ConfigIntegrations.init(); // Initializing mod integrations, looking at config file
        ConfigOreDict.init(); // Initializing ore dictionnary entries, depending on data inside ArrayCollector
        ArrayCollector.initMap(); // Initializing maps with possible integrations added
        // Initializing handlers
        ConfigHandlers.init();
        // Registering researches
        ConfigResearch.init(); // Initializing Thaumonomicon new researches
    }

    public static final String dependencies = "required-after:Thaumcraft@[4.2.3.5,);required-after:NemexLib@[1.0.0.5,);after:ForbiddenMagic;after:TaintedMagic;after:thaumicbases;after:TwilightForest;after:tc4tweak";
}
