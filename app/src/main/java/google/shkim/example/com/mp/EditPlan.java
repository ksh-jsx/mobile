package google.shkim.example.com.mp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class EditPlan extends Activity {

    private Database dbHelper;
    private static final String DEBUG_TAG = "{LOG_ANDROID}";
    private int year= Calendar.getInstance().get(Calendar.YEAR);
    private int month=Calendar.getInstance().get(Calendar.MONTH)+1;
    private int date=Calendar.getInstance().get(Calendar.DATE);

    private DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int Year, int monthOfYear, int dayOfMonth) {
            year=Year;
            month=monthOfYear+1;
            date=dayOfMonth;
            TextView dateShow=(TextView)findViewById(R.id.dateValue);
            if(month<10 && date<10)
                dateShow.setText(year+"년 "+"0"+month+"월 "+"0"+date+"일");
            else if(month<10 && date>10)
                dateShow.setText(year+"년 "+"0"+month+"월 "+date+"일");
            else if(month>10 && date<10)
                dateShow.setText(year+"년 "+month+"월 "+"0"+date+"일");
            else
                dateShow.setText(year+"년 "+month+"월 "+date+"일");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan);

        Button setDate=(Button)findViewById(R.id.setDate);
        Button setAddress = (Button)findViewById(R.id.setAddress);
        Button submit=(Button)findViewById(R.id.submit);
        Button back=(Button)findViewById(R.id.back);
        final EditText getName = (EditText)findViewById(R.id.placeNameValue);
        final EditText getDate = (EditText)findViewById(R.id.dateValue);
                        getDate.setEnabled(false);
        final TimePicker getTime = (TimePicker)findViewById(R.id.timeValue);
        final TextView getAddress = (TextView)findViewById(R.id.AddressValue);
        final TextView getlat = (TextView)findViewById(R.id.latValue);
        final TextView getlng = (TextView)findViewById(R.id.lngValue);

        if(month<10 && date<10)
            getDate.setText(year+"년 "+"0"+month+"월 "+"0"+date+"일");
        else if(month<10 && date>10)
            getDate.setText(year+"년 "+"0"+month+"월 "+date+"일");
        else if(month>10 && date<10)
            getDate.setText(year+"년 "+month+"월 "+"0"+date+"일");
        else
            getDate.setText(year+"년 "+month+"월 "+date+"일");

        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(EditPlan.this,dateSetListener,year,month-1,date).show();
            }
        });
        setAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditPlan.this,google.class);
                startActivity(intent);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameValue = getName.getText().toString();
                String fullDatevalue = getDate.getText().toString();
                String yearValue = fullDatevalue.substring(0,4);
                String monthValue =  fullDatevalue.substring(6,8);
                String dateValue =  fullDatevalue.substring(10,12);
                int hourValue = getTime.getHour();
                int minuteValue = getTime.getMinute();
                String latString = getlat.getText().toString();
                String lngString = getlng.getText().toString();

                Log.d(DEBUG_TAG, "name : " + nameValue);
                Log.d(DEBUG_TAG, "Fulldate : " + fullDatevalue);
                Log.d(DEBUG_TAG, "year : " + yearValue);
                Log.d(DEBUG_TAG, "month : " + monthValue);
                Log.d(DEBUG_TAG, "date : " + dateValue);
                Log.d(DEBUG_TAG, "hour : " + hourValue);
                Log.d(DEBUG_TAG, "minute : " + minuteValue);

                Log.d(DEBUG_TAG, "location : " + latString + ", " + lngString);
                if(nameValue.length() == 0)
                    Toast.makeText(getApplicationContext(), "장소명을 입력해주세요", Toast.LENGTH_SHORT).show();
                else if(fullDatevalue.length() == 0)
                    Toast.makeText(getApplicationContext(), "날짜를 입력해주세요", Toast.LENGTH_SHORT).show();
                else if(latString.length() == 0)
                    Toast.makeText(getApplicationContext(), "위치를 입력해주세요", Toast.LENGTH_SHORT).show();
                else
                {
                    //dbHelper.insert("insert into infos values('" + adr + "'," + lat + ", " + lng + ");");//여긴 건들 ㄴㄴ
                    Intent intent = new Intent(EditPlan.this,index.class);
                    startActivity(intent);
                }

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
            getAddress.setText(cursor1.getString(0));
            getlat.setText(cursor1.getString(1));
            getlng.setText(cursor1.getString(2));
        }

    }
}

