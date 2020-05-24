package com.example.eksamenS2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/")
    public String index(Model model) {

        try (Stream<Path> walk = Files.walk(Paths.get("src\\main\\resources\\static\\img\\test\\"))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());

            result.forEach(System.out::println);

            String rep = "src\\main\\resources\\static";
            List<String> result2 = new ArrayList<>();


            for (int i = 0; i < result.size(); i++) {
                String s = result.get(i);
                s = s.replace(rep, "..");
                s = s.replace("\\", "/");
                result2.add(s);

            }
            result2.forEach(System.out::println);

            model.addAttribute("ModelsImg", result2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "index";
    }
}

