/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedjavaassignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Nayan
 */
public class checkLicenseValidity {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException, ParseException {

        
        //Reading Document
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
        //Previously merged file being accesed
        Document doc = dbuilder.parse("merged_list.xml");
        //Traversing the XML file
        NodeList nlist = doc.getElementsByTagName("CSR_Producer");
        Date dt = new Date();
        String todaysdate = new SimpleDateFormat("dd/MM/yyyy").format(dt);
        for (int i = 0; i < nlist.getLength(); i++) {
            Node n = nlist.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element listItem = (Element) n;
                NodeList nlist2 = listItem.getElementsByTagName("License");
                for (int j = 0; j < nlist2.getLength(); j++) {
                    Node q = nlist2.item(j);
                    if (q.getNodeType() == Node.ELEMENT_NODE) {
                        Element listItem2 = (Element) q;
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        if (sdf.parse(listItem2.getAttribute("License_Expiration_Date")).before(sdf.parse(todaysdate))) {
                            String f = "Invalid_Licenses.txt";
                            FileWriter fw = new FileWriter(f, true); 
                            //Writing to Invalid_Licenses txt file
                            fw.write("Date_Status_Effective: " + listItem2.getAttribute("Date_Status_Effective") + ", License_Class: "
                                    + listItem2.getAttribute("License_Class") + ", License_Class_Code: "
                                    + listItem2.getAttribute("License_Class_Code") + ", License_Expiration_Date: "
                                    + listItem2.getAttribute("License_Expiration_Date") + ", License_Issue_Date: "
                                    + listItem2.getAttribute("License_Issue_Date") + ", License_Number: "
                                    + listItem2.getAttribute("License_Number") + ", License_Status: "
                                    + listItem2.getAttribute("License_Status") + ", Resident_Indicator: "
                                    + listItem2.getAttribute("Resident_Indicator") + ", State_Code: "
                                    + listItem2.getAttribute("State_Code") + ", State_ID: "
                                    + listItem2.getAttribute("State_ID") + "\n"
                            );
                     //Close writer
                            fw.close();
                           System.out.println("Invalid_Licenses.xml updated!");
                        } else if (sdf.parse(listItem2.getAttribute("License_Expiration_Date")).after(sdf.parse(todaysdate))) {
                            String f = "Valid_Licenses.txt";
                            FileWriter fw = new FileWriter(f, true);
                            //Writing to Valid_Licenses txt file
                            fw.write("Date_Status_Effective: " + listItem2.getAttribute("Date_Status_Effective") + ", License_Class: "
                                    + listItem2.getAttribute("License_Class") + ", License_Class_Code: "
                                    + listItem2.getAttribute("License_Class_Code") + ", License_Expiration_Date: "
                                    + listItem2.getAttribute("License_Expiration_Date") + ", License_Issue_Date: "
                                    + listItem2.getAttribute("License_Issue_Date") + ", License_Number: "
                                    + listItem2.getAttribute("License_Number") + ", License_Status: "
                                    + listItem2.getAttribute("License_Status") + ", Resident_Indicator: "
                                    + listItem2.getAttribute("Resident_Indicator") + ", State_Code: "
                                    + listItem2.getAttribute("State_Code") + ", State_ID: "
                                    + listItem2.getAttribute("State_ID") + "\n"
                            );
                            //Close writer
                            fw.close();
                                        System.out.println("Valid_Licenses.xml updated!");


                        }
}}}}}}
