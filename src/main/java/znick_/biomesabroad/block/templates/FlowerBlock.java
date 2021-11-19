package znick_.biomesabroad.block.templates;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import znick_.biomesabroad.BiomesAbroad;

public class FlowerBlock extends BlockFlower {

	private final String name;
	private final String category;
	private final IIcon[] icons = new IIcon[6];
	
	public FlowerBlock(String name, String folder) {
		super(0);
		this.setBlockName(name);
		this.name = name;
		this.category = folder;
		this.setStepSound(Block.soundTypeGrass);
		this.setCreativeTab(BiomesAbroad.CREATIVE_TAB);
		this.setBlockTextureName(BiomesAbroad.MODID + ":" + folder + "/" + name);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		for (int i = 0; i < 6; i++) this.icons[i] = reg.registerIcon(BiomesAbroad.MODID + ":" + this.category + "/" + this.name);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return this.icons[side];
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1));
    }
	
	@Override
	protected boolean canPlaceBlockOn(Block block) {
        return block instanceof BlockGrass || block instanceof GrassBlock;
    }

}
