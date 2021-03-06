package com.example.eksamenS2.repositories;
import com.example.eksamenS2.models.Models;
import com.example.eksamenS2.models.TypesByModel;
import com.example.eksamenS2.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//Lavet af Daniel



public class TypeListRepository {
    private Connection conn;
    public TypeListRepository() {this.conn = DatabaseConnectionManager.getDatabaseConnection(); }

/////////
    // SELECT mh.MotorHomesID , mh.Models_Model_number, COUNT(mh.Status) FROM motorhomes mh
    //INNER JOIN models m WHERE mh.status='Ready' AND mh.Models_Model_Number = m.Model_number AND Type ='6L' ;
    //////////////
    // Her skal laves en metode til at vise Typer. og mængden af statusser

    /////////////////////////////////////////////////////////////////////////////////////

//public List<TypesByModel> MetodeTilTypeStatusVisning(String Status, String Type){
//
//    try {
//
//        PreparedStatement ps = conn.prepareStatement("SELECT mh.MotorHomesID , mh.Models_Model_number, COUNT(mh.Status) FROM motorhomes mh\n" +
//                "INNER JOIN models m WHERE mh.status='"+Status+"' AND mh.Models_Model_Number = m.Model_number AND Type ='"+Type+"' ;");
//        ResultSet rs = ps.executeQuery();
//        List<TypesByModel> MotorHomeModelDetail = new ArrayList<>();
//        List<Models> TyperAfModeller = new ArrayList<>(readAllTypes());
//
//        for(int i=0;i<TyperAfModeller.size())
//
//
//
//    } catch (SQLException throwables) {
//        throwables.printStackTrace();
//    }
//
//
//}

////////////////////////////////////////////////////////////////////////////////////

//    metode der Laver inner join sql prepared statement og Selecter relavandt data, motorhome og model model_number bliver sammenlignet
// og den valgte "Selectede" data bliver requested og brugt til at oprette et object.
    // dette object bliver så tilføjet en ArrayListe som bliver retuneret og som kan itereres igennem med Type parameter som er metodens input

    public List<TypesByModel> ModelsFromType(String Type){
        PreparedStatement ps = null;
        List<TypesByModel> MotorHomeModelDetail = new ArrayList<>();
        List<Models> TyperAfModeller = new ArrayList<>(readAllTypes());


        try {
            ps = conn.prepareStatement("SELECT mh.MotorHomesID, mh.Models_Model_number, NumberPlate, mh.Status ,Total_Km, m.Price FROM motorhomes mh\n" +
                    "INNER JOIN models m WHERE m.Type='" + Type + "' AND mh.Models_Model_Number = m.Model_number ;");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                TypesByModel tempModel = new TypesByModel();
                tempModel.setMhID(rs.getInt(1));
                tempModel.setModel(rs.getString(2));
                tempModel.setNumberPlate(rs.getString(3));
                tempModel.setStatus(rs.getString(4));
                tempModel.setTotalKm(rs.getString(5));
                tempModel.setPrice(rs.getInt(6));

            MotorHomeModelDetail.add(tempModel);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return MotorHomeModelDetail;
    }

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
            PreparedStatement ps= conn.prepareStatement("SELECT DISTINCT Type FROM models");
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







