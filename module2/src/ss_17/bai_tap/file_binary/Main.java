package ss_17.bai_tap.file_binary;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static void copyFileUsingByteStream(File source, File dest) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        int countByte = 0;
        try {
            if (!source.exists()) {
                throw new FileNotFoundException();
            }
            if (!dest.exists()) {
                throw new IOException();
            } else {
                System.out.println("Dest file is exist, we over write on this file");
                inputStream = new FileInputStream(source);
                outputStream = new FileOutputStream(dest);
                byte[] buffer = new byte[1];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                    countByte++;
                }
                System.out.println("Copy completed, total byte is: " + countByte);
            }

        } catch (IOException e) {
            System.out.println(" Dest file is not exist");
        } catch (Exception e) {
            System.out.println(" Source File is not exist");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter source path");
        String sourcePath = in.nextLine();
        System.out.printf("Enter dest path");
        String destPath = in.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            copyFileUsingByteStream(sourceFile, destFile);
        } catch (IOException ioe) {
            System.out.println("Can't copy");
            System.out.println(ioe.getMessage());
        }
    }
}
