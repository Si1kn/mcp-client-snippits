package clientname.mods.emote;

import clientname.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class Dab extends ModelPlayer {

	private ModelBase oldModel;
	private float thirdPersonPartialTicks;

	public Dab(ModelBase oldModel, float p_i46304_1_, boolean p_i46304_2_) {
		super(p_i46304_1_, p_i46304_2_);
		this.oldModel = oldModel;
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTickTime) {

		super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
		thirdPersonPartialTicks = partialTickTime;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

		float uuid = entityIn.getEntityId();
		boolean isOurPlayer = uuid == Minecraft.getMinecraft().thePlayer.getEntityId();

		if (Client.getInstance().dab == true || (isOurPlayer && InputEvent.prevDabbingHeld > 0)) {

			float heldPercent = (InputEvent.prevDabbingHeld
					+ (InputEvent.dabbingHeld - InputEvent.prevDabbingHeld) * thirdPersonPartialTicks)
					/ InputEvent.MAX_DABBING_HELD;

			if (!isOurPlayer)
				heldPercent = 1.0F;

			this.bipedRightArm.rotateAngleX = (float) Math.toRadians(-90F * heldPercent);
			this.bipedRightArm.rotateAngleY = (float) Math.toRadians(-35F * heldPercent);

			this.bipedRightArmwear.rotateAngleX = (float) Math.toRadians(-90F * heldPercent);
			this.bipedRightArmwear.rotateAngleY = (float) Math.toRadians(-35F * heldPercent);

			this.bipedLeftArm.rotateAngleX = (float) Math.toRadians(15F * heldPercent);
			this.bipedLeftArm.rotateAngleY = (float) Math.toRadians(15F * heldPercent);
			this.bipedLeftArm.rotateAngleZ = (float) Math.toRadians(-110F * heldPercent);

			this.bipedLeftArmwear.rotateAngleX = (float) Math.toRadians(15F * heldPercent);
			this.bipedLeftArmwear.rotateAngleY = (float) Math.toRadians(15F * heldPercent);
			this.bipedLeftArmwear.rotateAngleZ = (float) Math.toRadians(-110F * heldPercent);

			float rotationX = entityIn.rotationPitch;
			this.bipedHead.rotateAngleX = (float) Math.toRadians(-rotationX * heldPercent)
					+ (float) Math.toRadians(45F * heldPercent + rotationX);

			float rotationY = (((EntityPlayer) entityIn).renderYawOffset - entityIn.rotationYaw);
			this.bipedHead.rotateAngleY = (float) Math.toRadians(rotationY * heldPercent)
					+ (float) Math.toRadians(35F * heldPercent - rotationY);

			// AMOUR TEST 1:

			RenderPlayer render = (RenderPlayer) Minecraft.getMinecraft().getRenderManager()
					.<AbstractClientPlayer>getEntityRenderObject(entityIn);
			ModelPlayer modelPlayer = render.getMainModel();

			copyModelAngles(modelPlayer.bipedRightArm, this.bipedRightArm);
			copyModelAngles(modelPlayer.bipedLeftArm, this.bipedLeftArm);
			copyModelAngles(modelPlayer.bipedHead, this.bipedHead);
			copyModelAngles(modelPlayer.bipedHeadwear, this.bipedHeadwear);

			copyModelAngles(this.bipedHead, this.bipedHeadwear);

			if (isOurPlayer) {
				if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
					heldPercent = (InputEvent.prevDabbingHeld + (InputEvent.dabbingHeld - InputEvent.prevDabbingHeld)
							* InputEvent.firstPersonPartialTicks) / InputEvent.MAX_DABBING_HELD;

					GlStateManager.rotate(-50F * heldPercent, 1, 0, 0);
					GlStateManager.rotate(30F * heldPercent, 0, 1, 0);
					GlStateManager.rotate(-30F * heldPercent, 0, 0, 1);
					GlStateManager.translate(-0.3 * heldPercent, -0.2 * heldPercent, -0.5 * heldPercent);
				}
			}
		}
		//FLoss
	//	if (Client.getInstance().dab == true || (isOurPlayer && InputEvent.prevDabbingHeld > 0)) {
	}

}
