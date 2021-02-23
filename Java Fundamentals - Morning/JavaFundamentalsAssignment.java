/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafundamentalsassignment;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Nayan
 */
class Student {

    int rollno, marks;
    String subject;

    Student(int rollno, int marks, String subject) {
        this.rollno = rollno;
        this.marks = marks;
        this.subject = subject;
    }
}

class Student2 implements Serializable {

    int rollnum, totalmarks;

    Student2(int rollnum, int totalmarks) {
        this.rollnum = rollnum;
        this.totalmarks = totalmarks;
    }

    public static Comparator<Student2> totalMarksSort = new Comparator<Student2>() {
        public int compare(Student2 s1, Student2 s2) {

            int tm1 = s1.totalmarks;
            int tm2 = s2.totalmarks;

            return tm2 - tm1;

        }
    };

}

public class JavaFundamentalsAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Student> Students = new ArrayList<Student>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        System.out.println("Deserializing student.xml file...");
        try {

            File inputFile = new File("input.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("student");

            int rollno, marks;
            String subject;

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    rollno = Integer.parseInt(eElement.getElementsByTagName("roll").item(0).getTextContent());
                    marks = Integer.parseInt(eElement.getElementsByTagName("marks").item(0).getTextContent());
                    subject = eElement.getElementsByTagName("subject").item(0).getTextContent();

                    Students.add(new Student(rollno, marks, subject));

                    if (map.containsKey(rollno)) {
                        map.replace(rollno, map.get(rollno) + marks);
                    } else {
                        map.put(rollno, marks);
                    }

                }
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        for (int i = 0; i < Students.size(); i++) {
            Student s = Students.get(i);
            System.out.println("Roll No. : " + s.rollno);
            System.out.println("Marks : " + s.marks);
            System.out.println("Subject : " + s.subject);
            System.out.println();
        }

        ArrayList<Student2> Students2 = new ArrayList<Student2>();
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            Students2.add(new Student2(entry.getKey(), entry.getValue()));
        }

        try {
            FileOutputStream fos = new FileOutputStream("student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Students2);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("Deserializing student.txt file...");
        ArrayList<Student2> deserializedList = new ArrayList<Student2>();

        try {
            FileInputStream fis = new FileInputStream("student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            deserializedList = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        for (Student2 s : deserializedList) {
            System.out.println("Roll no. = " + s.rollnum);
            System.out.println("Total marks = " + s.totalmarks);
            System.out.println();
        }

        System.out.println("Sorting based on total marks...");

        Collections.sort(deserializedList, Student2.totalMarksSort);

        try (PrintWriter writer = new PrintWriter(new File("output.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Rank");
            sb.append(',');
            sb.append("Roll Number");
            sb.append(',');
            sb.append("Total Marks(out of 300)");
            sb.append('\n');

            for (int i = 0; i < deserializedList.size() && i < 5; i++) {
                Student2 s = deserializedList.get(i);

                sb.append(i + 1);
                sb.append(',');
                sb.append(s.rollnum);
                sb.append(',');
                sb.append(s.totalmarks);
                sb.append('\n');

            }

            writer.write(sb.toString());

            System.out.println("CSV File Created!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
