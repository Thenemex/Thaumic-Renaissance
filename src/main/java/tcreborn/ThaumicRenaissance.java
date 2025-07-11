package tcreborn;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import tcreborn.config.Config;
import tcreborn.model.ArrayCollector;
import tcreborn.model.config.*;

import static tcreborn.ThaumicRenaissance.modID;
import static tcreborn.ThaumicRenaissance.dependencies;

import java.io.File;

@SuppressWarnings("unused")
@Mod(modid = modID, useMetadata = true, version = "1.3.2.1", dependencies = dependencies)
public class ThaumicRenaissance {

    public static final String modID = "TCReborn", modName = "ThaumicRenaissance";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.init(new File(event.getModConfigurationDirectory(), modName)); // Custom folder with mod name
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
        // Registering researches
        ConfigTab.init(); // Initializing Thaumonomicon new tabs
        ConfigResearch.init(); // Initializing Thaumonomicon new researches
    }

    public static final String dependencies = "required-after:Thaumcraft@[4.2.3.5,);after:ForbiddenMagic;after:TaintedMagic;after:thaumicbases;after:TwilightForest;after:tc4tweak";
}
