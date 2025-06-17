package tcreborn.api.items.types;

import net.minecraft.block.Block;

public class BlockType {

    private final Block block;
    private final int meta;

    public BlockType(Block block, int meta) {
        this.block = block;
        this.meta = Math.max(meta, 0);
    }

    public Block block() {
        return block;
    }
    public int meta() {
        return meta;
    }
}
