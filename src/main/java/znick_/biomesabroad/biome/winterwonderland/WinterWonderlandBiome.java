package znick_.biomesabroad.biome.winterwonderland;

import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary.Type;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.biome.winterwonderland.deco.IceTreeGenerator;
import znick_.biomesabroad.block.BiomesAbroadBlocks;

public class WinterWonderlandBiome extends BaseBiome {

	public WinterWonderlandBiome() {
		super(WinterWonderlandDecorator.class, Type.SNOWY);
		this.setBiomeName("Winter Wonderland");
		this.setTemperatureRainfall(-Float.MAX_VALUE, 0.0F);

		this.setHeight(new Height(0, 0.3F));
		this.setDisableRain();
		this.enableSnow = true;
		this.setBlocks(Blocks.snow, Blocks.snow);
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySnowman.class, 12, 4, 4));
		
		this.addStructure(new IceTreeGenerator(), 3);
		this.addFlower(BiomesAbroadBlocks.ICE_FLOWER, Blocks.snow, 5);
	}

}
