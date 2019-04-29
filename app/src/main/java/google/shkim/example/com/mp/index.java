
package google.shkim.example.com.mp;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class index extends AppCompatActivity {
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        setTitle("17101197");
        final EditText tv = (EditText) findViewById(R.id.setText);
        final Button btn = (Button)findViewById(R.id.btn1);
        DatePicker dp = (DatePicker)findViewById(R.id.getDate);


        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);
        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                fileName = Integer.toString(i) +"_" + Integer.toString(i1) +"_"
                        + Integer.toString(i2) + ".txt";
                String str = readDairy(fileName);
                tv.setText(str);
                btn.setEnabled(true);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = tv.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),fileName+"이 저장됨",Toast.LENGTH_SHORT).show();
                }
                catch(IOException e){}
            }
        });

    }
    String readDairy(String fName)
    {
        EditText tv = (EditText) findViewById(R.id.setText);
        Button btn = (Button)findViewById(R.id.btn1);
        String diaryStr = null;
        FileInputStream infs;
        try{
            infs = openFileInput(fName);
            byte[] txt = new byte[500];
            infs.read(txt);
            infs.close();
            diaryStr = (new String(txt).trim());
            btn.setText("수정하기");
        }catch(IOException e){
            tv.setHint("일기없음");
            btn.setText("새로저장");
        }
        return  diaryStr;
    }
}


