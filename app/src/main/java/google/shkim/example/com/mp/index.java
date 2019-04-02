package google.shkim.example.com.mp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class index extends Activity {

    private View header;
    private final long FINISH_INTERVAL_TIME = 2000;
    private long   backPressedTime = 0;
    private static final String DEBUG_TAG = "{LOG_ANDROID}";
    private ArrayList<HashMap<String,String>> Data = new ArrayList<HashMap<String, String>>();
    private HashMap<String,String> InputData1 = new HashMap<>();
    private static final String TAG_NAME = "name";
    private static final String TAG_DATE ="date";
    private static final String TAG_TIME ="time";
    ArrayList<HashMap<String, String>> infoList;
    ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Button gotoPlan = (Button)findViewById(R.id.gotoPlan);
        Button del = (Button)findViewById(R.id.del);
        final Database dbHelper = new Database(getApplicationContext(), "SQLite3.db", null, 1);
        ListView list = (ListView) findViewById(R.id.List_view);
        infoList = new ArrayList<HashMap<String,String>>();
        String dateSave = "";
        String name;
        String date;
        String time;
        int i;
        Cursor cursor1 = dbHelper.select("select * from infos order by Year asc, Month asc,Date asc,Hour asc,Minute asc");
        cursor1.moveToFirst();
        for(i=0;i<cursor1.getCount();i++)
        {

          Log.d(DEBUG_TAG, "name : " + cursor1.getString(1));
            Log.d(DEBUG_TAG, "time : " + cursor1.getString(5)+"시"+cursor1.getString(6)+"분");
            Log.d(DEBUG_TAG, "datesave : " + dateSave);

            name = cursor1.getString(1);
            date = cursor1.getString(2)+"년 "+cursor1.getString(3)+"월 "+cursor1.getString(4)+"일";
            time = cursor1.getString(5)+"시"+cursor1.getString(6)+"분";
            Log.d(DEBUG_TAG, "date : " + date);

            header = getLayoutInflater().inflate(R.layout.activity_list_item, null, false);
            LinearLayout nameTIme = (LinearLayout)header.findViewById(R.id.nameTime);
            TextView dateView = (TextView)header.findViewById(R.id.date);
            HashMap<String,String> infos = new HashMap<String,String>();
            if(dateSave.equals(date))
            {
                infos.put(TAG_NAME,name);
                infos.put(TAG_TIME,time);
                dateView.setVisibility(View.GONE);
                nameTIme.setVisibility(View.VISIBLE);
                cursor1.moveToNext();
            }
            else
            {
                infos.put(TAG_DATE,date);
                nameTIme.setVisibility(View.GONE);
                dateView.setVisibility(View.VISIBLE);
                i--;
            }

            //ArrayList에 추가합니다..
            infoList.add(infos);
            dateSave = date;

            infoList.add(header);
            if(date.equals("a")){}


            adapter = new SimpleAdapter(
                    this, infoList, R.layout.activity_list_item,
                    new String[]{TAG_NAME,TAG_DATE,TAG_TIME},
                    new int[]{ R.id.name, R.id.date, R.id.time}
            );
            list.setAdapter(adapter);
        }




        //화면에 보여주기 위해 Listview에 연결합니다.



        //setContentView(layout);

        gotoPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.delete("delete from markerPoint;");
                dbHelper.delete("delete from tempSave;");
                Intent intent = new Intent(index.this, EditPlan.class);
                startActivity(intent);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.delete("delete from infos;");
                view.invalidate();
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
