package google.shkim.example.com.mp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myviewholder> {

    ArrayList<data> myarr;

    public myadapter(ArrayList<data> myDataArr) {
        this.myarr = myDataArr;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);

        return new myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.colorImg.setImageResource(myarr.get(position).color);
        holder.colorName.setText(myarr.get(position).colorName);
        holder.content.setText(myarr.get(position).content);
    }

    @Override
    public int getItemCount() {
        return myarr.size();
    }
}
