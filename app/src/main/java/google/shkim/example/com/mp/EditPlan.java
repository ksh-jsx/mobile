package google.shkim.example.com.mp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class EditPlan extends Activity {

    private Database dbHelper;
    private int year= Calendar.getInstance().get(Calendar.YEAR);
    private int month=Calendar.getInstance().get(Calendar.MONTH)+1;
    private int date=Calendar.getInstance().get(Calendar.DATE);

    private DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int Year, int monthOfYear, int dayOfMonth) {
            year=Year;
            month=monthOfYear+1;
            date=dayOfMonth;
            TextView dateShow=(TextView)findViewById(R.id.dateShow);
            dateShow.setText(year+" - "+month+" - "+date);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan);

        Button setDate=(Button)findViewById(R.id.setDate);
        Button submit=(Button)findViewById(R.id.submit);
        Button back=(Button)findViewById(R.id.back);
        Button setLatLng = (Button)findViewById(R.id.setLatLng);
        TextView setaddress = (TextView)findViewById(R.id.setAddress);
        TextView dateShow=(TextView)findViewById(R.id.dateShow);

        dateShow.setText(year+" - "+month+" - "+date);


        TextView setlat = (TextView)findViewById(R.id.setPositionLatitude);
        TextView setlng = (TextView)findViewById(R.id.setPositionLatitude);

        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(EditPlan.this,dateSetListener,year,month-1,date).show();
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

        back.setOnClickListener(new View.OnClickListener() {
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
