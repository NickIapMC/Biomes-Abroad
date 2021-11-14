package znick_.biomesabroad.biome;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.world.gen.StructureGenerator;

public class BaseBiome extends BiomeGenBase {
	
	private static volatile int nextID = 200;
	private static volatile Class<? extends BiomeDecorator> current;
	
	private final Type type;
	private final Map<WorldGenerator, Float> structures = new LinkedHashMap<WorldGenerator, Float>();
	
	public BaseBiome(Class<? extends BiomeDecorator> decorator, Type type) {
		super(getNextID(decorator), true);
		this.type = type;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
        try {return this.getModdedBiomeDecorator(current.newInstance());}
        catch(InstantiationException e) {throw new RuntimeException(e);} 
        catch (IllegalAccessException e) {throw new RuntimeException(e);}
    }
	
	@Override
	public void decorate(World world, Random rand, int chunkX, int chunkZ) {
		super.decorate(world, rand, chunkX, chunkZ);
		
		for (Map.Entry<WorldGenerator, Float> entry : this.structures.entrySet()) {
			StructureGenerator.generateStructure(world, rand, chunkX, chunkZ, this.rootHeight, entry.getKey(), entry.getValue()); 
		}
	}
	
	public Type getType() {
		return this.type;
	}
	
	private static int getNextID(Class<? extends BiomeDecorator> clazz) {
		current = clazz;
		return nextID++;
	}
	
	protected void setBlocks(Block top, Block fill) {
		this.topBlock = top;
		this.fillerBlock = fill;
	}
	
	
	protected void addFlower(Block toGenerate, float chance) {
		this.addFlower(toGenerate, Blocks.grass, chance);
	}
	
	protected void addFlower(Block toGenerate, Block generateIn, float chance) {
		this.addFlower(toGenerate, 0, generateIn, chance); 
	}
	
	/**
	 * Adds a block to be randomly generated on the surface of the biome. Usually used for flowers, but can be any
	 * single block structure. 
	 * 
	 * @param toGenerate The block to generate
	 * @param meta The metadata value of the block
	 * @param generateIn The block to generate on (typically grass, but some biomes have different ground blocks)
	 * @param chance The chance to generate one in each chunk if less than 1, or the number to generate per chunk
	 * if greater than or equal to 1.
	 */
	protected void addFlower(final Block toGenerate, final int meta, final Block generateIn, float chance) {
		this.structures.put(new WorldGenerator() {
			@Override
			public boolean generate(World world, Random rand, int x, int y, int z) {
				if (world.getBlock(x, y - 1, z) != null) {
					if (toGenerate.canPlaceBlockAt(world, x, y, z) && world.getBlock(x, y - 1, z) == generateIn) {
						world.setBlock(x, y, z, toGenerate, meta, 3);
					}
				}
				return true;
			}
			
		}, chance);
	}
	
	protected void addStructure(WorldGenerator structure, float chance) {
		this.structures.put(structure, chance);
	}

}
