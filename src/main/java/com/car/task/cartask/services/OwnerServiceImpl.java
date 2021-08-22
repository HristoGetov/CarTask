package com.car.task.cartask.services;

import com.car.task.cartask.model.Owner;
import com.car.task.cartask.repositories.OwnerRepository;
import com.car.task.cartask.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> getAllOwners() {
        List<Owner> owners = new ArrayList<>();
        ownerRepository.findAll().forEach(owners :: add);
        return owners;
    }

    @Override
    public Owner getById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner saveOrUpdate(Owner owner) {
        ownerRepository.save(owner);
        return owner;
    }

    @Override
    public void delete(Long id) {
        ownerRepository.deleteById(id);
    }
}
