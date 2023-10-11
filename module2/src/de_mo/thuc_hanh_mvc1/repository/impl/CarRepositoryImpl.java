package de_mo.thuc_hanh_mvc1.repository.impl;

import de_mo.thuc_hanh_mvc1.model.Car;
import de_mo.thuc_hanh_mvc1.repository.ICarRepository;
import de_mo.thuc_hanh_mvc1.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements ICarRepository {
    private static final String path = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/de_mo/thuc_hanh_mvc1/data/carlist.csv";

    private List<Car> readCarFromFile() {
        List<String> data = FileUtil.readFile(path);
        List<Car> listCars = new ArrayList<>();
        for (String str : data) {
            String[] strSplit = str.split(",");
            listCars.add(new Car(strSplit[0], strSplit[1], Integer.parseInt(strSplit[2])));
        }
        return listCars;
    }

    private void writeCarToFile(List<Car> listCars) {
        List<String> data = new ArrayList<>();
        for (Car car : listCars) {
            data.add(car.getCarId() + "," + car.getCarName() + "," + car.getPrice());
        }
        FileUtil.writeFile(data, path);
    }

    @Override
    public void addCar(Car car) {
        List<Car> listCars = readCarFromFile();
        listCars.add(car);
        writeCarToFile(listCars);
    }

    @Override
    public List<Car> getListCar() {
        return readCarFromFile();
    }

    @Override
    public Car getCar(int index) {
        return null;
    }

    @Override
    public void deleteCar(int index) {
        List<Car> listCars = readCarFromFile();
        listCars.remove(index);
        writeCarToFile(listCars);
    }

    @Override
    public void editCar(int index, Car car) {

    }
}
