
package google.shkim.example.com.mp;

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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class index extends AppCompatActivity {
    LinearLayout baseLayout;
    Button button1;
    View toastView;
    TextView textView3;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        setTitle("여섯번째 과제");

        baseLayout = (LinearLayout)findViewById(R.id.base);
        button1 = (Button)findViewById(R.id.button1);
        final TextView textView1= (TextView)findViewById(R.id.textView1);
        final TextView textView2= (TextView)findViewById(R.id.textView2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index=0;
                final String[] versionArray = new String[] {"파이리","꼬부기","이상해씨"};
                if(versionArray[0].equals(textView1.getText().toString()))
                    index = 0;
                else if(versionArray[1].equals(textView1.getText().toString()))
                    index = 1;
                else if(versionArray[1].equals(textView1.getText().toString()))
                    index =2;

                AlertDialog.Builder dlg = new AlertDialog.Builder(index.this);
                dlg.setTitle("포켓몬");
                dlg.setIcon(R.drawable.ball);
                dlg.setSingleChoiceItems(versionArray,index,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView2.setText(versionArray[i]);
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView1.setText(textView2.getText().toString());
                        Toast toast = new Toast(index.this);
                        toastView = (View)View.inflate(index.this,R.layout.toast1,null);
                        textView3 = (TextView)toastView.findViewById(R.id.toastText1);
                        textView3.setText(textView2.getText().toString()+"를 선택했습니다");
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }
}


