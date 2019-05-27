package google.shkim.example.com.mp;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myviewholder> {

    ArrayList<data> myarr;
    View.OnClickListener onItemClick;

    void setOnItemClick(View.OnClickListener i)
    {
        onItemClick = i;
    }

    public myadapter(ArrayList<data> myDataArr) {
        this.myarr = myDataArr;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);

        itemView.setOnClickListener(onItemClick);

        return new myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        String r = "#FF0000";
        String g = "#00FF00";
        String b = "#0000FF";
        holder.colorImg.setImageResource(myarr.get(position).color);
        holder.colorName.setText(myarr.get(position).colorName);
        if(myarr.get(position).colorName.equals("RED")) {
            holder.colorName.setTextColor(Color.parseColor(r));
            holder.content.setTextColor(Color.parseColor(r));
        }
        else if(myarr.get(position).colorName.equals("GREEN")){
            holder.colorName.setTextColor(Color.parseColor(g));
            holder.content.setTextColor(Color.parseColor(g));
        }
        else if(myarr.get(position).colorName.equals("BLUE")) {
            holder.colorName.setTextColor(Color.parseColor(b));
            holder.content.setTextColor(Color.parseColor(b));
        }
        holder.content.setText(myarr.get(position).content);
    }

    @Override
    public int getItemCount() {
        return myarr.size();
    }
}
