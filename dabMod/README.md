# MCP-dab-mod

```		
if (Minecraft.getMinecraft().gameSettings.dab.isKeyDown()) {

			dab = true;

			if (!alreadyExecuted && Minecraft.getMinecraft().isSingleplayer() == false) { // && onServer
				Minecraft.getMinecraft().getNetHandler().addToSendQueue(new DabPacket());
				alreadyExecuted = true;
			}

		}

		if (!Minecraft.getMinecraft().gameSettings.dab.isKeyDown()) {

			dab = false;
			alreadyExecuted = false;
		}
    ```
    Add this to your client and create the boolean called "dab"
    
    In the class RenderPlayer
    
    change the constructor from: super(renderManager, new ModelPlayer(0.0F, useSmallArms), 0.5F);
    
    to: super(renderManager, new Dab(staticModel, 0.0F, useSmallArms), 0.5F);
    
    
    In the class RendererLivingEntity
    
    add this: protected static ModelBase staticModel;
    
    Its becuase it needs to be static and the other model cant be static otherwise it breaks everyting
