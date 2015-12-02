from com.joe.game.model.event import MessageEvent

@on_command('test')
def do(event):
	send(MessageEvent('omg hello!'))
	send(MessageEvent(event.command))

