package ru.ncedu.java.tasks.kudashov;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class TestInfoSystem {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		
		InfoSystemXML isx = new InfoSystemXMLImpl();
		Console cons = new ConsoleImpl();
		File file = new File("doc.xml");
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		builder = docFactory.newDocumentBuilder();
		Document document = builder.newDocument();
		document = builder.parse(file);
		cons.start(document, System.in);
	}

}
