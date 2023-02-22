//Created By: Evan Williams
//For: CSE 274 HW-1
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class driver {

	private static ArrayList<String> words = new ArrayList<String>();
	private static ArrayList<String> uniqueWords = new ArrayList<String>();
	private static int[] counts = new int[10];
	private static String[] word = new String[10];
	private static Word[] allWord;

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter directory name");
		String myPath = input.next();
		File folder = new File(myPath);
		File[] files = folder.listFiles();
		Arrays.sort(files);
		for (File f : files) {
			System.out.println(f.toString());
		}
		for (int i = 0; i < files.length; i++) {
			readWordsFromFile(files[i]);
			Collections.sort(words);
			System.out.println("The total number of unique words in " + files[i] + " is: " + (unique(words)-4));
			allWord = new Word[uniqueWords.size()];
			for (int l = 0; l < allWord.length; l++) {
				allWord[l] = new Word();
			}
			Word[] theWords = mostRepeat(cleaning(words));
			insertionSort(theWords);
			System.out.println("The top ten words in " + files[i]);
			for (int j = uniqueWords.size() - 10; j < uniqueWords.size(); j++) {
				System.out.println(String.format("%s\t\t\t%d", theWords[j].getWord(), theWords[j].getCount()));
			}
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		duration = (duration/1000000);
		System.out.println("Time Taken: " + duration + " ms");
	}

	/**
	 * Reads the information on the files
	 */
	public static void readWordsFromFile(File f) {
		Scanner in = null;
		words.clear();
		uniqueWords.clear();
		try {
			in = new Scanner(f).useDelimiter("[^A-Za-z]");
			while (in.hasNextLine()) {
				String input = in.nextLine();
				String string[] = input.toLowerCase().split("([\\W\\n\\d_]+)");

				for (String s : string) {
					if (s.isEmpty() || s.isBlank()) {
					} else {
						words.add(s);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Counts how many unique words are in the ArrayList
	 * 
	 * @param list
	 * @return the size of the ArrayList giving the amount of unique words
	 */
	public static int unique(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i).toLowerCase();
			if (uniqueWords.contains(temp)) {

			} else {
				uniqueWords.add(temp);
			}
		}
		return uniqueWords.size();
	}

	/**
	 * Removes the unwanted words in the list of words that were on the file
	 * 
	 * @param list
	 * @return ArrayList of Strings containing all data from the read file without
	 *         the specified amounts
	 */
	public static ArrayList<String> cleaning(ArrayList<String> list) {
		ArrayList<String> cleaned = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("a") || list.get(i).equals("an") || list.get(i).equals("and")
					|| list.get(i).equals("the") || list.get(i).equals(" ")) {
			} else {
				cleaned.add(list.get(i));
			}
		}
		return cleaned;
	}

	/**
	 * Gathers the ten most repeated words and puts them into a Word array
	 * 
	 * @param cleaned
	 * @return Word array of ten most common words in the array
	 */
	public static Word[] mostRepeat(ArrayList<String> cleaned) {
		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < uniqueWords.size(); i++) {
			count = 0;
			for (int j = 0; j < cleaned.size(); j++) {
				if (uniqueWords.get(i).equalsIgnoreCase(cleaned.get(j))) {
					count++;
				}
			}
			allWord[i].setCount(count);
			allWord[i].setWord(uniqueWords.get(i));
		}
		return allWord;
	}

	/**
	 * This method recursively sorts the array of words
	 * @param words
	 */
	private static void insertionSort(Word[] words) {
		if (words == null || words.length < 2) {
			return;
		}
		for (int i = 1; i < words.length; i++) {
			Word temp = words[i];
			int j = i;
			while (j > 0 && words[j - 1].getCount() > temp.getCount()) {
				words[j] = words[--j];
			}
			words[j] = temp;
		}
	}
}
