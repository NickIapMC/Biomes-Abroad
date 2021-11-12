package znick_.biomesabroad.biome.mushroomforest;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.biome.mushroomforest.deco.MiniRedMushroomGenerator;

public class MushroomForest extends BaseBiome {

	public MushroomForest() {
		super(BiomeDecorator.class, Type.FOREST);
		this.setBiomeName("Mushroom Forest");
		this.heightVariation = 0.3F;
		this.setColor(6934491);
		this.addStructure(new MiniRedMushroomGenerator(), 3);
		this.addFlower(Blocks.red_mushroom, Blocks.grass, 16);
		this.addFlower(Blocks.brown_mushroom, Blocks.grass, 16);
		this.flowers.clear();
	}
	
	@Override
    public int getBiomeGrassColor(int x, int y, int z) {
		return 6934491;
	}
	
	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return 7397529;
	}

}
