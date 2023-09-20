package org.example.raffleView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface IViewOut extends IViewBace{
    String TRYAGAINRU = "Попробуйте ещё раз. ";
    default void showString(String s){
        System.out.print(s);
    }

    default void saveResult(String text, String fileName, boolean append) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter(fileName, append)) {
            fw.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
