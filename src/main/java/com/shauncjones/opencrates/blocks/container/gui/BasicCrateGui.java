package com.shauncjones.opencrates.blocks.container.gui;

import com.shauncjones.opencrates.blocks.container.BasicCrateContainer;
import com.shauncjones.opencrates.blocks.tile.TileEntityBasicCrate;
import com.shauncjones.opencrates.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

public class BasicCrateGui extends GuiContainer {
	//Basic = 175, 221
	//Hardened = 337, 221
    public static final int WIDTH = 175;
    public static final int HEIGHT = 221;

    private static final ResourceLocation background = new ResourceLocation(Reference.MODID, "textures/gui/basic_crate.png");
    private final InventoryPlayer playerInv;
	private final TileEntityBasicCrate te;
    
    
    public BasicCrateGui(InventoryPlayer playerInv, TileEntityBasicCrate tileEntity, BasicCrateContainer container) {
        super(container);
        this.te = tileEntity;
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
		this.fontRenderer.drawString(I18n.format("inv.basic_crate.name", new Object[0]), 8, 6, 000000);
		this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 000000);
	}
    
}
