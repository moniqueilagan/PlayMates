package com.example.playmate;

import android.os.Build;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Objects;

public class getPetMatches {
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> descriptions = new ArrayList<String>();
    ArrayList<String> matchesArrayList = new ArrayList<String>();
    String email;
    String petDescription;
    String petName;

    public getPetMatches() {}

    public getPetMatches(ArrayList<String> names, ArrayList<String> descriptions, String email, String petDescription, String petName) {
        this.names = names;
        this.descriptions = descriptions;
        this.email = email;
        this.petDescription = petDescription;
        this.petName = petName;
    }

    public String getPetDescriptionsArray(){
        String[] xArray = petDescription.split("[ , ]");
        String xList = "";
        for (int i = 0;i < xArray.length;i++){
            xList += xArray[i] + " ";
        }
        return xList;
    }

    public ArrayList<String> getMatchesArrayList() {
        getMatches();
        return matchesArrayList;
    }

    public String getMatches(){
        ArrayList<String> newMatches = new ArrayList<>();
        ArrayList<String> newDescriptions = new ArrayList<>();

        ListIterator<String> currentValueD = descriptions.listIterator();
        ListIterator<String> currentValueN = names.listIterator();

        //Remove [] of petDescription
        String petD = petDescription.replace("["," ");
        String newPetDescription = petD.replace("]"," ");
        String[] petDescriptionArray = newPetDescription.split(",");

        String tempValueD;
        String tempValueN;
        String newMatchesStr = "";

        int counter = 0;

        while(currentValueD.hasNext()){
            tempValueD = currentValueD.next();
            tempValueN = currentValueN.next();

            //Remove [] of tempValueD
            String removeBrace1D = tempValueD.replace("["," ");
            String removeCommaD = removeBrace1D.replace(","," ");
            String newTempValueD = removeCommaD.replace("]"," ");

            //Remove [] of tempValueN
            String removeBrace1N = tempValueN.replace("["," ");
            String newTempValueN = removeBrace1N.replace("]"," ");


            for (int i = 0;i < petDescriptionArray.length;i++){
                if (newTempValueD.contains(petDescriptionArray[i])){
                    newMatches.add(counter,newTempValueN);
                    newDescriptions.add(counter,newTempValueD);
                    counter++;
                    break;
                }
            }
        }

        String q = petDescription.replace("["," ");
        String r = q.replace("]"," ");
        String s = r.replace(",", " ");
        newMatches.remove(petName);
        newMatches.remove(petName);
        newMatches.remove(petName);
        newDescriptions.remove(s);


        for (int i = 0; i < newMatches.size(); i++) {
            newMatchesStr = newMatches.get(i);
            matchesArrayList.add(newMatches.get(i));
        }

        return newMatchesStr;
    }
}
