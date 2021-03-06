package znick_.biomesabroad.biome.rainbowforest;

import java.awt.Color;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;

public class RainbowForestBiome extends BaseBiome {
	
	public RainbowForestBiome() {
		super(BiomeDecorator.class, Type.FOREST);
		this.setBiomeName("Rainbow Forest");

		this.heightVariation = 0F;
		this.enableSnow = false;
		this.theBiomeDecorator.treesPerChunk = 8;
		this.theBiomeDecorator.generateLakes = true;
		this.setTemperatureRainfall(1, 1);
		
		for (int i = 1; i <= 8; i++) this.addFlower(Blocks.red_flower, i, 10);
		for (int i = 0; i <= 5; i++) this.addFlower(Blocks.tallgrass, i, 10);
		
		this.theBiomeDecorator.flowersPerChunk = 64;
	}
	
	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		
		float f = 0.1F;
		
		float r = (float) (0.5 * Math.sin(f * x) + 0.5);
		float g = (float) (0.5 * Math.sin(f * y) + 0.5);
		float b = (float) (0.5 * Math.sin(f * z) + 0.5);
		
		return (new Color(r, g, b)).getRGB();
    }

}
