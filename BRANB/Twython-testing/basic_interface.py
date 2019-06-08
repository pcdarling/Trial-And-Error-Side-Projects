from twython import Twython

APP_KEY = "P3TyZI4ELKYnKQf56O4hdFcez"  # brandon's key"VdxItbS6YKi6KibcsS07o1Onh"
APP_SECRET = "JfRmg4VGCiK8sv7iTK0uF13bFExiKluWRJexKdi2J2MVZRG2kU"  # brandon's secret"ZmeXbVMiMaAwuxCmDMpXwZcLfKU6xz3BgZXZrBy9ZfETFxkDlz"

OAUTH_TOKEN = "999809546636922880-0YTHtdtIwx4EDszsu4SsZpghyP3BIID"  # brandon's token"2749858793-UiAdvAuAEOS8aQVCHrWmeHL3lsfEIuhWXnVwdzA"
OAUTH_TOKEN_SECRET = "ARHB1ofOUdgltXxRbyuzUwvMSXh8N0Je5YW8TIWMU4YPY"  # brandon's token secret"WJvX90jzLaRO9FduM1ozkP6jU8O5cW7VxtHJUv8hghTcU"

user_input = ""

t = Twython(APP_KEY,APP_SECRET,OAUTH_TOKEN,OAUTH_TOKEN_SECRET)

def main():

	print('Welcome to Twython! For a list of commands, type "help()". To exit the program, type"exit()"')
	user_input = input("Enter command here!")
	if (user_input == 'tweet'):
		create_tweet()

def create_tweet():
	user_input = ""
	inside_tweet = True
	print('what would you like to tweet?')
	while(inside_tweet):
		#waiting for further user input to determine what happens next
		if(user_input != ""):
			print("sending tweet...")
			t.update_status(status=user_input)
			print('tweet posted!')
			user_input= ""
			inside_tweet=False