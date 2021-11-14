package znick_.biomesabroad.biome.starfield;

import java.awt.Color;

import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.block.BiomesAbroadBlocks;

public class StarfieldBiome extends BaseBiome {
	
	public StarfieldBiome() {
		super(StarfieldDecorator.class, Type.PLAINS);
		this.setBiomeName("Starfield");

		this.heightVariation = 0.05F;
		this.enableSnow = false;
		this.setBlocks(BiomesAbroadBlocks.STARGRASS, BiomesAbroadBlocks.STARDIRT);
		this.waterColorMultiplier = (new Color(0, 0, 0)).getRGB();
		
		this.addFlower(BiomesAbroadBlocks.STARFLOWER, BiomesAbroadBlocks.STARGRASS, 5);
	}

	@Override
	public int getSkyColorByTemp(float temp) {
		return Color.BLACK.getRGB();
	}

}
