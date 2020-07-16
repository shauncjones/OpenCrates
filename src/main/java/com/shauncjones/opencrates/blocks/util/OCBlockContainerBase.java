package com.shauncjones.opencrates.blocks.util;

import com.shauncjones.opencrates.OpenCrates;
import com.shauncjones.opencrates.blocks.tile.TileEntityBasicCrate;
import com.shauncjones.opencrates.blocks.tile.TileEntityHardenedCrate;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class OCBlockContainerBase extends BlockContainer{

	protected String name;
	protected TileEntity te;
	
	public OCBlockContainerBase(Material materialIn, String name, float hardness, String tool, int level) {
		super(materialIn);
		this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(OpenCrates.OCTab);
        setHardness(hardness);
        setHarvestLevel(tool, level);
    }
	
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
    	switch(name) {
    	case "basic_crate":
    		return new TileEntityBasicCrate();
    	case "hardened_crate":
    		return new TileEntityHardenedCrate();
    	}
        return null;
        
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state){
        return false;
    }

    @Override
	public boolean isFullBlock(IBlockState state){
		return true;
	}
    
    @Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}
    
    @Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) { 
	     // Only execute on the server
    	switch(name) {
    	case "basic_crate":
    		if (worldIn.isRemote) {
                return true;
            }
            te = worldIn.getTileEntity(pos);
            if (!(te instanceof TileEntityBasicCrate)) {
                return false;
            }
            playerIn.openGui(OpenCrates.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
            return true;
    	case "hardened_crate":
    		if (worldIn.isRemote) {
                return true;
            }
            te = worldIn.getTileEntity(pos);
            if (!(te instanceof TileEntityHardenedCrate)) {
                return false;
            }
            playerIn.openGui(OpenCrates.instance, 2, worldIn, pos.getX(), pos.getY(), pos.getZ());
            return true;
    	}
        return false;
    }
    
    @Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
    	switch(name) {
    	case "basic_crate":
    		TileEntityBasicCrate basicTE = (TileEntityBasicCrate) worldIn.getTileEntity(pos);
            IItemHandler cap = basicTE.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

            for (int i = 0; i < cap.getSlots(); ++i){
                ItemStack itemstack = cap.getStackInSlot(i);

                if (!itemstack.isEmpty()){
                    InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
                }
            }
            break;
    	case "hardened_crate":
    		TileEntityHardenedCrate hardenedTE = (TileEntityHardenedCrate) worldIn.getTileEntity(pos);
            IItemHandler hardenedCap = hardenedTE.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

            for (int i = 0; i < hardenedCap.getSlots(); ++i){
                ItemStack itemstack = hardenedCap.getStackInSlot(i);

                if (!itemstack.isEmpty()){
                    InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
                }
            }
            break;
    	}
    	 

         super.breakBlock(worldIn, pos, state);
	}
    
    public void registerItemModel(Item itemBlock){
    	OpenCrates.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock(){
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public OCBlockContainerBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
	
	
}
