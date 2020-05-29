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

// tester lige noget af

//    public String AlternativMetode(Model_number)


// Metode der skal kunne finde mængden af de forskellige status
// Daniel Skal lave det her færdig imorgen! tager model_nr og type og sammenligner med model_nR og status
public List<String> readStatusAmount(String Type){
        List<String> ResultListFromTypeSearch = new ArrayList<>();
    try {
        PreparedStatement Modelps = conn.prepareStatement("SELECT Model_number , Type FROM models WHERE Type="+ Type );
        List<Models> ModelNrType = new ArrayList<>();
        List<MotorHome> MotorHomeModelNr = new ArrayList<>();

        ResultSet Modelrs = Modelps.executeQuery();
        while(Modelrs.next()){
            Models tempNrType = new Models();

            tempNrType.setModel_number(Modelrs.getString(1));
            tempNrType.setType(Modelrs.getString(2));

            ModelNrType.add(tempNrType);
        }

        PreparedStatement MotorHomeps = conn.prepareStatement("SELECT Models_Model_number, status FROM motorhomes");
        ResultSet MotorHomers = MotorHomeps.executeQuery();

        while(MotorHomers.next()){
            MotorHome tempMhId = new MotorHome();

            tempMhId.setModels_Model_number(MotorHomers.getString(1));
            tempMhId.setStatus(MotorHomers.getString(2));

            MotorHomeModelNr.add(tempMhId);
        }


        for(int i=0;i<=ModelNrType.size();i++){
            for(int j=0; j<=MotorHomeModelNr.size();j++){
                if(ModelNrType.get(i).getModel_number().equals(MotorHomeModelNr.get(j).getModels_Model_number())){
                    ResultListFromTypeSearch.add(MotorHomeModelNr.get(j).getStatus());
            }
            }
        }
    }

    catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    return ResultListFromTypeSearch;
}

    // skal kunne "tælle mængden af typer, og indsætte den talte værdi
    // i den tilsvarende type ArrayList
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
