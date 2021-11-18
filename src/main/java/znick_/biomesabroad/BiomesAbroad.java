package znick_.biomesabroad;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldType;
import znick_.biomesabroad.biome.BiomesAbroadBiomes;
import znick_.biomesabroad.block.BiomesAbroadBlocks;
import znick_.biomesabroad.util.helper.FileHelper;
import znick_.biomesabroad.world.WorldTypeBiomesAbroad;

@Mod(modid = "ba", name = "Biomes Abroad", version = "1.0")
public class BiomesAbroad {
	
	@Instance("ba")
	public static BiomesAbroad instance;

	public static final String MODID = "ba";
	public static final WorldType WORLD_TYPE = new WorldTypeBiomesAbroad();
	public static final CreativeTabs CREATIVE_TAB = new CreativeTabs("tabBiomesAbroad") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(BiomesAbroadBlocks.CARTOON_GRASS);
		}
	};
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		FileHelper.generateLangFile();
		BiomesAbroadBlocks.init();
		BiomesAbroadBiomes.init();
	}
	
}
