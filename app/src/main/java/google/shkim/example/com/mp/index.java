package google.shkim.example.com.mp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        final CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        final TextView textView = (TextView)findViewById(R.id.textView);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.rGroup);
        final RadioButton radioButton1 = (RadioButton)findViewById(R.id.radio1);
        final RadioButton radioButton2 = (RadioButton)findViewById(R.id.radio2);
        final RadioButton radioButton3 = (RadioButton)findViewById(R.id.radio3);
        final Button button = (Button)findViewById(R.id.button);
        final ImageView image0 = (ImageView)findViewById(R.id.imageView0);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBox.isChecked())
                {
                    radioGroup.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                    image0.setVisibility(View.VISIBLE);
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               if(radioButton1.isChecked()) {
                   image0.setImageResource(R.drawable.pa);
               }
               else if(radioButton2.isChecked()) {
                   image0.setImageResource(R.drawable.kko);
               }
               else if(radioButton3.isChecked()) {
                   image0.setImageResource(R.drawable.lee);
               }
            }
        });






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "파이리를 선택하셨습니다.", Toast.LENGTH_LONG).show();
                }
                else if(radioButton2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "꼬부기를 선택하셨습니다.", Toast.LENGTH_LONG).show();
                }
                else if(radioButton3.isChecked()) {
                    Toast.makeText(getApplicationContext(), "이상해씨를 선택하셨습니다.", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}




