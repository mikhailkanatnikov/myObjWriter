package writer;

import math.Vector2f;
import math.Vector3f;
import model.Model;

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


        }


    }
}
