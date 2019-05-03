package google.shkim.example.com.mp;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class tempView {

    private View view;
    private int count = 0;
    public void getView(View view)
    {
         this.view = view;
    }

    public void setView()
    {
        TextView oTextTitle = (TextView) view.findViewById(R.id.textTitle);
        TextView oimgName = (TextView) view.findViewById(R.id.imgName);
        ImageView lineImage = (ImageView)view.findViewById(R.id.lineImage);
        Button listBtn = (Button)view.findViewById(R.id.listButton1);
        view.setBackgroundColor(Color.WHITE);
        if(oimgName.getText().equals("last"))
            lineImage.setImageResource(R.drawable.line_blue_non_bottom);
        else
            lineImage.setImageResource(R.drawable.line_blue);
        listBtn.setVisibility(View.INVISIBLE);
        oTextTitle.setTextColor(Color.rgb(51, 170, 187));

        return;
    }
}
