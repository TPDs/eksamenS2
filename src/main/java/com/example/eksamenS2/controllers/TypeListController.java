package com.example.eksamenS2.controllers;
import com.example.eksamenS2.models.TypesByModel;
import com.example.eksamenS2.models.Models;
import com.example.eksamenS2.models.MotorHome;
import com.example.eksamenS2.repositories.ModelRepository;
import com.example.eksamenS2.repositories.MotorHomeRepositoryImpl;
import com.example.eksamenS2.repositories.MotorhomeBookingRepository;
import com.example.eksamenS2.repositories.TypeListRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Objects;

@Controller
public class TypeListController {
private MotorHomeRepositoryImpl MotorhomeRep;
private TypeListRepository TypeRep;
    private ModelRepository modelRepository;
    public TypeListController(){
        modelRepository = new ModelRepository();
        TypeRep = new TypeListRepository();}

        @GetMapping("/motorhomes/showMotorhome")
        public String GetShowMotorhome(Model model, @RequestParam String Type){
        model.addAttribute("showMotorhome",TypeRep.ModelsFromType(Type));

            return "/motorhomes/showMotorhome";
        }


        @GetMapping("/motorhomes/chooseType")
    public String GetTypes(Model model){
        ArrayList<Models> ModelsList = new ArrayList<>(modelRepository.readAll());
           MotorhomeRep = new MotorHomeRepositoryImpl();
           TypeRep = new TypeListRepository();
        ArrayList<MotorHome> MotorhomeStatus = new ArrayList<>(MotorhomeRep.readAll());
        ArrayList<Models> DistinctTypes = new ArrayList<>(TypeRep.StatusAmounts());
        ArrayList<TypesByModel> StatusByTypes = new ArrayList<>();
        ArrayList<TypesByModel> CountedTypes = new ArrayList<>();


        for(int i=0;i<ModelsList.size();i++){
                for(int j=0; j<MotorhomeStatus.size();j++){
                    if(ModelsList.get(i).getModel_number().equals(MotorhomeStatus.get(j).getModels_Model_number())) {

                        TypesByModel temp = new TypesByModel(ModelsList.get(i).getType(), MotorhomeStatus.get(j).getStatus());
                        StatusByTypes.add(temp);
                    }
                    }
                }

                // lave et sql distinkt call
                // denne statusByTypes skal have en iterations size der repeæsentere hver enkelt status


            for(int h=0;h<DistinctTypes.size();h++){
                TypesByModel tempObj = new TypesByModel(StatusByTypes.get(h).getTyper(),0,0,0,0,0,0,0);
                CountedTypes.add(tempObj);
            }

            for(int i=0;i<StatusByTypes.size();i++){
                HandleStatusType(StatusByTypes, CountedTypes, i, StatusByTypes.get(i).getStatus());

            }

            ArrayList<TypesByModel> sortedCountedTypes = GetSortedCountedTypes(CountedTypes);

            model.addAttribute("ReadyCount",sortedCountedTypes);
            //model.addAttribute("ReadyCount",CountedTypes);

        return "/motorhomes/chooseType";
        }


        public void HandleStatusType(ArrayList<TypesByModel> StatusByTypes, ArrayList<TypesByModel> CountedTypes, int i, String status ){
            if(StatusByTypes.get(i).getStatus().equals(status)){
                for(int h=0;h<CountedTypes.size();h++){
                    if(StatusByTypes.get(i).getTyper().equals(CountedTypes.get(h).getTyper()))
                    {
                        if(status.equals("Ready"))
                        {
                            int tempInt = CountedTypes.get(h).getReady()+1;
                            CountedTypes.get(h).setReady(tempInt);
                        }
                        else if(status.equals("Cleaning")){
                            int tempInt = CountedTypes.get(h).getCleaning()+1;
                            CountedTypes.get(h).setCleaning(tempInt);
                        }
                        else if(status.equals("Repair")){
                            int tempInt = CountedTypes.get(h).getRepair()+1;
                            CountedTypes.get(h).setRepair(tempInt);
                        }
                        else if(status.equals("CleanAndRepair")){
                            int tempInt = CountedTypes.get(h).getCleanAndRepair()+1;
                            CountedTypes.get(h).setCleanAndRepair(tempInt);
                        }
                        else if(status.equals("Booked")){
                            int tempInt = CountedTypes.get(h).getBooked()+1;
                            CountedTypes.get(h).setBooked(tempInt);
                        }
                        else if(status.equals("OutOfOrder")){
                            int tempInt = CountedTypes.get(h).getOutOfOrder()+1;
                            CountedTypes.get(h).setOutOfOrder(tempInt);
                        }
                    }
                }
            }
        }



