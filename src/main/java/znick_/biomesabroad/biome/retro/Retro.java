package znick_.biomesabroad.biome.retro;

import java.awt.Color;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.registry.BiomesAbroadBlocks;

public class Retro extends BaseBiome {
	
	public Retro() {
		super(BiomeDecorator.class, Type.PLAINS);
		this.setBiomeName("Retro");

		this.heightVariation = 0.1F;
		this.enableSnow = false;
		this.setBlocks(BiomesAbroadBlocks.blockRetroGrass, BiomesAbroadBlocks.blockRetroDirt);
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.generateLakes = false;
		this.waterColorMultiplier = (new Color(0, 0, 0)).getRGB();
		
		this.addFlower(BiomesAbroadBlocks.plantSpaceInvader, BiomesAbroadBlocks.blockRetroGrass, 5);
	}

}