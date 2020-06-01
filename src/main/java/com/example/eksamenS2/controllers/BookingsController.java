package com.example.eksamenS2.controllers;

import com.example.eksamenS2.models.*;
import com.example.eksamenS2.repositories.AccItemsRepository;
import com.example.eksamenS2.repositories.BookingIDRepositoryImpl;
import com.example.eksamenS2.repositories.MotorHomeRepositoryImpl;
import com.example.eksamenS2.repositories.MotorhomeBookingRepository;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class BookingsController {

    private BookingIDRepositoryImpl BookingIDRep;
    private MotorhomeBookingRepository MotorhomeBookingRep;
    private AccItemsRepository AccItemsRep;
    private MotorHomeRepositoryImpl Motorhomerep;


    public BookingsController() {
        Motorhomerep = new MotorHomeRepositoryImpl();
        AccItemsRep = new AccItemsRepository();
        BookingIDRep = new BookingIDRepositoryImpl();
    }

    @GetMapping("/bookings/addBooking")
    public String createBookings(Model model, BookingID bookingID) {
        //model.addAttribute("booking", BookingIDRep.showCurrentBookings());
        return "bookings/addBooking";
    }

    //Lavet af Christian
    @GetMapping("/bookings/BookMotorHome")
    public String bookMotorHome(@RequestParam MotorHome motorHome, Model model) {
        model.addAttribute("MotorHomeList", BookingIDRep.readAllbyModel(motorHome.getModels_Model_number()));
        return "bookings/confirmBooking";
    }


    //Lavet af Christian
    @PostMapping("/bookings/addBooking")
    public String addBookings(Model model, BookingID bookingID) {
        MotorhomeBookingRep = new MotorhomeBookingRepository();
        model.addAttribute("ModelBooking", BookingIDRep.create(bookingID));
        model.addAttribute("SingleMotorHomeBookings", MotorhomeBookingRep.showCurrentBookings());
        return "redirect:/";
    }


    @GetMapping("bookings/completedbookings")
    public String completeBookings() {
        return "bookings/completedbookings";
    }


    @GetMapping("/bookings/showBookings")
    public String readAllBookings(Model model) {
        MotorhomeBookingRep = new MotorhomeBookingRepository();
        ArrayList<BookingID> bookingArr = new ArrayList<>();

        // Loader disse 2 Arraylister ind i 2 nye arrays for ikke at kalde SQL serveren ved hvert loop
        ArrayList<BookingID> Blist = new ArrayList<>(BookingIDRep.showCurrentBookings());
        ArrayList<MotorhomeBooking> Alist = new ArrayList<>(MotorhomeBookingRep.showCurrentBookings());

        for (int i = 0; i < Blist.size(); ) {
            BookingID book = new BookingID(Blist.get(i).getFromDate(), Blist.get(i).getEndDate(), Blist.get(i).getStaffID(), Blist.get(i).getCustomerID(), Blist.get(i).getBookingID(), Alist.get(i).getMotorhomeID());
            bookingArr.add(book);
            i++;
        }

        model.addAttribute("showCurrentBookings", bookingArr);

        return "/bookings/showBookings";
    }


    //Lavet af Christian
    @GetMapping("/bookings/deleteBooking")
    public String getDeleteBooking(@RequestParam int id, Model model) {
        model.addAttribute("deleteBooking", BookingIDRep.BookingIdByInt(id));
        return "/bookings/deleteBooking";

    }


    //Lavet af Christian
    @PostMapping("/bookings/deleteBooking")
    public String postDeleteBooking(BookingID bookingID) {
        BookingIDRep.deleteBooking(bookingID);
        return "redirect:/";
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

//    //Bruges ved at indlæsning af billeder fra en models mappe navn
//    @PostMapping("/modelpictures")
//    public String index(Model model, String ModelNumber) {
//        try (Stream<Path> walk = Files.walk(Paths.get("src\\main\\resources\\static\\img\\" + ModelNumber + "\\"))) {
//
//            List<String> result = walk.filter(Files::isRegularFile)
//                    .map(Path::toString).collect(Collectors.toList());
//
//            result.forEach(System.out::println);
//
//            String rep = "src\\main\\resources\\static";
//            List<String> result2 = new ArrayList<>();
//
//
//            for (int i = 1; i < result.size(); i++) {
//                String s = result.get(i);
//                s = s.replace(rep, "..");
//                s = s.replace("\\", "/");
//                result2.add(s);
//
//            }
//            String p;
//            p = result.get(0);
//            p = p.replace(rep, "..");
//            p = p.replace("\\", "/");
//
//            result2.forEach(System.out::println);
//
//            model.addAttribute("First", p);
//            model.addAttribute("ModelsImg", result2);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "";
//    }


    @GetMapping("bookings/confirmBooking")
    public String EndedBooking(@RequestParam int id, Model model) {
        int ids = BookingIDRep.MotorhomeByBookingID(id);
        model.addAttribute("motorhomePrice", Motorhomerep.motorhomePriceByMhId(id));
        model.addAttribute("AccList", AccItemsRep.readAllByBooking(id));
        model.addAttribute("motorhome", Motorhomerep.read(ids));
        model.addAttribute("BookingID", BookingIDRep.BookingIdByInt(id));
        return "bookings/confirmBooking";
    }

    @GetMapping("bookings/CancelBooking")
    public String CancelBooking(@RequestParam int id, Model model) {
        CancelBooking cancelInfo;
        cancelInfo = BookingIDRep.cencelBooking(id);
        double cancelInfoSeason = SeasonCheck(cancelInfo.getFromdate());
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        int days = daysBetween(cancelInfo.getFromdate(), date);
        double cancelprice = 1.0;
        if (days >= 50) {
            cancelprice = (cancelInfoSeason * cancelInfo.getPrice() * 0.2);
            if (cancelprice < 200) {
                cancelprice = 200;
            }
        } else if (days < 49 && days >= 15) {
            cancelprice = (cancelInfoSeason * cancelInfo.getPrice() * 0.5);
        } else if (days >= 14) {
            cancelprice = (cancelInfoSeason * cancelInfo.getPrice() * 0.8);
        } else if (days <= 1) {
            cancelprice = (cancelInfoSeason * cancelInfo.getPrice() * 0.95);
        } else {
            cancelprice = (cancelInfoSeason * cancelInfo.getPrice() * 1);
        }

        int totaldays = daysBetween(cancelInfo.getFromdate(), cancelInfo.getEndDate());
        model.addAttribute("cancelPrice", cancelprice);
        model.addAttribute("BookingInfo", cancelInfo);
        model.addAttribute("id", id);
        model.addAttribute("Season", cancelInfoSeason);
        model.addAttribute("days", totaldays);

        return "/bookings/CancelBooking";
    }


    @PostMapping("bookings/EndBooking")
    public String endbooking(EndBooking endBooking, MotorHome motorHome, BookingID bookingID, Model model) {
        int Total_km = motorHome.getTotal_Km() - endBooking.getEndKm();
        int EndGas = 100 - endBooking.getEndgas();
        int PickUpKm = endBooking.getPickUpKm();
        int MhId = motorHome.getMotorHomesID();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(bookingID.getFromDate());
        cal2.setTime(bookingID.getEndDate());
        int days = daysBetween(bookingID.getFromDate(), bookingID.getEndDate());
        int KmPerDay = Total_km / days;
        double SeasonPrice = SeasonCheck(bookingID.getFromDate());
        CompletedBookings BookingData = new CompletedBookings(Total_km, EndGas, PickUpKm, days, KmPerDay, bookingID.getBookingID(), MhId, SeasonPrice, bookingID.getFromDate(), bookingID.getEndDate());
        model.addAttribute("CompletedMotorHomeBooking", BookingData);
        model.addAttribute("AccBookings", AccItemsRep.readAllByBooking(bookingID.getBookingID()));
        return "bookings/confirmBooking"; // ændres til et completed?
    }

    public int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }


    public double SeasonCheck(Date startdate) {
        double SeasonPrice = 1.1;

        // Disse Datoer burde kunne ændres over tiden, men de desværre er blevet hardcoded pga tidspress, Ville evt have lavet et sql table til dette og/eller en fucktion der retter år for hver season ..Michael

        Date LowA = new Date(2020 - 1 - 15);
        Date LowB = new Date(2020 - 5 - 15);

        Date HighA = new Date(2020 - 5 - 16);
        Date HighB = new Date(2020 - 10 - 15);

        Date MidA = new Date(2020 - 10 - 16);
        Date MidB = new Date(2021 - 1 - 14);

        if (!(startdate.before(LowA)) && !(startdate.after(LowB))) {
            SeasonPrice = 1.0;
        } else if (!(startdate.before(HighA)) && !(startdate.before(HighB))) {
            SeasonPrice = 1.6;
        } else if (!(startdate.before(MidA)) && !(startdate.before(MidB))) {
            SeasonPrice = 1.3;
        }

        return SeasonPrice;
    }

}

