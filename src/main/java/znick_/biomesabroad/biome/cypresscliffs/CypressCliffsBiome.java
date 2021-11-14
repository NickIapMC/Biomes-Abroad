package znick_.biomesabroad.biome.cypresscliffs;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.biome.cypresscliffs.deco.CypressTreeGenerator;

public class CypressCliffsBiome extends BaseBiome {

	public CypressCliffsBiome() {
		super(BiomeDecorator.class, Type.MOUNTAIN);
		this.setBiomeName("Cypress Cliffs");
		this.setHeight(new Height(0.5F, 2));
		
		this.addStructure(new CypressTreeGenerator(), 2);
	}

}
