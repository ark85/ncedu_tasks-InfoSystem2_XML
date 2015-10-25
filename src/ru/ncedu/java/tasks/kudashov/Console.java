package ru.ncedu.java.tasks.kudashov;

import java.io.InputStream;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Work with console. Input and output of data to the console.
 * @author Arkadiy Kudashov
 */

public interface Console {
	//For know without description
	
	/**
	 * Prints all information in XML src
	 * @param src - document 
	 */
	public void startInfo(Document src);
	
	/**
	 * Reading and printing inform. from console
	 * @param str - string from console with request
	 */
	public void readAndPrint(String str);
	
	/**
	 * Starts listening InputStream in
	 * @param in - in this program it's System.in
	 */

	public void start(InputStream in, String path);
	
	/**
	 * Printing all information about Node n
	 * @param n
	 */
	public void printNode(Node n);
}
