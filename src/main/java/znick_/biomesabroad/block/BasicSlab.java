package znick_.biomesabroad.block;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import znick_.biomesabroad.BiomesAbroad;
import znick_.biomesabroad.util.helper.MinecraftHelper;
import znick_.biomesabroad.util.recipe.ShapedCraftable;

/**
 * The base class for all custom slabs added by Biomes Abroad.
 */
public class BasicSlab extends BlockSlab implements ShapedCraftable {

	/**The block that represents the "double" full block version of this slab.*/
	private final Block block;
	/**The recipe map for this slab*/
	private final Map<Object[], Integer> recipes = new HashMap<Object[], Integer>();
	
	/**
	 * Creates a new basic slab block with the given properties.
	 * 
	 * @param block The "double" full block version of this block.
	 * @param name The name of this block
	 * @param folder The location of the texture of the block
	 */
	public BasicSlab(BasicBlock block) {
		super(false, block.getMaterial());

		this.block = block;
		this.useNeighborBrightness = true;
		
		this.setBlockTextureName(BiomesAbroad.MODID + ":" + block.category + "/" + block.getUnlocalizedName().substring(5));
		this.setBlockName(block.getUnlocalizedName().substring(5) + "_slab");
		this.setHardness(MinecraftHelper.getBlockHardness(block));
		this.setCreativeTab(BiomesAbroad.CREATIVE_TAB);
		
		this.recipes.put(new Object[] {"AAA", "   ", "   ", 'A', block}, 6);
		this.recipes.put(new Object[] {"   ", "AAA", "   ", 'A', block}, 6);
		this.recipes.put(new Object[] {"   ", "   ", "AAA", 'A', block}, 6);
	}

	@Override
	public String func_150002_b(int par1) {
		return this.getUnlocalizedName();
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
		if (world.getBlock(x, y - 1, z) == this) world.setBlock(x, y - 1, z, this.block);
		if (world.getBlock(x, y + 1, z) == this) world.setBlock(x, y + 1, z, this.block);
	}
	
	@Override
	protected ItemStack createStackedBlock(int meta) {
		return new ItemStack(this, 2, meta & 7);
	}

	@Override
	public Map<Object[], Integer> getRecipes() {
		return this.recipes;
	}

}
