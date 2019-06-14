from twython import Twython

APP_KEY = "VdxItbS6YKi6KibcsS07o1Onh"
APP_SECRET = "ZmeXbVMiMaAwuxCmDMpXwZcLfKU6xz3BgZXZrBy9ZfETFxkDlz"

OAUTH_TOKEN = "2749858793-UiAdvAuAEOS8aQVCHrWmeHL3lsfEIuhWXnVwdzA"
OAUTH_TOKEN_SECRET = "WJvX90jzLaRO9FduM1ozkP6jU8O5cW7VxtHJUv8hghTcU"


function_arr = ['"tweet" - allows you to post a tweet','"search user" - get the most recent posts from a user','"search twitter" - find posts based on keyword(s)', '"exit" - this will take you out of the program' ]

t = Twython(APP_KEY,APP_SECRET,OAUTH_TOKEN,OAUTH_TOKEN_SECRET)

def main():
	print('Welcome to Twython! For a list of commands, type "help". To exit the program, type"exit"')
	user_input = input("Enter command here!-->")
	if (user_input == 'tweet'):
		create_tweet()
	elif(user_input == 'search user'):
		fetch_timeline()
	elif(user_input == 'help'):
		help()
	elif(user_input == 'exit'):
		exit()
	else:
		print('command was not valid. For a list of commands, please type "help"')
		main()

def create_tweet():
	tweet_content = input('what would you like to tweet?')
	if(tweet_content == ""):
		print('you have to type something in, silly')
		tweet_content = input('what would you like to tweet?')
	elif((tweet_content == 'cancel') or (tweet_content == 'back') or (tweet_content == 'exit')):
		print('returning to main menu')
		main()
	else:
		print("sending tweet...")
		t.update_status(status=tweet_content)
		print('tweet posted!')
		inside_tweet=False
		main()

def fetch_timeline():
	user = input('which user do you want to see?')
	if(user == ""):
		print('you have to type something in, silly')
		user = input('which user do you want to see?')
	elif((user == 'cancel') or (user == 'back') or (user == 'exit')):
		print('returning to main menu')
		main()
	else:
		user_timeline = t.get_user_timeline(screen_name=user, count=40, include_rts=False, exclude_replies=True)
		for i in range(20):
			timeline_results = user_timeline[i]
			print(timeline_results['text']
		main()


def help():
	print('These are the list of commands you can use in this interface:')
	print(function_arr)
	main()

def exit():
	print('Now leaving twython terminal interface. Goodbye world!')
if(__name__ == "__main__"):
	main()