package znick_.biomesabroad.biome.autumnalforest;

import java.awt.Color;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.block.BiomesAbroadBlocks;
import znick_.biomesabroad.world.gen.BigTreeGenerator;

public class AutumnalForestBiome extends BaseBiome {

	public AutumnalForestBiome() {
		super(BiomeDecorator.class, Type.FOREST);
		this.setBiomeName("Autumnal Forest");
		this.theBiomeDecorator.treesPerChunk = 5;
		this.setGrassColor(new Color(130, 255, 128));
		this.setFoliageColor(new Color(130, 255, 128));
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random rand) {
		Block leaves = null;
		switch(rand.nextInt(4)) {
		case 0: leaves = Blocks.leaves; break;
		case 1: leaves = BiomesAbroadBlocks.RED_LEAVES; break;
		case 2: leaves = BiomesAbroadBlocks.ORANGE_LEAVES; break;
		case 3: leaves = BiomesAbroadBlocks.YELLOW_LEAVES; break;
		}
		return new BigTreeGenerator(Blocks.log, leaves);
	}

}
