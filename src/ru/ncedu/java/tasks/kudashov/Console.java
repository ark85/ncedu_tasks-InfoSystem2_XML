package ru.ncedu.java.tasks.kudashov;

import java.io.InputStream;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Work with console. Input and output of data to the console.
 * @author Arkadiy Kudashov
 */

public interface Console {
	//For know without description
	
	
	public void startInfo(Document src);
	
	/*
	 *Reading and parse inform. from console
	 */
	public String[] readAndParse(String str);
	
	public void printingElements(Element[] elements);

	public void start(Document document, InputStream in);
}
