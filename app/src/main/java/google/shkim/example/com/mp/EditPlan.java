package google.shkim.example.com.mp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditPlan extends AppCompatActivity {

    private Database dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan);
        Button setDate=(Button)findViewById(R.id.setDate);
        Button submit=(Button)findViewById(R.id.submit);
        Button setLatLng = (Button)findViewById(R.id.setLatLng);
        TextView setaddress = (TextView)findViewById(R.id.setAddress);
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
}
