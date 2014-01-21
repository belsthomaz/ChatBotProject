package chatbot.controller;

import java.util.ArrayList;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;


/**
 * 
 * @author Isabella Thomaz
 * @version 1.3 10/31/13 Removed old popup GUI,  reference to Chatbot.
 */
public class ChatbotController
	{
		/**
		 * Instance of the view object for the project.
		 */
		private Chatbot myChatbot;
		private ChatbotFrame appFrame;
		
		public ChatbotController()
			{
				myChatbot = new Chatbot();
			}
		
		public Chatbot getMyChatbot()
			{
				return myChatbot;
			}

		public void start()
			{
				appFrame = new ChatbotFrame(this);
			}
		
		private String conversationHelper(ArrayList<String> conversationList)
			{
				String currentConversationPiece = "";
				
				if(conversationList.size() >0)
					{
						currentConversationPiece =  conversationList.remove(0);
					}
				
				return currentConversationPiece;
			}
		public String processConversation()
			{
				String currentConversation = "";
				
				currentConversation = conversationHelper(myChatbot.topicConversation());
				
				return currentConversation;
			}
		
		public String processMeme(String currentInput)
			{
				String memeResponse= "you can't handle the memes!";
				
				if(myChatbot.memeChecker(currentInput))
					{
						return memeResponse = currentInput + " is a cool meme";
					}
				
				return memeResponse;
			}
		
		public String processMovies(String currentInput)
			{
				String movieResponse = "You can't handle the movies!";
				
				if(myChatbot.movieChecker(currentInput))
					{
						return movieResponse = currentInput + " is a cool movie";
					}
				return movieResponse;
			}
		public String processAnimals(String currentInput)
			{
				String animalResponse = "You can't handle the animals!";
				
				if(myChatbot.animalChecker(currentInput))
					{
						return animalResponse = currentInput + " is a cool animal";
					}
				return animalResponse;
			}
		public String processVideoGames(String currentInput)
			{
				String videoGameResponse = "You can't handle the video games!";
				
				if(myChatbot.videoGameChecker(currentInput))
					{
						return videoGameResponse = currentInput + " is a cool game";
					}
				return videoGameResponse;
			}

	}
