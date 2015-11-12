package ru.ncedu.java.tasks.kudashov;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class InfoSystemXMLImpl implements InfoSystemXML{
	
	Document doc;
	Element[] lastFind = null;
	String[] lastF = {"*"};
	String pathDoc = null;
	static Set<Integer> ids;
	
	
	static {
		ids = new HashSet<Integer>();
		for (int i = 1; i < 9999; i++) {
			ids.add(i);
		}
	}
	public InfoSystemXMLImpl(Document document) {
		doc = document;
		NodeList nodeList = doc.getElementsByTagName("employee");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element n = (Element) nodeList.item(i);
			ids.remove(Integer.parseInt(n.getAttribute("id")));
		}
	}
	
	@Override
	public Element[] find(String[] strForSearch) {
		// TODO Auto-generated method stub
		if( strForSearch != null) {
			lastF = new String[strForSearch.length];
			lastF = strForSearch;
		}
		NodeList nodeList = doc.getElementsByTagName("employee");
		String[] s = strForSearch;
		if(s == null || (s.length == 1 && strForSearch[0].equals("*"))) {
			Element[] el = new Element[nodeList.getLength()];
			for (int i = 0; i < el.length; i++) {
				el[i] = (Element) nodeList.item(i);
			}
			return el;
		}
		else {
			List<Element> listEl = new ArrayList<Element>();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node n = nodeList.item(i);
				NodeList chN = n.getChildNodes();
				String[] attr = {n.getAttributes().item(1).getTextContent(),
						chN.item(1).getTextContent(), chN.item(3).getTextContent()
						};
				if (s.length == 1) {
					if (attr[0].contains(s[0]) || attr[1].contains(s[0]) || attr[2].contains(s[0])) {
						listEl.add((Element) n);
					}
				}
				if (s.length == 2) {
					if ((attr[0].contains(s[0]) || attr[1].contains(s[0]) || attr[2].contains(s[0])) &&
						(attr[0].contains(s[1]) || attr[1].contains(s[1]) || attr[2].contains(s[1]))) {
						listEl.add((Element) n);
					}
				}
				if (s.length == 3) {
					if ((attr[0].contains(s[0]) || attr[1].contains(s[0]) || attr[2].contains(s[0])) &&
						(attr[0].contains(s[1]) || attr[1].contains(s[1]) || attr[2].contains(s[1])) &&
						(attr[0].contains(s[2]) || attr[1].contains(s[2]) || attr[2].contains(s[2]))) {
						listEl.add((Element) n);
					}
				}
			}
			Element[] el = new Element[listEl.size()];
			for (int i = 0; i < el.length; i++) {
				el[i] = listEl.get(i);
			}
			return el;
		}
	}

	@Override
	public Element[] edit(String[] strWithAttr) {
		// TODO Auto-generated method stub
		String[] s = strWithAttr;
		NodeList nodes = doc.getElementsByTagName("employee");
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element emp = (Element) node;
				String idEmp =  emp.getAttribute("id");
				if (idEmp.equals(s[1])) {
					if (s[2].equals("null") == false) {
						emp.setAttribute("deptno", s[2]);
					}
					emp.setAttribute("type", "id");
					NodeList fn = emp.getElementsByTagName("firstname");
					NodeList ln = emp.getElementsByTagName("lastname");
					NodeList job = emp.getElementsByTagName("job");
					NodeList sal = emp.getElementsByTagName("salary");
					NodeList ph = emp.getElementsByTagName("phone");
					if (s[3].equals("null") == false) {
						fn.item(0).setTextContent(s[3]);
					}
					if (s[4].equals("null") == false) {
						ln.item(0).setTextContent(s[4]);
					}
					if (s[5].equals("null") == false) {
						job.item(0).setTextContent(s[5]);
					}
					if (s[6].equals("null") == false) {
						sal.item(0).setTextContent(s[6]);
					}		
					if (s[7].equals("null") == false) {
						ph.item(0).setTextContent(s[7]);
					}		
				}
			}
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
	    try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    DOMSource source = new DOMSource(doc);
	    StreamResult result = new StreamResult(pathDoc);
	    try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Element[] elem = find(lastF);
	    return elem;
	}

	@Override
	public Element[] add(String[] strWithAttr) {
		// TODO Auto-generated method stub
		String[] s = strWithAttr;
		Element el = doc.getDocumentElement();
		Element n = doc.createElement("employee");
		Node tab = doc.createTextNode("\t");
		Node nl = doc.createTextNode("\n");
		Node nTabTab = doc.createTextNode("\n\t\t");
		Node nTab = doc.createTextNode("\n\t");
		el.appendChild(tab.cloneNode(false));
		el.appendChild(n);
		n.appendChild(nTabTab);
		Node fn = doc.createElement("firstname");
		Node ln = doc.createElement("lastname");
		Node job = doc.createElement("job");
		Node salary = doc.createElement("salary");
		Node ph = doc.createElement("phone");
		n.appendChild(fn);
		n.appendChild(nTabTab.cloneNode(false));
		n.appendChild(ln);
		n.appendChild(nTabTab.cloneNode(false));
		n.appendChild(job);
		n.appendChild(nTabTab.cloneNode(false));
		n.appendChild(salary);
		n.appendChild(nTabTab.cloneNode(false));
		n.appendChild(ph);
		n.appendChild(nTab.cloneNode(false));
		el.appendChild(nl);
		try {
			Iterator it = ids.iterator();
			Integer i = (Integer) it.next();
			n.setAttribute("id", i.toString());
			ids.remove(i);
			n.setAttribute("deptno", s[1]);
			n.setAttribute("type", "id");
			fn.setTextContent(s[2]);
			ln.setTextContent(s[3]);
			job.setTextContent(s[4]);
			salary.setTextContent(s[5]);
			ph.setTextContent(s[6]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Not enough parameters");
			return null;
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
	    try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    DOMSource source = new DOMSource(doc);
	    StreamResult result = new StreamResult(pathDoc);
	    try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Element[] elem = find(lastF);
	    return elem;
	}

	@Override
	public Element[] delete(String id) {
		// TODO Auto-generated method stub
		NodeList nodes = doc.getElementsByTagName("employee");
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element emp = (Element) node;
				String idEmp =  emp.getAttribute("id");
				if (idEmp.equals(id)) {
					Node tab = emp.getNextSibling();
					emp.getParentNode().removeChild(emp);
					tab.getParentNode().removeChild(tab);
					Integer integer =  Integer.parseInt(idEmp);
					ids.add(integer);
				}
			}
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
	    try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    DOMSource source = new DOMSource(doc);
	    StreamResult result = new StreamResult(pathDoc);
	    try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Element[] elem = find(lastF);
	    return elem;
	}
	
	public Document getDoc() {
		return doc;
	}
	
	public void setLastFind(Element[] el) {
		lastFind = el;
	}
	
	public Element[] getLastFind() {
		return lastFind;
	}
	
	public void setPathDoc(String path) {
		pathDoc = path;
	}
}
