package com.yang.factory;

import com.yang.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 正常使用静态工厂的方式创建对象
 */
public class StaticCarFactory {
    private static Map<Long, Car> carMap;
    static {
        carMap = new HashMap<Long, Car>();
        carMap.put(1L,new Car(1L,"宝马"));
        carMap.put(2L,new Car(2L,"奔驰"));
    }

    //提供一个方法提供外部获取car的方法
    public static Car getCar(long id){
        return carMap.get(id);
    }
}
