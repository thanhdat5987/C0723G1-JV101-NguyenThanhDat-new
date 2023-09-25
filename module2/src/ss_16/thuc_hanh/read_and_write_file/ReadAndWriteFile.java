package ss_16.thuc_hanh.read_and_write_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public static final String NUMBER_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/ss_16/thuc_hanh/read_and_write_file/numbers.txt";
    public static final String RESULT_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/ss_16/thuc_hanh/read_and_write_file/result.txt";

    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File is not exist or error");
        }
        return numbers;
    }
    public void writeFile(String filePath, int max){
        try{
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Max value is: "+max);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static int findMax(List<Integer> numbers){
        int max = numbers.get(0);
        for(int i =0;i< numbers.size(); i++){
            if(max<numbers.get(i)){
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile(NUMBER_PATH);
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile(RESULT_PATH, maxValue);
    }
}

