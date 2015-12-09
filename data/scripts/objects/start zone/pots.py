from com.joe.game import Game
from com.joe.game.model.event import MessageEvent
from com.joe.game.model.event import ReplaceObjectEvent
from com.joe.game.model.component import Position
from com.joe.game.model import Zone
from com.joe.game.control import EntityFactory

@on_event('InteractWithObject')
def do(event):
	object = event.getTarget()
	option = event.getOption()
	zoneID = event.getZone()

	TILE_ID = 0
	
	if object.globalID == 2:
		if option == 0:
			send(ReplaceObjectEvent(zoneID, object, TILE_ID))
		