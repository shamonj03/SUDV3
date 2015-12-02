from com.joe.game import Game

@on_event('InteractWithNpc')
def do(event):
	npc = event.getEntity()
	
	if npc.globalID == 1:
		Game.getGameMessageEncoder().streamLine("Hello adventurer!")