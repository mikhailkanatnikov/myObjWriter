package writer;

import math.Vector2f;
import math.Vector3f;
import model.Model;
import model.Polygon;

import java.io.IOException;
import java.io.PrintWriter;

public class objWriter {

    public String filePath = "C:\\Users\\Asus\\Desktop\\УЧОБА\\ВУЗ_2 курс\\компГрафика\\CGVSU-main\\Task2\\myObjWriter\\src\\main\\testOutput.txt";


    public void write(Model model, String path) throws IOException {


        try (PrintWriter writer = new PrintWriter(filePath)) {

            //вершины v
            for (Vector3f v : model.vertices) {
                writer.println("v " + v.getX() + " " + v.getY() + " " + v.getZ());
            }

            //текстуры vt
            if (!model.textureVertices.isEmpty()) {
                for (Vector2f vt : model.textureVertices) {
                    writer.println("vt " + vt.getX() + " " + vt.getY());
                }
            }

            //нормали vn
            if (!model.normals.isEmpty()) {
                for (Vector3f vn : model.normals) {
                    writer.println("vn " + vn.getX() + " " + vn.getY() + " " + vn.getZ());
                }
            }

            //ПОЛИГОНЫ
            for (Polygon pol : model.polygons) {

                //состоит только из вершин
                if (pol.getTextureVertexIndices().isEmpty() && pol.getNormalIndices().isEmpty()) {
                    writer.print("f ");
                    for (int v : pol.getVertexIndices()) {
                        writer.print((v + 1) + " ");
                    }
                    writer.println();

                }

                //вершины + текстуры
                if (!pol.getTextureVertexIndices().isEmpty() && pol.getNormalIndices().isEmpty()) {
                    writer.print("f ");
                    for (int i = 0; i < pol.getVertexIndices().size(); i++) {
                        int verIndex = pol.getVertexIndices().get(i) + 1;
                        int textIndex = pol.getTextureVertexIndices().get(i) + 1;
                        writer.print(verIndex + "/" + textIndex + " ");
                    }
                    writer.println();
                }

                //вершины + нормали
                if (pol.getTextureVertexIndices().isEmpty() && !pol.getNormalIndices().isEmpty()) {
                    writer.print("f ");
                    for (int i = 0; i < pol.getVertexIndices().size(); i++) {
                        int verInd = pol.getVertexIndices().get(i) + 1;
                        int normInd = pol.getNormalIndices().get(i) + 1;
                        writer.print(verInd + "//" + normInd + " ");
                    }
                    writer.println();
                }

                //вершины + текстуры + нормали
                if (!pol.getTextureVertexIndices().isEmpty() && !pol.getNormalIndices().isEmpty()) {
                    writer.print("f ");
                    for (int i = 0; i < pol.getVertexIndices().size(); i++) {
                        int ver = pol.getVertexIndices().get(i) + 1;
                        int verTex = pol.getTextureVertexIndices().get(i) + 1;
                        int normInd = pol.getNormalIndices().get(i) + 1;
                        writer.print(ver + "/" + verTex + "/" + normInd + " ");
                    }
                    writer.println();
                }
            }


        }


    }
}
