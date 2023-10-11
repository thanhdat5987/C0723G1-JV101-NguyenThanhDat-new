package bai_3.repository.impl;

import bai_3.model.ElectricalBill;
import bai_3.repository.IElectricalBillRepository;
import bai_3.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class ElectricalBillRepositoryImpl implements IElectricalBillRepository {
    private static final String BILL_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/ThiModule2/src/bai_3/data/hoa_don_tien_dien.csv";
    @Override
    public void addBill(ElectricalBill bill) {
        List<ElectricalBill> bills = readBillFromFile();
        bills.add(bill);
        writeBillToFile(bills);
    }

    @Override
    public List<ElectricalBill> getAllBills() {
        return readBillFromFile();
    }
    public static List<ElectricalBill> readBillFromFile(){
        List<String> data = FileUtil.readFile(BILL_PATH);
        List<ElectricalBill> bills = new ArrayList<>();
        for(String str:data){
            String [] splitedString = str.split(",");
            bills.add(new ElectricalBill(splitedString[0],splitedString[1],splitedString[2],Integer.parseInt(splitedString[3])));
        }
        return bills;
    }
    public static void writeBillToFile(List<ElectricalBill> bills){
        List<String> data = new ArrayList<>();
        for(ElectricalBill bill : bills){
            data.add(bill.getBillId()+","+bill.getCustomerName()+","+bill.getCustomerType()+","+bill.getTargetConsumption());
        }
        FileUtil.writeFile(data, BILL_PATH);
    }
}
