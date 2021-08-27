package com.yang.factory;

import com.yang.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂
 */
public class InstanceCarFactory {
    private Map<Long, Car> carMap;
    public InstanceCarFactory(){
        carMap = new HashMap<>();
        carMap.put(1l,new Car(1l,"大众"));
        carMap.put(2l,new Car(2l,"特斯拉"));
    }

    public Car getCar(long id){
        return carMap.get(id);
    }
}
