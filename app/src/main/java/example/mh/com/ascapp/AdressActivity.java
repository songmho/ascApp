package example.mh.com.ascapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by songmho on 2014-09-19.
 */
public class AdressActivity extends Fragment {

    ArrayList<Adressitem> data=null;
    ListView adress_listview;
    LinearLayout adressactivity;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adressactivity=(LinearLayout)inflater.inflate(R.layout.activity_adress,container,false);

        context=getActivity();

        adress_listview=(ListView)adressactivity.findViewById(R.id.adress_listview);
        data=new ArrayList<Adressitem>();
        Adressitem [] item=new Adressitem[100];

        for(int i=0;i<item.length;i++){
            item[i]=new Adressitem(R.drawable.setup,"송명호","32기","010-2016-2689");
        }

        for (Adressitem anItem : item) {
            data.add(anItem);
        }

        AdressAdapter adressAdapter=new AdressAdapter(context,data);

        adress_listview.setAdapter(adressAdapter);

        adress_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent=new Intent(getActivity(),PopupAdressActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        return adressactivity;
    }

}
