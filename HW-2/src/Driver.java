import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Driver for use in CSE 274 Homework 2 on LinkedLists
 * @author Evan Williams
 * December 2, 2022
 */
public class Driver {
	public static void main(String[] args) {
		LinkedList<Address> info = new LinkedList<Address>();
		File input = new File("addresses.txt");
		Scanner in = null;
		// Making sure no errors happen
		try {
			in = new Scanner(input);
			while (in.hasNextLine()) {
				// read in an address
				String lastName = in.nextLine();
				String firstName = in.nextLine();
				String address = in.nextLine();
				String zipString = in.nextLine();
				int zip = Integer.parseInt(zipString);
				String phoneNum = in.nextLine();
				Address a = new Address(firstName, lastName, zip, address, phoneNum);
				// add address to linkedList
				info.insertFirst(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("There was an error reading from the file" + ", please try again.");
			System.exit(0);
		} finally {
			try {
				// always close your scanner
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Printing the unsorted List
		System.out.println("The Unsorted List");
		System.out.println("_______________________________");
		System.out.println("");
		System.out.println(info);

		// Sort the list
		info.sort();

		// Printing the sorted List
		System.out.println("The Sorted List");
		System.out.println("_______________________________");
		System.out.println("");
		System.out.println(info);
	}
}
