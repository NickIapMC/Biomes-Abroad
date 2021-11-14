package znick_.biomesabroad.util.helper;

import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Field;

import net.minecraft.block.Block;
import znick_.biomesabroad.BiomesAbroad;
import znick_.biomesabroad.util.registry.BiomesAbroadBlocks;

public class FileHelper {

	public static void generateLangFile() {
		try {
			PrintWriter writer = new PrintWriter(new File(BiomesAbroad.class.getResource("/assets/ba/lang/en_US.lang").getPath()));
			
			for (Field field : BiomesAbroadBlocks.class.getDeclaredFields()) {
				if (field.get(null) instanceof Block) {
					Block block = (Block) field.get(null);
					writer.println(block.getUnlocalizedName() + "=" + StringHelper.format(block.getUnlocalizedName().substring(5)));
				}
			}
			
			writer.flush();
			writer.close();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
