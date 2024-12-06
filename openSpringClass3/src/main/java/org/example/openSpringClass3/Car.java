package org.example.openSpringClass3;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "manofacturerYear")
    private Integer year;
    private String model;
    private String manofacturer;

    public Car() {
    }

    public Car(Long id, Integer year, String model, String manofacturer) {
        this.id = id;
        this.year = year;
        this.model = model;
        this.manofacturer = manofacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManofacturer() {
        return manofacturer;
    }

    public void setManofacturer(String manofacturer) {
        this.manofacturer = manofacturer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", year=" + year +
                ", model='" + model + '\'' +
                ", manofacturer='" + manofacturer + '\'' +
                '}';
    }
}
