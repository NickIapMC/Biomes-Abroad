package znick_.biomesabroad.biome.autumnalforest;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.world.gen.BigTreeGenerator;

public class AutumnalForest extends BaseBiome {

	public AutumnalForest() {
		super(BiomeDecorator.class, Type.FOREST);
		this.theBiomeDecorator.treesPerChunk = 5;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random rand) {
		return new BigTreeGenerator(Blocks.log, Blocks.leaves);
	}

}
