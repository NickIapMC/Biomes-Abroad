package znick_.biomesabroad.block;

import java.util.Arrays;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import znick_.biomesabroad.BiomesAbroad;

/**Base class for all custom blocks added by Biomes Abroad, not including special types such as slabs, stairs, and flowers.
 * 
 * <dl>
 * <dt><strong>Superclasses:</strong><dt><dd>Block (net.minecraft.block.Block)</dd>
*/
public class BlockBase extends Block {
	
	 /** Whether the object is multitextured.*/
	boolean multiTextured;
	/**The file directory that the texture is located in, relative to ba/textures/blocks.*/
	String category;
	/**The name of the block, also sets its texture name*/
	String name;
	
	/**
     * Base constructor for all custom blocks added by Biomes Abroad, not including special types such as slabs, stairs, and flowers.
     * 
     * @param String name: The name of the block, also sets its texture name.
     * @param String category: The file directory that the texture is located in, relative to ba/textures/blocks.
     * @param Float hardness: The hardness of the block.
     * @param Material material: the material of the block.
     * @param SoundType sound: the sound of the block.
     * @param Float light: the amount of light the block gives off, from 0 - 15.
     * @param Boolean opaque: Whether or not the block is opaque.
     * @param Boolean multitextured: Whether or not the block has different textures on different sides.
     * 
     */
	public BlockBase(String name, String category, float hardness, Material material, SoundType sound, float light, boolean opaque, boolean multiTextured) {
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
		this.setCreativeTab(BiomesAbroad.tabBiomesAbroad);
	}

	@Override
	public boolean isOpaqueCube() {
		return this.opaque;
	}
	
	public IIcon[] icons = new IIcon[6];
	
	@Override
    public void registerBlockIcons(IIconRegister reg) {
		if (this.multiTextured) {
			for (int i = 0; i < 6; i++) {
				switch(i) {
				case 0:
					this.icons[i] = reg.registerIcon(BiomesAbroad.MODID + ":" + this.category + "/" + this.name + "_bottom");
					break;
				case 1:
					this.icons[i] = reg.registerIcon(BiomesAbroad.MODID + ":" + this.category + "/" + this.name + "_top");
					break;
				default:
					this.icons[i] = reg.registerIcon(BiomesAbroad.MODID + ":" + this.category + "/" + this.name + "_side");
				}
			}
		} else {
			for (int i = 0; i < 6; i++) {
				this.icons[i] = reg.registerIcon(BiomesAbroad.MODID + ":" + this.category + "/" + this.name);
			}
		}
    }
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return this.icons[side];
	}
	
}