package bai_3.service.impl;

import bai_3.model.ElectricalBill;
import bai_3.repository.IElectricalBillRepository;
import bai_3.repository.impl.ElectricalBillRepositoryImpl;
import bai_3.service.IElectricalBillService;

import java.util.List;

public class ElectricalBillServiceImpl implements IElectricalBillService {
    private static final IElectricalBillRepository electricalBillRepository = new ElectricalBillRepositoryImpl();

    @Override
    public void addBill(ElectricalBill bill) {
        electricalBillRepository.addBill(bill);
    }

    @Override
    public List<ElectricalBill> getAllBills() {
        return electricalBillRepository.getAllBills();
    }
}
