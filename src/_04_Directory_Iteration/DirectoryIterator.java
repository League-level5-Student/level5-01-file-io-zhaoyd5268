package _04_Directory_Iteration;

import java.io.File;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */

		/*
		 * Your task is to write a program that iterates through the src folder of this
		 * current Java Project. For every .java file it finds, the program will add a
		 * (non-legally binding) copyright statement at the bottom. Be aware of possible
		 * directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */

		JFileChooser jfc1 = new JFileChooser();
		jfc1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal1 = jfc1.showOpenDialog(null);
		if (returnVal1 == JFileChooser.APPROVE_OPTION) {
			File directory1 = jfc1.getSelectedFile();
			System.out.println(directory1);
			File[] files1 = directory1.listFiles();
			for(int i = 0; i < 8; i++) {
				File[] f = files1[i].listFiles();

			if (files1 != null) {
				for (File f1 : f) {
					if (f1.getName().contains(".java")) {
						System.out.println(f1.getAbsolutePath() + "       " + "//Copyright © 2023 Daniel Zhao");
					}
				}
			}
			}

		}
	}
}
