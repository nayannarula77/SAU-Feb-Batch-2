package javamultithreadingq2;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class JavaMultithreadingQ2 {

    static final int OUT = 0;
    static final int IN = 1;

    //Word count function
    static int countWords(String str) {
        int state = OUT;
        int wc = 0;  
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == ' ' || str.charAt(i) == '\n'
                    || str.charAt(i) == '\t') {
                state = OUT;
            }
            else if (state == OUT) {
                state = IN;
                ++wc;
            }
            ++i;
        }
        return wc;
    }

    
    static int counter1 = 0, counter2 = 0, counter3 = 0, maincounter = 0, filelinecount = 0;

    public static void main(String[] args) throws InterruptedException {

        
        //Counting words without threads
        long start = System.currentTimeMillis();
        try {
            FileInputStream fis = new FileInputStream("Demo.txt");
            Scanner sc = new Scanner(fis);   
            while (sc.hasNextLine()) {
                maincounter += countWords(sc.nextLine());
                filelinecount++;
            }
            sc.close();    
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken without threads= "
                + (end - start) + "ms");
        System.out.println("No. of words =" + maincounter);
        System.out.println("No. of lines= " + filelinecount);

                //Counting words with threads
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream fis = new FileInputStream("Demo.txt");
                    Scanner sc = new Scanner(fis);    //file to be scanned  
                    int i = 0;
                    while (sc.hasNextLine() && i < filelinecount / 2) {
                        counter1 += countWords(sc.nextLine());
                        i++;
                    }
                    sc.close();   
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream fis = new FileInputStream("Demo.txt");

                    Scanner sc = new Scanner(fis);    
                    int j = 0;

                    while (sc.hasNextLine()) {
                        if (j >= filelinecount / 2) {
                            counter2 += countWords(sc.nextLine());
                        } else {
                            sc.nextLine();
                        }
                        j++;
                    }
                    sc.close();     
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();

        System.out.println();
        System.out.println("Time taken with 2 threads= "
                + (end - start) + "ms");
        System.out.println("No.of words=" + (counter1 + counter2));
        System.out.println("No. of lines= " + filelinecount);

    }

}
