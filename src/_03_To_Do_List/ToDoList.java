package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton addtask = new JButton();
	static JButton viewTasks = new JButton();
	static JButton removeTask = new JButton();
	static JButton saveList = new JButton();
	static JButton loadList = new JButton();
	String listOfTasks = "";
	ArrayList<String> arrlist = new ArrayList<String>();

	public void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		initialize(addtask, "Add task");
		initialize(viewTasks, "View tasks");
		initialize(removeTask, "Remove task");
		initialize(saveList, "Save list");
		initialize(loadList, "Load list");
	}

	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.setup();

	}

	public JButton initialize(JButton q, String text) {
		panel.add(q);
		q.setText(text);
		frame.pack();
		q.addActionListener(this);
		return q;
	}

		public void refreshList() {
			listOfTasks = "Here is your list of tasks: ";
			for (int i = 0; i < arrlist.size(); i++) {
				listOfTasks = listOfTasks + "\n" + ("     - " + arrlist.get(i));
			}
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addtask)) {
			String task = JOptionPane.showInputDialog("Add your task name here.");
			arrlist.add(task);
			refreshList();
		} else if (e.getSource().equals(viewTasks)) {
			JOptionPane.showMessageDialog(null, listOfTasks);
		} else if (e.getSource().equals(removeTask)) {
			String which = JOptionPane.showInputDialog("Type the exact name fo the event you want to remove.");
			arrlist.remove(which);
			refreshList();
		} else if (e.getSource().equals(saveList)) {
			FileWriter fw;
			String name = JOptionPane.showInputDialog("What name do you want your file to be called?");
			try {
				JOptionPane.showMessageDialog(null, "Saving...");
				fw = new FileWriter("src/_03_To_Do_List/" + name);
				fw.write(listOfTasks);
				JOptionPane.showMessageDialog(null, "Success!");
				fw.close();
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "ERROR! Try again later.");
				e1.printStackTrace();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "ERROR! Try again later.");
				e1.printStackTrace();
			}
			refreshList();
		} else if (e.getSource().equals(loadList)) {
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line = br.readLine();
					listOfTasks = "here is your list of Tasks:";
					while(line != null){
						line = br.readLine();
						listOfTasks = listOfTasks + "\n" + "-     " + line;
					}
					
					br.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}
