package google.shkim.example.com.mp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class index extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Button gotoPlan = (Button)findViewById(R.id.gotoPlan);
        final Database dbHelper = new Database(getApplicationContext(), "SQLite.db", null, 1);


        gotoPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.delete("delete from markerPoint;");
                Intent intent = new Intent(index.this, EditPlan.class);
                startActivity(intent);
            }
        });
    }


}
