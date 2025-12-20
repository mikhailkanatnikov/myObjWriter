package org.example;

import math.Vector2f;
import math.Vector3f;
import model.Model;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.Polygon;
import writer.objWriter;

public class Main {


    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Asus\\Desktop\\УЧОБА\\ВУЗ_2 курс\\компГрафика\\CGVSU-main\\Task2\\myObjWriter\\src\\main\\testOutput.txt";


        Model model = new Model();

        //вершины
        Vector3f v1 = new Vector3f(1,2,3);
        Vector3f v2 = new Vector3f(4,5,6);
        Vector3f v3 = new Vector3f(7,3,5);
        Vector3f v4 = new Vector3f(8,7,2);

        //текстуры
        Vector2f vt1 = new Vector2f(7,8);
        Vector2f vt2 = new Vector2f(9,10);
        Vector2f vt3 = new Vector2f(11,12);

        //нормали
        Vector3f vn1 = new Vector3f(13,14,15);
        Vector3f vn2 = new Vector3f(16,17,18);
        Vector3f vn3 = new Vector3f(2,4,1);

        model.vertices.add(v1);
        model.vertices.add(v2);
        model.vertices.add(v3);
        model.vertices.add(v4);

        model.textureVertices.add(vt1);
        model.textureVertices.add(vt2);
        model.textureVertices.add(vt3);

        model.normals.add(vn1);
        model.normals.add(vn2);
        model.normals.add(vn3);

        //полигон только из вершин
        Polygon p1 = new Polygon();
        ArrayList<Integer> vertexIndices1 = new ArrayList<>();
        vertexIndices1.add(0);
        vertexIndices1.add(1);
        vertexIndices1.add(2);
        p1.setVertexIndices(vertexIndices1);

        model.polygons.add(p1);

        //полигон из вершин + текстур
        Polygon p2 = new Polygon();
        ArrayList<Integer> vertexIndices2 = new ArrayList<>();
        ArrayList<Integer> textInd2 = new ArrayList<>();
        vertexIndices2.add(0);
        vertexIndices2.add(1);
        vertexIndices2.add(3);

        textInd2.add(0);
        textInd2.add(1);
        textInd2.add(2);
        p2.setVertexIndices(vertexIndices2);
        p2.setTextureVertexIndices(textInd2);

        model.polygons.add(p2);

        //полигон вершины + нормали
        Polygon p3 = new Polygon();
        ArrayList<Integer> vertexIndices3 = new ArrayList<>();
        ArrayList<Integer> normalIndices = new ArrayList<>();

        vertexIndices3.add(0);
        vertexIndices3.add(1);
        vertexIndices3.add(2);

        normalIndices.add(0);
        normalIndices.add(1);
        normalIndices.add(2);

        p3.setVertexIndices(vertexIndices3);
        p3.setNormalIndices(normalIndices);

        model.polygons.add(p3);

        objWriter writer = new objWriter();
        writer.write(model,path);


    }
}