package com.ms_1.controllers;

import com.ms_1.dto.Baby;
import com.ms_1.dto.Boolean;
import com.ms_1.dto.Car;
import com.ms_1.dto.SeralizedCar;
import com.ms_1.dto.Toy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

        cars.add(new Car("Ford", "T410", 60, 6.4, 'T', 7.6f, 4.3));
        cars.add(new Car("Ford", "T415", 67, 3.2, 'T', 5.6f, 7.3));
        return cars;
        // Output: [
        // {"name":"Ford","model":"T410","age":60,"tireWear":6.4,"type":"T","engineWear":7.6,"totalWear":4.3},
        // {"name":"Ford","model":"T415","age":67,"tireWear":3.2,"type":"T","engineWear":5.6,"totalWear":7.3}
        // ]
    }

    @RequestMapping(value = "/baby", method = RequestMethod.GET)
    public Baby getObjInsideObj() {
        return new Baby("Jonny", 3, new Toy("Teddy Bear"));
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

    @RequestMapping(value = "/getAudio.mp3", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void getAudio(HttpServletResponse response) throws IOException {

        var mp3 = new ClassPathResource("audio/s1.mp3");

        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        StreamUtils.copy(mp3.getInputStream(), response.getOutputStream());
        //This will result in download of the file
        // .* (binary stream, don't know the type of download file)	Application/octet-stream
        // https://tool.oschina.net/commons
    }

    @RequestMapping(value = "/playAudio", method = RequestMethod.GET,
            produces = "Audio/mp3")
    public void playAudio(HttpServletResponse response) throws IOException {

        var mp3 = new ClassPathResource("audio/s1.mp3");

        response.setContentType("Audio/mp3");
        StreamUtils.copy(mp3.getInputStream(), response.getOutputStream());
        //This will play the audio on the webpage

        // https://tool.oschina.net/commons

    }

    @RequestMapping(value = "/terminal", method = RequestMethod.GET)
    public Boolean terminal(HttpServletResponse response) {
        Process proc = null;
        try {
            String[] cmdss = {"gnome-terminal"};


            proc = Runtime.getRuntime().exec(cmdss);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Boolean(true);
    }


    @RequestMapping(value = "/action", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  void action(@RequestParam("cmd") String cmd, HttpServletResponse response) {
        Process proc = null;
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try {
            String cmdss[] = {"/bin/bash", "-c", cmd};
            proc = Runtime.getRuntime().exec(cmdss);

            proc.waitFor(5000, TimeUnit.MILLISECONDS);
            StreamUtils.copy(proc.getInputStream(), response.getOutputStream());
            //var mp3 = new ClassPathResource("audio/s1.mp3");


            //StreamUtils.copy(mp3.getInputStream(), response.getOutputStream());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


}
