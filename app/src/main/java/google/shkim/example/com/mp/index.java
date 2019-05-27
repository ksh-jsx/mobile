
package google.shkim.example.com.mp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

public class index extends AppCompatActivity implements View.OnClickListener{

    ArrayList<data> myDataArr;
    myadapter adapter;
    RecyclerView topRecyclerView,centerRecyclerView,bottomRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        setTitle("17101197");

        topRecyclerView = findViewById(R.id.main_top_recyclerview);
        centerRecyclerView = findViewById(R.id.main_center_recyclerview);
        bottomRecyclerView = findViewById(R.id.main_bottom_recyclerview);

        myDataArr = new ArrayList();
        myDataArr.add(new data(R.drawable.green_img,"GREEN","리스트1"));
        myDataArr.add(new data(R.drawable.blue_img,"BLUE","리스트2"));
        myDataArr.add(new data(R.drawable.red_img,"RED","리스트3"));
        myDataArr.add(new data(R.drawable.red_img,"RED","리스트4"));
        myDataArr.add(new data(R.drawable.blue_img,"BLUE","리스트5"));
        myDataArr.add(new data(R.drawable.green_img,"GREEN","리스트6"));
        myDataArr.add(new data(R.drawable.green_img,"GREEN","리스트7"));
        myDataArr.add(new data(R.drawable.green_img,"GREEN","리스트8"));
        myDataArr.add(new data(R.drawable.blue_img,"BLUE","리스트9"));
        myDataArr.add(new data(R.drawable.red_img,"RED","리스트10"));

        adapter = new myadapter(myDataArr);
        topRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        topRecyclerView.setAdapter(adapter);

        centerRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        centerRecyclerView.setAdapter(adapter);

        bottomRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        bottomRecyclerView.setAdapter(adapter);

        adapter.setOnItemClick(this);


    }

    @Override
    public void onClick(View view) {
        int position = topRecyclerView.getChildAdapterPosition(view);
        String numValue = myDataArr.get(position).content;
        Toast.makeText(getApplicationContext(),numValue+"번째 리스트입니다",Toast.LENGTH_SHORT).show();
    }
}



