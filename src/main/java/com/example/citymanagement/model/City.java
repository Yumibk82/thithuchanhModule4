package com.example.citymanagement.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;
    @NotEmpty
    private String cityName;
//    @Min(value = 0,message = "require positive number")
    @NotNull
    private Double area;
//    @Min(value = 0,message = "require positive number")
    @NotNull
    private Integer population;
//    @Min(value = 0,message = "require positive number")
    @NotNull
    private Double gdp;
    private String description;
    @ManyToOne
    @JoinColumn()
    private Nation national;

    @Override
    public boolean supports(Class<?> clazz) {
        return City.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        City city = (City) target;
        Double area = city.getArea();
        Integer population = city.getPopulation();
        Double gdp = city.getGdp();

        if (area.doubleValue() < 0) {
            errors.rejectValue("area", "area.value");
        }
        if (population.intValue() < 0) {
            errors.rejectValue("population", "population.value");
        }
        if (gdp.doubleValue() < 0) {
            errors.rejectValue("gdp", "gdp.value");
        }
    }
}
