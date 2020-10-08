public class ExampleAutoGg {


  @EventTarget
	public void ChatEventMessage(ChatEventServer e)
	{
		if(e.message.equals("Put in the chat message!") && !Minecraft.getMinecraft().isSingleplayer()) {
		System.out.println(e.message);
		//Thanks mason for the fix!
		Minecraft.getMinecraft().thePlayer.sendChatMessage("/achat GG!");
		}
	}
}
