package io.github.si1kn.KangarooClient.mods.hud;

import io.github.si1kn.KangarooClient.gui.hud.Position;
import io.github.si1kn.KangarooClient.gui.hud.RenderModule;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.chunk.Chunk;

public class CoordsMod extends RenderModule {

    private final Minecraft mc = Minecraft.getMinecraft();
    private String biome;

    @Override
    public void render(Position pos) {
        Minecraft.getMinecraft().fontRendererObj.drawString("X: " + MathHelper.floor_double(Minecraft.getMinecraft().thePlayer.posX), (int) pos.getX(), (int) pos.getY(), -1);
        Minecraft.getMinecraft().fontRendererObj.drawString("Y: " + MathHelper.floor_double(Minecraft.getMinecraft().thePlayer.posY), (int) pos.getX(), (int) pos.getY() + 10, -1);
        Minecraft.getMinecraft().fontRendererObj.drawString("Z: " + MathHelper.floor_double(Minecraft.getMinecraft().thePlayer.posZ), (int) pos.getX(), (int) pos.getY() + 20, -1);
        Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(new BlockPos(Minecraft.getMinecraft().thePlayer));

        this.biome = chunk.getBiome(new BlockPos(Minecraft.getMinecraft().thePlayer), this.mc.theWorld.getWorldChunkManager()).biomeName;
        Minecraft.getMinecraft().fontRendererObj.drawString("Biome: " + biome, (int) pos.getX(), (int) pos.getY() + 30, -1);
    }

    @Override
    public double getWidth() {
        return 40 + Minecraft.getMinecraft().fontRendererObj.getStringWidth(biome);
    }

    @Override
    public double getHeight() {
        return 40;
    }
}
