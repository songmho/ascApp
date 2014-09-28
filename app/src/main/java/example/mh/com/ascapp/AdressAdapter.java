package example.mh.com.ascapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by songmho on 2014-09-19.
 */
public class AdressAdapter extends BaseAdapter {

    private ArrayList<Adressitem> data;
    private LayoutInflater inflater;
    Context context;

    public AdressAdapter(Context context, ArrayList<Adressitem> data){
        this.context=context;
        this.data=data;
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
            inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.adressitem,viewGroup,false);
        }

        Adressitem adressitem=data.get(position);

        ImageView adress_profile=(ImageView)view.findViewById(R.id.adress_profile);
        adress_profile.setImageResource(adressitem.getProfile());

        TextView adress_name=(TextView)view.findViewById(R.id.adress_name);
        adress_name.setText(adressitem.getName());

        TextView adress_number=(TextView)view.findViewById(R.id.adress_number);
        adress_number.setText(adressitem.getNumber());

        TextView adress_phone=(TextView)view.findViewById(R.id.adress_phone);
        adress_phone.setText(adressitem.getPhone());

        return view;
    }
}
