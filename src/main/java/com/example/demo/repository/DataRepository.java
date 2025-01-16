package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataRepository {

    public int[] getData(){

        return new int[] {10,20,30,40,50,60,70};

    }
}
