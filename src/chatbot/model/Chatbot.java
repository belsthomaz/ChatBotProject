package chatbot.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;


/**
 * Explanation of the class: Chatbot model to test String manipulation and use.
 * @author Isabella Thomaz
 *@version 1.5 10/30/13
 *
 */
public class Chatbot
	{

		/**
		 * an ArrayList of Strings that holds the memes, movies, and animals for the program.
		 */
		private ArrayList<String> myMemes;
		private ArrayList<String> myMovies;
		private ArrayList<String> myAnimals;
		private ArrayList<String> conversationList;
		/**
		 * An ArrayList of Strings to hold random topics.
		 */
		private ArrayList<String> randomList;
		private ArrayList<String> videoGameList;
		
		public Chatbot()
			{
				/*
				 * calls the methods, ArrayLists, constructors.
				 */
				myMemes = new ArrayList<String>();
				myMovies = new ArrayList<String>();
				myAnimals = new ArrayList<String>();
				randomList = new ArrayList<String>();
				conversationList = new ArrayList<String>();
				videoGameList = new ArrayList<String>();
				
				fillTheMemeList();
				fillTheMovieList();
				fillTheAnimalsList();
				fillTheRandomList();
				fillTheConversationList();
				fillTheVideoGameList();
			}
		
		
		/**
		 * 	alphabatizes your name from first, middle and last depending on what letter it begins with.
		 * goes through several if/else statement tests.
		 * uses a String.
		 */
		public String alphabatizeYourName(String first, String middle, String last)
			{
				String nameInOrder = "";
				if(first.compareTo(middle) < 0)
					{
						if(first.compareTo(last )<0)
							{
								if(middle.compareTo(last) <0)
									{
										nameInOrder = first +", " + middle + ", " + last;
									}
								else
									{
										nameInOrder = first + ", " + last + ", " + middle;
									}
							 }
						else
							{
								nameInOrder = last + ", " + first + ", " + middle;
							}
					 }
				else
					{
						if(middle.compareTo(last) <0)
							{
								if(first.compareTo(last) <0)
									{
										nameInOrder = middle + ", " + first + ", " + last;
									}
								else
									{
										nameInOrder = middle + ", " + last + ", " + first;
									}
							}
						else 
							{
								nameInOrder = last + ", " + middle + ", " + first;
							}
					}
				
				return nameInOrder;
		 	 }
		/**
		 * checks to see if something contains what it is looking for.
		 * uses a String.
		 */
		public String contentBased(String currentInput)
			{
				String processed = "";
				
				if(currentInput.contains("boo"))
					{
						processed = "oooooh scawy";
					}
				else
					{
						processed = "*yaaaaawn* boooooriiiiiing";
					}
				
				return processed;
				
			}
		
		public ArrayList<String> getMyMemes()
			{
				return myMemes;
			}
		

			public ArrayList<String> getMyMovies()
			{
				return myMovies;
			}


		public ArrayList<String> getMyAnimals()
			{
				return myAnimals;
			}


		public ArrayList<String> getConversationList()
			{
				return conversationList;
			}


		public ArrayList<String> getRandomList()
			{
				return randomList;
			}


		public ArrayList<String> getVideoGameList()
			{
				return videoGameList;
			}


			/**
			 * Fills the RandomList with various Strings for the Chatbot.
			 */
		private void fillTheRandomList()
			{
				randomList.add("i like cheese ");
				randomList.add("I hate essays ");
				randomList.add("I like cereal ");
				randomList.add("this is random ");
				randomList.add("I like typing ");
			
			}
		
		/**
		 * This method chooses a random item from the RandomList.
		 * @return A random element from the randomlist.
		 */
		public String getRandomTopic()
			{
				String randomTopic = "";
				
				double myRandom = Math.random();
				int myRandomListPosition = (int) (myRandom * randomList.size());
				randomTopic = randomList.get(myRandomListPosition);
				
				return randomTopic;
			}
		/**
		 * fills the meme list
		 */
		private void fillTheMemeList()
			{
				myMemes.add("nicholas cage");
				myMemes.add("arrow to the knee");
				myMemes.add("one does not simply");
				myMemes.add("y u no");
			}
		/**
		 * checks for memes in currentInput
		 * @param currentInput
		 * @return
		 */
		public boolean memeChecker(String currentInput)
			{
				boolean hasMeme = false;
				//loop over all the items in the list, if the input matches a meme, change hasMeme to true.
				
				if(currentInput != null)
					{	
						for (String currentPhrase : myMemes)
							{
								if(currentPhrase.equalsIgnoreCase(currentInput))
									{
										hasMeme = true;
									}
						
							}
					}
				return hasMeme;
			}
		/**
		 * fills the movie list
		 */
		private void fillTheMovieList()
		{
			myMovies.add("bolt");
			myMovies.add("the incredibles");
			myMovies.add("up");
			myMovies.add("despicable me 2");
			myMovies.add("iron man 3");
		}
		/**
		 * checks for mocie references/movies from currentInput
		 * @param currentInput
		 * @return
		 */
		public boolean movieChecker(String currentInput)
			{
				boolean hasMovie = false;
				
				if(currentInput != null)
					{
						for(String currentPhrase : myMovies)
							{
								if(currentPhrase.equalsIgnoreCase(currentInput))
									{
										hasMovie = true;
									}
							}
					}
				
				return hasMovie;
			}
		
		private void fillTheConversationList()
			{
				conversationList.add("dishonor on you, dishonor on your cow ");
				conversationList.add("hoppity hoppity ;asdflkasjd;lhnkajsdhf ");
				conversationList.add("in mother russia you no code program, program code you ");
			}
		/**

		 * Uses the conversationList object to talk about a specified topic.
		 * @return a refernce to the conversationList Object
		 */
		public ArrayList<String> topicConversation()
			{
				
				return conversationList;
			}
		/**
		 * fills the animal list
		 */
		private void fillTheAnimalsList()
			{
				myAnimals.add("Dog");
				myAnimals.add("Cat");
				myAnimals.add("Meerkat");
				myAnimals.add("Fox");
				myAnimals.add("Tiger");
			}
		
		
		/**
		 * checks currentInput for animals.
		 * @param currentInput
		 * @return
		 */
		public boolean animalChecker(String currentInput)
			{
				boolean hasAnimal = false;
				
						if(currentInput != null)
							{
								for(String currentPhrase : myAnimals)
									{
										if(currentPhrase.equalsIgnoreCase(currentInput))
											{
												hasAnimal = true;
											}
									}
							}
					return hasAnimal;
			}
		private void fillTheVideoGameList()
			{
				videoGameList.add("lego ");
				videoGameList.add("assassin's creed ");
				videoGameList.add("skyrim ");
				videoGameList.add("bioshock ");
				videoGameList.add("dishonored ");
			}
		
		public boolean videoGameChecker(String currentInput)
			{
				boolean hasVideoGame = false;
				
				if(currentInput != null)
					{
						for(String currentPhrase : videoGameList)
							{
								if(currentPhrase.equalsIgnoreCase(currentInput))
									{
										hasVideoGame = true;
									}
							}
					}
				return hasVideoGame;
			}
		
		
	}
