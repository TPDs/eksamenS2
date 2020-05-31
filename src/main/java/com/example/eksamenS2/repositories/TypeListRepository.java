package com.example.eksamenS2.repositories;
import com.example.eksamenS2.models.Models;
import com.example.eksamenS2.models.MotorHome;
import com.example.eksamenS2.util.DatabaseConnectionManager;
import org.springframework.ui.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeListRepository {
    private Connection conn;
    public TypeListRepository() {this.conn = DatabaseConnectionManager.getDatabaseConnection(); }

// Skal oprette et objekt der kan bruges i Thymeleaf til at each iterere i html
//gennem spring, så vi kan få vist hvor mange forskellige status de seperate typer har

   public List<Models> StatusAmounts() {
       List<Models> ModelNummerOgStatus = new ArrayList<>();
       try {
           PreparedStatement Modelps = conn.prepareStatement("SELECT Model_number , Type FROM models");
           ResultSet Modelrs = Modelps.executeQuery();
           while (Modelrs.next()) {
               Models tempNrType = new Models();

               tempNrType.setModel_number(Modelrs.getString(1));
               tempNrType.setType(Modelrs.getString(2));

               ModelNummerOgStatus.add(tempNrType);
           }

           } catch(SQLException throwables){
               throwables.printStackTrace();
           }
    return ModelNummerOgStatus;
   }

//public List<MotorHome>




    // denne metode finder DISTINCT typer og gemmer en af hver type i en ArrayListe
    public List<Models> readAllTypes(){
        List<Models> alleEnkelteTyper = new ArrayList<>();

        try {
            PreparedStatement ps= conn.prepareStatement("SELECT DISTINCT Type, FROM models");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Models tempType = new Models();
                tempType.setType(rs.getString(1));

                alleEnkelteTyper.add(tempType);
            }

        } catch (SQLException throwables) {

            throwables.printStackTrace();
            System.out.println("ArrayListe med enkel type metoden fungere ikke");
        }

        return alleEnkelteTyper;
    }




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








