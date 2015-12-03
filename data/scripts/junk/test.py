from com.joe.game import Game
from com.joe.game.model.event import MessageEvent
from com.joe.game.model.event import CameraPositionEvent
from com.joe.game.model.component import Position

@on_event('InteractWithNpc')
def do(event):
	npc = event.getEntity()
	
	if npc.globalID == 1:
		send(MessageEvent("Hello adventurer aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!"))
		send(CameraPositionEvent(Position(8, 9)))
		send(MessageEvent("See right there?"))
		
		player = Game.getWorld().getPlayer()
		position = player.getComponent(Position)
		send(CameraPositionEvent(position))