package google.shkim.example.com.mp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditPlan extends Activity {

    private Database dbHelper;
    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    TextView dateShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan);

        Button setDate=(Button)findViewById(R.id.setDate);
        Button submit=(Button)findViewById(R.id.submit);
        Button back=(Button)findViewById(R.id.back);
        Button setLatLng = (Button)findViewById(R.id.setLatLng);
        TextView setaddress = (TextView)findViewById(R.id.setAddress);

        dateShow=(TextView)findViewById(R.id.dateShow);
        dateShow.setText(getTime());


        TextView setlat = (TextView)findViewById(R.id.setPositionLatitude);
        TextView setlng = (TextView)findViewById(R.id.setPositionLatitude);

        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditPlan.this,setDate.class);
                startActivity(intent);
            }
        });
        setLatLng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditPlan.this,google.class);
                startActivity(intent);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditPlan.this,index.class);
                startActivity(intent);
            }
        });
        dbHelper = new Database(getApplicationContext(), "SQLite.db", null, 1);

        final Cursor cursor1 = dbHelper.select("SELECT * FROM markerPoint;");
        cursor1.moveToFirst();
        if(cursor1.isFirst()) {
            setaddress.setText(cursor1.getString(0));
            setlat.setText(cursor1.getString(1));
            setlng.setText(cursor1.getString(2));
        }

    }

    private String getTime() {
        return sdf.format(date);
    }
}
