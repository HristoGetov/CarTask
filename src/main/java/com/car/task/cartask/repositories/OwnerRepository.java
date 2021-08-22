package com.car.task.cartask.repositories;

import com.car.task.cartask.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
