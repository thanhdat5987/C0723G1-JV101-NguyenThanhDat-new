package bai_3.controller;

import bai_3.model.ElectricalBill;
import bai_3.service.IElectricalBillService;
import bai_3.service.impl.ElectricalBillServiceImpl;

import java.util.List;

public class ElectricalBillController {
   private static final IElectricalBillService electricalBillService = new ElectricalBillServiceImpl();
    public void addBill(ElectricalBill bill) {
        electricalBillService.addBill(bill);
    }


    public List<ElectricalBill> getAllBills() {
        return electricalBillService.getAllBills();
    }
}
