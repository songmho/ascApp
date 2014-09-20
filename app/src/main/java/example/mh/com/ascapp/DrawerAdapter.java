package example.mh.com.ascapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by songmho on 2014-09-18.
 */
public class DrawerAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private ArrayList<Draweritem> data;
    private int layout;

    public DrawerAdapter(Context context, int layout, ArrayList<Draweritem> data) {
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null){
            view=inflater.inflate(layout,viewGroup,false);
        }

        Draweritem draweritem=data.get(position);

        ImageView drawer_icon=(ImageView)view.findViewById(R.id.drawer_icon);
        drawer_icon.setImageResource(draweritem.getIcon());

        TextView drawer_name=(TextView)view.findViewById(R.id.drawer_name);
        drawer_name.setText(draweritem.getName());

        return view;
    }
}
