package znick_.biomesabroad.biome.cartoonhills;

import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.biome.cartoonhills.deco.CartoonTreeGenerator;
import znick_.biomesabroad.block.BiomesAbroadBlocks;

public class CartoonHillsBiome extends BaseBiome {
	
	public CartoonHillsBiome() {
		super(CartoonHillsDecorator.class, Type.PLAINS);
		this.setBiomeName("Cartoon Hills");

		this.heightVariation = 0.5F;
		this.enableSnow = false;
		this.setBlocks(BiomesAbroadBlocks.CARTOON_GRASS, BiomesAbroadBlocks.CARTOON_DIRT);
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.flowersPerChunk = 0;
		
		this.addStructure(new CartoonTreeGenerator(), 0.75F);
		this.addFlower(BiomesAbroadBlocks.CARTOON_GRASS_PLANT, BiomesAbroadBlocks.CARTOON_GRASS, 64);
		this.addFlower(BiomesAbroadBlocks.CARTOON_POPPY, BiomesAbroadBlocks.CARTOON_GRASS, 2);
	}

}
