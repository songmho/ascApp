package example.mh.com.ascapp;

/**
 * Created by songmho on 2014-09-18.
 */
public class Draweritem {
    private int icon;
    private String name;

    public int getIcon(){return icon;}
    public String getName(){return name;}

    public Draweritem(int icon,String name){
        this.icon=icon;
        this.name=name;
    }
}
