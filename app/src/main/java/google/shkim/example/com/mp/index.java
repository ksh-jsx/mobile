package google.shkim.example.com.mp;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class index  extends Activity
{
    private ListView m_oListView = null;
    private final long FINISH_INTERVAL_TIME = 2000;
    private long   backPressedTime = 0;
    Button gotoPlan;
    Button del;
    private static final String DEBUG_TAG = "{LOG_ANDROID}";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        gotoPlan = (Button)findViewById(R.id.gotoPlan);
        del = (Button)findViewById(R.id.del);
        String dateSave = "a";
        final Database dbHelper = new Database(getApplicationContext(), "SQLite3.db", null, 1);
        ListView listview = (ListView)findViewById(R.id.List_view);
        TextView noticeText = (TextView)findViewById(R.id.notice);
        // 데이터 생성.
        Cursor cursor1 = dbHelper.select("SELECT * FROM infos");
        cursor1.moveToFirst();
        if(cursor1.getCount() != 0)
        {
            listview.setVisibility(View.VISIBLE);
            noticeText.setVisibility(View.GONE);
        }

        ArrayList<ItemData> oData = new ArrayList<>();
        for (int i=0; i<cursor1.getCount(); ++i)
        {
            ItemData oItem = new ItemData();
            oItem.strTitle = cursor1.getString(1);
            oItem.strTIme = cursor1.getInt(5)+"시 "+cursor1.getInt(6)+"분";
            oItem.strDate = cursor1.getInt(2)+"년"+cursor1.getInt(3)+"월"+cursor1.getInt(4)+"일";
            oItem.count1 = i+1;
            oItem.count2 = cursor1.getCount();
            if(!dateSave.equals(oItem.strDate))
                i--;
            else
                cursor1.moveToNext();

            dateSave = oItem.strDate;
            oData.add(oItem);
        }

        // ListView 생성
        m_oListView = (ListView)findViewById(R.id.List_view);
        ListAdapter oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);

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


