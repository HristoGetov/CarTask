package com.car.task.cartask.dataloader;

import com.car.task.cartask.model.Car;
import com.car.task.cartask.model.Owner;
import com.car.task.cartask.repositories.CarRepository;
import com.car.task.cartask.repositories.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public DataLoader(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Car car = new Car("Ford","Ah65787","S-Max",2.0,140,"Blue",5);
        Owner owner = new Owner("Hristo","Getov");

        car.setOwner(owner);
        Set<Car> cars = new HashSet<>();
        cars.add(car);
        owner.setCars(cars);
        ownerRepository.save(owner);
        carRepository.save(car);

        Car car2 = new Car("Fiat","Ah65782","Punto",1.2,80,"Red",3);
        carRepository.save(car2);

        Car car3 = new Car("Mazda","Ah657122","6",1.8,150,"Red",5);
        carRepository.save(car3);
        Car car4 = new Car("Opel","Ah657122","Vectra",2.0,140,"White",5);
        carRepository.save(car4);
        Car car5 = new Car("Dacia","Ah6512782","Logan",1.2,80,"Red",5);
        carRepository.save(car5);
        Car car6 = new Car("Mitsubishi","Ah65122","Lancer",1.8,150,"Metal",5);
        carRepository.save(car5);



    }
}
