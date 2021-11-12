package znick_.biomesabroad.biome.mushroomforest.deco.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import znick_.biomesabroad.BiomesAbroad;

public class MushroomStem extends Block {

	public MushroomStem() {
		super(Material.wood);
		this.setBlockName("mushroom_stem");
		this.setBlockTextureName(BiomesAbroad.MODID + ":biomes/mushroom forest/mushroom_stem");
	}
}
