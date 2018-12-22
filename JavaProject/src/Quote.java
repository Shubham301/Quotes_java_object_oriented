import java.util.Random;

import javax.swing.JOptionPane;

public class Quote {
	private String quote;
	private int count;

	public Quote(String q) {
		quote = q;
	}

	/*
	 * getQuote: This returns the quote itself.
	 */
	public String getQuote() {
		String[] splitstring = quote.split("-- ");

		String onlyQuote = "";

		for (int i = 0; i < splitstring.length - 1; i++) {
			onlyQuote += splitstring[i];
		}

		return onlyQuote;
	}

	/*
	 * getCredit: This returns the person that the quote is attributed to.
	 */

	public String getCredit() {
		String[] splitstring = quote.split("-- ");
		String onlyCredits = splitstring[splitstring.length - 1]; // Get first
																	// element
																	// in Array
																	// after
																	// "-- "
																	// which is
																	// Credits.
		return onlyCredits;
	}

	/*
	 * getWordCount: This gets the ouput of getQuote and counts the number of
	 * words in the quote itself. You might use the keyword ’this’.
	 */

	public int getWordCount() {

		String quote = this.getQuote();
		quote = quote.replace("\n", " "); // Replace line break with blank
											// space, so splitting gives proper
											// result.
		return quote.split(" ").length;

	}

	/*
	 * (8*) byWhoGame: Show the user a quote and let them guess who it’s
	 * attributed to. You could give them three random names and let them
	 * choose.
	 */

	public void byWhoGame(Quote quote2, Quote quote3) {

		Random rand = new Random();
		int num = rand.nextInt(3) + 1;

		String answer;

		if (num == 1) {

			answer = JOptionPane
					.showInputDialog("\n--------- By Who Game ---------\n"
							+ "Guess the Author of Quote below\n\n"
							+ getQuote() + "\n [1] " + getCredit() + " [2] "
							+ quote3.getCredit() + " [3] " + quote2.getCredit());

		} else if (num == 2) {
			answer = JOptionPane
					.showInputDialog("\n--------- By Who Game ---------\n"
							+ "Guess the Author of Quote below\n\n"
							+ getQuote() + "\n [1] " + quote2.getCredit()
							+ " [2] " + getCredit() + " [3] " + getCredit());

		} else {
			answer = JOptionPane
					.showInputDialog("\n--------- By Who Game ---------\n"
							+ "Guess the Author of Quote below\n\n"
							+ getQuote() + "\n [1] " + quote2.getCredit()
							+ " [2] " + quote3.getCredit() + " [3] "
							+ getCredit());

		}

		int ans = Integer.parseInt(answer);

		if (ans == num) {

			JOptionPane.showMessageDialog(null, "Awesome! You got it Right!");

		} else {

			JOptionPane.showMessageDialog(null, "Wrong! Answer was\n\n"
					+ getCredit());

		}

	}
}