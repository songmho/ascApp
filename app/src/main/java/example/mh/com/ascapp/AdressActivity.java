package example.mh.com.ascapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by songmho on 2014-09-19.
 */
public class AdressActivity extends Fragment {

    //ArrayList<String> listgroup=null;
    ExpandableListView adress_listview;
    LinearLayout adressactivity;
    Context context;

    ArrayList<Adressgroupitem> group;
    ArrayList<Adresschilditem> child;
    private ArrayList<Adressgroupitem> item;
    private AdressAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        adressactivity=(LinearLayout)inflater.inflate(R.layout.activity_adress,container,false);

        context=getActivity();

        adress_listview=(ExpandableListView)adressactivity.findViewById(R.id.adress_listview);
        item= prepareListData();
        adapter=new AdressAdapter(context,item);
        adress_listview.setAdapter(adapter);

        return adressactivity;
    }

    private ArrayList<Adressgroupitem> prepareListData() {

        String group_names[]={"1기","2기","3기","4기"};
        String name[]={"송명호","송명호","송명호","송명호","송명호","송명호","송명호","송명호"};
        String phone[]={"010-2016-2689","010-2016-2689","010-2016-2689","010-2016-2689","010-2016-2689","010-2016-2689","010-2016-2689","010-2016-2689","010-2016-2689"};

        int size = 2;
        int j = 0;

       ArrayList<Adressgroupitem> group=new ArrayList<Adressgroupitem>();
        for(String group_name: group_names){
            Adressgroupitem adressgroupitem=new Adressgroupitem(group_name);

            child=new ArrayList<Adresschilditem>();
            for (;j<size;j++){
                Adresschilditem adresschilditem=new Adresschilditem(name[j],phone[j]);
                child.add(adresschilditem);
            }
            adressgroupitem.setItems(child);
            group.add(adressgroupitem);

            size=size+2;
        }
        return group;
    }

}
