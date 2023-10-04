package case_study.furama.repository.impl;

import case_study.furama.model.Facility;
import case_study.furama.model.House;
import case_study.furama.model.Room;
import case_study.furama.model.Villa;
import case_study.furama.repository.IFacilityRepository;

import java.util.LinkedHashMap;
import java.util.List;

public class FacilityRepositoryImpl implements IFacilityRepository<Facility> {
    private static final LinkedHashMap<Facility, Integer> facilityLinkedHashMap = new LinkedHashMap<>();
    static {
        Villa villa1 = new Villa("SVVL-0001","Thue",30,100,10,"Day","Vip",30,2);
        facilityLinkedHashMap.put(villa1,5);
        Villa villa2 = new Villa("SVVL-0002","Thue",30,100,15,"Night","Vip",30,2);
        facilityLinkedHashMap.put(villa2,5);
        Villa villa3 = new Villa("SVVL-0003","Thue",30,100,15,"Week","Normal",40,3);
        facilityLinkedHashMap.put(villa3,2);
        House house1 = new House("SVHO-0001","Thue",30,100,15,"Week","Normal",3);
        facilityLinkedHashMap.put(house1,5);
        House house2 = new House("SVHO-0001","Thue",30,100,15,"Week","Normal",3);
        facilityLinkedHashMap.put(house2,1);
        Room room1 = new Room("SVRO-0001","Thue",30,100,15,"Week","Massage");
        facilityLinkedHashMap.put(room1,1);
    }
    @Override
    public LinkedHashMap<Facility, Integer> displayFacilityMaintenance() {
        return facilityLinkedHashMap;
    }

    @Override
    public void deleteFacility(Facility facility) {
facilityLinkedHashMap.remove(facility);
    }

    @Override
    public LinkedHashMap<Facility, Integer> displayFacility() {
        return facilityLinkedHashMap;
    }

    @Override
    public void add(Facility facility) {
            facilityLinkedHashMap.put(facility, 0);
    }

    @Override
    public List<Facility> display() {
        return null;
    }
}
