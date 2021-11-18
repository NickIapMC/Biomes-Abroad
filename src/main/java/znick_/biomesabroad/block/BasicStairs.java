package znick_.biomesabroad.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import znick_.biomesabroad.BiomesAbroad;

public class BasicStairs extends BlockStairs {

	public BasicStairs(Block block, String name) {
		super(block, 0);
		this.setStepSound(block.stepSound);
		this.setCreativeTab(BiomesAbroad.CREATIVE_TAB);
		this.setBlockName(name);
		this.useNeighborBrightness = true;
	}

}
