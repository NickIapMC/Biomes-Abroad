package znick_.biomesabroad.util.helper;

import java.lang.reflect.Field;

import net.minecraft.block.Block;

public class MinecraftHelper {

	public static float getBlockHardness(Block block) {
		try {
			Field field = Block.class.getDeclaredField("blockHardness");
			field.setAccessible(true);
			return field.getFloat(block);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
