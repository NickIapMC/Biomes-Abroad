package znick_.biomesabroad.biome.forbiddengraveyard;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;

public class ForbiddenGraveyardBiome extends BaseBiome {

	public ForbiddenGraveyardBiome() {
		super(BiomeDecorator.class, Type.DEAD);
		this.setBiomeName("Forbidden Graveyard");
		
		
	}

}
