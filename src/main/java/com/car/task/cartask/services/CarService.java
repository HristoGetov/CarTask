package com.car.task.cartask.services;

import com.car.task.cartask.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();
    Car getById(Long id);
    Car saveOrUpdate(Car car);
    void delete(Long id);
}
