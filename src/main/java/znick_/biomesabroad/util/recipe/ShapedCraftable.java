package znick_.biomesabroad.util.recipe;

import java.util.Map;

public interface ShapedCraftable {
	
	/**
	 * Returns a map that represents the recipes of the block/item. The keys are object arrays of the recipes and
	 * the values represent the amount of items in each result.
	 */
	public abstract Map<Object[], Integer> getRecipes();
}
