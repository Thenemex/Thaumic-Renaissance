package tcreborn.model.research.light;

import nemexlib.api.thaumcraft.research.AResearch;
import net.minecraft.init.Blocks;
import tcreborn.model.config.ConfigTab;

public class TorchBasicRecipes extends AResearch {
    public TorchBasicRecipes() {
        super(ConfigTab.lumberjack, "TORCHBASICRECIPES", Blocks.torch);
    }

    @Override
    public void init() {

    }

    @Override
    public void setResearchProperties() {
        this.research.setAutoUnlock().setRound();
    }
}
