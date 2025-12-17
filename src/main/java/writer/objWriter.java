package writer;

import math.Vector3f;
import model.Model;

import java.io.IOException;
import java.io.PrintWriter;

public class objWriter {

    public String filePath = "C:\\Users\\Asus\\Desktop\\УЧОБА\\ВУЗ_2 курс\\компГрафика\\CGVSU-main\\Task2\\myObjWriter\\src\\main\\testOutput.txt";


    public void write(Model model, String path) throws IOException {

        //вершины v
        for (Vector3f v : model.vertices) {
            try (PrintWriter writer = new PrintWriter(filePath)) {

            }


        }


    }
}
