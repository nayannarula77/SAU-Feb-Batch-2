/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedjavaassignment;

import java.util.*;
import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author Nayan
 */
public class Merging {
    private static boolean isEqual(Element e1, Element e2) {

       if (e1.getAttribute("State_Code").equals(e2.getAttribute("State_Code")) && e1.getAttribute("License_Number").equals(e2.getAttribute("License_Number"))&& e1.getAttribute("Date_Status_Effective").equals(e2.getAttribute("Date_Status_Effective"))) {
                                    return true;
                                }
                                return false;
                            }
     private static void writeToFile(Document resdoc, Element root, Element current_license) {
                                try {
                                    Node valid_license = resdoc.importNode(current_license, true);
                                    root.appendChild(valid_license);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args)throws Exception {
        try{
            File f1 = new File("License1.xml");
            File f2 = new File("License2.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbuilder = dbf.newDocumentBuilder();
            Document d1 = dbuilder.parse(f1);
            Document d2 = dbuilder.parse(f2);
            Document resdoc = dbuilder.newDocument();
            Element rootElement = resdoc.createElement("CSR_Producer");
            resdoc.appendChild(rootElement);
            d1.getDocumentElement().normalize();
            NodeList nl1 = d1.getElementsByTagName("CSR_Producer");
            d2.getDocumentElement().normalize();
            NodeList nl2 = d1.getElementsByTagName("CSR_Producer");
           for (int i = 0; i < nl1.getLength(); i++) {
                Node n1 = nl1.item(i);
                Element e1 = (Element) n1;
                for (int j = 0; j < nl2.getLength(); j++) {
                    Node n2 = nl2.item(j);
                    Element e2 = (Element) n2;
                    if (e1.getAttribute("NIPR_Number").equals(e2.getAttribute("NIPR_Number"))) {
                        NodeList nl3 = e1.getElementsByTagName("License");
                        for (int k = 0; k < nl3.getLength(); k++) {
                            Element e3 = (Element) nl3.item(k);
                            NodeList nl4 = e2.getElementsByTagName("License");
                            for (int l = 0; l < nl4.getLength(); l++) {
                                Element currLicenseElement2 = (Element) nl4.item(l);
                                if (isEqual(e3, currLicenseElement2)) {
                                    writeToFile(resdoc, rootElement, currLicenseElement2);
                                }}}}}
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
             transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource src = new DOMSource(resdoc);
            // Wtriting to merged_list.xml file
            StreamResult file = new StreamResult(new File("merged_list.xml"));
            transformer.transform(src, file);
            System.out.println("merged_list.xml created!");
           }}
                            catch(Exception e){
                                    e.printStackTrace();
                            }}}                    