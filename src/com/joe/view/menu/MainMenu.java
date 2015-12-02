package com.joe.view.menu;

import com.joe.game.Game;
import com.joe.game.model.Direction;
import com.joe.game.model.World;
import com.joe.game.model.entity.Player;
import com.joe.game.model.event.InputEvent;
import com.joe.game.model.event.MovementEvent;

public class MainMenu extends GameMenu {

	public MainMenu() {
		super("What would you like to do?");
	}

	@Override public void populate() {
		addItem("1: Move North");
		addItem("2: Move South");
		addItem("3: Move East");
		addItem("4: Move West");
		addItem("5: Interact With Entities");
	}

	@Override public void handle(InputEvent event) {
		String input = event.getInput();

		if (input.matches("[0-9]")) {
			int index = Integer.parseInt(input);

			World world = Game.getWorld();
			Player player = world.getPlayer();

			if (index == 1) {
				Game.getEventController().sendEvent(new MovementEvent(player, Direction.NORTH));
			} else if (index == 2) {
				Game.getEventController().sendEvent(new MovementEvent(player, Direction.SOUTH));
			} else if (index == 3) {
				Game.getEventController().sendEvent(new MovementEvent(player, Direction.EAST));
			} else if (index == 4) {
				Game.getEventController().sendEvent(new MovementEvent(player, Direction.WEST));
			} else if (index == 5) {
				Game.getMenuController().setMenuID(1);
			}
		}
	}
}
