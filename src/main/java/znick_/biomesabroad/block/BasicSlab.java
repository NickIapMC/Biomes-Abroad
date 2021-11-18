package znick_.biomesabroad.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import znick_.biomesabroad.BiomesAbroad;

/**
 * The base class for all custom slabs added by Biomes Abroad
 * 
 * <dl>
 * <dt><strong>Superclasses</strong></dt>
 * <dd><strong>BlockSlab</strong> (net.minecraft.block.BlockSlab)</dd>
 * <dd><strong>Block</strong> (net.minecraft.block.Block)</dd>
 */
public class BasicSlab extends BlockSlab {

	public Block block;
	
	public BasicSlab(Block block, String name, String folder, float hardness) {
		super(false, block.getMaterial());

		this.block = block;
		this.useNeighborBrightness = true;
		
		this.setBlockTextureName(BiomesAbroad.MODID + ":" + folder + "/" + block.getUnlocalizedName().substring(5));
		this.setHardness(hardness);
		this.setBlockName(name);
		this.setCreativeTab(BiomesAbroad.CREATIVE_TAB);
	}

	@Override
	public String func_150002_b(int par1) {
		return this.getUnlocalizedName();
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {

		if (world.getBlock(x, y - 1, z) == this) {
			world.setBlockToAir(x, y, z);
			world.setBlock(x, y - 1, z, this.block);
		}

	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {

		super.onBlockPlaced(world, x, y, z, side, hitX, hitY, hitZ, meta);

		if (world.getBlock(x, y, z) == this) {
			world.setBlock(x, y, z, this.block);
		}

		return super.onBlockPlaced(world, x, y, z, side, hitX, hitY, hitZ, meta);
	}

	@Override
	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(this, 2, par1 & 7);
	}

}
