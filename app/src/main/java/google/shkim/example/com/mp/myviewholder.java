package google.shkim.example.com.mp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class myviewholder extends RecyclerView.ViewHolder {
    public myviewholder(@NonNull View itemview)
    {
        super(itemview);
    }

    ImageView colorImg = itemView.findViewById(R.id.item_color_img);
    TextView colorName = itemView.findViewById(R.id.item_colorname_tv);
    TextView content = itemView.findViewById(R.id.item_content_tv);

}

