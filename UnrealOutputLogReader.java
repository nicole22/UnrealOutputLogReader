import java.util.Scanner;
import java.lang.Object.*;
import java.io.*;

public class UnrealOutputLogReader {
	// *****************************************************
	// *** Please enter input and output file names here ***
	// *****************************************************
	static String inputFileName = "C:\\Users\\username\\Documents\\Unreal Projects\\NameOfUnrealGame\\Saved\\Logs\\NameOfUnrealGame.log";
	static String outputFileName = "C:\\Users\\username\\Desktop\\out.txt";

	// Show or hide debug messages in console
	static boolean debug = true;

	public static void main (String[] args) {
		
		try {
			// read input
			File inFile = new File(inputFileName);
			Scanner scan;
			scan = new Scanner(inFile);
			String line, category = new String();
			StringBuilder builder = new StringBuilder();
			boolean printThisLine = false; 
			int linesRead = 0;
			int linesWritten = 0;

			// Feedback to user
			if (debug == true) {
				System.out.println("Reading from input file " + inputFileName);
			}

			while (scan.hasNextLine()) {
				// keep track of how many lines of the input file have been read
				linesRead++;

				// decide whether to print this line to the output file
				line = scan.nextLine();
				if (line.length() < 57) {
					printThisLine = false;
				}
				else {
					category = line.substring(30, 57);
					if (category.equals("LogBlueprintUserMessages: [")) {
						printThisLine = true;
					}
					else 
						printThisLine = false;
				}

				// if the line should be printed
				if (printThisLine) {
					// keep track of how many lines have been written to the output file 
					linesWritten++;

					//add the next line and a line break to the builder
					builder.append(line.substring(76));
					builder.append(System.lineSeparator());
				}
			}
			
			// Feedback to user
			if (debug == true) {
				System.out.println("Writing to output file " + outputFileName);
			}

			// print output
			FileWriter writer = new FileWriter(outputFileName);
			writer.write(builder.toString());
			writer.close();

			// Feedback that the program is finished running
			if (debug == true) {
				System.out.println("Finished reading " + linesRead + " lines of input file. Wrote " + linesWritten + " lines to output file.");
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: File Not Found");
		}
		catch (IOException e) {
			System.out.println("Error: IO Exception");
		}
	}
}
