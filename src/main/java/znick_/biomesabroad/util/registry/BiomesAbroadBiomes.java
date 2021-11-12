package znick_.biomesabroad.util.registry;

import java.lang.reflect.Field;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import znick_.biomesabroad.biome.BaseBiome;
import znick_.biomesabroad.biome.autumnalforest.AutumnalForest;
import znick_.biomesabroad.biome.cartoonhills.CartoonHills;
import znick_.biomesabroad.biome.chaoslands.ChaosLands;
import znick_.biomesabroad.biome.cherryforest.CherryForest;
import znick_.biomesabroad.biome.mushroomforest.MushroomForest;
import znick_.biomesabroad.biome.overgrownmountains.OvergrownMountains;
import znick_.biomesabroad.biome.pirateshores.PirateShores;
import znick_.biomesabroad.biome.rainbowforest.RainbowForest;
import znick_.biomesabroad.biome.retro.Retro;
import znick_.biomesabroad.biome.starfield.Starfield;
import znick_.biomesabroad.biome.wasteland.Wasteland;
import znick_.biomesabroad.biome.winterwonderland.WinterWonderland;
import znick_.biomesabroad.world.BiomesAbroadGenLayer;

public final class BiomesAbroadBiomes {
	
	public static final BaseBiome AUTUMNAL_FOREST = new AutumnalForest();
	public static final BaseBiome CARTOON_HILLS = new CartoonHills();
	public static final BaseBiome CHAOS_LANDS = new ChaosLands();
	public static final BaseBiome CHERRY_FOREST = new CherryForest();
	public static final BaseBiome MUSHROOM_FOREST = new MushroomForest();
	public static final BaseBiome OVERGROWN_MOUNTAINS = new OvergrownMountains();
	public static final BaseBiome PIRATE_SHORES = new PirateShores();
	public static final BaseBiome RAINBOW_FOREST = new RainbowForest();
	public static final BaseBiome RETRO = new Retro();
	public static final BaseBiome STARFIELD = new Starfield();
	public static final BaseBiome WASTELAND = new Wasteland();
	public static final BaseBiome WINTER_WONDERLAND = new WinterWonderland();
	
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
