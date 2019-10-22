package com.ms_1.controllers;

import com.ms_1.dto.Baby;
import com.ms_1.dto.Car;
import com.ms_1.dto.SeralizedCar;
import com.ms_1.dto.Toy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

@RestController
public class MyRestController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting() {
        return "Hello!";
    }

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public Car getCar() {
        return new Car();
        // Output: {"name":null,"model":null,"age":0,"tireWear":0.0,"type":"\u0000","engineWear":0.0,"totalWear":0.0}
    }


    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List getCars() {
        List cars = new LinkedList<Car>();

        cars.add(new Car("Ford" , "T410" , 60, 6.4 , 'T' , 7.6f , 4.3));
        cars.add(new Car("Ford" , "T415" , 67, 3.2 , 'T' , 5.6f , 7.3));
        return cars;
        // Output: [
        // {"name":"Ford","model":"T410","age":60,"tireWear":6.4,"type":"T","engineWear":7.6,"totalWear":4.3},
        // {"name":"Ford","model":"T415","age":67,"tireWear":3.2,"type":"T","engineWear":5.6,"totalWear":7.3}
        // ]
    }

    @RequestMapping(value = "/baby", method = RequestMethod.GET)
    public Baby getObjInsideObj() {
        return new Baby("Jonny",3, new Toy("Teddy Bear"));
        // Output: {"name":"Jonny","boxNumber":3,"toy":{"name":"Teddy Bear"}}
    }


    //copy code
    @RequestMapping(value = "/getImage", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response) throws IOException {

        var imgFile = new ClassPathResource("images/img1.jpg");

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }

    //copy code
    @RequestMapping(value = "/getImage1", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage1(HttpServletResponse response) throws IOException {

        SeralizedCar seralizedCar = new SeralizedCar();
        StreamUtils.(seralizedCar, response.getOutputStream());
    }
}
