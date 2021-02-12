package com.example.sport;

public class Exercice {
    private String name,type,nbRep,poids;
    public String getName(){
        return name;
    }
    public  String getType(){
        return type;
    }
    public String getnbRep(){
        return nbRep;
    }
    public String getPoids(){
        return poids;
    }
    public Exercice(String name,String type,String nbRep,String poids){
        this.name = name;
        this.poids = poids;
        this.nbRep = nbRep;
        this.type = type;
    }
}
