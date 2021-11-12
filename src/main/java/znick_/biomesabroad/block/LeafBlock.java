package znick_.biomesabroad.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LeafBlock extends BlockBase {

	public LeafBlock(String name, String category) {
		super(name, category, 0.2F, Material.leaves, Block.soundTypeGrass, 0, false, false);
	}

}
