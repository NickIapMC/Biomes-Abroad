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

	public static void generateLangFile() {
		try {
			File langFile = new File(BiomesAbroad.class.getResource("/assets/ba/lang/en_US.lang").toURI().getPath());
			StringBuilder sb = new StringBuilder();
			sb.append("itemGroup.tabBiomesAbroad=Biomes Abroad");
			sb.append("generator.Biomes Abroad=Biomes Abroad");
			
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
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
}
