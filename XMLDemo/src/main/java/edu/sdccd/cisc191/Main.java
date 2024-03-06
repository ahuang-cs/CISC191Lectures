package edu.sdccd.cisc191;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Main {
    public static void main(String[] args) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(Main.class.getClassLoader().getResourceAsStream("SimplePaint.xml"));
            NodeList curves = doc.getElementsByTagName("curve");

            for(int i=0; i<curves.getLength(); i++) {
                NodeList curveAttrs = curves.item(i).getChildNodes();
                for(int j=0; j<curveAttrs.getLength(); j++) {
                    if(curveAttrs.item(j).getNodeName().equals("point")) {
                        System.out.println("x: " + curveAttrs.item(j).getAttributes().getNamedItem("x").getNodeValue() +
                                            ", y: " + curveAttrs.item(j).getAttributes().getNamedItem("y").getNodeValue());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
