package znick_.biomesabroad.biome;

import java.lang.reflect.Field;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import znick_.biomesabroad.biome.autumnalforest.AutumnalForestBiome;
import znick_.biomesabroad.biome.cartoonhills.CartoonHillsBiome;
import znick_.biomesabroad.biome.chaoslands.ChaosLandsBiome;
import znick_.biomesabroad.biome.cherryforest.CherryForestBiome;
import znick_.biomesabroad.biome.cypresscliffs.CypressCliffsBiome;
import znick_.biomesabroad.biome.lushgarden.LushGardenBiome;
import znick_.biomesabroad.biome.mushroomforest.MushroomForestBiome;
import znick_.biomesabroad.biome.overgrownmountains.OvergrownMountainsBiome;
import znick_.biomesabroad.biome.pirateshores.PirateShoresBiome;
import znick_.biomesabroad.biome.rainbowforest.RainbowForestBiome;
import znick_.biomesabroad.biome.retro.RetroBiome;
import znick_.biomesabroad.biome.snowypeaks.SnowyPeaksBiome;
import znick_.biomesabroad.biome.starfield.StarfieldBiome;
import znick_.biomesabroad.biome.wasteland.WastelandBiome;
import znick_.biomesabroad.biome.winterwonderland.WinterWonderlandBiome;
import znick_.biomesabroad.world.BiomesAbroadGenLayer;

public final class BiomesAbroadBiomes {
	
	public static final BaseBiome AUTUMNAL_FOREST = new AutumnalForestBiome();
	public static final BaseBiome CARTOON_HILLS = new CartoonHillsBiome();
	public static final BaseBiome CHAOS_LANDS = new ChaosLandsBiome();
	public static final BaseBiome CHERRY_FOREST = new CherryForestBiome();
	public static final BaseBiome CYPRESS_CLIFFS = new CypressCliffsBiome();
	public static final BaseBiome LUSH_GARDEN = new LushGardenBiome();
	public static final BaseBiome MUSHROOM_FOREST = new MushroomForestBiome();
	public static final BaseBiome OVERGROWN_MOUNTAINS = new OvergrownMountainsBiome();
	public static final BaseBiome PIRATE_SHORES = new PirateShoresBiome();
	public static final BaseBiome RAINBOW_FOREST = new RainbowForestBiome();
	public static final BaseBiome RETRO = new RetroBiome();
	public static final BaseBiome SNOWY_PEAKS = new SnowyPeaksBiome();
	public static final BaseBiome STARFIELD = new StarfieldBiome();
	public static final BaseBiome WASTELAND = new WastelandBiome();
	public static final BaseBiome WINTER_WONDERLAND = new WinterWonderlandBiome();
	
	public static void init() {
		try {
			for (Field field : BiomesAbroadBiomes.class.getDeclaredFields()) {
				if (field.get(null) instanceof BaseBiome) {
					BaseBiome biome = (BaseBiome) field.get(null);
					BiomeDictionary.registerBiomeType(biome, biome.getType());
					BiomesAbroadGenLayer.addBiome(biome);
					BiomeManager.addSpawnBiome(biome);
				}
			}
		} catch(Exception e) {throw new RuntimeException(e);}
	}
	
}
