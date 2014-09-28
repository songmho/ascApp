package example.mh.com.ascapp;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private int main_page =4;
    ViewPager main_viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setIcon(new ColorDrawable(0x00FFFFFF));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF003775));

        final Button wallpost=(Button)findViewById(R.id.wallpost);
        wallpost.setOnClickListener(this);
        final Button calender=(Button)findViewById(R.id.calender);
        calender.setOnClickListener(this);
        final Button contact=(Button)findViewById(R.id.contact);
        contact.setOnClickListener(this);
        final Button setting=(Button)findViewById(R.id.setting);
        setting.setOnClickListener(this);

        main_viewpager=(ViewPager)findViewById(R.id.main_viewpager);
        main_viewpager.setAdapter(new adapter_pager(getSupportFragmentManager()));
        main_viewpager.setCurrentItem(0);
        wallpost.setSelected(true);
        calender.setSelected(false);
        contact.setSelected(false);
        setting.setSelected(false);

        main_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        wallpost.setSelected(true);
                        calender.setSelected(false);
                        contact.setSelected(false);
                        setting.setSelected(false);
                        break;

                    case 1:
                        wallpost.setSelected(false);
                        calender.setSelected(true);
                        contact.setSelected(false);
                        setting.setSelected(false);
                        break;

                    case 2:
                        wallpost.setSelected(false);
                        calender.setSelected(false);
                        contact.setSelected(true);
                        setting.setSelected(false);
                        break;

                    case 3:
                        wallpost.setSelected(false);
                        calender.setSelected(false);
                        contact.setSelected(false);
                        setting.setSelected(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {            }

            @Override
            public void onPageScrolled(int i, float v, int i2) {            }

        });
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.wallpost:
                main_viewpager.setCurrentItem(0);
                break;
            case R.id.calender:
                main_viewpager.setCurrentItem(1);
                break;
            case R.id.contact:
                main_viewpager.setCurrentItem(2);
                break;
            case R.id.setting:
                main_viewpager.setCurrentItem(3);
                break;
        }
    }

    private class adapter_pager extends FragmentPagerAdapter {
        public adapter_pager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0:
                    return new WallpostActivity();
                case 1:
                    return new CalenderActivity();
                case 2:
                    return new AdressActivity();
                case 3:
                    return new SettingActivity();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return main_page;
        }
    }
}
