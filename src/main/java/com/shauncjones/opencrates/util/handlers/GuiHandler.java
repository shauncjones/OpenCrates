package com.shauncjones.opencrates.util.handlers;

import com.shauncjones.opencrates.blocks.container.BasicCrateContainer;
import com.shauncjones.opencrates.blocks.container.HardenedCrateContainer;
import com.shauncjones.opencrates.blocks.container.gui.BasicCrateGui;
import com.shauncjones.opencrates.blocks.container.gui.HardenedCrateGui;
import com.shauncjones.opencrates.blocks.tile.TileEntityBasicCrate;
import com.shauncjones.opencrates.blocks.tile.TileEntityHardenedCrate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityBasicCrate) {
            return new BasicCrateContainer(player.inventory, (TileEntityBasicCrate) te);
        }else if(te instanceof TileEntityHardenedCrate) {
        	return new HardenedCrateContainer(player.inventory, (TileEntityHardenedCrate) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityBasicCrate) {
        	TileEntityBasicCrate containerTileEntity = (TileEntityBasicCrate) te;
            return new BasicCrateGui(player.inventory, containerTileEntity, new BasicCrateContainer(player.inventory, containerTileEntity));
        }else if(te instanceof TileEntityHardenedCrate) {
        	TileEntityHardenedCrate containerTileEntity = (TileEntityHardenedCrate) te;
            return new HardenedCrateGui(player.inventory, containerTileEntity, new HardenedCrateContainer(player.inventory, containerTileEntity));
        }
        return null;
    }
}
