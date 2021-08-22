package com.car.task.cartask.services;

import com.car.task.cartask.model.Car;
import com.car.task.cartask.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{


    private CarRepository carRepository;


    public CarServiceImpl( CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public Car getById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (!optionalCar.isPresent()){
            throw new RuntimeException("Car not found!");
        }
        return optionalCar.get();
    }

    @Override
    public Car saveOrUpdate(Car car) {
        carRepository.save(car);
        return car;
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
