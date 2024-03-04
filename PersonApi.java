package com.fsse2401.lab_b01;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonApi {
//Mock Database
    List<PersonData> personDataList= new ArrayList<>();

    @PostMapping("/person/create")
    public PersonData createPerson(@RequestBody PersonData personData){
        personDataList.add(personData);
        return personData;
    }
    @GetMapping("/person/all")
    public List<PersonData>getPersonDataList(){
        return personDataList;
    }
    @PutMapping("/person/update")
    public PersonData putPersonData(@RequestBody PersonData personData){

        for(PersonData personData1: personDataList){
            if( personData1.getHkid().equals(personData.getHkid())){
                personData1.setFirstName(personData.getFirstName());
                personData1.setLastName(personData.getLastName());
            }return personData1;
        }
    }
}
