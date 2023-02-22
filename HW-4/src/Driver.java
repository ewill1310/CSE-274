import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		HashMap<String, Address> addresses = new HashMap<>();
		ArrayList<String> keys = new ArrayList<String>();
		File input = new File("addresses.txt");
		Scanner in = null;
 
		// Compiling the HashMap from the input file
		try {
			in = new Scanner(input);
			ArrayList<String> lines = new ArrayList<String>();
			while (in.hasNextLine()) {
				String temp = in.nextLine();
				lines.add(temp);
			}
			for (int i = 0; i < lines.size(); i += 5) {
				String first = lines.get(i + 1);
				String last = lines.get(i);
				Address temp = new Address(first, last, Integer.parseInt(lines.get(i + 3)), lines.get(i + 2),
						lines.get(i + 4));
				String key = first + " " + last;
				keys.add(key);
				addresses.put(key, temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// User Input after HashMap is made
		boolean running = true;
		Scanner userInput = new Scanner(System.in);
		while (running = true) {
			System.out.println("Who would you like to search for (or enter -1 to exit program)?");
			String name = userInput.nextLine();
			if (name.equals("-1")) {
				System.out.println("Goodbye");
				userInput.close();
				System.exit(0);
			}
			name = removePunctuation(name);
			boolean status = false;
			String userKey = "";
			for (int i = 0; i < keys.size(); i++) {
				if (keys.get(i).contains(name)) {
					userKey = keys.get(i);
					status = true;
					break;
				}
			}
			if (!status) {
				System.out.println("Entry not found.");
			} else {
				Address temp = addresses.get(userKey);
				System.out.println(temp.toString());
			}
		}

	}

	/**
	 * Method to remove all punctuation from user input key request
	 * 
	 * @param s
	 * @return the User input string without punctuation or symbols
	 */
	public static String removePunctuation(String s) {
		if (s == null) {
			return null;
		}
		return s.replaceAll("[^A-Za-z0-9 ]", "");
	}

}
