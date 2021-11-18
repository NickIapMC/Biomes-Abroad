package znick_.biomesabroad.block;

import java.util.Arrays;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import znick_.biomesabroad.BiomesAbroad;

/**
 * Base class for creating custom blocks.
 * @author zNick_
 */
public class BasicBlock extends Block {
	
	/**Whether the object is multitextured.*/
	private boolean multiTextured;
	/**The file directory that the texture is located in, relative to {@code ba/textures/blocks}.*/
	String category;
	/**The name of the block; also used for its texture name*/
	private String name;
	/**The textures for the block*/
	private final IIcon[] textures = new IIcon[6];
	
	/**
	 * Creates a new block with all of the specified properties.
	 * 
	 * @param name The unlocalized name of the block, as well as its texture name
	 * @param category The folder that the block's texture lies in
	 * @param hardness The hardness of the block (breaking time)
	 * @param material The material of the block (what tool)
	 * @param sound The sound the block makes upon breaking and walking on it
	 * @param light The amount of light the block gives off, or 0 for none
	 * @param opaque Whether or not the block is opaque as opposed to transparent
	 * @param multiTextured Whether or not the block uses different textures for each side
	 */
	public BasicBlock(String name, String category, float hardness, Material material, SoundType sound, float light, boolean opaque, boolean multiTextured) {
		super(material);

		this.name = name;
		this.opaque = opaque;
		this.multiTextured = multiTextured;
		this.category = category;
		
		this.setBlockName(name);
		this.setHardness(hardness);
		this.setStepSound(sound);
		this.setLightLevel(light);
		this.setBlockTextureName(BiomesAbroad.MODID + ":" + name);
		this.setCreativeTab(BiomesAbroad.CREATIVE_TAB);
	}

	@Override
	public boolean isOpaqueCube() {
		return this.opaque;
	}
	
	@Override
    public void registerBlockIcons(IIconRegister reg) {
		if (this.multiTextured) {
			for (int i = 0; i < 6; i++) {
				switch(i) {
				case 0:
					this.textures[i] = reg.registerIcon(BiomesAbroad.MODID + ":" + this.category + "/" + this.name + "_bottom");
					break;
				case 1:
					this.textures[i] = reg.registerIcon(BiomesAbroad.MODID + ":" + this.category + "/" + this.name + "_top");
					break;
				default:
					this.textures[i] = reg.registerIcon(BiomesAbroad.MODID + ":" + this.category + "/" + this.name + "_side");
				}
			}
		} else {
			for (int i = 0; i < 6; i++) {
				this.textures[i] = reg.registerIcon(BiomesAbroad.MODID + ":" + this.category + "/" + this.name);
			}
		}
    }
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return this.textures[side];
	}
	
}
