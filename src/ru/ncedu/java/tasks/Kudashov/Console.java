package ru.ncedu.java.tasks.kudashov;

import java.util.Scanner;

import org.w3c.dom.Element;

/**
 * Work with console. Input and output of data to the console.
 * @author Arkadiy Kudashov
 */

 
public interface Console {
	//For know without description
	
	
	public void startInfo();
	
	/*
	 *Reading and parse inform. from console
	 */
	public String[] readAndParse(Scanner scanner);
	
	public void printingElements(Element[] elements);
}
