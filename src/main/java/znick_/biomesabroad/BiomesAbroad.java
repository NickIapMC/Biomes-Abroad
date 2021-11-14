package znick_.biomesabroad;

import java.lang.reflect.InvocationTargetException;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldType;
import znick_.biomesabroad.util.registry.BiomesAbroadBiomes;
import znick_.biomesabroad.util.registry.BiomesAbroadBlocks;
import znick_.biomesabroad.util.registry.BiomesAbroadRecipes;
import znick_.biomesabroad.world.WorldTypeBiomesAbroad;

@Mod(modid = "ba", name = "Biomes Abroad", version = "1.0")
public class BiomesAbroad {
	
	@Instance("ba")
	public static BiomesAbroad instance;

	public static final String MODID = "ba";
	public static final WorldType WORLD_TYPE = new WorldTypeBiomesAbroad();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		BiomesAbroadBlocks.init();
		BiomesAbroadBiomes.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	public static CreativeTabs tabBiomesAbroad = new CreativeTabs("tabBiomesAbroad") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(BiomesAbroadBlocks.CARTOON_GRASS).getItem();
		}
	};
	
}
