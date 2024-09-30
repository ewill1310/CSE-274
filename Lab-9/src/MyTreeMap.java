import java.io.File;
import java.util.Scanner;

/**
 * Use BSTLab9 to create a TreeMap to hold addresses with a String key.
 * Includes code from homework 2 and reads addresses
 * @author john1819
 *
 */
public class MyTreeMap {

	public static void main(String[] args) {
		
		// first declare a tree to hold AddressEntry
		BSTLab9<AddressEntry> theMap = new BSTLab9<AddressEntry>();
		Scanner theFile = null; // declare variable outside of try/catch so can be closed

		// place all file operations in try/catch block for proper exception handling
		try {
			// open file
			theFile = new Scanner(new File("addresses.txt"));

			while (theFile.hasNextLine()) {
				// read in an address
				String lastName = theFile.nextLine();
				String firstName = theFile.nextLine();
				String address = theFile.nextLine();
				String zipString = theFile.nextLine();
				int zip = Integer.parseInt(zipString);
				String phoneNum = theFile.nextLine();
				Address a = new Address(firstName, lastName, zip, address, phoneNum);
				
				// create unique and add to theMap
				String theKey = firstName + " " + lastName;
				theMap.insert(new AddressEntry(theKey, a));

			}
			theFile.close();

		} catch (Exception ex) {
			System.out.println("Problem opening and reading file- please check file and try again");
			System.exit(0); // exit program gracefully
		}
		
		// now print the addresses inorder based on key
		theMap.inorder();

	}

}
