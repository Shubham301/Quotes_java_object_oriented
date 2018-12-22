import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

public class QuoteApp {
	static QuoteFile myQuoteFile;
	static Quote quote;

	public static void main(String[] args) throws IOException {
		// Create all objects and call all methods that you
		// need here. You have freedom as to how you want to
		// interact with the user.

		myQuoteFile = new QuoteFile("quotes.txt");

		Random random = new Random();

		int option = -1;

		while (option != 6) {

			option = Integer
					.parseInt(JOptionPane
							.showInputDialog("Hello! Welcome to Quote World!\nHere you Store and do various activities with your Quotes!\n\n"
									+ "1: Count Quotes\n"
									+ "2: Add Entry\n"
									+ "3: Retrive Quote\n"
									+ "4: See a Random Quote\n"
									+ "5: By who Game\n"
									+ "6: Exit\n\n"
									+ "Enter the choice: "));

			switch (option) {
			case 1:

				int quoteCount = myQuoteFile.countQuotes();
				JOptionPane.showMessageDialog(null,
						"\nTotal number of quotes in file are: " + quoteCount);

				break;

			case 2:

				String quoteString = JOptionPane.showInputDialog("Enter the Quote:");

				String author = JOptionPane.showInputDialog(quoteString
						+ "\n\nEnter the Author for this Quote:");

				myQuoteFile.addEntry(quoteString, author);

				JOptionPane.showMessageDialog(null, quoteString + "\n-- " + author
						+ "\n\nQuote Added Successfully!");

				break;
			case 3:

				String input = JOptionPane
						.showInputDialog("Enter the Quote number you want to read:");
				int number = Integer.parseInt(input);

				quote = new Quote(myQuoteFile.retrieveQuote(number));

				JOptionPane.showMessageDialog(
						null,
						"\nQuote:\n" + quote.getQuote() + "\nAuthor:\n"
								+ quote.getCredit()
								+ "\nNumber of words in this Quote are: "
								+ quote.getWordCount());

				break;
			case 4:

				int randomNumber = random.nextInt(myQuoteFile.countQuotes()) + 1;

				String myQuote = myQuoteFile.retrieveQuote(randomNumber);
				quote = new Quote(myQuote);

				System.out.println();

				JOptionPane.showMessageDialog(null,
						String.format("\nRandom Quote[%d]: \n", randomNumber)
								+ "\nQuote:\n" + quote.getQuote()
								+ "\nAuthor:\n" + quote.getCredit()
								+ "\nNumber of words in this Quote are: "
								+ quote.getWordCount());

				break;
			case 5:

				int randomNumber1 = random.nextInt(myQuoteFile.countQuotes()) + 1;
				int randomNumber2 = random.nextInt(myQuoteFile.countQuotes()) + 1;
				int randomNumber3 = random.nextInt(myQuoteFile.countQuotes()) + 1;

				while (randomNumber1 == randomNumber2
						|| randomNumber2 == randomNumber3
						|| randomNumber1 == randomNumber3) {

					randomNumber1 = random.nextInt(myQuoteFile.countQuotes()) + 1;
					randomNumber2 = random.nextInt(myQuoteFile.countQuotes()) + 1;
					randomNumber3 = random.nextInt(myQuoteFile.countQuotes()) + 1;

				}

				String myQuote1 = myQuoteFile.retrieveQuote(randomNumber1);
				String myQuote2 = myQuoteFile.retrieveQuote(randomNumber2);
				String myQuote3 = myQuoteFile.retrieveQuote(randomNumber3);

				quote = new Quote(myQuote1);
				Quote quote2 = new Quote(myQuote2);
				Quote quote3 = new Quote(myQuote3);

				quote.byWhoGame(quote2, quote3);

				break;

			case 6:
				break;

			default:

				JOptionPane.showMessageDialog(null,
						"Wrong Choice, Read and enter choice carefully!");

				break;

			}

		}

		// System.out.println("\nCredits:\nMade with Love ");
		JOptionPane.showMessageDialog(null, "Thank you!\n\n"
				+ "This software was created by\n"
				+ "Ghapa Ghap Production\n\n"
				+ "Credits:\nHimanshu Patel (C0735691)\n"
				+ "Shubham (C0737342)\n" + "Sujalkumar Patel (C0735603)");

		System.exit(0);

		

	}

	// Write your aux methods here:


}