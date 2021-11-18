package znick_.biomesabroad.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import znick_.biomesabroad.block.BiomesAbroadBlocks;
import znick_.biomesabroad.util.helper.MathHelper;

public class StructureGenerator {

	/**
	 * Pseudo-randomly generates a structure in the given chunk.
	 * 
	 * @param world The world that the structure is generating in
	 * @param rand An instance of java's Random class. 
	 * @param chunkX The x-coordinate of the chunk to generate in
	 * @param chunkZ The z-coordinate of the chunk to generate in
	 * @param rootHeight The median height of the biome to generate in
	 * @param toGenerate The class containing the schematics for the structure
	 * @param chance The amount of times per chunk to generate the structure, or the chance for it to generate on any given chunk
	*/
	public static void generateStructure(World world, Random rand, int chunkX, int chunkZ, float rootHeight, WorldGenerator toGenerate, float chance) {
		if (chance < 1) {
			if (Math.random() < chance) {
				int randX = chunkX + rand.nextInt(8) - rand.nextInt(16);
				int y = (int) (MathHelper.map(rootHeight, -2, 2, 0, 128));
				int randZ = chunkZ + rand.nextInt(8) - rand.nextInt(16);

				for (int i = -100; i < 100; i++) {
					toGenerate.generate(world, rand, randX, y + i, randZ);
				}
			}
		} else {
			for (int j = 0; j < chance; j++) {
				int y = (int) (MathHelper.map(rootHeight, -2, 2, 0, 128));
				int randX = chunkX + rand.nextInt(8) - rand.nextInt(16);
				int randZ = chunkZ + rand.nextInt(8) - rand.nextInt(16);
				
				for (int i = -100; i < 100; i++) {
					toGenerate.generate(world, rand, randX, y + i, randZ);
				}
			}
		}
	}
	
}
