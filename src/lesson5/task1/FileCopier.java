package lesson5.task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

/**
 * Created by artem on 30.01.17.
 */


public class FileCopier {

    public static void copy(String src, String dst) {
        if(src != null && dst != null) {
            copy(new File(src), new File(dst));
        }
    }

    public static void copy(File src, File dst) {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dst)) {
            byte[] buffer = new byte[1024];
            int byteread = 0;
            for (; (byteread = fis.read(buffer)) > 0;) {
                fos.write(buffer, 0, byteread);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}