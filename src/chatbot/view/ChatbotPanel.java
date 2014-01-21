package chatbot.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import chatbot.controller.ChatbotController;
import chatbot.model.Chatbot;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EtchedBorder;

public class ChatbotPanel extends JPanel
	{
		
		private ChatbotController baseController;
		private JButton submitButton;
		private JTextField userInputField;
		private JTextArea chatArea;
		private SpringLayout baseLayout;
		private Chatbot appBot;
		private JScrollPane textPane;
		private int clickCount;
		
		
		public ChatbotPanel(ChatbotController baseController)
			{
			
				this.appBot = baseController.getMyChatbot();
				this.baseController = baseController;
				
				submitButton =  new JButton("Submit this to the chatbot! ");
				userInputField = new JTextField(30);
				
				chatArea = new JTextArea(10, 30);
				textPane = new JScrollPane(chatArea);
				baseLayout = new SpringLayout();
				clickCount = 0;
				
				setupPanel();
				setupLayout();
				setupListeners();
				
				startChat();
			}
		
		private void startChat()
			{
				chatArea.setText(appBot.getRandomTopic());
			}
		
		private void setupPanel()
			{
				
				this.setLayout(baseLayout);
				this.add(submitButton);
				this.add(userInputField);
				this.add(textPane);
				
				chatArea.setLineWrap(true);
				chatArea.setWrapStyleWord(true);
				
			}
		/**
		 * setup layout method
		 * contains code from 
		 */
		private void setupLayout()
			{
				setBackground(new Color(0, 51, 102));
				baseLayout.putConstraint(SpringLayout.NORTH, textPane, 8, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, textPane, 10, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, textPane, -67, SpringLayout.SOUTH, this);
				baseLayout.putConstraint(SpringLayout.EAST, textPane, 440, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.NORTH, userInputField, 6, SpringLayout.SOUTH, submitButton);
				baseLayout.putConstraint(SpringLayout.WEST, userInputField, 51, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.EAST, userInputField, 92, SpringLayout.EAST, submitButton);
				baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -36, SpringLayout.SOUTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, submitButton, 143, SpringLayout.WEST, this);

			}
		
		
		private void setupListeners()
			{
				submitButton.addActionListener(new ActionListener()
					{
						/**
						 * This is what happens when I click the button.
						 */
						public void actionPerformed(ActionEvent click)
							{
								clickCount++;
								String currentInput = userInputField.getText();
								
								if(clickCount % 7 ==0)
									{
										String currentConversation = baseController.processConversation();
										if(currentConversation.length() != 0)
											{
												chatArea.append(currentConversation);
												clickCount--;
											}
									}
								else if(clickCount % 11 ==0)
									{
										chatArea.append(baseController.processMeme(currentInput));
									}
								else if(clickCount % 15 ==0)
									{
										chatArea.append(baseController.processMovies(currentInput));
									}
								else if(clickCount % 19 ==0)
									{
										chatArea.append(baseController.processAnimals(currentInput));
									}
								else if( clickCount % 23 == 0)
									{
										chatArea.append(baseController.processVideoGames(currentInput));
									}
								else
									{
									
										chatArea.append("\n" + currentInput);					
										chatArea.append("\n" + appBot.getRandomTopic());
									}
							}
					});
			}
		
	}
