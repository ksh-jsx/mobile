
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
import java.util.Calendar;
import java.util.Date;

public class index extends AppCompatActivity{
    int[] count = {0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        setTitle("17101197");

        ImageView imageView1= (ImageView) findViewById(R.id.img1);
        ImageView imageView2= (ImageView) findViewById(R.id.img2);
        ImageView imageView3= (ImageView) findViewById(R.id.img3);
        ImageView imageView4= (ImageView) findViewById(R.id.img4);
        ImageView imageView5= (ImageView) findViewById(R.id.img5);
        ImageView imageView6= (ImageView) findViewById(R.id.img6);
        ImageView imageView7= (ImageView) findViewById(R.id.img7);
        ImageView imageView8= (ImageView) findViewById(R.id.img8);
        ImageView imageView9= (ImageView) findViewById(R.id.img9);
        Button btn1 = (Button)findViewById(R.id.btn);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count[0]<5)
                    count[0]++;
                Toast.makeText(getApplicationContext(),"아이언맨: 총 "+count[0]+" 표",Toast.LENGTH_SHORT).show();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count[1]<5)
                    count[1]++;
                Toast.makeText(getApplicationContext(),"캡틴아메리카: 총 "+count[1]+" 표",Toast.LENGTH_SHORT).show();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count[2]<5)
                    count[2]++;
                Toast.makeText(getApplicationContext(),"토르: 총 "+count[2]+" 표",Toast.LENGTH_SHORT).show();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count[3]<5)
                    count[3]++;
                Toast.makeText(getApplicationContext(),"헐크: 총 "+count[3]+" 표",Toast.LENGTH_SHORT).show();
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count[4]<5)
                    count[4]++;
                Toast.makeText(getApplicationContext(),"스파이더맨: 총 "+count[4]+" 표",Toast.LENGTH_SHORT).show();
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count[5]<5)
                    count[5]++;
                Toast.makeText(getApplicationContext(),"앤트맨: 총 "+count[5]+" 표",Toast.LENGTH_SHORT).show();
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count[6]<5)
                    count[6]++;
                Toast.makeText(getApplicationContext(),"블랙팬서: 총 "+count[6]+" 표",Toast.LENGTH_SHORT).show();
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count[7]<5)
                    count[7]++;
                Toast.makeText(getApplicationContext(),"닥터스트레인지: 총 "+count[7]+" 표",Toast.LENGTH_SHORT).show();
            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count[8]<5)
                    count[8]++;
                Toast.makeText(getApplicationContext(),"캡틴마블: 총 "+count[8]+" 표",Toast.LENGTH_SHORT).show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Res.class);

                intent.putExtra("Count",count);

                startActivity(intent);
                finish();
            }
        });

    }
}


