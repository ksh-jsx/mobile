package google.shkim.example.com.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class index extends Activity {

    private final long FINISH_INTERVAL_TIME = 2000;
    private long   backPressedTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Button gotoPlan = (Button)findViewById(R.id.gotoPlan);
        final Database dbHelper = new Database(getApplicationContext(), "SQLite3.db", null, 1);


        gotoPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.delete("delete from markerPoint;");
                Intent intent = new Intent(index.this, EditPlan.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed()
    {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            finishAffinity();
        }
        else
        {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "한번 더 뒤로가기 누르면 꺼짐.", Toast.LENGTH_SHORT).show();
        }

    }
}
