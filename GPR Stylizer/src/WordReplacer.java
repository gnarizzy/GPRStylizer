import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 * Replaces styling errors in text file based on predefined style rules
 * 
 * @author Gautam Narula
 * 
 */
class WordReplacer {
	File file;
	String path;

	/**
	 * Constructor
	 * 
	 * @param file
	 *            The text file to be modified
	 */
	public WordReplacer(File input) {
		file = input;
		path = input.getPath();
	}

	/**
	 * Outward facing method to open file, fix styling errors, and write back to
	 * file
	 * @throws IOException 
	 */
	public void stylize() throws IOException {

			String text = getText(file);
			String newText = replace(text);
			writeToFile(newText);
	}

	/**
	 * 
	 * @param input
	 *            The input file to extract text from
	 * @return String with text from text file
	 * @throws FileNotFoundException
	 */
	private String getText(File input) throws FileNotFoundException {
		StringBuilder text = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		Scanner scan = new Scanner(new FileInputStream(input));

		while (scan.hasNextLine())
			text.append(scan.nextLine() + newLine);
		scan.close();
		return text.toString();
	}

	/**
	 * 
	 * @param contents The string of text that potentially contains style errors
	 * @return String with style errors corrected via regexes
	 */
	private String replace(String contents) {
		String contents1 = contents.replaceAll("%", "percent");
		String contents2 = contents1.replaceAll("O.K.", "OK");
		String contents3 = contents2.replaceAll("okay", "OK");
		String contents4 = contents3.replaceAll("Atheist", "atheist");
		String contents5 = contents4.replaceAll(" 1 ", " one ");
		String contents6 = contents5.replaceAll(" 2 ", " two ");
		String contents7 = contents6.replaceAll(" 3 ", " three ");
		String contents8 = contents7.replaceAll(" 4 ", " four ");
		String contents9 = contents8.replaceAll(" 5 ", " five ");
		String contents10 = contents9.replaceAll(" 6 ", " six ");
		String contents11 = contents10.replaceAll(" 7 ", " seven ");
		String contents12 = contents11.replaceAll(" 8 ", " eight ");
		String contents13 = contents12.replaceAll(" 9", " nine ");
		String contents14 = contents13.replaceAll("Towards", "Toward");
		String contents15 = contents14.replaceAll("towards", "toward");
		String contents16 = contents15.replaceAll("Forwards", "Forward");
		String contents17 = contents16.replaceAll("forwards", "forward");
		String contents18 = contents17.replaceAll("Backwards", "Backward");
		String contents19 = contents18.replaceAll("backwards", "backward");
		String contents20 = contents19.replaceAll("Upwards", "Upward");
		String contents21 = contents20.replaceAll("upwards", "upward");
		String contents22 = contents21.replaceAll("Downwards", "Downward");
		String contents23 = contents22.replaceAll("downwards", "downward");
		
		return contents23;
	}

	/**
	 * Writes the corrected string text into an output file
	 * 
	 * @param toWrite The correct output string
	 * @throws IOException 
	 */
	private void writeToFile(String toWrite) throws IOException {
			Writer outWriter = new OutputStreamWriter(new FileOutputStream(path));
			try {
				outWriter.write(toWrite);
			}
			finally {
				outWriter.close();
			}
	}

}
