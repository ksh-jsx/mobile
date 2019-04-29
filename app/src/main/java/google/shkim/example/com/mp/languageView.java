package google.shkim.example.com.mp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class languageView extends Activity {

    ArrayList arrayList;
    private Database dbHelper;
    String selectedItem;
    private static final String DEBUG_TAG = "{LOG_ANDROID}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_view);
        dbHelper = new Database(getApplicationContext(), "SQLite.db", null, 1);
        Cursor cursor1 = dbHelper.select("SELECT * FROM spinnerSelect");
        cursor1.moveToFirst();
        Log.d(DEBUG_TAG, "list : " + cursor1.getString(0));

        String[][] itmesA_1 = {
                {"안녕하세요\n\nhello\n\n헬로우", "안녕히 가세요\n\nGood bye\n\n굿 바이", "처음 뵙겠습니다\n\nnice to meet you\n\n나이스 투 미트 유", "제 이름은 ***입니다\n\nMy name is ***\n\n마이 네임 이즈 ***"},
                {"안녕하세요\n\nこんにちは\n\n\n곤니찌와", "안녕히 가세요\n\nさようなら\n\n사요나라", "처음 뵙겠습니다\n\n始めまして\n\n하지메마시떼", "저는 ***입니다\n\n私は***です\n\n와따시와***데스"},
                {"안녕하세요\n\n你好\n\n니하오", "안녕히 가세요\n\n再见\n\n짜이찌엔", "처음 뵙겠습니다\n\n初次见面\n\n하추츠 젠 멘", "저는 ***입니다\n\n我叫***\n\n워 쟈오 ***"},
                {"안녕하세요\n\nBonjours\n\n봉쥬르", "안녕히 가세요\n\nAu revoir\n\n오흐브와흐", "처음 뵙겠습니다\n\nEnchantée\n\n엉셩떼", "저는 ***입니다\n\nJe suis ***\n\n즈 쒸 ***"},
                {"안녕하세요\n\nHola\n\n올라", "안녕히 가세요\n\nAdiós\n\n아디오스", "처음 뵙겠습니다\n\nMucho gusto\n\n무쵸 구스토", "저는 ***입니다\n\nsoy ***\n\n소이 ***"}
        };
        String[][] itmesA_2 = {
                {"안녕하세요\n\nhello\n\n헬로우", "안녕히 가세요\n\nGood bye\n\n굿 바이", "처음 뵙겠습니다\n\nnice to meet you\n\n나이스 투 미트 유", "제 이름은 ***입니다\n\nMy name is ***\n\n마이 네임 이즈 ***"},
                {"안녕하세요\n\nこんにちは\n\n\n곤니찌와", "안녕히 가세요\n\nさようなら\n\n사요나라", "처음 뵙겠습니다\n\n始めまして\n\n하지메마시떼", "저는 ***입니다\n\n私は***です\n\n와따시와***데스"},
                {"안녕하세요\n\n你好\n\n니하오", "안녕히 가세요\n\n再见\n\n짜이찌엔", "처음 뵙겠습니다\n\n初次见面\n\n하추츠 젠 멘", "저는 ***입니다\n\n我叫***\n\n워 쟈오 ***"},
                {"안녕하세요\n\nBonjours\n\n봉쥬르", "안녕히 가세요\n\nAu revoir\n\n오흐브와흐", "처음 뵙겠습니다\n\nEnchantée\n\n엉셩떼", "저는 ***입니다\n\nJe suis ***\n\n즈 쒸 ***"},
                {"안녕하세요\n\nHola\n\n올라", "안녕히 가세요\n\nAdiós\n\n아디오스", "처음 뵙겠습니다\n\nMucho gusto\n\n무쵸 구스토", "저는 ***입니다\n\nsoy ***\n\n소이 ***"}
        };
        String[][] itmesA_3 = {
                {"안녕하세요\n\nhello\n\n헬로우", "안녕히 가세요\n\nGood bye\n\n굿 바이", "처음 뵙겠습니다\n\nnice to meet you\n\n나이스 투 미트 유", "제 이름은 ***입니다\n\nMy name is ***\n\n마이 네임 이즈 ***"},
                {"안녕하세요\n\nこんにちは\n\n\n곤니찌와", "안녕히 가세요\n\nさようなら\n\n사요나라", "처음 뵙겠습니다\n\n始めまして\n\n하지메마시떼", "저는 ***입니다\n\n私は***です\n\n와따시와***데스"},
                {"안녕하세요\n\n你好\n\n니하오", "안녕히 가세요\n\n再见\n\n짜이찌엔", "처음 뵙겠습니다\n\n初次见面\n\n하추츠 젠 멘", "저는 ***입니다\n\n我叫***\n\n워 쟈오 ***"},
                {"안녕하세요\n\nBonjours\n\n봉쥬르", "안녕히 가세요\n\nAu revoir\n\n오흐브와흐", "처음 뵙겠습니다\n\nEnchantée\n\n엉셩떼", "저는 ***입니다\n\nJe suis ***\n\n즈 쒸 ***"},
                {"안녕하세요\n\nHola\n\n올라", "안녕히 가세요\n\nAdiós\n\n아디오스", "처음 뵙겠습니다\n\nMucho gusto\n\n무쵸 구스토", "저는 ***입니다\n\nsoy ***\n\n소이 ***"}
        };
        String[][] itmesA_4 = {
                {"안녕하세요\n\nhello\n\n헬로우", "안녕히 가세요\n\nGood bye\n\n굿 바이", "처음 뵙겠습니다\n\nnice to meet you\n\n나이스 투 미트 유", "제 이름은 ***입니다\n\nMy name is ***\n\n마이 네임 이즈 ***"},
                {"안녕하세요\n\nこんにちは\n\n\n곤니찌와", "안녕히 가세요\n\nさようなら\n\n사요나라", "처음 뵙겠습니다\n\n始めまして\n\n하지메마시떼", "저는 ***입니다\n\n私は***です\n\n와따시와***데스"},
                {"안녕하세요\n\n你好\n\n니하오", "안녕히 가세요\n\n再见\n\n짜이찌엔", "처음 뵙겠습니다\n\n初次见面\n\n하추츠 젠 멘", "저는 ***입니다\n\n我叫***\n\n워 쟈오 ***"},
                {"안녕하세요\n\nBonjours\n\n봉쥬르", "안녕히 가세요\n\nAu revoir\n\n오흐브와흐", "처음 뵙겠습니다\n\nEnchantée\n\n엉셩떼", "저는 ***입니다\n\nJe suis ***\n\n즈 쒸 ***"},
                {"안녕하세요\n\nHola\n\n올라", "안녕히 가세요\n\nAdiós\n\n아디오스", "처음 뵙겠습니다\n\nMucho gusto\n\n무쵸 구스토", "저는 ***입니다\n\nsoy ***\n\n소이 ***"}
        };
        String[][] itmesA_5 = {
                {"안녕하세요\n\nhello\n\n헬로우", "안녕히 가세요\n\nGood bye\n\n굿 바이", "처음 뵙겠습니다\n\nnice to meet you\n\n나이스 투 미트 유", "제 이름은 ***입니다\n\nMy name is ***\n\n마이 네임 이즈 ***"},
                {"안녕하세요\n\nこんにちは\n\n\n곤니찌와", "안녕히 가세요\n\nさようなら\n\n사요나라", "처음 뵙겠습니다\n\n始めまして\n\n하지메마시떼", "저는 ***입니다\n\n私は***です\n\n와따시와***데스"},
                {"안녕하세요\n\n你好\n\n니하오", "안녕히 가세요\n\n再见\n\n짜이찌엔", "처음 뵙겠습니다\n\n初次见面\n\n하추츠 젠 멘", "저는 ***입니다\n\n我叫***\n\n워 쟈오 ***"},
                {"안녕하세요\n\nBonjours\n\n봉쥬르", "안녕히 가세요\n\nAu revoir\n\n오흐브와흐", "처음 뵙겠습니다\n\nEnchantée\n\n엉셩떼", "저는 ***입니다\n\nJe suis ***\n\n즈 쒸 ***"},
                {"안녕하세요\n\nHola\n\n올라", "안녕히 가세요\n\nAdiós\n\n아디오스", "처음 뵙겠습니다\n\nMucho gusto\n\n무쵸 구스토", "저는 ***입니다\n\nsoy ***\n\n소이 ***"}
        };
        String[][] items1 = {{"a"}};
        if(cursor1.getString(0).equals("A1"))
            items1 = itmesA_1;
        else if (cursor1.getString(0).equals("A2"))
            items1 = itmesA_2;
        else if (cursor1.getString(0).equals("A3"))
            items1 = itmesA_3;
        else if (cursor1.getString(0).equals("A4"))
            items1 = itmesA_4;
        else if (cursor1.getString(0).equals("A5"))
            items1 = itmesA_5;


        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items1[0]) ;
        Button button = (Button)findViewById(R.id.ok);
        final ListView e = (ListView) findViewById(R.id.e);
        e.setAdapter(adapter1);

        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items1[1]);
        final ListView j = (ListView) findViewById(R.id.j);
        j.setAdapter(adapter2);

        ArrayAdapter adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items1[2]);
        final ListView c = (ListView) findViewById(R.id.c);
        c.setAdapter(adapter3);

        ArrayAdapter adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items1[3]);
        final ListView f = (ListView) findViewById(R.id.f);
        f.setAdapter(adapter4);

        ArrayAdapter adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items1[4]);
        final ListView s = (ListView) findViewById(R.id.s);
        s.setAdapter(adapter5);





        arrayList = new ArrayList();
        arrayList.add("선택하세요");
        arrayList.add("영어");
        arrayList.add("일본어");
        arrayList.add("중국어");
        arrayList.add("프랑스어");
        arrayList.add("스페인어");



        Spinner spinner1 = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapterA = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item, arrayList);
        spinner1.setAdapter(adapterA);



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = (String) parent.getItemAtPosition(position);
                if (selectedItem.equals("영어")) {

                    e.setVisibility(View.VISIBLE);
                    j.setVisibility(View.GONE);
                    c.setVisibility(View.GONE);
                    f.setVisibility(View.GONE);
                    s.setVisibility(View.GONE);

                } else if (selectedItem.equals("일본어")) {

                    j.setVisibility(View.VISIBLE);
                    e.setVisibility(View.GONE);
                    c.setVisibility(View.GONE);
                    f.setVisibility(View.GONE);
                    s.setVisibility(View.GONE);

                } else if (selectedItem.equals("중국어")) {

                    c.setVisibility(View.VISIBLE);
                    j.setVisibility(View.GONE);
                    e.setVisibility(View.GONE);
                    f.setVisibility(View.GONE);
                    s.setVisibility(View.GONE);

                } else if (selectedItem.equals("프랑스어")) {

                    f.setVisibility(View.VISIBLE);
                    j.setVisibility(View.GONE);
                    c.setVisibility(View.GONE);
                    e.setVisibility(View.GONE);
                    s.setVisibility(View.GONE);

                } else if (selectedItem.equals("스페인어")) {

                    s.setVisibility(View.VISIBLE);
                    j.setVisibility(View.GONE);
                    c.setVisibility(View.GONE);
                    f.setVisibility(View.GONE);
                    e.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });



    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(languageView.this, index.class);
            startActivity(intent);
        }
    });


    }


}
