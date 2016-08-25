package com.hbm.blocks;

import java.util.Random;

import com.hbm.lib.RefStrings;
import com.hbm.main.MainRegistry;
import com.hbm.tileentity.TileEntityCoreAdvanced;
import com.hbm.tileentity.TileEntityCoreTitanium;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class FactoryHatch extends Block {
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;

	protected FactoryHatch(Material p_i45394_1_) {
		super(p_i45394_1_);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iconFront = iconRegister.registerIcon(RefStrings.MODID + (this == ModBlocks.factory_titanium_furnace ? ":factory_titanium_furnace" : ":factory_advanced_furnace"));
		this.blockIcon = iconRegister.registerIcon(RefStrings.MODID + (this == ModBlocks.factory_titanium_furnace ? ":factory_titanium_hull" : ":factory_advanced_hull"));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return metadata == 0 && side == 3 ? this.iconFront : (side == metadata ? this.iconFront : this.blockIcon);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		//this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote)
		{
			Block block1 = world.getBlock(x, y, z - 1);
			Block block2 = world.getBlock(x, y, z + 1);
			Block block3 = world.getBlock(x - 1, y, z);
			Block block4 = world.getBlock(x + 1, y, z);
			
			byte b0 = 3;
			
			if(block1.func_149730_j() && !block2.func_149730_j())
			{
				b0 = 3;
			}
			if(block2.func_149730_j() && !block1.func_149730_j())
			{
				b0 = 2;
			}
			if(block3.func_149730_j() && !block4.func_149730_j())
			{
				b0 = 5;
			}
			if(block4.func_149730_j() && !block3.func_149730_j())
			{
				b0 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
		int i = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		
		if(i == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(i == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if(i == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(i == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(world.isRemote)
		{
			return true;
		} else if(!player.isSneaking())
		{
			if(this == ModBlocks.factory_titanium_furnace)
			{
				if(world.getBlockMetadata(x, y, z) == 2)
				{
					if(world.getTileEntity(x, y, z + 1) instanceof TileEntityCoreTitanium)
					{
						if(((TileEntityCoreTitanium)world.getTileEntity(x, y, z + 1)).isStructureValid(world))
						{
							FMLNetworkHandler.openGui(player, MainRegistry.instance, ModBlocks.guiID_factory_titanium, world, x, y, z + 1);
						} else {
							player.addChatMessage(new ChatComponentText("[Basic Factory] Error: Factory Structure not valid!"));
						}
					} else {
						player.addChatMessage(new ChatComponentText("[Basic Factory] Error: Factory Core not found!"));
					}
				}
				if(world.getBlockMetadata(x, y, z) == 3)
				{
					if(world.getTileEntity(x, y, z - 1) instanceof TileEntityCoreTitanium)
					{
						if(((TileEntityCoreTitanium)world.getTileEntity(x, y, z - 1)).isStructureValid(world))
						{
							FMLNetworkHandler.openGui(player, MainRegistry.instance, ModBlocks.guiID_factory_titanium, world, x, y, z - 1);
						} else {
							player.addChatMessage(new ChatComponentText("[Basic Factory] Error: Factory Structure not valid!"));
						}
					} else {
						player.addChatMessage(new ChatComponentText("[Basic Factory] Error: Factory Core not found!"));
					}
				}
				if(world.getBlockMetadata(x, y, z) == 4)
				{
					if(world.getTileEntity(x + 1, y, z) instanceof TileEntityCoreTitanium)
					{
						if(((TileEntityCoreTitanium)world.getTileEntity(x + 1, y, z)).isStructureValid(world))
						{
							FMLNetworkHandler.openGui(player, MainRegistry.instance, ModBlocks.guiID_factory_titanium, world, x + 1, y, z);
						} else {
							player.addChatMessage(new ChatComponentText("[Basic Factory] Error: Factory Structure not valid!"));
						}
					} else {
						player.addChatMessage(new ChatComponentText("[Basic Factory] Error: Factory Core not found!"));
					}
				}
				if(world.getBlockMetadata(x, y, z) == 5)
				{
					if(world.getTileEntity(x - 1, y, z) instanceof TileEntityCoreTitanium)
					{
						if(((TileEntityCoreTitanium)world.getTileEntity(x - 1, y, z)).isStructureValid(world))
						{
							FMLNetworkHandler.openGui(player, MainRegistry.instance, ModBlocks.guiID_factory_titanium, world, x - 1, y, z);
						} else {
							player.addChatMessage(new ChatComponentText("[Basic Factory] Error: Factory Structure not valid!"));
						}
					} else {
						player.addChatMessage(new ChatComponentText("[Basic Factory] Error: Factory Core not found!"));
					}
				}
			}
			
			if(this == ModBlocks.factory_advanced_furnace)
			{
				if(world.getBlockMetadata(x, y, z) == 2)
				{
					if(world.getTileEntity(x, y, z + 1) instanceof TileEntityCoreAdvanced)
					{
						if(((TileEntityCoreAdvanced)world.getTileEntity(x, y, z + 1)).isStructureValid(world))
						{
							FMLNetworkHandler.openGui(player, MainRegistry.instance, ModBlocks.guiID_factory_advanced, world, x, y, z + 1);
						} else {
							player.addChatMessage(new ChatComponentText("[Advanced Factory] Error: Factory Structure not valid!"));
						}
					} else {
						player.addChatMessage(new ChatComponentText("[Advanced Factory] Error: Factory Core not found!"));
					}
				}
				if(world.getBlockMetadata(x, y, z) == 3)
				{
					if(world.getTileEntity(x, y, z - 1) instanceof TileEntityCoreAdvanced)
					{
						if(((TileEntityCoreAdvanced)world.getTileEntity(x, y, z - 1)).isStructureValid(world))
						{
							FMLNetworkHandler.openGui(player, MainRegistry.instance, ModBlocks.guiID_factory_advanced, world, x, y, z - 1);
						} else {
							player.addChatMessage(new ChatComponentText("[Advanced Factory] Error: Factory Structure not valid!"));
						}
					} else {
						player.addChatMessage(new ChatComponentText("[Advanced Factory] Error: Factory Core not found!"));
					}
				}
				if(world.getBlockMetadata(x, y, z) == 4)
				{
					if(world.getTileEntity(x + 1, y, z) instanceof TileEntityCoreAdvanced)
					{
						if(((TileEntityCoreAdvanced)world.getTileEntity(x + 1, y, z)).isStructureValid(world))
						{
							FMLNetworkHandler.openGui(player, MainRegistry.instance, ModBlocks.guiID_factory_advanced, world, x + 1, y, z);
						} else {
							player.addChatMessage(new ChatComponentText("[Advanced Factory] Error: Factory Structure not valid!"));
						}
					} else {
						player.addChatMessage(new ChatComponentText("[Advanced Factory] Error: Factory Core not found!"));
					}
				}
				if(world.getBlockMetadata(x, y, z) == 5)
				{
					if(world.getTileEntity(x - 1, y, z) instanceof TileEntityCoreAdvanced)
					{
						if(((TileEntityCoreAdvanced)world.getTileEntity(x - 1, y, z)).isStructureValid(world))
						{
							FMLNetworkHandler.openGui(player, MainRegistry.instance, ModBlocks.guiID_factory_advanced, world, x - 1, y, z);
						} else {
							player.addChatMessage(new ChatComponentText("[Advanced Factory] Error: Factory Structure not valid!"));
						}
					} else {
						player.addChatMessage(new ChatComponentText("[Advanced Factory] Error: Factory Core not found!"));
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

}
