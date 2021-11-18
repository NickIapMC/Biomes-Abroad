package znick_.biomesabroad.block;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import znick_.biomesabroad.BiomesAbroad;
import znick_.biomesabroad.util.helper.MinecraftHelper;
import znick_.biomesabroad.util.recipe.ShapedCraftable;

/**
 * Class for creating basic custom stairs.
 * 
 * @author zNick_
 */
public class BasicStairs extends BlockStairs implements ShapedCraftable {
	
	/**The recipe map for crafting the stairs*/
	private final Map<Object[], Integer> recipes = new HashMap<Object[], Integer>();
	
	/**
	 * Creates a new stair block from the given block.
	 * 
	 * @param block The block to use for the texture, name, sound, etc.
	 */
	public BasicStairs(Block block) {
		super(block, 0);
		this.setHardness(MinecraftHelper.getBlockHardness(block));
		this.setStepSound(block.stepSound);
		this.setCreativeTab(BiomesAbroad.CREATIVE_TAB);
		this.setBlockName(block.getUnlocalizedName().substring(5) + "_stairs");
		this.useNeighborBrightness = true;
		
		this.recipes.put(new Object[] {"  A", " AA", "   ", 'A', block}, 4);
		this.recipes.put(new Object[] {" A ", "AA ", "   ", 'A', block}, 4);
		this.recipes.put(new Object[] {"   ", "  A", " AA", 'A', block}, 4);
		this.recipes.put(new Object[] {"   ", " A ", "AA ", 'A', block}, 4);
		this.recipes.put(new Object[] {"  A", "AA ", "   ", 'A', block}, 4);
		this.recipes.put(new Object[] {" A ", " AA", "   ", 'A', block}, 4);
		this.recipes.put(new Object[] {"   ", "  A", "AA ", 'A', block}, 4);
		this.recipes.put(new Object[] {"   ", " A ", " AA", 'A', block}, 4);
	}

	@Override
	public Map<Object[], Integer> getRecipes() {
		return this.recipes;
	}

}
