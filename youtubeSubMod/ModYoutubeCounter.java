package clientname.mods.impl;

import java.io.IOException;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Channels.List;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;

import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import clientname.util.FetchUTIL;

public class ModYoutubeCounter extends ModDraggable {

	boolean alreadyExecuted;
	int SUBS;
	int time;

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		{
			if(!alreadyExecuted) {
			    FetchUTIL.start();
			    alreadyExecuted = true;
			}
		}
		font.drawString("Sub Counter: " + FetchUTIL.getSubCount(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
	}

}
