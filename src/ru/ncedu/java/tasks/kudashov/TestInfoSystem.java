package ru.ncedu.java.tasks.kudashov;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class TestInfoSystem {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stubs
		File file = new File("doc.xml");
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		builder = docFactory.newDocumentBuilder();
		Document document = builder.newDocument();
		document = builder.parse(file);
		Console cons = new ConsoleImpl(document);
		cons.start(System.in, "doc.xml");
	}

}


//1100 12 Vladimir Smirnov Clerk 20000 89452164738
// 7369 10 Ivan Ivanushkin Salerman 5000 89196714129
//7269 10 Anatoliy Levyev Clerk 10000 89115614129