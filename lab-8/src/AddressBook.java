
//Written By: Evan Williams
//For CSE-271 Lab 8
//Due 3/27/22
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class AddressBook extends JFrame {

	private final int FRAME_WIDTH = 630;
	private final int FRAME_HEIGHT = 550;
	private JPanel panel;
	private JPanel textPanel;
	private JPanel output;
	private JButton addContact;
	private JButton saveToFile;
	private JTextField name;
	private JTextField address;
	private JTextField phone;
	private JTextField email;
	private JTextArea area;
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel phoneLabel;
	private JLabel emailLabel;

	private ArrayList<String> contacts = new ArrayList<String>();

	/**
	 * Constructor for the AddressBook class
	 */
	public AddressBook() {
		constructDisplay();
	}

	/**
	 * This methods purpose is to write to the file we read from to append the list
	 * of contacts with any new ones that were added with the program/GUI
	 */
	public void writeContactsToFile() {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("contacts.txt");
			pw = new PrintWriter(fw, true);

			for (String s : contacts) {
				pw.println(s);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				fw.close();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This methods purpose is to read from the text file contacts.txt it then takes
	 * the contents of the file and puts them into an arraylist of
	 * addresses/contacts then also appends the JTextField to display its contents
	 * on the GUI
	 */
	public void readContactsFromFile() {
		Scanner in = null;
		try {
			in = new Scanner(new File("contacts.txt"));
			while (in.hasNextLine()) {
				String input = in.nextLine();
				area.append(input + "\n");
				contacts.add(input);
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
	 * This methods purpose is to create the display that is being put into the GUI
	 * takes no inputs and when it is finished executing it should have a
	 * constructed GUI in a window with functioning features that includes
	 * textFields, functioning buttons, and a textArea that displays text
	 */
	public void constructDisplay() {
		Container container = getContentPane();
		textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout(6, 10, 10));
		nameLabel = new JLabel("     Name:  ");
		name = new JTextField(55);
		addressLabel = new JLabel("Address:   ");
		address = new JTextField(55);
		phoneLabel = new JLabel("    Phone:  ");
		phone = new JTextField(55);
		emailLabel = new JLabel("     Email:  ");
		email = new JTextField(55);
		area = new JTextArea(20, 50);
		JScrollPane pane = new JScrollPane(area);
		area.setEditable(false);

		addContact = new JButton("Add Contact");
		addContact.addActionListener(new ActionListener() {
			/**
			 * recognized that the button is clicked and then takes the text from text
			 * fields and constructs a String that is then appended into the JTextArea
			 * 
			 * @param e
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String out = (name.getText() + ", " + address.getText() + ", " + phone.getText() + ", "
						+ email.getText());
				contacts.add(out);
				area.append(out + "\n");
			}
		});
		saveToFile = new JButton("Saves to File");
		saveToFile.addActionListener(new ActionListener() {
			/**
			 * recognized that the button is clicked and then writes what is in the
			 * JTextArea into the contacts.txt file
			 * 
			 * @param e
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				writeContactsToFile();
			}
		});

		textPanel.add(nameLabel, 0);
		textPanel.add(name, 1);
		textPanel.add(addressLabel, 2);
		textPanel.add(address, 3);
		textPanel.add(phoneLabel, 4);
		textPanel.add(phone, 5);
		textPanel.add(emailLabel, 6);
		textPanel.add(email, 7);

		output = new JPanel();
		readContactsFromFile();
		output.add(addContact);
		output.add(saveToFile);
		output.add(pane);
		container.setLayout(new BorderLayout(10, 10));
		container.add(textPanel, BorderLayout.CENTER);
		container.add(output, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Address Book");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
}
