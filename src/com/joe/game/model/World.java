package com.joe.game.model;

import com.joe.game.model.entity.Player;

public class World {

	private Player player;
	
	public void initialize() {
		player = new Player();
	}
	
	
	public Player getPlayer() {
		return player;
	}
}
