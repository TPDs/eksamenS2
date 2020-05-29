package com.example.eksamenS2.repositories;
import com.example.eksamenS2.models.Models;
import com.example.eksamenS2.util.DatabaseConnectionManager;
import org.springframework.ui.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeListRepository {
    private Connection conn;
    public TypeListRepository() {this.conn = DatabaseConnectionManager.getDatabaseConnection(); }

    // oprette et objekt med information omkring Type fra models.
    // og status fra Motorhomes

    // skal kunne "tælle mængden af typer, og indsætte den talte værdi
    // i den tilsvarende type

    public List<Models> readAllTypes(){
        List<Models> allTypes = new ArrayList<>();
        List<Models> alleEnkelteTyper = new ArrayList<>();

        try {
            PreparedStatement ps= conn.prepareStatement("SELECT DISTINCT Type FROM models");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Models tempType = new Models();
                tempType.setType(rs.getString(1));

                alleEnkelteTyper.add(tempType);
            }

// dette kode stykke burdte virke istedet for Distinct keyword i SQL PreparedStatement
//            for(int i=0;i<allTypes.size();i++) {
//                if(!alleEnkelteTyper.contains(allTypes.get(i))){
//                    alleEnkelteTyper.add(allTypes.get(i));
//                }
//            }

            // denne kode virker ikke da der aldrig bliver tilføjet en værdi til andet for loop
            // så den iterere ikke igennem
//            for(int i=0;i<allTypes.size();i++)
//            {
//
//                System.out.println("første loop kører!");
//                for(int j=0;j<alleEnkelteTyper.size(); j++){
//                    System.out.println("andet loop kører");
//                    if(alleEnkelteTyper.get(j).equals(allTypes.get(i))){
//                        System.out.println("if printer fint ?");
//                    }
//                    else{
//                        alleEnkelteTyper.add(allTypes.get(i));
//                        System.out.println("else printer fint");
//
//                    }
//                }
//            }

        } catch (SQLException throwables) {

            throwables.printStackTrace();
            System.out.println("ArrayListe med enkel type metoden fungere ikke");
        }
        System.out.println(""+ allTypes.size());
        System.out.println("" + alleEnkelteTyper.size());
    return alleEnkelteTyper;
    }





}
