package google.shkim.example.com.mp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        final Dog dog1 = new Dog("강아지1",5);
        final Dog dog2 = new Dog("강아지2",3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date now = new Date();
                SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMdd");
                Toast.makeText(getApplicationContext(), sFormat.format(now), Toast.LENGTH_LONG).show();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date now = new Date();
                SimpleDateFormat sFormat = new SimpleDateFormat("HH:mm:ss");
                Toast.makeText(getApplicationContext(), sFormat.format(now), Toast.LENGTH_LONG).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dog1.plusCount();
                Toast.makeText(getApplicationContext(),"강아지 이름:"+dog1.getName(), Toast.LENGTH_LONG).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dog2.plusCount();
                Toast.makeText(getApplicationContext(), "강아지 이름:"+dog2.getName(), Toast.LENGTH_LONG).show();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dog1.getCount()>dog2.getCount())
                    Toast.makeText(getApplicationContext(), "강아지1 버튼이 더 많이 눌림", Toast.LENGTH_LONG).show();
                else if(dog1.getCount()<dog2.getCount())
                    Toast.makeText(getApplicationContext(), "강아지2 버튼이 더 많이 눌림", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "눌린 횟수 동일", Toast.LENGTH_LONG).show();
            }
        });




    }

    public class Dog
    {
        String name;
        int age;
        int clickCount;

        Dog(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
        String getName()
        {
            return name;
        }
        int getAge()
        {
            return age;
        }

        int getCount()
        {
            return clickCount;
        }
        void plusCount()
        {
            clickCount++;
        }

    }
}




