package com.example.eksamenS2.controllers;

import com.example.eksamenS2.models.BookingID;
import com.example.eksamenS2.models.MotorHome;
import com.example.eksamenS2.repositories.BookingIDRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class BookingsController {
    // How to create a folder in Java https://stackoverflow.com/questions/4801971/how-to-create-empty-folder-in-java/4802032
    // Dette skal vi bruge for hver Model ved oprettelse

    private BookingIDRepositoryImpl BookingIDRep;

    public BookingsController() {
        BookingIDRep = new BookingIDRepositoryImpl();
    }


    @GetMapping("/bookings/showBookings")
    public String ShowBookings() {

        return "bookings/showBookings";
    }

    @GetMapping("/bookings/addBooking")
    public String createBookings(BookingID bookingID) {

        return "bookings/addBooking";
    }

    @GetMapping("/bookings/BookMotorHome")
    public String bookMotorHome(@RequestParam MotorHome motorHome, Model model) {
        model.addAttribute("MotorHomeList", BookingIDRep.readAllbyModel(motorHome.getModels_Model_number()));
        return "bookings/confirmBooking";
    }


    @PostMapping("/bookings/addBooking")
    public String addBookings(Model model, BookingID bookingID) {
        model.addAttribute("ModelBooking", BookingIDRep.create(bookingID));
        return "bookings/addBooking";
    }


    @GetMapping("bookings/completedbookings")
    public String completeddBookings() {

        return "bookings/completedbookings";
    }


    @GetMapping("/")
    public String index(Model model) {
        try (Stream<Path> walk = Files.walk(Paths.get("src\\main\\resources\\static\\img\\test\\"))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());

            result.forEach(System.out::println);

            String rep = "src\\main\\resources\\static";
            List<String> result2 = new ArrayList<>();


            for (int i = 1; i < result.size(); i++) {
                String s = result.get(i);
                s = s.replace(rep, "..");
                s = s.replace("\\", "/");
                result2.add(s);

            }
            String p;
            p = result.get(0);
            p = p.replace(rep, "..");
            p = p.replace("\\", "/");

            result2.forEach(System.out::println);

            model.addAttribute("First", p);
            model.addAttribute("ModelsImg", result2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "index";
    }

    // Bruges ved at indlæsning af billeder fra en models mappe navn
    @PostMapping("/modelpictures")
    public String index(Model model, String ModelNumber) {
        try (Stream<Path> walk = Files.walk(Paths.get("src\\main\\resources\\static\\img\\" + ModelNumber + "\\"))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());

            result.forEach(System.out::println);

            String rep = "src\\main\\resources\\static";
            List<String> result2 = new ArrayList<>();


            for (int i = 1; i < result.size(); i++) {
                String s = result.get(i);
                s = s.replace(rep, "..");
                s = s.replace("\\", "/");
                result2.add(s);

            }
            String p;
            p = result.get(0);
            p = p.replace(rep, "..");
            p = p.replace("\\", "/");

            result2.forEach(System.out::println);

            model.addAttribute("First", p);
            model.addAttribute("ModelsImg", result2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }


}

