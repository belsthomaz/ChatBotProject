package chatbot.view;

import chatbot.model.Chatbot;
import javax.swing.JOptionPane;

public class ChatbotView
	{
		private Chatbot myChatbot;
	
		public ChatbotView()
			{
				myChatbot = new Chatbot();
			}
		
		public void showApp()
			{
				String answer  = "keep going";
				while(answer == null || !answer.equals("no"))
					{
						JOptionPane.showMessageDialog(null, myChatbot.getRandomTopic());
						answer = getInput();
						useInput(answer);
					}
				(myChatbot).topicConversation();
			}
	
		private String getInput()
			{
				String userInput = "";
				
			userInput = JOptionPane.showInputDialog("Do you want to talk?");
				
				return userInput;
			}
		
		private void useInput(String currentInput)
			{
				
				if(myChatbot.memeChecker(currentInput))
					{
						JOptionPane.showMessageDialog(null,  "you like memes huh?");
					}
				if(myChatbot.movieChecker(currentInput))
					{
						JOptionPane.showMessageDialog(null, "I think that's a very lovely movie.");
					}
				if(myChatbot.animalChecker(currentInput))
					{
						JOptionPane.showMessageDialog(null,  "That's a lovely animal.");
					}
				else
					{
						
					}
			}
		
		
		
		
		
	}
