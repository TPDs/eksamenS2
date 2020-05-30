package com.example.eksamenS2.controllers;

import com.example.eksamenS2.models.BookingID;
import com.example.eksamenS2.models.EndBooking;
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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

    @GetMapping("/bookings/EndBooking")
    public String endbooking() {
        return "/bookings/EndBooking";
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

    @PostMapping("/EndBooking")
    public Boolean endbooking(EndBooking endBooking, MotorHome motorHome, BookingID bookingID) {
        int Total_km = motorHome.getTotal_Km() - endBooking.getEndKm();
        int EndGas = 100 - endBooking.getEndgas();
        int PickUpKm = endBooking.getPickUpKm();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(bookingID.getFromDate());
        cal2.setTime(bookingID.getEndDate());
        int days = daysBetween(bookingID.getFromDate(), bookingID.getEndDate());
        int KmPerDay = Total_km / days;
// Hvis "days" er i season, skal der vælges en pris ud fra season. 1.6 1.3 eller 1


        return true;
    }

    public int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public double SeasonCheck(Date startdate) {
        Double SeasonPrice = null;

        // Disse Datoer skal ændres over tiden da de desværre er blevet hardcoded pga tidspress, Ville evt have lavet et sql table til dette og/eller en fucktion der retter år for hver season ..Michael
        Date LowA = new Date(2020 - 1 - 15);
        Date LowB = new Date(2020 - 5 - 15);

        Date HighA = new Date(2020 - 5 - 16);
        Date HighB = new Date(2020 - 10 - 15);

        Date MidA = new Date(2020 - 10 - 16);
        Date MidB = new Date(2021 - 1 - 14);


        if (LowA.compareTo(startdate) * startdate.compareTo(LowB) > 0) {
            SeasonPrice = 1.0;
        } else if (MidA.compareTo(startdate) * startdate.compareTo(MidB) > 0) {
            SeasonPrice = 1.3;
        } else if (HighA.compareTo(startdate) * startdate.compareTo(HighB) > 0) {
            SeasonPrice = 1.6;
        }


        return SeasonPrice;
    }


}

