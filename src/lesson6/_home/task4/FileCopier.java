package lesson6._home.task4;

import java.io.*;

public class FileCopier implements Runnable {
    private File[] fileArray;
    private String dstPath;

    public FileCopier() {
    }

    public FileCopier(File[] fileArray, String dstPath) {
        this.fileArray = fileArray;
        setDstPath(dstPath);
    }

    public File[] getFileArray() {
        return fileArray;
    }

    public void setFileArray(File[] fileArray) {
        this.fileArray = fileArray;
    }

    public String getDstPath() {
        return dstPath;
    }

    public void setDstPath(String dstPath) {
        if(dstPath != null) {
            this.dstPath = dstPath;
        } else {
            System.out.println("Destination path can't be null");
            System.exit(1);
        }
    }

    public void copy() {
        for (File file : this.fileArray) {
            if(file == null) {
                continue;
            }
            File dstFile = new File(this.dstPath + file.getName());
            copy(file, dstFile);
            System.out.println("File copied: " + file.getName());
        }
    }

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

    @Override
    public void run() {
        this.copy();
    }
}
