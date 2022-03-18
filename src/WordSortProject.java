

	import java.io.*;
	import java.util.*;
	
	
	public class WordSortProject {
	static String words[] = new String[3000];
	static int count[] = new int[3000];
	static int lastIndex = 0;
	 
	static Map<String, Integer> WordCount = new HashMap<>();
	 

	/**
	 * addWordToList - add word to list or increment counter
	 * @param inWord - the word to add to the list
	 * @return number of words in the list
	 */
	static int addWordToList(String inWord) {
	int index = lastIndex;
	if (WordCount.containsKey(inWord)) {
	 
	Integer count = WordCount.get(inWord);
	 
	WordCount.put(inWord, count + 1);
	 
	 
	}
	else {
	WordCount.put(inWord, 1);
	 
	index++;
	 
	lastIndex = index;
	 
	return index;
	 
	}
	return index;
	}
	/**
	 * printWordList - dump the list if count > inMinimum
	 */
	static void printWordList(int inMinimum) {
	for(Map.Entry<String,Integer> entry:
	WordCount.entrySet())
	{
	if(entry.getValue() >= inMinimum) {
	 
	System.out.println("\"" + entry.getKey() + "\"" +
	 
	" is said "+entry.getValue() + " times in Psalms.");
	}
	}
	}
	/**
	 * getVerse - Parse and return only the Psalms verse
	 * @param inLine - the line to parse on tab delimiter
	 * @return right half of tab delimited string
	 */
	static String getVerse(String inLine) {
	String ver = "";
	String[] s1 =inLine.split("\t");
	ver = s1[1];
	return ver;
	}
	/**
	 * PsalmsReaderMain main() - Template for Assignment-4
	 * @param args
	 */
	public static void main(String[] args) {
	try {
		// Open the required text file for sequential read
		Scanner inputFile = new Scanner (new File("src\\bible-psalms.txt"));
		// Check for EOF, read the next line, and display it
		while (inputFile.hasNextLine()) {
		String inLine, verse;
		String[] verseParsed;
		inLine = inputFile.nextLine();
		verse = getVerse(inLine);
		verseParsed = verse.split("[ :;,.'!?()-]+");
			for (String s : verseParsed) {
			addWordToList(s.toLowerCase());
			}
		}
		// Close the required file when EOF is reached
		inputFile.close();
		printWordList(1000);
		} // END try
	catch (Exception e) {
		// All Exceptions come here for graceful termination
		System.out.println("PsalmsReaderMain Error: " + e);
		} // END catch
	} // END main
	
}
