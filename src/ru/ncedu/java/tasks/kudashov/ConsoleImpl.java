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
	
	InfoSystemXML isx;
	String title = null;
	
	public ConsoleImpl(Document document) {
		isx = new InfoSystemXMLImpl(document);
	}
	@Override
	public void startInfo(Document src) {
		// TODO Auto-generated method stub
		NodeList nodeList = src.getElementsByTagName("employee");
		Node node = nodeList.item(0);
		NodeList chNode = node.getChildNodes();
		NamedNodeMap nnm = nodeList.item(0).getAttributes();
		title = nnm.item(1).getNodeName() + "     | " + nnm.item(0).getNodeName() + " | " +
				chNode.item(1).getNodeName() + " |    " + chNode.item(3).getNodeName() + "   |    " +
				chNode.item(5).getNodeName() + "    | " + chNode.item(7).getNodeName() + " | " +
				chNode.item(9).getNodeName();
		System.out.println(title);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node n = nodeList.item(i);
			printNode(n);
		}
		System.out.println("\nActions:");
		System.out.println("find <string_for_search>");
		System.out.println("edit <id> <string_with_new_parameters>");
		System.out.println("add <string_with_parameters>");
		System.out.println("delete <id>");
		System.out.println("Write 'exit' to exit");
	}

	@Override
	public void readAndPrint(String str) {
		String[] strs = str.split(" ");
		if (strs[0].equals("find")) {
			Element[] lastFind;
			if (strs.length == 1) {
				lastFind = isx.find(null);
			}
			else {
				String[] help = new String[strs.length - 1];
				for (int i = 1; i < strs.length; i++) {
					help[i - 1] = strs[i];
				}
				lastFind = isx.find(help);
			}
			if (lastFind == null) {
				System.out.println("Something wrong!");
			}
			else {
				isx.setLastFind(lastFind);
				System.out.println(title);
				for (int i = 0; i < lastFind.length; i++) {
					printNode((Node) lastFind[i]);
				}
			}
		}
		
		if (strs[0].equals("add")) {
			Element[] lastFind = isx.add(strs);
			System.out.println(title);
			if (lastFind == null) {
				return;
			}
			else {
				for (int i = 0; i < lastFind.length; i++) {
					printNode((Node) lastFind[i]);
				}
			}
		}
		
		if (strs[0].equals("delete")) {
			Element[] lastFind = isx.delete(strs[1]);
			System.out.println(title);
			if (lastFind == null) {
				return;
			}
			else {
				for (int i = 0; i < lastFind.length; i++) {
					printNode((Node) lastFind[i]);
				}
			}
		}
		
		if (strs[0].equals("edit")) {
			Element[] lastFind = isx.edit(strs);
			System.out.println(title);
			if (lastFind == null) {
				return;
			}
			else {
				for (int i = 0; i < lastFind.length; i++) {
					printNode((Node) lastFind[i]);
				}
			}
		}
	}
	
	public void start(InputStream in, String pathDoc) {
		// TODO Auto-generated method stub
		isx.setPathDoc(pathDoc);
		startInfo(isx.getDoc());
		Scanner scanner = new Scanner(in);
		while(true) {
			String str = "";
			str = scanner.nextLine();
			if (str.equals("exit")) {
				return;
			}
			else {
				readAndPrint(str);
			}
			
		}
	}
	
	public void printNode(Node n) {
		NodeList chN = n.getChildNodes();
		NamedNodeMap nNM = n.getAttributes();
		System.out.format(" %.5s  | %.6s | %.9s | %.13s | %.9s | %.6s | %.11s %n", 
				nNM.item(1).getTextContent() + "   ", nNM.item(0).getTextContent() + "     ",
				chN.item(1).getTextContent() + "       ", chN.item(3).getTextContent() + "       ",
				chN.item(5).getTextContent() + "        ", chN.item(7).getTextContent() + "   ",
				chN.item(9).getTextContent() + "   ");
	}
}
