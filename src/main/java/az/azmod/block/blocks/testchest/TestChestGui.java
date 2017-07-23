package az.azmod.block.blocks.testchest;

import az.azmod.AzMod;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public class TestChestGui extends GuiContainer {
    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    public static final ResourceLocation bg = new ResourceLocation(AzMod.MODID, "textures/gui/testchest.png");

    public TestChestGui(TestChestEntity tileEntity, TestChestContainer container){
        super(container);
        xSize =WIDTH;
        ySize =HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
        mc.getTextureManager().bindTexture(bg);
        drawTexturedModalRect(guiLeft, guiTop, 0,0,xSize,ySize);
    }
}
