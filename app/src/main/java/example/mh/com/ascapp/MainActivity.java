package example.mh.com.ascapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    ActionBarDrawerToggle drawerToggle;
    ListView drawer_listview;
    ArrayList<Draweritem> data=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setIcon(new ColorDrawable(0x00FFFFFF));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF172987));
        getActionBar().setDisplayHomeAsUpEnabled(true);


        LinearLayout drawer=(LinearLayout)findViewById(R.id.drawer);
        FrameLayout main_layout=(FrameLayout)findViewById(R.id.main_layout);
        drawer_listview=(ListView)findViewById(R.id.drawer_listview);

        drawer();
        drawer_data();

        drawer_listview.setOnItemClickListener(new Drawerlistviewitemclick());

        ImageView profile=(ImageView)findViewById(R.id.profile);
        TextView drawer_number=(TextView)findViewById(R.id.drawer_number);
        TextView drawer_name=(TextView)findViewById(R.id.drawer_name);

        profile.setImageResource(R.drawable.setup);
        drawer_number.setText("32기");
        drawer_name.setText("송명호");


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void drawer() {
        DrawerLayout main_drawerlayout=(DrawerLayout)findViewById(R.id.main_Drawerlayout);
        drawerToggle=new ActionBarDrawerToggle(this,main_drawerlayout,R.drawable.icon_drawer,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerToggle.syncState();
        main_drawerlayout.setDrawerListener(drawerToggle);

    }

    private void drawer_data() {
        data=new ArrayList<Draweritem>();

        Draweritem plan= new Draweritem(R.drawable.plan,"ASC 일정");
        Draweritem adress=new Draweritem(R.drawable.adress,"주소록");
        Draweritem setup=new Draweritem(R.drawable.setup,"설정");

        data.add(plan);
        data.add(adress);
        data.add(setup);

        DrawerAdapter drawerAdapter=new DrawerAdapter(this,R.layout.draweritem,data);

        drawer_listview.setAdapter(drawerAdapter);

    }

    private class Drawerlistviewitemclick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            switch (position){
                case 0:
                    Toast.makeText(getApplicationContext(),"ASC 일정",Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    startActivity(new Intent(MainActivity.this,AdressActivity.class));
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(),"설정",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
