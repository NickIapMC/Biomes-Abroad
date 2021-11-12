package znick_.biomesabroad.item;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import znick_.biomesabroad.BiomesAbroad;

public class BiomeBook extends Item {

	public BiomeBook() {
		this.setUnlocalizedName("biome_book");
		this.setTextureName(BiomesAbroad.MODID + ":biome_book");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.rare;
	}
}
