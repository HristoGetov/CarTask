package com.car.task.cartask.repositories;

import com.car.task.cartask.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
