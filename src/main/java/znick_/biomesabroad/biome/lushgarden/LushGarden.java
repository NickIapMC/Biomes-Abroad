package znick_.biomesabroad.biome.lushgarden;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.util.registry.BiomesAbroadBlocks;
import znick_.biomesabroad.world.gen.GroundBlockGenerator;

public class LushGarden extends BaseBiome {

	public LushGarden() {
		super(BiomeDecorator.class, Type.PLAINS);
		this.setBiomeName("Lush Garden");
		this.setHeight(new Height(0.2F, 0.5F));

		this.theBiomeDecorator.treesPerChunk = 4;
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.grassPerChunk = 32;
		
		for (int i = 0; i < 9; i++) this.addFlower(Blocks.red_flower, i, Blocks.grass, 4);
		
		this.addFlower(Blocks.hay_block, 1);
		this.addFlower(Blocks.pumpkin, 1);
		this.addFlower(Blocks.melon_block, 1);
		this.addFlower(Blocks.leaves, 1);
		this.addFlower(Blocks.brown_mushroom, 1);
		this.addFlower(Blocks.red_mushroom, 1);
		
		this.addStructure(new GroundBlockGenerator(Blocks.grass, Blocks.leaves), 15);
		this.addStructure(new GroundBlockGenerator(Blocks.grass, Blocks.gravel), 7);
		this.addStructure(new GroundBlockGenerator(Blocks.grass, Blocks.cobblestone), 7);
		this.addStructure(new GroundBlockGenerator(Blocks.grass, BiomesAbroadBlocks.PATH), 7);
	}

	@Override
	public int getBiomeGrassColor(int x, int y, int z) {
		return 1759340;
	}

	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return 1368687;
	}
}
