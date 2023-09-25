package ss_16.bai_tap.file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileText {
    public static final String SOURCE_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/ss_16/bai_tap/file_text/source_file.txt";
    public static final String TARGET_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/ss_16/bai_tap/file_text/target_file11.txt";

    public List<String> readFile(String fileSourcePath) {
        List<String> string = new ArrayList<>();
        try {
            File fileSource = new File(fileSourcePath);
            if (!fileSource.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(fileSource));
            String character = "";
            while ((character = br.readLine()) != null) {
                string.add(character);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File is not exist or faulty contents");
        }
        return string;
    }

    public void copyFile(String fileTargetPath, List<String> string) {
        int count = 0;
        try {
            File fileTarget = new File(fileTargetPath);
            if (fileTarget.exists()) {
                System.out.println("Target file is exist, We will overwrite on this file");
                fileTarget.delete();
                FileWriter writer = new FileWriter(fileTarget, true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                for (String s : string) {
                    for (int j = 0; j < s.length(); j++) {
                        bufferedWriter.write(s.charAt(j));
                        count++;
                    }
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                System.out.println("Copy successfully " + count + " characters");
            } else {
                System.out.println("Target file is not exits");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileText fileCopy = new FileText();
        List<String> stringList = fileCopy.readFile(SOURCE_PATH);
        fileCopy.copyFile(TARGET_PATH, stringList);
    }

}