
package google.shkim.example.com.mp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class index extends AppCompatActivity{

    String temp1;
    String temp2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        setTitle("아이돌 관리 DB");

        final data dbHelper = new data(getApplicationContext(), "project11.db", null, 1);
        final EditText nametxt = (EditText) findViewById(R.id.nametxt);
        final EditText personneltxt = (EditText) findViewById(R.id.personneltxt);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);

        final EditText view1 = (EditText) findViewById(R.id.view1);
        final EditText view2 = (EditText) findViewById(R.id.view2);

        temp1 = "";
        temp2 = "";

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor1 = dbHelper.select("select * from singers order by _id");
                cursor1.moveToFirst();
                if (cursor1.isFirst()) {
                    dbHelper.delete("delete from singers;");
                    //onCreate(savedInstanceState);
                }

                if (cursor1.isFirst()) {
                    for (int i = 0; i < cursor1.getCount(); i++) {
                        temp1 += cursor1.getString(0) + "\n";
                        temp2 += cursor1.getString(1) + "\n";
                        cursor1.moveToNext();
                    }
                    view1.setText("그룹이름\n----------\n" + temp1);
                    view2.setText("인원\n----------\n" + temp2);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nametxt.getText().length()>1 && personneltxt.getText().length() > 1)
                    dbHelper.insert("insert into singers(name,personnel) values('" + nametxt.getText().toString() + "'," + personneltxt.getText() + ");");

                Cursor cursor1 = dbHelper.select("select * from singers order by _id");
                Log
                cursor1.moveToFirst();
                if (cursor1.isFirst()) {
                    for (int i = 0; i < cursor1.getCount(); i++) {
                        temp1 += cursor1.getString(0) + "\n";
                        temp2 += cursor1.getString(1) + "\n";
                        cursor1.moveToNext();
                    }
                    view1.setText("그룹이름\n----------\n" + temp1);
                    view2.setText("인원\n----------\n" + temp2);
                }
               // onCreate(savedInstanceState);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor1 = dbHelper.select("select * from singers order by _id");
                cursor1.moveToFirst();
                if (cursor1.isFirst()) {
                    dbHelper.insert("update singers set personnel = " + personneltxt.getText() + " where name = '" + nametxt.getText().toString() + "';");
                    // onCreate(savedInstanceState);
                }

                if (cursor1.isFirst()) {
                    for (int i = 0; i < cursor1.getCount(); i++) {
                        temp1 += cursor1.getString(0) + "\n";
                        temp2 += cursor1.getString(1) + "\n";
                        cursor1.moveToNext();
                    }
                    view1.setText("그룹이름\n----------\n" + temp1);
                    view2.setText("인원\n----------\n" + temp2);
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor1 = dbHelper.select("select * from singers order by _id");
                cursor1.moveToFirst();
                if (cursor1.isFirst()) {
                    dbHelper.delete("delete from singers where name = '" + nametxt.getText() + "' and personnel = " + personneltxt.getText() + ";");
                   // onCreate(savedInstanceState);
                }

                if (cursor1.isFirst()) {
                    for (int i = 0; i < cursor1.getCount(); i++) {
                        temp1 += cursor1.getString(0) + "\n";
                        temp2 += cursor1.getString(1) + "\n";
                        cursor1.moveToNext();
                    }
                    view1.setText("그룹이름\n----------\n" + temp1);
                    view2.setText("인원\n----------\n" + temp2);
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor1 = dbHelper.select("select * from singers order by _id");
                cursor1.moveToFirst();
                if (cursor1.isFirst()) {
                    for (int i = 0; i < cursor1.getCount(); i++) {
                        temp1 += cursor1.getString(0) + "\n";
                        temp2 += cursor1.getString(1) + "\n";
                        cursor1.moveToNext();
                    }
                    view1.setText("그룹이름\n----------\n" + temp1);
                    view2.setText("인원\n----------\n" + temp2);
                }
            }
        });

        view1.setText("그룹이름\n----------\n");
        view2.setText("인원\n----------\n");

    }
}



