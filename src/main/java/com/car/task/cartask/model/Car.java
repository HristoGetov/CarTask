package com.car.task.cartask.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;



@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String regNumber;
    private String model;
    private double engineSize;
    private int horsePower;
    private String color;
    private int numberOfDoors;

    @JsonIgnore
    @ManyToOne
    private Owner owner;



    public Car() {
    }

    public Car(String brand, String regNumber, String model, double engineSize, int horsePower, String color, int numberOfDoors) {
        this.brand = brand;
        this.regNumber = regNumber;
        this.model = model;
        this.engineSize = engineSize;
        this.horsePower = horsePower;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
    }



    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", model=" + model.toString()+
                '}';
    }
}
