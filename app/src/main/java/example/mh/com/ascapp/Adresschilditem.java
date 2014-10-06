package example.mh.com.ascapp;

/**
 * Created by songmho on 2014-09-19.
 */
public class Adresschilditem {

    private String name;
    private String phone;

    public String getName(){
        return name;
    }


    public String getPhone(){return phone;}

    public Adresschilditem( String name, String phone){
        this.name=name;
        this.phone=phone;
    }
}
