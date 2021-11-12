package znick_.biomesabroad.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import znick_.biomesabroad.BiomesAbroad;

public class StairBase extends BlockStairs {

	public StairBase(Block block, String name) {
		super(block, 0);
		this.setStepSound(block.stepSound);
		this.setCreativeTab(BiomesAbroad.tabBiomesAbroad);
		this.setBlockName(name);
		this.useNeighborBrightness = true;
	}

}
