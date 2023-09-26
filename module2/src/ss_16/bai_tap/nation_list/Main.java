package ss_16.bai_tap.nation_list;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String COUNTRY_LIST = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/ss_16/bai_tap/nation_list/country_list.csv";

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(COUNTRY_LIST));
            while ((line = br.readLine()) != null) {
                displayCountry(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void displayCountry(String csvLine) {
        String[] countryArray;
        if (csvLine != null) {
            countryArray = csvLine.split(",");
            System.out.println("id= " + countryArray[0] + ", code= " + countryArray[1] + ", name= " + countryArray[2]);
        }
    }
}
