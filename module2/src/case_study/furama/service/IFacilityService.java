package case_study.furama.service;

import java.util.List;

public interface IFacilityService<E>extends IService<E> {
List<E> displayFacilityMaintenance();
void deleteFacility(int index);
}
