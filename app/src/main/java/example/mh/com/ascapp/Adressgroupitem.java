package example.mh.com.ascapp;

import java.util.ArrayList;

/**
 * Created by songmho on 2014-10-06.
 */
public class Adressgroupitem {
    private String number;
    private ArrayList<Adresschilditem> items;


    public String getNumber(){
        return number;
    }

    public ArrayList<Adresschilditem> getItem(){
        return items;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public  void setItems(ArrayList<Adresschilditem> items){
        this.items=items;
    }
    Adressgroupitem(String number){
        this.number=number;
    }
}
