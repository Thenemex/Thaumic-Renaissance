package tcreborn.api.items.types;

import net.minecraft.block.Block;

/**
 * Class used for storing the Block and it's metadata.
 */
public class BlockType {

    protected final Block block;
    protected final int meta;

    /**
     * Constructor for the class
     * @param block The block
     * @param meta The metadata
     */
    public BlockType(Block block, int meta) {
        this.block = block;
        this.meta = Math.max(meta, 0);
    }

    /**
     * Getter for the block
     * @return The block
     */
    public Block block() {
        return block;
    }
    /**
     * Getter for the metadata
     * @return The metadata
     */
    public int meta() {
        return meta;
    }

    /**
     * Convert the instance into text
     * @return The instance turned into text
     */
    @Override
    public String toString() {
        return getClass().getSimpleName().concat("{block = " + block() + ", meta = " + meta + "}");
    }
}
