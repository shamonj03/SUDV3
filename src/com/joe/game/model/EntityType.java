package com.joe.game.model;

import com.google.gson.annotations.SerializedName;

/**
 * Contains valid types of entities that make up the world.
 */
public enum EntityType {

	PLAYER, @SerializedName("NPC") NPC, OBJECT, @SerializedName("GROUND_ITEM") GROUND_ITEM;

}
