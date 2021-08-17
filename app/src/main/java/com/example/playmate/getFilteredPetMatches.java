package com.example.playmate;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class getFilteredPetMatches {
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String age, size, spayNeuterStatus, tempStatus, allAge, allName, allSize, allSpayNeuter, allTemp;
    ArrayList<String> matches = new ArrayList<>();


    public getFilteredPetMatches() {
    }

    public getFilteredPetMatches(String age, String size, String spayNeuterStatus, String tempStatus) {
        this.age = age;
        this.size = size;
        this.spayNeuterStatus = spayNeuterStatus;
        this.tempStatus = tempStatus;
    }

    public getFilteredPetMatches(String age, String size, String spayNeuterStatus, String tempStatus, ArrayList matches) {
        this.age = age;
        this.size = size;
        this.spayNeuterStatus = spayNeuterStatus;
        this.tempStatus = tempStatus;
        this.matches = matches;
    }

    public getFilteredPetMatches(String age, String size, String spayNeuterStatus, String tempStatus, String allAge, String allName, String allSize, String allSpayNeuter, String allTemp, ArrayList matches) {
        this.age = age;
        this.size = size;
        this.spayNeuterStatus = spayNeuterStatus;
        this.tempStatus = tempStatus;
        this.allAge = allAge;
        this.allName = allName;
        this.allSize = allSize;
        this.allSpayNeuter = allSpayNeuter;
        this.allTemp = allTemp;
        this.matches = matches;
    }

    public String getAge() {
        return age;
    }

    public String getSize() {
        return size;
    }

    public String getSpayNeuterStatus() {
        return spayNeuterStatus;
    }

    public String getTempStatus() {
        return tempStatus;
    }


    public String getFilteredMatches(){
        String newM = "";

        Iterator<String> mIt = matches.listIterator();

        ArrayList<String> newMatches = new ArrayList<>();

        String size1 = allSize.replace("(Less than 20 lbs)"," ");
        String size2 = size1.replace("(20 to 30 lbs)", " ");
        String size3 = size2.replace("(30 to 50 lbs)", " ");
        String size4 = size3.replace("(50 to 90 lbs)", " ");
        String size5 = size4.replace("(More than 90 lbs)", " ");

        String age1 = allAge.replace("(Less than 1 Year Old)"," ");
        String age2 = age1.replace("(1 to 3 Years Old)", " ");
        String age3 = age2.replace("(4 to 9 Years Old)", " ");
        String age4 = age3.replace("(10 Years Old or Above)", " ");

        String[] newSize = size5.split(" ");
        String[] newAge = age4.split(" ");
        String[] allNames = allName.split(" ");
        String[] allFixed = allSpayNeuter.split(" ");
        String[] allTemps = allTemp.split(" ");

        int i = 0;

        while(mIt.hasNext()){
            String key = mIt.next();

            if(allNames[i].equals(key)){
                if (newSize[i].equals(size) || newAge[i].equals(age) || allFixed.equals(spayNeuterStatus) || allTemps[i].equals(tempStatus)){
                    newM = allNames[i];
                    i++;
                } else {
                    i++;
                }
            }

        }



        return newM;
    }

}