    public ArrayList<TypesByModel> GetSortedCountedTypes( ArrayList<TypesByModel> models )
    {
        ArrayList<TypesByModel> sortedModels = GetListOfTypesByModels();

        for (TypesByModel model:models)
        {
            TypesByModel currentModel = GetModelByType(sortedModels, model.getTyper());
            HandleStatuses(currentModel, model);
        }

        return sortedModels;
    }

    public void HandleStatuses(TypesByModel sortedModel, TypesByModel model)
    {
        sortedModel.setReady(sortedModel.getReady() + model.getReady());
        sortedModel.setCleaning(sortedModel.getCleaning() + model.getCleaning());
        sortedModel.setRepair(sortedModel.getRepair() + model.getRepair());
        sortedModel.setCleanAndRepair(sortedModel.getCleanAndRepair() + model.getCleanAndRepair());
        sortedModel.setBooked(sortedModel.getBooked() + model.getBooked());
        sortedModel.setOutOfOrder(sortedModel.getOutOfOrder() + model.getOutOfOrder());
    }

    public TypesByModel GetModelByType(ArrayList<TypesByModel> models, String type)
    {
        TypesByModel modelToReturn = null;

        for (TypesByModel model:models
             ) {
            if(model.getTyper().equals(type)){
                modelToReturn = model;
                break;
            }
        }

        return modelToReturn;
    }

    public ArrayList<TypesByModel> GetListOfTypesByModels()
    {
        ArrayList<TypesByModel> typeModels = new  ArrayList<TypesByModel>();

        TypesByModel m1 = new TypesByModel();
        m1.setTyper("6L");

        TypesByModel m2 = new TypesByModel();
        m2.setTyper("5M");

        TypesByModel m3 = new TypesByModel();
        m3.setTyper("5L");

        TypesByModel m4 = new TypesByModel();
        m4.setTyper("4L");

        TypesByModel m5 = new TypesByModel();
        m5.setTyper("3L");

        TypesByModel m6 = new TypesByModel();
        m6.setTyper("2L");

        TypesByModel m7 = new TypesByModel();
        m7.setTyper("1L");

        typeModels.add(m1);
        typeModels.add(m2);
        typeModels.add(m3);
        typeModels.add(m4);
        typeModels.add(m5);
        typeModels.add(m6);
        typeModels.add(m7);

        return typeModels;
    }
}

//        @GetMapping("/motorhomes/chooseType")
//    public String GetStatuses(Model model){
//        model.addAttribute("readStatusAmount",typesRepository.readStatusAmount());
//        return "/motorhomes/chooseType";
//    }

//}for(int i =0;i<ModelsList.size();i++){
//
//                for(int h=0;h<MotorhomeStatus.size();h++){
//
//                    if(ModelsList.get(i).getModel_number().equals(MotorhomeStatus.get(h).getModels_Model_number())){
//                        TypesByModel temp = new TypesByModel(ModelsList.get(i).getType(), MotorhomeStatus.get(h).getStatus());
//                        StatusByTypes.add(temp);
//
//                    }
//                    System.out.println(StatusByTypes.size());
//                }
//            }
