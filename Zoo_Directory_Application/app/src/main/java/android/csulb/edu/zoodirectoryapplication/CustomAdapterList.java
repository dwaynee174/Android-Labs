package android.csulb.edu.zoodirectoryapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Dhwani on 2/26/2016.
 */
public class CustomAdapterList extends ArrayAdapter<String> {
        Activity context;
        String[] names;
        Integer[] images;
        public CustomAdapterList(Activity context, String[] names, Integer[] images) {
            super(context, R.layout.animal_list_row,names);
            this.context = context;
            this.names= names;
            this.images=images;
        }
        public View getView(int position,View view,ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.animal_list_row, null,true);

            TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);

            txtTitle.setText(names[position]);
            imageView.setImageResource(images[position]);
            return rowView;
        }
    }


