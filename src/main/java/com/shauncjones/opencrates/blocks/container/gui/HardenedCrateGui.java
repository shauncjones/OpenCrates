package com.shauncjones.opencrates.blocks.container.gui;

import com.shauncjones.opencrates.blocks.OCBlocks;
import com.shauncjones.opencrates.blocks.container.BasicCrateContainer;
import com.shauncjones.opencrates.blocks.container.HardenedCrateContainer;
import com.shauncjones.opencrates.blocks.tile.TileEntityBasicCrate;
import com.shauncjones.opencrates.blocks.tile.TileEntityHardenedCrate;
import com.shauncjones.opencrates.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class HardenedCrateGui extends GuiContainer {
	//Basic = 175, 221
	//Hardened = 337, 221
    public static final int WIDTH = 238;
    public static final int HEIGHT = 256;

    private static final ResourceLocation background = new ResourceLocation(Reference.MODID, "textures/gui/hardened_crate.png");
    private final InventoryPlayer playerInv;
	private final TileEntityHardenedCrate te;
    
    
    public HardenedCrateGui(InventoryPlayer playerInv, TileEntityHardenedCrate containerTileEntity, HardenedCrateContainer hardenedCrateContainer) {
        super(hardenedCrateContainer);
        this.te = containerTileEntity;
        this.playerInv = playerInv;
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
    
    @Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(OCBlocks.hardenedCrate.getUnlocalizedName(), 8, 6, 000000);
		this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 000000);
	}
    
}
