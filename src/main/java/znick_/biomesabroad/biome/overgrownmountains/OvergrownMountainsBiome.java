package znick_.biomesabroad.biome.overgrownmountains;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.block.BiomesAbroadBlocks;

public class OvergrownMountainsBiome extends BaseBiome {
	
	public OvergrownMountainsBiome() {
		super(OvergrownMountainsDecorator.class, Type.MOUNTAIN);
		this.setBiomeName("Overgrown Mountains");

		this.heightVariation = 0.7F;
		this.enableSnow = false;
		this.setBlocks(BiomesAbroadBlocks.OVERGROWN_STONE, Blocks.stone);
	}
}
