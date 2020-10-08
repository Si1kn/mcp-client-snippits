package clientname.event.impl;

import clientname.event.Event;

public class  ChatEventServer extends Event
{
	public String message;

	public ChatEventServer(String msg)
	{
		this.message = msg;
	}
}
