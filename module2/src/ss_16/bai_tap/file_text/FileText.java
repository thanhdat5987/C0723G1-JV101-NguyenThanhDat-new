package ss_16.bai_tap.file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileText {

    public List<String> readFile(String filePath) {
        List<String> string = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String character = "";
            while ((character = br.readLine()) != null) {
                string.add(character);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File is not exist or error");
        }
        return string;
    }
    public void copyFile(String filePath, List<String> string){
        int count =0;
        try{
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i=0; i<string.size();i++) {
                bufferedWriter.write(string.get(i));
                count++;
            }
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("Copy successfully "+count+" characters");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileText fileCopy = new FileText();
        List<String> strings = fileCopy.readFile("/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/ss_16/bai_tap/file_text/source_file.txt");
        fileCopy.copyFile("/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/ss_16/bai_tap/file_text/target_file.txt",strings);
    }

}