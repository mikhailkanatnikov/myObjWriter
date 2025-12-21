package writer;
import math.Vector2f;
import math.Vector3f;
import model.Model;
import model.Polygon;
import org.junit.Test;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.*;

import static org.junit.Assert.*;
public class objWriterTest {
    @Test
    public void testEmptyModel() throws Exception {
        Model model = new Model();
        String fileName = "test.obj";

        objWriter writer = new objWriter();
        writer.write(model, fileName);

        File outputFile = new File(fileName);
        assertTrue("Файл должен существовать", outputFile.exists());

        // Удали файл после теста
        outputFile.delete();
    }

    @Test
    public void testSingleVertex() throws Exception {
        Vector3f v1 = new Vector3f(1,2,3);
        Model model = new Model();
        model.vertices.add(v1);

        String fileName = "testSingle_Vertex.obj";
        objWriter writer = new objWriter();
        writer.write(model,fileName);

        String content = new String(Files.readAllBytes(Paths.get(fileName)));

        assertTrue("Должно записаться v 1.0 2.0 3.0",content.contains("v 1.0 2.0 3.0"));

        new File(fileName).delete();

    }

    @Test
    public void testPolygonOnlyVertex() throws Exception{
        Model model = new Model();
        Vector3f v1 = new Vector3f(1,2,3);
        Vector3f v2 = new Vector3f(4,5,6);
        Vector3f v3 = new Vector3f(7,8,9);
        Vector3f v4 = new Vector3f(10,11,12);

        Polygon p1 = new Polygon();
        model.vertices.add(v1);
        model.vertices.add(v2);
        model.vertices.add(v3);
        model.vertices.add(v4);

        ArrayList<Integer> vertexes= new ArrayList<>();
        vertexes.add(0);
        vertexes.add(1);
        vertexes.add(2);
        vertexes.add(3);

        p1.setVertexIndices(vertexes);

        model.polygons.add(p1);

        objWriter writer = new objWriter();
        String filePath = "vertexPolygon.obj";
        writer.write(model,filePath);

        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        assertTrue("Должно быть f 1 2 3 4",content.contains("f 1 2 3 4"));
        new File(filePath).delete();


    }

    @Test
    public void testPolygonVertexAndTexture() throws Exception{
        Model model = new Model();

        Vector3f v1 = new Vector3f(1,2,3);
        Vector3f v2 = new Vector3f(4,5,6);
        Vector3f v3 = new Vector3f(7,8,9);

        Vector2f vt1 = new Vector2f(1,2);
        Vector2f vt2 = new Vector2f(3,4);
        Vector2f vt3 = new Vector2f(5,6);

        model.vertices.add(v1);
        model.vertices.add(v2);
        model.vertices.add(v3);
        model.textureVertices.add(vt1);
        model.textureVertices.add(vt2);
        model.textureVertices.add(vt3);

        Polygon p2 = new Polygon();

        ArrayList<Integer> vertex = new ArrayList<>();
        vertex.add(0);
        vertex.add(1);
        vertex.add(2);
        p2.setVertexIndices(vertex);

        ArrayList<Integer> textVertexes = new ArrayList<>();
        textVertexes.add(0);
        textVertexes.add(1);
        textVertexes.add(2);
        p2.setTextureVertexIndices(textVertexes);

        model.polygons.add(p2);

        objWriter writer = new objWriter();
        String filePath = "vertexAndTexturePolygon.obj";
        writer.write(model,filePath);

        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        assertTrue("Должно быть f 1/1 2/2 3/3",content.contains("f 1/1 2/2 3/3"));
        new File(filePath).delete();


    }


    @Test
    public void testPolygonVertexAndNormals() throws Exception{
        Model model = new Model();

        Vector3f v1 = new Vector3f(1,2,3);
        Vector3f v2 = new Vector3f(4,5,6);
        Vector3f v3 = new Vector3f(7,8,9);

        Vector3f vn1 = new Vector3f(1,2,3);
        Vector3f vn2 = new Vector3f(4,5,6);
        Vector3f vn3 = new Vector3f(7,8,9);

        model.vertices.add(v1);
        model.vertices.add(v2);
        model.vertices.add(v3);
        model.normals.add(vn1);
        model.normals.add(vn2);
        model.normals.add(vn3);

        Polygon p3 = new Polygon();

        ArrayList<Integer> vertex = new ArrayList<>();
        vertex.add(0);
        vertex.add(1);
        vertex.add(2);
        p3.setVertexIndices(vertex);

        ArrayList<Integer> normals = new ArrayList<>();
        normals.add(0);
        normals.add(1);
        normals.add(2);
        p3.setNormalIndices(normals);

        model.polygons.add(p3);

        objWriter writer = new objWriter();
        String filePath = "vertexAndNormalsPolygon.obj";
        writer.write(model,filePath);

        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        assertTrue("Должно быть f 1//1 2//2 3//3",content.contains("f 1//1 2//2 3//3"));
        new File(filePath).delete();

    }

    @Test
    public void testFullPolygon() throws Exception{

        Model model = new Model();

        Vector3f v1 = new Vector3f(1,2,3);
        Vector3f v2 = new Vector3f(4,5,6);
        Vector3f v3 = new Vector3f(7,8,9);

        Vector3f vn1 = new Vector3f(1,2,3);
        Vector3f vn2 = new Vector3f(4,5,6);
        Vector3f vn3 = new Vector3f(7,8,9);

        Vector2f vt1 = new Vector2f(1,2);
        Vector2f vt2 = new Vector2f(3,4);
        Vector2f vt3 = new Vector2f(5,6);

        model.vertices.add(v1);
        model.vertices.add(v2);
        model.vertices.add(v3);
        model.textureVertices.add(vt1);
        model.textureVertices.add(vt2);
        model.textureVertices.add(vt3);
        model.normals.add(vn1);
        model.normals.add(vn2);
        model.normals.add(vn3);

        Polygon p4 = new Polygon();
        ArrayList<Integer> vertexes = new ArrayList<>();
        vertexes.add(0);
        vertexes.add(1);
        vertexes.add(2);
        p4.setVertexIndices(vertexes);

        ArrayList<Integer> TextVertexes = new ArrayList<>();
        TextVertexes.add(0);
        TextVertexes.add(1);
        TextVertexes.add(2);
        p4.setTextureVertexIndices(TextVertexes);

        ArrayList<Integer> normalInd = new ArrayList<>();
        normalInd.add(0);
        normalInd.add(1);
        normalInd.add(2);
        p4.setNormalIndices(normalInd);

        model.polygons.add(p4);

        objWriter writer = new objWriter();
        String filePath = "fullPolygon.obj";
        writer.write(model,filePath);

        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        assertTrue("Должно быть f 1/1/1 2/2/2 3/3/3",content.contains("f 1/1/1 2/2/2 3/3/3"));
        new File(filePath).delete();





    }


  
}