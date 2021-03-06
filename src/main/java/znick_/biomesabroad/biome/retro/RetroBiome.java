package znick_.biomesabroad.biome.retro;

import java.awt.Color;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.block.BiomesAbroadBlocks;

public class RetroBiome extends BaseBiome {
	
	public RetroBiome() {
		super(BiomeDecorator.class, Type.PLAINS);
		this.setBiomeName("Retro");

		this.heightVariation = 0.1F;
		this.enableSnow = false;
		this.setBlocks(BiomesAbroadBlocks.RETRO_GRASS, BiomesAbroadBlocks.RETRO_DIRT);
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.generateLakes = false;
		this.waterColorMultiplier = (new Color(0, 0, 0)).getRGB();
		
		this.addFlower(BiomesAbroadBlocks.SPACE_INVADER, BiomesAbroadBlocks.RETRO_GRASS, 5);
	}

}
