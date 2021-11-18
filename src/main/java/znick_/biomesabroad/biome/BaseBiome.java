package znick_.biomesabroad.biome;

import java.awt.Color;
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
import znick_.biomesabroad.world.gen.Structure;
import znick_.biomesabroad.world.gen.StructureGenerator;

public class BaseBiome extends BiomeGenBase {
	
	private static volatile int nextID = 200;
	private static volatile Class<? extends BiomeDecorator> current;
	
	private final Type type;
	private final Map<Structure, Float> structures = new LinkedHashMap<Structure, Float>();
	private final Class<? extends BiomeDecorator> decoratorClass;
	private Integer grassColor;
	private Integer foliageColor;
	
	public BaseBiome(Class<? extends BiomeDecorator> decorator, Type type) {
		super(getNextID(decorator), true);
		this.decoratorClass = decorator;
		this.type = type;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
        try {
        	if (this.decoratorClass != null) return this.decoratorClass.newInstance();
        	return this.getModdedBiomeDecorator(current.newInstance());
        }
        catch(InstantiationException e) {throw new RuntimeException(e);} 
        catch (IllegalAccessException e) {throw new RuntimeException(e);}
    }
	
	/**
	 * Decorates the biome with the biome's {@code BiomeDecorator}.
	 * 
	 * @param world The world object the biome is in
	 * @param rand The random instance to decorate with
	 * @param chunkX The {@code x} coordinate of the chunk to decorate
	 * @param chunkZ The {@code z} coordinate of the chunk to decorate
	 */
	@Override
	public void decorate(World world, Random rand, int chunkX, int chunkZ) {
		super.decorate(world, rand, chunkX, chunkZ);
		
		for (Map.Entry<Structure, Float> entry : this.structures.entrySet()) {
			StructureGenerator.generateStructure(world, rand, chunkX, chunkZ, this.rootHeight, entry.getKey(), entry.getValue()); 
		}
	}
	
	@Override
	public int getBiomeGrassColor(int x, int y, int z) {
		return this.grassColor != null ? this.grassColor : super.getBiomeGrassColor(x, y, z);
	}

	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return this.foliageColor != null ? this.foliageColor : super.getBiomeGrassColor(x, y, z);
	}
	
	/**
	 * Sets the color of the grass blocks in this biome.
	 * @param color The color of the grass
	 */
	protected void setGrassColor(Color color) {
		this.grassColor = color.getRGB();
	}
	
	/**
	 * Sets the color of foliage in this biome, such as leaves and tall grass.
	 * @param color The color of the foliage
	 */
	protected void setFoliageColor(Color color) {
		this.grassColor = color.getRGB();
	}
	
	/**
	 * Returns the type of biome to register as.
	 */
	public Type getType() {
		return this.type;
	}
	
	/**
	 * Returns the next available biome ID and sets the current decorator class.
	 * 
	 * @param clazz The decorator class of the biome
	 * @return The ID of the biome
	 */
	private static int getNextID(Class<? extends BiomeDecorator> clazz) {
		current = clazz;
		return nextID++;
	}
	
	/**
	 * Sets the top and filler block of this biome; More specifically, the blocks to replace grass and dirt
	 * 
	 * @param top The top block; traditionally grass
	 * @param fill The bottom block; traditionally dirt
	 */
	protected void setBlocks(Block top, Block fill) {
		this.topBlock = top;
		this.fillerBlock = fill;
	}
	
	/**
	 * Convenience method for {@link #addFlower(Block, int, Block, float)} with metadata 0 and generating on
	 * {@link net.minecraft.init.Blocks#grass Blocks.grass}.
	 */
	protected void addFlower(Block toGenerate, float chance) {
		this.addFlower(toGenerate, Blocks.grass, chance);
	}
	
	/**
	 * Convenience method for {@link #addFlower(Block, int, Block, float)} with 0 metadata.
	 */
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
		this.structures.put(new Structure() {
			
			@Override
			public void generate(World world, int x, int y, int z) {
				world.setBlock(x, y, z, toGenerate, meta, 3);
			}

			@Override
			public boolean canGenerateAt(World world, int x, int y, int z) {
				if (world.getBlock(x, y - 1, z) == null) return false;
				if (!toGenerate.canPlaceBlockAt(world, x, y, z)) return false;
				if (world.getBlock(x, y - 1, z) != generateIn) return false;
				return true;
			}
			
		}, chance);
	}
	
	/**
	 * Adds the structure to be generated randomly with the given chance.
	 * 
	 * @param structure The structure to generate
	 * @param chance The percent change per chunk to generate the structure in that chunk if {@code chance <= 1}, or
	 * the number of structures to generate per chunk if {@code chance >= 1}.
	 */
	protected void addStructure(Structure structure, float chance) {
		this.structures.put(structure, chance);
	}

}
