package ss_16.bai_tap.file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileText {
    private static final String SOURCE_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/ss_16/bai_tap/file_text/source_file.txt";
    private static final String TARGET_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/ss_16/bai_tap/file_text/target_file.txt";

    public List<String> readFile(String fileSourcePath) {
        List<String> string = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            File fileSource = new File(fileSourcePath);
            if (!fileSource.exists()) {
                throw new FileNotFoundException();
            }
            bufferedReader = new BufferedReader(new FileReader(fileSource));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                string.add(line);
            }
        } catch (Exception e) {
            System.out.println("File is not exist or faulty contents");
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return string;
    }

    public void copyFile(String fileTargetPath, List<String> string) {
        int count = 0;
        BufferedWriter bufferedWriter = null;
        try {
            File fileTarget = new File(fileTargetPath);
            if (fileTarget.exists()) {
                System.out.println("Target file is exist, We will overwrite on this file");
                fileTarget.delete();
                FileWriter writer = new FileWriter(fileTarget, true);
                bufferedWriter = new BufferedWriter(writer);
                for (String s : string) {
                    for (int j = 0; j < s.length(); j++) {
                        bufferedWriter.write(s.charAt(j));
                        count++;
                    }
                    bufferedWriter.newLine();
                }

            } else {
                System.out.println("Target file is not exits");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                    System.out.println("Copy successfully " + count + " characters");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileText fileCopy = new FileText();
        List<String> stringList = fileCopy.readFile(SOURCE_PATH);
        fileCopy.copyFile(TARGET_PATH, stringList);
    }

}