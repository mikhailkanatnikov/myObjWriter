package org.example;

import math.Vector3f;
import model.Model;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import writer.objWriter;

public class Main {


    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Asus\\Desktop\\УЧОБА\\ВУЗ_2 курс\\компГрафика\\CGVSU-main\\Task2\\myObjWriter\\src\\main\\testOutput.txt";


        Model model = new Model();
        Vector3f v1 = new Vector3f(1,2,3);
        Vector3f v2 = new Vector3f(4,5,6);

        model.vertices.add(v1);
        model.vertices.add(v2);

        objWriter writer = new objWriter();
        writer.write(model,path);


    }
}