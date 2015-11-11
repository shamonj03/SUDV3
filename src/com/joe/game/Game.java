package com.joe.game;

import com.joe.game.control.EntityFactory;
import com.joe.game.io.OnDemandFetcher;
import com.joe.game.model.component.Position;
import com.joe.game.model.entity.Npc;
import com.joe.util.Constants;
import com.joe.util.MessageUtil;
import com.joe.view.Messages;

public class Game implements Runnable {

	/**
	 * Fetches npc data when needed.
	 */
	private static final OnDemandFetcher npcFethcer = new OnDemandFetcher("./data/npcs/");

	/**
	 * Fetches object data when needed.
	 */
	private static final OnDemandFetcher objectFetcher = new OnDemandFetcher("./data/objects/");

	/**
	 * The thread the game is running on.
	 */
	private Thread gameThread;

	/**
	 * Boolean used to terminate game thread.
	 */
	private boolean running;

	/**
	 * Boolean to pause the game thread.
	 */
	private boolean paused = false;

	/**
	 * Initialize any pregame data.
	 */
	public void initialize() {
		Npc npc = EntityFactory.createNpc(0, new Position(1, 1));
		Npc npc2 = EntityFactory.createNpc(1, new Position(3, 3));
		System.out.println(npc);
		System.out.println(npc2);
	}

	/**
	 * Start the main game loop.
	 */
	public void start() {
		initialize();

		gameThread = new Thread(this, "GameThread");
		gameThread.start();
	}

	/**
	 * Update the game every game tick.
	 */
	public void update() {
		MessageUtil.stream(Messages.greetingMessage());
	}


	@Override public void run() {
		setRunning(true);

		gameLoop();
	}

	/**
	 * I use Eli's game loop for just about everything.
	 * 
	 * @author Eli Delventhal {@link http
	 *         ://www.java-gaming.org/index.php?topic=24220.0}
	 * 
	 */
	private synchronized void gameLoop() {
		// This value would probably be stored elsewhere.
		final double GAME_HERTZ = 60.0;
		// Calculate how many ns each frame should take for our target game
		// hertz.
		final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
		// At the very most we will update the game this many times before a new
		// render.
		// If you're worried about visual hitches more than perfect timing, set
		// this to 1.
		final int MAX_UPDATES_BEFORE_RENDER = 5;
		// We will need the last update time.
		double lastUpdateTime = System.nanoTime();
		// Store the last time we rendered.
		double lastRenderTime = System.nanoTime();

		// If we are able to get as high as this FPS, don't render again.
		final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / Constants.TARGET_FPS;

		// Simple way of finding FPS.
		int lastSecondTime = (int) (lastUpdateTime / 1000000000);

		while (isRunning()) {
			double now = System.nanoTime();
			int updateCount = 0;

			if (!isPaused()) {
				// Do as many game updates as we need to, potentially playing
				// catchup.
				while (now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER) {
					update();

					lastUpdateTime += TIME_BETWEEN_UPDATES;
					updateCount++;
				}

				// If for some reason an update takes forever, we don't want to
				// do an insane number of catchups.
				// If you were doing some sort of game that needed to keep EXACT
				// time, you would get rid of this.
				if (now - lastUpdateTime > TIME_BETWEEN_UPDATES) {
					lastUpdateTime = now - TIME_BETWEEN_UPDATES;
				}

				// Render. To do so, we need to calculate interpolation for a smooth render.
				// This is only needed for graphical games.
				/*interpolation = Math
						.min(1.0f,
								(float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES));

				processGraphics();*/

				lastRenderTime = now;

				// Update the frames we got.
				int thisSecond = (int) (lastUpdateTime / 1000000000);
				if (thisSecond > lastSecondTime) {
					lastSecondTime = thisSecond;
				}

				// Yield until it has been at least the target time between
				// renders. This saves the CPU from hogging.
				while (now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS
						&& now - lastUpdateTime < TIME_BETWEEN_UPDATES) {
					Thread.yield();

					// This stops the app from consuming all your CPU. It makes
					// this slightly less accurate, but is worth it.
					// You can remove this line and it will still work (better),
					// your CPU just climbs on certain OSes.
					// FYI on some OS's this can cause pretty bad stuttering.
					// Scroll down and have a look at different peoples'
					// solutions to this.
					try {
						Thread.sleep(1);
					} catch (Exception e) {
					}

					now = System.nanoTime();
				}
			}
		}
	}

	/**
	 * Pause the game thread.
	 * 
	 * @param paused
	 *            True to pause the game.
	 */
	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	/**
	 * Change the state of the game thread.
	 * 
	 * @param running
	 *            False to terminate game.
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * @return the onDemand fetcher for npc data.
	 */
	public static OnDemandFetcher getNpcFetcher() {
		return npcFethcer;
	}

	/**
	 * @return the onDemand fetcher for object data.
	 */
	public static OnDemandFetcher getObjectFetcher() {
		return objectFetcher;
	}

	/**
	 * @return whether or not the game thread is paused.
	 */
	public boolean isPaused() {
		return paused;
	}

	/**
	 * @return whether or not the game thread is running.
	 */
	public boolean isRunning() {
		return running;
	}

}
