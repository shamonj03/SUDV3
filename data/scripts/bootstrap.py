from com.joe.game.model import EventHandler
from com.joe.game.control import EventController
from com.joe.game.model import EventHandler
from java.lang import Class

class EHandler(EventHandler):
	def __init__(self, function):
		self.function = function

	def handle(self, event):
		self.function(event)
		
def on_event(type):
		message = type
		name = message.title() + 'Event'
		package = 'com.joe.game.model.event'
		c = Class.forName(package + '.' + name)
		
		def handle(func):
			EventController.register(c, EHandler(func))
		return handle
		
def on_command(cmd):
	def handle(func):
		@on_event('command')
		def do(event):
			if event.command[2:] == cmd:
				func(event)
			return func
		return do
	return handle