package znick_.biomesabroad.util.helper;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;

public class MinecraftHelper {

	/**
	 * Returns the base hardness of a block.
	 * 
	 * @param block The block to get the hardness of.
	 */
	public static float getBlockHardness(Block block) {
		try {
			String fieldName = SystemHelper.isRunningInIDE()? "blockHardness" : "field_149782_v"; //Field uses obfuscated name when running in jar
			Field field = Block.class.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.getFloat(block);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Picks a random key in the given map based on their values as weights.
	 * 
	 * @param weightMap The map of objects and their associated weights
	 * @param <T> The type of objects in the map
	 * 
	 * @return A randomly picked object based on its weight
	 */
	public static <T> T getRandomFromWeightMap(Map<T, Integer> weightMap) {
		int cumSum = 0;
		for (Integer i : weightMap.values()) cumSum += i;
		int rand = new Random().nextInt(cumSum);
		
		for (Map.Entry<T, Integer> entry : weightMap.entrySet()) {
			if (rand < entry.getValue()) return entry.getKey();
			rand -= entry.getValue();
		}
		
		throw new IllegalStateException("A fatal error has occurred while attempting to generate a weighted random number");
	}
}
