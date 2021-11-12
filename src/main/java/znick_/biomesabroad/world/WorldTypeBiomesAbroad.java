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
		GenLayer ret = new BiomesAbroadGenLayer(200L, parentLayer, this);
		ret = GenLayerZoom.magnify(1000L, ret, 2);
		ret = new GenLayerBiomeEdge(1000L, ret);
		return ret;
	}
}
