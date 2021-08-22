package com.car.task.cartask.controllers;

import com.car.task.cartask.model.Car;
import com.car.task.cartask.services.CarService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cars")
public class RestClientController {

    private CarService carService;


    public RestClientController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Car getCar(@PathVariable Long id){
        return carService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Car> getCars(){
        return carService.getAllCars();
    }

    @PostMapping(path = "/add")
    public String addCar(@RequestParam(name = "brand") String brand, @RequestParam(name = "color") String color,
                         @RequestParam(name = "engine_size") double engineSize, @RequestParam(name = "horse_power") int horsePower,
                         @RequestParam(name = "model") String model, @RequestParam(name = "number_of_doors") int numberOfDoor,
                         @RequestParam(name = "reg_number") String regNumber){

        Car car = new Car(brand,regNumber,model,engineSize,horsePower,color,numberOfDoor);
        carService.saveOrUpdate(car);
        return "Car was added";
    }

    @PutMapping(path = "/update/{id}")
    public String updateCar(@PathVariable Long id, @RequestParam(required = false) String brand, @RequestParam(required = false) String color,
                            @RequestParam(required = false) double engineSize, @RequestParam(required = false) int horsePower,
                            @RequestParam(required = false) String model, @RequestParam(required = false) int numberOfDoor,
                            @RequestParam(required = false) String regNumber){
        Car car = carService.getById(id);
        if (brand != null){
            car.setBrand(brand);
        }
        if(color != null){
            car.setColor(color);
        }
        if (engineSize != 0){
            car.setEngineSize(engineSize);
        }
        if (horsePower != 0){
            car.setHorsePower(horsePower);
        }
        if (model != null){
            car.setModel(model);
        }
        if (numberOfDoor != 0){
            car.setNumberOfDoors(numberOfDoor);
        }
        if (regNumber != null){
            car.setRegNumber(regNumber);
        }
        carService.saveOrUpdate(car);
        return "Car was updated";
    }

    @GetMapping(path = "/brand/{brand}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Car> getCarsByBrand(@PathVariable String brand){
        List<Car> cars = new ArrayList<>();
        List<Car> allCars = carService.getAllCars();
        for (int i = 0; i<allCars.size();i++){
            if (allCars.get(i).getBrand().equals(brand)){
                cars.add(allCars.get(i));
            }
        }
        return cars;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCar(@PathVariable Long id){

        try {
            carService.delete(id);
            return "Car was deleted!";
        }catch (Exception ex){
            return "A car with this ID does not exist!";
        }
    }





}
