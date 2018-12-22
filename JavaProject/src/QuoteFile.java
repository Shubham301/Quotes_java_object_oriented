import java.io.*;
import java.util.Scanner;

// load the classes that you need. 

public class QuoteFile {
	File file;

	QuoteFile(String file_name) {
		file = new File(file_name);

	}

	/*
	 * countQuotes: This method returns the count of the quotes by looking at
	 * the blank lines that separates them. Most likely, having a while loop
	 * would be useful here.
	 */

	public int countQuotes() throws IOException {

		Scanner scan = new Scanner(file);
		int quoteCount = 0;
		while (scan.hasNext()) {
			if (scan.nextLine().trim().isEmpty()) {
				quoteCount++;
			}
		}

		quoteCount++; // For adding last Quote without blank space

		scan.close();

		return quoteCount;
	}

	/*
	 * addEntry: This allows the user to enter a new quotation entry which gets
	 * written to the bottom of the text file in the same format.
	 */

	public void addEntry(String quote, String author) throws IOException {

		FileWriter fileWriter = new FileWriter(file, true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println("\n");
		printWriter.println(quote); // TODO Enter Quote and Author text
		printWriter.print("-- " + author);
		printWriter.close();

	}

	/*
	 * retrieveQuote(int num): This method retrieves the ith quote from the
	 * file. Put a while loop here to make sure that the input num is within the
	 * valid range. Most quotes span multiple lines. This method transforms the
	 * entire quote entry into one long String and returns it.
	 */

	public String retrieveQuote(int num) {

		String quote = "";

		try {

			Scanner scan = new Scanner(file);

			if (num > 1) { // Check if it's not a first Quote, so we can start
							// scanning for blank lines

				int blankLineCount = 0;

				while (scan.hasNext() && blankLineCount != (num - 1)) {

					if (scan.nextLine().trim().isEmpty()) {
						blankLineCount++;
					}

				}

				String tempLine = scan.nextLine();

				while (scan.hasNext() && !tempLine.trim().isEmpty()) {

					quote += tempLine + "\n";
					tempLine = scan.nextLine();
				}

			} else if (num == 1) { // Check if it's first Quote

				String tempLine = scan.nextLine();

				while (scan.hasNext() && !tempLine.trim().isEmpty()) {

					quote += tempLine + "\n";
					tempLine = scan.nextLine();
				}

			} else { // if Quote number is negative value
				quote = "Invalide Quote Number";
			}

			scan.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return quote;
	}

}