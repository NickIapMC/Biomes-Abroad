package znick_.biomesabroad.biome.wasteland;

import java.awt.Color;

import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.biome.wasteland.deco.DeadTreeGenerator;
import znick_.biomesabroad.block.BiomesAbroadBlocks;

public class WastelandBiome extends BaseBiome {
	
	public WastelandBiome() {
		super(WastelandDecorator.class, Type.SANDY);
		this.setTemperatureRainfall(Float.MAX_VALUE, 0.0F);
		this.setBiomeName("Wasteland");

		this.setHeight(new Height(0, 0));
		this.setDisableRain();
		this.enableSnow = false;
		this.topBlock = BiomesAbroadBlocks.DEAD_GRASS;
		this.waterColorMultiplier = (new Color(255, 128, 0)).getRGB();
		this.theBiomeDecorator.generateLakes = false;
		this.flowers.clear();
		
		this.addStructure(new DeadTreeGenerator(), 0.2F);
		this.addFlower(BiomesAbroadBlocks.TUMBLEWEED, BiomesAbroadBlocks.DEAD_GRASS, 1);
	}

	@Override
	public float getSpawningChance() {
		return 0;
	}

}
