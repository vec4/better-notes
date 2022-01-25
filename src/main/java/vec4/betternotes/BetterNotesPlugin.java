package vec4.betternotes;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;

@Slf4j
@PluginDescriptor(
	name = "Better Notes"
)
public class BetterNotesPlugin extends Plugin
{

	private static final BufferedImage TOOLBAR_ICON = ImageUtil.loadImageResource(BetterNotesPlugin.class, "toolbar-icon.png");

	private BetterNotesPanel panel;
	private NavigationButton navButton;

	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private BetterNotesConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Better Notes plugin started!");

		panel = new BetterNotesPanel();
		navButton = NavigationButton.builder()
				.icon(TOOLBAR_ICON) // TODO: make a navbar icon (temp image for now)
				.tooltip("Better Notes")
				.priority(9)
				.panel(panel)
				.build();
		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Better Notes plugin stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		/*
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
		}
		 */
	}

	@Provides
	BetterNotesConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BetterNotesConfig.class);
	}
}
