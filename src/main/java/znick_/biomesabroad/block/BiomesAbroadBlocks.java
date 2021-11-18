package znick_.biomesabroad.block;

import java.lang.reflect.Field;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import znick_.biomesabroad.biome.mushroomforest.deco.block.MushroomStem;
import znick_.biomesabroad.biome.mushroomforest.deco.block.RedMushroomBlock;
import znick_.biomesabroad.block.templates.DirtBlock;
import znick_.biomesabroad.block.templates.FlowerBlock;
import znick_.biomesabroad.block.templates.GrassBlock;
import znick_.biomesabroad.block.templates.LeafBlock;
import znick_.biomesabroad.block.templates.LogBlock;
import znick_.biomesabroad.block.templates.PlanksBlock;

public final class BiomesAbroadBlocks {

	//Autumnal Forest
	public static final Block RED_LEAVES = new LeafBlock("red_leaves", "biomes/autumnal forest");
	public static final Block ORANGE_LEAVES = new LeafBlock("orange_leaves", "biomes/autumnal forest");
	public static final Block YELLOW_LEAVES = new LeafBlock("yellow_leaves", "biomes/autumnal forest");
	
	//Cartoon Hills
	public static final Block CARTOON_DIRT = new DirtBlock("cartoon_dirt", "biomes/cartoon hills/ground");
	public static final Block CARTOON_GRASS = new GrassBlock("cartoon_grass", "biomes/cartoon hills/ground/grass", CARTOON_DIRT);
	public static final Block CARTOON_LOG = new LogBlock("cartoon_log", "biomes/cartoon hills/tree/log");
	public static final Block CARTOON_LEAVES = new LeafBlock("cartoon_leaves", "biomes/cartoon hills/tree");
	public static final Block CARTOON_GRASS_PLANT = new FlowerBlock("biomes/cartoon hills/foliage", "cartoon_grass_plant", BiomesAbroadBlocks.CARTOON_GRASS);
	public static final Block CARTOON_PLANKS = new PlanksBlock("cartoon_planks", "biomes/cartoon hills/cosmetic");
	public static final Block CARTOON_PLANKS_SLAB = new BasicSlab(BiomesAbroadBlocks.CARTOON_PLANKS, "cartoon_planks_slab","biomes/cartoon hills/cosmetic", 2.0F);
	public static final Block CARTOON_PLANKS_STAIRS = new BasicStairs(CARTOON_PLANKS, "cartoon_planks_stairs");
	public static final Block CARTOON_POPPY = new FlowerBlock("biomes/cartoon hills/foliage", "cartoon_poppy", BiomesAbroadBlocks.CARTOON_GRASS);
	
	//Cherry Blossom Forest
	public static final Block CHERRY_DIRT = new DirtBlock("cherry_dirt", "biomes/cherry forest/ground");
	public static final Block CHERRY_GRASS = new GrassBlock("cherry_grass", "biomes/cherry forest/ground/grass", CHERRY_DIRT);
	public static final Block CHERRY_GRASS_PLANT = new FlowerBlock("biomes/cherry forest/foliage", "cherry_grass_plant", BiomesAbroadBlocks.CHERRY_GRASS);
	
	//Lush Garden
	public static final Block PATH = new GrassBlock("path", "biomes/lush garden/ground");
	
	//Mushroom Forest
	public static final Block MUSHROOM_STEM = new MushroomStem();
	public static final Block RED_MUSHROOM_BLOCK = new RedMushroomBlock();
	
	//Overgrown Mountains
	public static final Block OVERGROWN_STONE = new BasicBlock("overgrown_stone", "biomes/overgrown mountains/ground/grass", 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
		
	//Pirate Shores
	public static final Block DESERT_FAN = new FlowerBlock("biomes/pirate shores/foliage", "desert_fan", Blocks.sand);
	
	//Retro
	public static final Block RETRO_DIRT = new DirtBlock("retro_dirt", "biomes/retro/ground");
	public static final Block RETRO_GRASS = new GrassBlock("retro_grass", "biomes/retro/ground/grass", RETRO_DIRT);
	public static final Block SPACE_INVADER = new FlowerBlock("biomes/retro/foliage", "space_invader", BiomesAbroadBlocks.RETRO_GRASS);
	
	//Starfield
	public static final Block STARDIRT = new DirtBlock("stardirt", "biomes/starfield/ground");
	public static final Block STARGRASS = new GrassBlock("stargrass", "biomes/starfield/ground/grass", STARDIRT);
	public static final Block STARFLOWER = new FlowerBlock("biomes/starfield/foliage", "starflower", BiomesAbroadBlocks.STARGRASS);
	
	//Wasteland
	public static final Block DEAD_GRASS = new DirtBlock("dead_grass", "biomes/wasteland/ground");
	public static final Block TUMBLEWEED = new LeafBlock("tumbleweed", "biomes/wasteland/foliage");
	public static final Block DEAD_LOG = new LogBlock("dead_log", "biomes/wasteland/tree/log");
	public static final Block DEAD_LEAVES = new LeafBlock("dead_leaves", "biomes/wasteland/tree");
	public static final Block DEAD_PLANKS = new PlanksBlock("dead_planks", "biomes/wasteland/cosmetic");
	public static final Block DEAD_PLANKS_SLAB = new BasicSlab(BiomesAbroadBlocks.DEAD_PLANKS, "dead_plank_slabs","biomes/wasteland/cosmetic", 2.0F);
	public static final Block DEAD_PLANKS_STAIRS = new BasicStairs(DEAD_PLANKS, "dead_plank_stairs");
	
	//Winter Wonderland
	public static final Block ICE_FLOWER = new FlowerBlock("biomes/winter wonderland/foliage", "ice_flower", Blocks.snow);
	public static final Block CANDY_CANE_BLOCK = new BasicBlock("candy_cane_block", "biomes/winter wonderland/cosmetic", 2.0F, Material.rock, Block.soundTypeStone, 0, true, false);

	/**
	 * Registers all custom Biomes Abroad blocks into the game.
	 */
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
