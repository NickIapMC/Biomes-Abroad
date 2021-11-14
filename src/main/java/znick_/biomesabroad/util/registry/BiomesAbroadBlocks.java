package znick_.biomesabroad.util.registry;

import java.lang.reflect.Field;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import znick_.biomesabroad.biome.mushroomforest.deco.block.MushroomStem;
import znick_.biomesabroad.biome.mushroomforest.deco.block.RedMushroomBlock;
import znick_.biomesabroad.block.BlockBase;
import znick_.biomesabroad.block.BlockFoliage;
import znick_.biomesabroad.block.LeafBlock;
import znick_.biomesabroad.block.SlabBase;
import znick_.biomesabroad.block.StairBase;

public final class BiomesAbroadBlocks {

	//Autumnal Forest
	public static final Block RED_LEAVES = new LeafBlock("red_leaves", "biomes/autumnal forest");
	public static final Block ORANGE_LEAVES = new LeafBlock("orange_leaves", "biomes/autumnal forest");
	public static final Block YELLOW_LEAVES = new LeafBlock("yellow_leaves", "biomes/autumnal forest");
	
	//Cartoon Hills
	public static final Block CARTOON_GRASS = new BlockBase("blockCartoonGrass", "ground/cartoon", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
	public static final Block CARTOON_DIRT = new BlockBase("blockCartoonDirt", "ground/cartoon", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
	public static final Block CARTOON_LOG = new BlockBase("blockCartoonLog", "tree/cartoon/log", 2.0F, Material.wood, Block.soundTypeWood, 0, true, true);
	public static final Block CARTOON_LEAVES = new LeafBlock("blockCartoonLeaves", "tree/cartoon/leaves");
	public static final Block CARTOON_GRASS_PLANT = new BlockFoliage("foliage/cartoon", "plantCartoonGrass", BiomesAbroadBlocks.CARTOON_GRASS);
	public static final Block CARTOON_PLANKS = new BlockBase("blockCartoonPlanks", "cosmetic/cartoon", 2.0F, Material.wood, Block.soundTypeWood, 0, true, false);
	public static final Block CARTOON_PLANKS_SLAB = new SlabBase(BiomesAbroadBlocks.CARTOON_PLANKS, "slabCartoonPlanks","cosmetic/cartoon", "blockCartoonPlanks", 2.0F);
	public static final Block CARTOON_PLANKS_STAIRS = new StairBase(CARTOON_PLANKS, "stairCartoonPlanks");
	public static final Block CARTOON_POPPY = new BlockFoliage("biomes/cartoon hills", "cartoon_poppy", BiomesAbroadBlocks.CARTOON_GRASS);
	
	//Cherry Blossom Forest
	public static final Block CHERRY_GRASS = new BlockBase("blockCherryGrass", "ground/cherry", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
	public static final Block CHERRY_DIRT = new BlockBase("blockCherryDirt", "ground/cherry", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
	public static final Block CHERRY_GRASS_PLANT = new BlockFoliage("foliage/cherry", "plantCherryGrass", BiomesAbroadBlocks.CHERRY_GRASS);
	
	//Lush Garden
	public static final Block PATH = new BlockBase("path", "biomes/lush garden/path", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
	
	//Mushroom Forest
	public static final Block MUSHROOM_STEM = new MushroomStem();
	public static final Block RED_MUSHROOM_BLOCK = new RedMushroomBlock();
	
	//Overgrown Mountains
	public static final Block OVERGROWN_STONE = new BlockBase("blockOvergrownStone", "ground/overgrown", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
		
	//Pirate Shores
	public static final Block DESERT_FAN = new BlockFoliage("foliage/pirate", "plantDesertFan", Blocks.sand);
	
	//Retro
	public static final Block RETRO_GRASS = new BlockBase("blockRetroGrass", "ground/retro", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
	public static final Block RETRO_DIRT = new BlockBase("blockRetroDirt", "ground/retro", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
	public static final Block SPACE_INVADER = new BlockFoliage("foliage/retro", "plantSpaceInvader", BiomesAbroadBlocks.RETRO_GRASS);
	
	//Starfield
	public static final Block STARGRASS = new BlockBase("blockStargrass", "ground/star", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
	public static final Block STARDIRT = new BlockBase("blockStardirt", "ground/star", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
	public static final Block STARFLOWER = new BlockFoliage("foliage/star", "flowerStar", BiomesAbroadBlocks.STARGRASS);
	
	//Wasteland
	public static final Block DEAD_GRASS = new BlockBase("blockDeadGrass", "ground/dead", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
	public static final Block TUMBLEWEED = new BlockBase("blockTumbleweed", "bush", 0.2F, Material.leaves, Block.soundTypeGrass, 0, false, false);
	public static final Block DEAD_LOG = new BlockBase("blockDeadLog", "tree/dead/log", 2.0F, Material.wood, Block.soundTypeWood, 0, true, true);
	public static final Block DEAD_LEAVES = new LeafBlock("blockDeadLeaves", "tree/dead/leaves");
	public static final Block DEAD_PLANKS = new BlockBase("blockDeadPlanks", "cosmetic/dead", 2.0F, Material.wood, Block.soundTypeWood, 0, true, false);
	public static final Block DEAD_PLANKS_SLAB = new SlabBase(BiomesAbroadBlocks.DEAD_PLANKS, "slabDeadPlanks","cosmetic/dead", "blockDeadPlanks", 2.0F);
	public static final Block DEAD_PLANKS_STAIRS = new StairBase(DEAD_PLANKS, "stairDeadPlanks");
	
	//Winter Wonderland
	public static final Block ICE_FLOWER = new BlockFoliage("foliage/winter", "flowerIce", Blocks.snow);
	public static final Block CANDY_CANE_BLOCK = new BlockBase("candy_cane_block", "biomes/winter wonderland", 2.0F, Material.rock, Block.soundTypeStone, 0, true, false);

	public static void init() {
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
