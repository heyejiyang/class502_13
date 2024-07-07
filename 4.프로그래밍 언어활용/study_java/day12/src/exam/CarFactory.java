package exam;

import java.util.HashMap;

public class CarFactory {

    private HashMap<String,Car> carMap = new HashMap<>();// 차 이름이 키값, 객체가 value값
    private static CarFactory instance;

    private CarFactory(){}

    public static CarFactory getInstance(){
        if(instance == null){
            instance = new CarFactory();
        }
        return instance;
    }


    public Car createCar(String carName){
        if( carMap.containsKey(carName) ) {
            return carMap.get(carName);
        }
        Car car = new Car();
        carMap.put(carName, car);
        return car;

    }

}
