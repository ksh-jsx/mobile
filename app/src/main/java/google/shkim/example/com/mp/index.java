
package google.shkim.example.com.mp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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

public class index extends Activity {
    int scale = 1;
    int rotation = 45;
    int light = 1;
    int dark = 3;
    int count = 0;
    String bright[] = {"#FFFFFF","#F2F2F2","#E6E6E6","#848484","#2E2E2E","#000000"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);



        ImageButton btn1 = (ImageButton)findViewById(R.id.zoomIn);
        ImageButton btn2 = (ImageButton)findViewById(R.id.zoomOut);
        ImageButton btn3 = (ImageButton)findViewById(R.id.rotate);
        ImageButton btn4 = (ImageButton)findViewById(R.id.bright);
        ImageButton btn5 = (ImageButton)findViewById(R.id.dark);
        ImageButton btn6 = (ImageButton)findViewById(R.id.gray);
        final ImageView apple = (ImageView)findViewById(R.id.apple);

        final int cenX = apple.getWidth()/2;
        final int cenY = apple.getHeight()/2;
        final int picX = (apple.getWidth() - apple.getWidth())/2;
        final int picY = (apple.getHeight() - apple.getHeight())/2;

        apple.setColorFilter(Color.parseColor(bright[2]), PorterDuff.Mode.MULTIPLY);
       // canvas.scale(2, 2, cenX, cenY);
        //canvas.drawBitmap(picture,picX,picY,null);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apple.setScaleX(++scale);
                apple.setScaleY(scale);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(scale>1) {
                    apple.setScaleX(--scale);
                    apple.setScaleY(scale);
                }
                else
                    Toast.makeText(getApplicationContext(),"더이상 작아질 수 없습니다",Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apple.setRotation(rotation);
                rotation+=45;
                if(rotation ==360)
                    rotation = 0;
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apple.setColorFilter(Color.parseColor(bright[light]), PorterDuff.Mode.MULTIPLY);
                if(light>0) {
                    light--;
                    dark = light;

                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apple.setColorFilter(Color.parseColor(bright[dark]), PorterDuff.Mode.MULTIPLY);
                if(dark<5) {
                    dark++;
                    light = dark;
                }

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorMatrix matrix = new ColorMatrix();

                if(count % 2 == 0)
                    matrix.setSaturation(0);

                else
                    matrix.setSaturation(1);

                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
                apple.setColorFilter(filter);
                count++;
            }
        });

    }

    private static class MyGraphicView extends View{
        public MyGraphicView(Context context) {
            super(context);
        }
        @Override
        protected  void onDraw(final Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture = BitmapFactory.decodeResource(getResources(),R.drawable.apple);


        }
    }


}


