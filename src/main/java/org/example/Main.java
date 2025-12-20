package org.example;

import math.Vector2f;
import math.Vector3f;
import model.Model;
import readerTeacher.ObjReader;
import readerTeacher.ObjReaderException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.Polygon;
import writer.objWriter;

public class Main {


    public static void main(String[] args) throws IOException {

        String path1 = "C:\\Users\\Asus\\Downloads\\Torus (1).obj";
        String pathToSave = "C:\\Users\\Asus\\Desktop\\торус_мой.obj";

        String fileContent = new String(Files.readAllBytes(Paths.get(path1)));
        Model teapot = ObjReader.read(fileContent);

        objWriter writer = new objWriter();
        writer.write(teapot,pathToSave);

/*
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

        //полный полигон из всего

        Polygon p4 = new Polygon();
        ArrayList<Integer> vertexIndices4 = new ArrayList<>();
        ArrayList<Integer> textVertexIndices4 = new ArrayList<>();
        ArrayList<Integer> normalIndices4 = new ArrayList<>();


        vertexIndices4.add(0);
        vertexIndices4.add(1);
        vertexIndices4.add(2);

        textVertexIndices4.add(0);
        textVertexIndices4.add(1);
        textVertexIndices4.add(2);

        normalIndices4.add(0);
        normalIndices4.add(1);
        normalIndices4.add(2);

        p4.setVertexIndices(vertexIndices4);
        p4.setNormalIndices(normalIndices4);
        p4.setTextureVertexIndices(textVertexIndices4);

        model.polygons.add(p4);

        objWriter writer = new objWriter();
        writer.write(model,path);
*/

    }
}