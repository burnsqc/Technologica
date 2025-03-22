package com.technologica.client.gui.screens.inventory;

import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.inventory.CarpentryWorkbenchMenu;

import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CarpentryWorkbenchScreen extends AbstractInventoryContainerScreen<CarpentryWorkbenchMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new TechnologicaLocation("textures/gui/container/carpentry_workbench.png");
	private static final ResourceLocation STOCK_BUTTON_TEXTURE = new TechnologicaLocation("textures/gui/stock_button.png");
	private final RecipeBookComponent recipeBookComponent = new RecipeBookComponent();
	private boolean widthTooNarrow;


	public CarpentryWorkbenchScreen(CarpentryWorkbenchMenu screenContainerIn, Inventory playerInventoryIn, Component titleIn) {
		super(screenContainerIn, playerInventoryIn, titleIn, 166, BACKGROUND_TEXTURE);
	}

	@Override
	public void init() {
		super.init();
		this.widthTooNarrow = this.width < 379;
		// this.recipeBookComponent.init(this.width, this.height, this.minecraft, this.widthTooNarrow, this.menu);
		this.addRenderableWidget(new ImageButton(this.leftPos + 5, this.height / 2 - 49, 20, 18, 0, 0, 19, STOCK_BUTTON_TEXTURE, (p_289630_) -> {
			// this.recipeBookComponent.toggleVisibility();
			this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
			p_289630_.setPosition(this.leftPos + 5, this.height / 2 - 49);
		}));
	}
}
