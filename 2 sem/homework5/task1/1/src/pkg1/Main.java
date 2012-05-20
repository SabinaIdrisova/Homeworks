package pkg1;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String str = " ";
        Scanner in = new Scanner(new File("C:/Users/1/Documents/NetBeansProjects/1/src/pkg1/input.txt"));
        while (in.hasNext())
            str += in.next();
        in.close();
        StringBuffer s = new StringBuffer(str);
        TreeElement node = null;
        s.deleteCharAt(0);
        switch (s.charAt(1)) {
            case '+':
                node = new Addition(s);
                break;
            case '-':
                node = new Substraction(s);
                break;
            case '*':
                node = new Multiplication(s);
                break;
            case '/':
                node = new Division(s);
                break;
        }
        int r = node.calculate(); 
        System.out.println("result = " + r);
        node.print();
    }
}