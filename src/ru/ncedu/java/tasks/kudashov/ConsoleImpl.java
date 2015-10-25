package ru.ncedu.java.tasks.kudashov;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConsoleImpl implements Console{

	@Override
	public void startInfo(Document src) {
		// TODO Auto-generated method stub
		NodeList nodeList = src.getElementsByTagName("employee");
		Node node = nodeList.item(0);
		NodeList chNode = node.getChildNodes();
		NamedNodeMap nnm = nodeList.item(0).getAttributes();
		System.out.println(nnm.item(0).getNodeName() + " | " + nnm.item(1).getNodeName() + "    | " +
				chNode.item(1).getNodeName() + " |    " + chNode.item(3).getNodeName() + "   |    " +
				chNode.item(5).getNodeName() + "    | " + chNode.item(7).getNodeName() + " | " +
				chNode.item(9).getNodeName());
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node n = nodeList.item(i);
			NodeList chN = n.getChildNodes();
			NamedNodeMap nNM = n.getAttributes();
			System.out.format(" %.6s | %.5s | %.9s | %.13s | %.9s | %.6s | %.11s %n", 
					nNM.item(0).getTextContent() + "   ", nNM.item(1).getTextContent() + "   ",
					chN.item(1).getTextContent() + "       ", chN.item(3).getTextContent() + "       ",
					chN.item(5).getTextContent() + "        ", chN.item(7).getTextContent() + "   ",
					chN.item(9).getTextContent() + "   ");
		}
		System.out.println("\nActions:");
		System.out.println("find <string_for_search>");
		System.out.println("edit <id> <string_with_new_parameters>");
		System.out.println("add <string_with_parameters>");
		System.out.println("delete <id>");
	}

	@Override
	public String[] readAndParse(String str) {
		
		
		return null;
	}

	@Override
	public void printingElements(Element[] elements) {
		// TODO Auto-generated method stub
		
	}
	
	public void start(Document src, InputStream in) {
		// TODO Auto-generated method stub
		startInfo(src);
		Scanner scanner = new Scanner(in);
		while(true) {
			String str = "";
			str = scanner.nextLine();
			if (str.equals("exit")) {
				return;
			}
			
			
		}
	}
}
