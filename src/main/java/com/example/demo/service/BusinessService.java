package com.example.demo.service;

import com.example.demo.annotations.TrackTime;
import com.example.demo.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService {

    private final DataRepository dataRepository;


    @Autowired
    public BusinessService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @TrackTime
    public int calculateMax(){
        //throw new RuntimeException();
        return Arrays.stream(dataRepository.getData()).max().orElse(0);
    }

}
