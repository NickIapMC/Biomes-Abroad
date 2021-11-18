package znick_.biomesabroad.world;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldTypeBiomesAbroad extends WorldType {

	public WorldTypeBiomesAbroad() {
		super("Biomes Abroad");
	}

	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer) {
		return new GenLayerBiomeEdge(1000, GenLayerZoom.magnify(1000, new BiomesAbroadGenLayer(200, parentLayer, this), 2));
	}
}
