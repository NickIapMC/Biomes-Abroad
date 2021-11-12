package znick_.biomesabroad.biome.mushroomforest.deco.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.crafting.CraftingManager;
import znick_.biomesabroad.BiomesAbroad;

public class RedMushroomBlock extends Block {

	public RedMushroomBlock() {
		super(Material.wood);
		this.setBlockName("red_mushroom_top");
		this.setBlockTextureName(BiomesAbroad.MODID + ":biomes/mushroom forest/red_mushroom_block");
	}
}
