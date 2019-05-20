package google.shkim.example.com.mp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class Res extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        setTitle("두번째 액티비티");

        Intent intent = getIntent();
        int[] res = intent.getIntArrayExtra("Count");

        Button btn = (Button)findViewById(R.id.btn2);

        RatingBar rating[] = new RatingBar[9];
        Integer ratingName[] = {R.id.rating1,R.id.rating2,R.id.rating3,R.id.rating4,
                R.id.rating5,R.id.rating6,R.id.rating7,R.id.rating8,R.id.rating9};

        for(int i=0;i<9;i++)
        {
         rating[i] = (RatingBar)findViewById(ratingName[i]);
        }

        for(int i=0;i<9;i++)
        {
            rating[i].setRating(res[i]);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),index.class);

                startActivity(intent);
                finish();
            }
        });

    }
}
