package znick_.biomesabroad.util.helper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import com.google.common.io.Files;

import net.minecraft.block.Block;
import znick_.biomesabroad.BiomesAbroad;
import znick_.biomesabroad.block.BiomesAbroadBlocks;

public class FileHelper {
 
	/**
	 * Generates the {@code en_US.lang} file for the mod. Only generates if {@link SystemHelper#isRunningInIDE()} 
	 * returns true, as embedded files are not editable in the final JAR. The mod must be run in an IDE at least
	 * once before each release to ensure the lang file was generated and filled. 
	 */
	public static void generateLangFile() {
		if (!SystemHelper.isRunningInIDE()) {
			System.out.print("Game running in JAR... skipping en_US.lang file generation");
			return;
		}
		System.out.println("Game running in IDE... generating en_US.lang file");
		try {
			String blank = new File("").getAbsolutePath();
			File langFile = new File(blank.substring(0, blank.length() - 8) + "/src/main/resources/assets/ba/lang/en_US.lang");
			
			System.out.println(langFile.getAbsolutePath());
			StringBuilder sb = new StringBuilder();
			sb.append("itemGroup.tabBiomesAbroad=Biomes Abroad");
			sb.append('\n');
			sb.append("generator.Biomes Abroad=Biomes Abroad");
			sb.append('\n');
			
			for (Field field : BiomesAbroadBlocks.class.getDeclaredFields()) {
				if (field.get(null) instanceof Block) {
					Block block = (Block) field.get(null);
					sb.append(block.getUnlocalizedName());
					sb.append(".name=");
					sb.append(StringHelper.format(block.getUnlocalizedName().substring(5)));
					sb.append('\n');
				}
			}
			Files.write(sb.toString(), langFile, Charset.defaultCharset());
		} catch(IOException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
