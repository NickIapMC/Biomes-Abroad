package znick_.biomesabroad.biome.pirateshores;

import java.awt.Color;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.biome.pirateshores.deco.BuriedTreasureGenerator;
import znick_.biomesabroad.biome.pirateshores.deco.PalmTreeGenerator;
import znick_.biomesabroad.biome.pirateshores.deco.SandstoneSlabGenerator;
import znick_.biomesabroad.registry.BiomesAbroadBlocks;

public class PirateShores extends BaseBiome {
	
	public PirateShores() {
		super(PirateShoresDecorator.class, Type.BEACH);
		this.setBiomeName("Pirate Shores");

		this.heightVariation = 0.1F;
		this.enableSnow = false;
		this.setBlocks(Blocks.sand, Blocks.sandstone);
		
		this.theBiomeDecorator.cactiPerChunk = 30;
		this.theBiomeDecorator.deadBushPerChunk = 15;
		
		this.addStructure(new PalmTreeGenerator(), 0.75F);
		this.addStructure(new SandstoneSlabGenerator(), 1000);
		this.addFlower(BiomesAbroadBlocks.plantDesertFan, Blocks.sand, 16);
		this.addStructure(new BuriedTreasureGenerator(), 0.02F);
	}
	
	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return (new Color(0, 255, 0)).getRGB();
    }

}