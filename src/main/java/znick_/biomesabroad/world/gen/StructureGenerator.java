package znick_.biomesabroad.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import znick_.biomesabroad.util.helper.BAMathHelper;
import znick_.biomesabroad.util.registry.BiomesAbroadBlocks;

/**
 * Class with a single static method that generates a structure such as a tree
 * or flower.
 */
public class StructureGenerator {

	/**
	 * Pseudo-randomly generates a structure in the given chunk.
	 * 
	 * @param world the world that the structure is generating in
	 * @param rand an instance of java's Random class. 
	 * @param chunkX the x-coordinate of the chunk to generate in
	 * @param chunkZ the z-coordinate of the chunk to generate in
	 * @param rootHeight the median height of the biome to generate in
	 * @param toGenerate the class containing the schematics for the structure
	 * @param chance the amount of times per chunk to generate the structure, or the chance for it to generate on any given chunk
	*/
	public static void generateStructure(World world, Random rand, int chunkX, int chunkZ, float rootHeight, WorldGenerator toGenerate, float chance) {

		if (chance < 1) {
			if (Math.random() < chance) {
				int randX = chunkX + rand.nextInt(8) - rand.nextInt(16);
				int y = (int) (BAMathHelper.map(rootHeight, -2, 2, 0, 128));
				int randZ = chunkZ + rand.nextInt(8) - rand.nextInt(16);

				for (int i = -100; i < 100; i++) {
					toGenerate.generate(world, rand, randX, y + i, randZ);
				}
			}
		} else {
			for (int j = 0; j < chance; j++) {
				int y = (int) (BAMathHelper.map(rootHeight, -2, 2, 0, 128));
				int randX = chunkX + rand.nextInt(8) - rand.nextInt(16);
				int randZ = chunkZ + rand.nextInt(8) - rand.nextInt(16);
				
				for (int i = -100; i < 100; i++) {
					toGenerate.generate(world, rand, randX, y + i, randZ);
				}
			}
		}
	}
	
	public static void generateStructure(World world, Random rand, int chunkX, int chunkZ, float rootHeight, final Block toGenerate, final Block generateOn, float chance) {
		generateStructure(world, rand, chunkX, chunkZ, rootHeight, new WorldGenerator() {
			@Override
			public boolean generate(World world, Random rand, int x, int y, int z) {
				if (world.getBlock(x, y - 1, z) != null) {
					if (toGenerate.canPlaceBlockAt(world, x, y, z) && world.getBlock(x, y - 1, z) == generateOn) {
						world.setBlock(x, y, z, toGenerate, 0, 3);
					}
				}
				return true;
			}
			
		}, chance);
	}

}