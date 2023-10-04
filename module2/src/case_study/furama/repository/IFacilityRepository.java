package case_study.furama.repository;

import java.util.LinkedHashMap;
import java.util.List;

public interface IFacilityRepository<E>extends IRepository<E>{
LinkedHashMap<E,Integer> displayFacilityMaintenance();
void deleteFacility(E facility);
LinkedHashMap<E,Integer> displayFacility();

}
