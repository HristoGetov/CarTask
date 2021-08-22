package com.car.task.cartask.services;

import com.car.task.cartask.model.Car;
import com.car.task.cartask.model.Owner;

import java.util.List;

public interface OwnerService {

    List<Owner> getAllOwners();
    Owner getById(Long id);
    Owner saveOrUpdate(Owner owner);
    void delete(Long id);
}
