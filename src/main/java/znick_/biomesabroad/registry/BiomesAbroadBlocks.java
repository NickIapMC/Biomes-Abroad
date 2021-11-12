package znick_.biomesabroad.registry;

import java.lang.reflect.Field;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import znick_.biomesabroad.biome.mushroomforest.deco.block.MushroomStem;
import znick_.biomesabroad.biome.mushroomforest.deco.block.RedMushroomBlock;
import znick_.biomesabroad.block.BlockBase;
import znick_.biomesabroad.block.BlockFoliage;
import znick_.biomesabroad.block.SlabBase;
import znick_.biomesabroad.block.StairBase;

/**Class where all custom tiles are created and registered.
*/
public final class BiomesAbroadBlocks {

	public static Block blockDeadGrass;
	public static Block blockTumbleweed;
	public static Block blockDeadLog;
	public static Block blockDeadLeaves;
	public static Block blockDeadPlanks;
	public static Block stairDeadPlanks;
	public static Block slabDeadPlanks;
	
	public static Block blockCartoonGrass;
	public static Block blockCartoonDirt;
	public static Block blockCartoonLog;
	public static Block blockCartoonLeaves;
	public static Block plantCartoonGrass;
	public static Block blockCartoonPlanks;
	public static Block stairCartoonPlanks;
	public static Block slabCartoonPlanks;
	
	public static Block blockRetroGrass;
	public static Block blockRetroDirt;
	public static Block plantSpaceInvader;
	
	public static Block blockOvergrownStone;
	
	public static Block flowerIce;
	
	public static Block plantDesertFan;
	
	public static Block blockStargrass;
	public static Block blockStardirt;
	public static Block flowerStar;
	
	public static Block blockCherryGrass;
	public static Block blockCherryDirt;
	public static Block plantCherryGrass;
	
	public static final Block MUSHROOM_STEM = new MushroomStem();
	public static final Block RED_MUSHROOM_BLOCK = new RedMushroomBlock();
	
	/**
	 * Initialize custom blocks.
	 * @return void
	 */
	public static void initializeBlocks() {
		blockDeadGrass = new BlockBase("blockDeadGrass", "ground/dead", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
		blockTumbleweed = new BlockBase("blockTumbleweed", "bush", 0.2F, Material.leaves, Block.soundTypeGrass, 0, false, false);
		blockDeadLog = new BlockBase("blockDeadLog", "tree/dead/log", 2.0F, Material.wood, Block.soundTypeWood, 0, true, true);
		blockDeadLeaves = new BlockBase("blockDeadLeaves", "tree/dead/leaves" , 0.2F, Material.leaves, Block.soundTypeGrass, 0, false, false);
		blockDeadPlanks = new BlockBase("blockDeadPlanks", "cosmetic/dead", 2.0F, Material.wood, Block.soundTypeWood, 0, true, false);
		
		blockCartoonGrass = new BlockBase("blockCartoonGrass", "ground/cartoon", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
		blockCartoonDirt = new BlockBase("blockCartoonDirt", "ground/cartoon", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
		blockCartoonLog = new BlockBase("blockCartoonLog", "tree/cartoon/log", 2.0F, Material.wood, Block.soundTypeWood, 0, true, true);
		blockCartoonLeaves = new BlockBase("blockCartoonLeaves", "tree/cartoon/leaves" , 0.2F, Material.leaves, Block.soundTypeGrass, 0, false, false);
		plantCartoonGrass = new BlockFoliage(0, "foliage/cartoon", "plantCartoonGrass", BiomesAbroadBlocks.blockCartoonGrass);
		blockCartoonPlanks = new BlockBase("blockCartoonPlanks", "cosmetic/cartoon", 2.0F, Material.wood, Block.soundTypeWood, 0, true, false);
		
		blockRetroGrass = new BlockBase("blockRetroGrass", "ground/retro", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
		blockRetroDirt = new BlockBase("blockRetroDirt", "ground/retro", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
		plantSpaceInvader = new BlockFoliage(0, "foliage/retro", "plantSpaceInvader", BiomesAbroadBlocks.blockRetroGrass);
		
		blockOvergrownStone = new BlockBase("blockOvergrownStone", "ground/overgrown", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
		
		flowerIce = new BlockFoliage(0, "foliage/winter", "flowerIce", Blocks.snow);
		
		plantDesertFan = new BlockFoliage(0, "foliage/pirate", "plantDesertFan", Blocks.sand);
		
		blockStargrass = new BlockBase("blockStargrass", "ground/star", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
		blockStardirt = new BlockBase("blockStardirt", "ground/star", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
		flowerStar = new BlockFoliage(0, "foliage/star", "flowerStar", BiomesAbroadBlocks.blockStargrass);
		
		blockCherryGrass = new BlockBase("blockCherryGrass", "ground/cherry", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
		blockCherryDirt = new BlockBase("blockCherryDirt", "ground/cherry", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
		plantCherryGrass = new BlockFoliage(0, "foliage/cherry", "plantCherryGrass", BiomesAbroadBlocks.blockCherryGrass);
	}
	
	/**
	 * Initialize custom slabs.
	 * @return void
	 */
	public static void initializeSlabs() {
		slabDeadPlanks = new SlabBase(BiomesAbroadBlocks.blockDeadPlanks, "slabDeadPlanks","cosmetic/dead", "blockDeadPlanks", 2.0F);
		slabCartoonPlanks = new SlabBase(BiomesAbroadBlocks.blockCartoonPlanks, "slabCartoonPlanks","cosmetic/cartoon", "blockCartoonPlanks", 2.0F);
	}
	
	/**
	 * Initialize custom stairs.
	 * @return void
	 */
	public static void initializeStairs() {
		stairDeadPlanks = new StairBase(blockDeadPlanks, "stairDeadPlanks");
		stairCartoonPlanks = new StairBase(blockCartoonPlanks, "stairCartoonPlanks");
	}

	public static void init() {
		initializeBlocks();
		initializeSlabs();
		initializeStairs();
		for (Field field : BiomesAbroadBlocks.class.getDeclaredFields()) {
			try {
				if (field.get(null) instanceof Block) {
					Block block = (Block) field.get(null);
					GameRegistry.registerBlock(block, block.getUnlocalizedName());
				}
			} 
			catch(Exception e) {throw new RuntimeException(e);}
		}
	}
	
}