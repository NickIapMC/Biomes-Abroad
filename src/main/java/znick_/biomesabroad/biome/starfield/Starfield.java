package znick_.biomesabroad.biome.starfield;

import java.awt.Color;

import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.registry.BiomesAbroadBlocks;

public class Starfield extends BaseBiome {
	
	public Starfield() {
		super(StarfieldDecorator.class, Type.PLAINS);
		this.setBiomeName("Starfield");

		this.heightVariation = 0.1F;
		this.enableSnow = false;
		this.setBlocks(BiomesAbroadBlocks.blockStargrass, BiomesAbroadBlocks.blockStardirt);
		this.waterColorMultiplier = (new Color(0, 0, 0)).getRGB();
		
		this.addFlower(BiomesAbroadBlocks.flowerStar, BiomesAbroadBlocks.blockStargrass, 5);
	}

	@Override
	public int getSkyColorByTemp(float temp) {
		return (new Color(0, 0, 0)).getRGB();
	}

}