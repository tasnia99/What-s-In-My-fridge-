package com.example.designpage;

import android.content.Context;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter implements Filterable {
    Context context;
    int[] pic;
    String[] foodNames;
    private LayoutInflater inflater;
    private List<String>filteredData=null;

    CustomAdapter(Context context, String[] foodNames, int[] pic) {
        this.context = context;
        this.foodNames = foodNames;
        this.pic = pic;
    }



    @Override
    public int getCount() {
        return foodNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.sample_view, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewId);
        TextView textView = (TextView) view.findViewById(R.id.textviewid);
        imageView.setImageResource(pic[position]);
        textView.setText(foodNames[position]);


        return view;
    }

  @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                constraint = constraint.toString().toLowerCase();
                FilterResults results = new FilterResults();
                ArrayList<String> f = new ArrayList<String>();
                ArrayList<String> p = new ArrayList<String>();
                for (String product : foodNames) {
                    p.add(product);
                }
                if (constraint != null && constraint.toString().length() > 0) {
                    for (int i = 0; i < p.size(); i++) {
                        String product = p.get(i);
                        if (product.toLowerCase().contains(constraint)) ;
                        f.add(product);
                    }
                    results.count = f.size();
                    results.values = f;
                } else {
                    results.values = p;
                    results.count = p.size();
                }
                return results;
            }

          @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredData = (List<String>) results.values;
                notifyDataSetChanged();
            }
        };

    }
}



