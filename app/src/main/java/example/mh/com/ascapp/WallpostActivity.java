package example.mh.com.ascapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by songmho on 2014-09-25.
 */
public class WallpostActivity extends Fragment {
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout wallpostactivity=(LinearLayout)inflater.inflate(R.layout.activity_wallpost,container,false);
        context=getActivity();

        return wallpostactivity;
    }
}
