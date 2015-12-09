from com.joe.game.model import EventHandler
from com.joe.game.control.event import EventDispatcher
from com.joe.game.model import EventHandler
from com.joe.game import Game
from java.lang import Class

print('Loading scripts...')

class EHandler(EventHandler):
	def __init__(self, function):
		self.function = function

	def handle(self, event):
		self.function(event)
		
def on_event(type):
		message = type
		name = message + 'Event'
		package = 'com.joe.game.model.event'
		c = Class.forName(package + '.' + name)
		
		def handle(func):
			Game.getEventDispatcher().register(c, EHandler(func))
		return handle
		
def on_command(cmd):
	def handle(func):
		@on_event('Command')
		def do(event):
			if event.command[2:] == cmd:
				func(event)
			return func
		return do
	return handle
	
def send(event):
	Game.getEventDispatcher().dispatch(event)