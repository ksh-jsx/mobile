package google.shkim.example.com.mp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan);
        Button setDate=(Button)findViewById(R.id.setDate);
        Button setPositionButton=(Button)findViewById(R.id.setPositionButtion);
        Button submit=(Button)findViewById(R.id.submit);

        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditPlan.this,setDate.class);
                startActivity(intent);
            }
        });
    }
}
