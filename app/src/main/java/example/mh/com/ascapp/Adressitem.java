package example.mh.com.ascapp;

/**
 * Created by songmho on 2014-09-19.
 */
public class Adressitem {

    private int profile;
    private String name;
    private String number;
    private String phone;

    public int getProfile(){return profile;}

    public String getName(){
        return name;
    }

    public String getNumber(){
        return number;
    }

    public String getPhone(){return phone;}

    public Adressitem(int profile,String name,String number,String phone){
        this.profile=profile;
        this.name=name;
        this.number=number;
        this.phone=phone;
    }
}
