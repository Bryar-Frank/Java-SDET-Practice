package com.skillstorm.hello_spring_boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.skillstorm.hello_spring_boot.beans.Car;
import com.skillstorm.hello_spring_boot.beans.ElectricEngine;
import com.skillstorm.hello_spring_boot.beans.Vehicle;
import com.skillstorm.hello_spring_boot.beans.Engine;
import com.skillstorm.hello_spring_boot.beans.GasEngine;

@Configuration
public class CarConfiguration {
    /*
     * where we can config our car beans: tells SpringBoot:
     *      - where to get our beans from
     *      - how to initialize them
     * 
     * @BEAN
     *      - register the bean inside the BeanFactory
     *      - needs to be used on every bean created
     *      - so we can get beans whenever we are asked for them
     * 
     * @SCOPE - tells Spring what kind of bean you want
     *      BEAN SCOPES:
     *          *singleton - each bean will be the same object (default)
     *          prototype - each bean will be different
     *          application - creates a bean for entire application lifespan
     *          *request - creates a bean for lifespan of an HTTP request
     *          *session - creates bean for lifespan of user's session
     *          websocket - create a bean for lifespan of web socket
     *          (* most likely to use)
     */
    @Bean(name = {"mustang", "camaro"})
    @Scope("prototype") // each bean will be different object
    public Vehicle gasCar() {
        Car car = new Car();
        car.setEngine(gasEngine());
        return car;
    }

    @Bean(name = "tesla")
    @Scope("singleton") // default
    public Vehicle electricCar() {
        Car car = new Car(electricEngine());
        return car;
    }

    @Bean
    public Engine gasEngine() {
        return new GasEngine();
    }

    @Bean
    public Engine electricEngine() {
        return new ElectricEngine();
    }
}
