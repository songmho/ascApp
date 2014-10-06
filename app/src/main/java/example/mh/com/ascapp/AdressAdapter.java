package example.mh.com.ascapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by songmho on 2014-09-19.
 */
public class AdressAdapter extends BaseExpandableListAdapter {

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Adressgroupitem> group;

    public AdressAdapter(Context context,ArrayList<Adressgroupitem> group){
        this.context=context;
        this.group=group;
    }

    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public int getChildrenCount(int i) {
        ArrayList<Adresschilditem> child=group.get(i).getItem();
        return child.size();
    }

    @Override
    public Object getGroup(int i) {
        return group.get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        ArrayList<Adresschilditem> child=group.get(i).getItem();
        return child.get(i2);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        Adressgroupitem group=(Adressgroupitem)getGroup(i);
        if(view==null){
           inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.adressgroup,null);
        }
        TextView number=(TextView)view.findViewById(R.id.adress_number);
        number.setText(group.getNumber());
        return view;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
        Adresschilditem child=(Adresschilditem)getChild(i,i2);
        if(view==null){
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.adressitem,null);
        }

        TextView name=(TextView)view.findViewById(R.id.adress_name);
        TextView phone=(TextView)view.findViewById(R.id.adress_phone);

        name.setText(child.getName().toString());
        phone.setText(child.getPhone().toString());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
