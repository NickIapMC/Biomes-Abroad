package znick_.biomesabroad.biome.snowypeaks;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;

public class SnowyPeaks extends BaseBiome {

	public SnowyPeaks() {
		super(BiomeDecorator.class, Type.MOUNTAIN);
		this.setBiomeName("Snowy Peaks");
		this.setHeight(new Height(4, 4));
		this.setBlocks(Blocks.snow, Blocks.snow);
	}

}
