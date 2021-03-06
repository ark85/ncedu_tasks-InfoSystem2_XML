package ru.ncedu.java.tasks.kudashov;

import javax.xml.transform.TransformerConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * The task consists of writing a Java console application - 
 * primitive information system which stores data in XML-file.</br>
 * Requirements for the objects in the structure:</br>
 * 1) The recreated and editable objects must have a valid
 * (not empty and not very short) name / title. If you try to enter
 * a name shorter than 3 characters should display a clear error 
 * message: validation error.</br>
 * 2) If user enters a duplicate of the field corresponding to the unique attribute of object, 
 * it is also necessary to generate an error message.
 *   
 * @autor Arkadiy Kudashov
 */
public interface InfoSystemXML {
	/**
	 * User can search for objects by name by typing "find <\strForSearch\>". 
	 * User can set any substring of the name (or the first characters of the name). 
	 * Input "find" with no argument (or, alternatively, "find *") is equivalent 
	 * to finding all the objects, 
	 * i.e. that that the program gives immediately after launch.
	 * @param strForSearch - firstname or/and lastname or/and id
	 * @return a list of elements that satisfy the search condition i.e. strForStearch
	 */
	public Element[] find(String[] strForSearch);
	
	/**
	 * Editing object specifying new attributes. Format:
	 * "edit <\id\> <\strWithAttr\>"
	 * @param strWithAttr - new values for all attributes
	 * @return the result of the last operation "find" 
	 * (with the possible exception of the edited object 
	 * if it ceased to satisfy the search condition).
	 */
	public Element[] edit(String[] strWithAttr);
	
	/**
	 * Adding new object.
	 * User enters a string attribute values of the new facility.
	 * Format: "add <\strWithAttr\>"
	 * @param strWithAttr - values for all attributes
	 * @return A list of elements. If the added object meets previously entered search condition then output the result 
	 * of the last operation "find" + added object. 
	 * Otherwise, output the full list of objects.
	 */
	
	public Element[] add(String[] strWithAttr);
	
	/**
	 * Deleting of an object
	 * @param id - unique field of an object
	 * @return The result of the last operation "find" except a deleted object.
	 */
	public Element[] delete(String id);
	
	/**
	 * Getter for document
	 * @return current document
	 */
	public Document getDoc();
	
	/**
	 *  Setter for lastFind
	 * @param el
	 */
	public void setLastFind(Element[] el);
	
	/**
	 * Returns list of elements form last find operation
	 * @return list of elements form last find operation
	 */
	public Element[] getLastFind();
	
	/**
	 * Sets path to Document
	 * @param path
	 */
	public void setPathDoc(String path);
}
