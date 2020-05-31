package com.example.eksamenS2.repositories;

import com.example.eksamenS2.models.MotorHome;

import java.util.List;

public interface IMotorHomeRepository {

    public boolean create(MotorHome MotorHome);

    public MotorHome read(int id);

    public List<MotorHome> readAll();

    public boolean update(MotorHome MotorHome);

    public boolean delete(MotorHome motorhome);
}



