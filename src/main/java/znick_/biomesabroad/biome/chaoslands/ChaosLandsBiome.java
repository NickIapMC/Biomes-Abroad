package znick_.biomesabroad.biome.chaoslands;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;

public class ChaosLandsBiome extends BaseBiome {

	public ChaosLandsBiome() {
		super(BiomeDecorator.class, Type.MOUNTAIN);
		this.setBiomeName("Chaos Lands");
		this.setHeight(new Height(0.5F, 5));
	}

}
