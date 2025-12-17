package org.example;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        try (PrintWriter printWriter = new PrintWriter("C:\\Users\\Asus\\Desktop\\УЧОБА\\ВУЗ_2 курс\\компГафика\\CGVSU-main\\Task2\\myObjWriter\\src\\main\\testOutput.txt")) {
            String text = "попка";
            printWriter.println(text);
        }
    }
}