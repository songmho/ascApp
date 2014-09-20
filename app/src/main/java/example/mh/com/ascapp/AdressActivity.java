package example.mh.com.ascapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by songmho on 2014-09-19.
 */
public class AdressActivity extends ActionBarActivity {

    ArrayList<Adressitem> data=null;
    ListView adress_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress);

        getSupportActionBar().setIcon(new ColorDrawable(0x00FFFFFF));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF172987));
        getActionBar().setDisplayHomeAsUpEnabled(true);

        listview();

        adress_listview.setOnItemClickListener(new adressitemclick());
    }

    private void listview() {
        adress_listview=(ListView)findViewById(R.id.adress_listview);

        data=new ArrayList<Adressitem>();
        Adressitem [] item=new Adressitem[100];

        for(int i=0;i<item.length;i++){
            item[i]=new Adressitem(R.drawable.setup,"송명호","32기","010-2016-2689");
        }

        for(int i=0;i<item.length;i++){
            data.add(item[i]);
        }

        AdressAdapter adressAdapter=new AdressAdapter(this,R.layout.adressitem,data);

        adress_listview.setAdapter(adressAdapter);
    }

    private class adressitemclick implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            switch (position){
                case 0:
                    startActivity(new Intent(AdressActivity.this, PopupAdressActivity.class));
                    break;
            }
        }
    }
}
