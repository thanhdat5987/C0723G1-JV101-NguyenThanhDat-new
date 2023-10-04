package case_study.furama.service;

import java.util.LinkedHashMap;
import java.util.List;

public interface IFacilityService<E>extends IService<E> {
LinkedHashMap<E, Integer> displayFacilityMaintenance();
void deleteFacility(E facility);
LinkedHashMap<E,Integer> displayFacility();
}
