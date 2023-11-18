package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("please enter some text for me to encrypt.");
		String key = JOptionPane.showInputDialog("Please enter a key for me to increase or decrease by. What I mean is enter a number"
				+ "for me to shift the letter up or down by.");
		int keyAsInt = Integer.parseInt(key);
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);
			c = (char) (c.charValue() + keyAsInt);
			s.append(c);
		}

		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encryptedtext.txt");
			fw.write(s.toString());
			fw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
