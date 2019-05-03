package google.shkim.example.com.mp;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class index  extends Activity
{
    private ListView m_oListView = null;
    private final long FINISH_INTERVAL_TIME = 2000;
    private long   backPressedTime = 0;
    private ArrayList<ListItem> data = null;
    Button gotoPlan;
    Button del;
    ArrayList arrayList;
    private int count = 0;
    String selectedItem;
    private static final String DEBUG_TAG = "{LOG_ANDROID}";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        gotoPlan = (Button)findViewById(R.id.gotoPlan);
        del = (Button)findViewById(R.id.del);
        String dateSave = "a";
        final Database dbHelper = new Database(getApplicationContext(), "SQLite.db", null, 1);
        final TextView TextTitle = (TextView) findViewById(R.id.textTitle);
        ListView listview = (ListView)findViewById(R.id.List_view);
        TextView noticeText = (TextView)findViewById(R.id.notice);
        TextView textTitle = (TextView)findViewById(R.id.textTitle);
        final tempView tempview = new tempView();
        ImageView tabWidget0 = new ImageView(this);
        tabWidget0.setImageResource(R.drawable.tab_00);
        ImageView tabWidget1 = new ImageView(this);
        tabWidget1.setImageResource(R.drawable.tab_01);
        ImageView tabWidget2 = new ImageView(this);
        tabWidget2.setImageResource(R.drawable.tab_02);

        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final Button button1 = (Button) findViewById(R.id.imgBtn1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        final Button button2 = (Button) findViewById(R.id.imgBtn2);
        final Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        final Button button4 = (Button) findViewById(R.id.imgBtn4);
        final Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
        final Button button5 = (Button) findViewById(R.id.imgBtn5);
        final Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
        final Button button6 = (Button) findViewById(R.id.imgBtn6);
        final Spinner spinner7 = (Spinner) findViewById(R.id.spinner7);
        final Button button7 = (Button) findViewById(R.id.imgBtn7);
        final Spinner spinner8 = (Spinner) findViewById(R.id.spinner8);
        final Button button8 = (Button) findViewById(R.id.imgBtn8);
        final Spinner spinner9 = (Spinner) findViewById(R.id.spinner9);
        final Button button9 = (Button) findViewById(R.id.imgBtn9);


        final TabHost tabhost = (TabHost)findViewById(R.id.tabHost1);
        tabhost.setup();

        TabHost.TabSpec ts1 = tabhost.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.content1) ;
        ts1.setIndicator(tabWidget0);
        tabhost.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        final TabHost.TabSpec ts2 = tabhost.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.content2) ;
        ts2.setIndicator(tabWidget1);
        tabhost.addTab(ts2) ;

        // 세 번째 Tab. (탭 표시 텍스트:"TAB 3"), (페이지 뷰:"content3")
        TabHost.TabSpec ts3 = tabhost.newTabSpec("Tab Spec 3") ;
        ts3.setContent(R.id.content3) ;
        ts3.setIndicator(tabWidget2);
        tabhost.addTab(ts3) ;

        tabhost.setCurrentTab(1);

        // 데이터 생성.
        Cursor cursor1 = dbHelper.select("SELECT * FROM infos");
        cursor1.moveToFirst();
        if(cursor1.getCount() != 0)
        {
            listview.setVisibility(View.VISIBLE);
            noticeText.setVisibility(View.GONE);
        }
        data = new ArrayList<>();
        ArrayList<ItemData> oData = new ArrayList<>();
        //데이터 삽입
        for (int i=0; i<cursor1.getCount(); ++i)
        {
            ItemData oItem = new ItemData();
            oItem.strTitle = cursor1.getString(1);
            oItem.strTIme = cursor1.getInt(5)+"시 "+cursor1.getInt(6)+"분";
            oItem.strDate = cursor1.getInt(2)+"년"+cursor1.getInt(3)+"월"+cursor1.getInt(4)+"일";
            oItem.strLat = cursor1.getString(7);
            oItem.strLng = cursor1.getString(8);
            oItem.count1 = i+1;
            oItem.count2 = cursor1.getCount();
            if(!dateSave.equals(oItem.strDate))
                i--;
            else
                cursor1.moveToNext();

            dateSave = oItem.strDate;
            oData.add(oItem);

            ListItem item1 = new ListItem(oItem.strTitle, oItem.strDate,oItem.strTIme,oItem.strLat,oItem.strLng);
            data.add(item1);
        }

        // ListView 생성
        m_oListView = (ListView)findViewById(R.id.List_view);
        ListAdapter oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);

        // ListView 클릭 이벤트
        m_oListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView oTextTitle = (TextView) view.findViewById(R.id.textTitle);
                TextView oimgName = (TextView) view.findViewById(R.id.imgName);
                ImageView lineImage = (ImageView)view.findViewById(R.id.lineImage);
                LinearLayout btns = (LinearLayout)view.findViewById(R.id.btns);
                view.setBackgroundColor(Color.rgb(51, 170, 187));
                if(count != 0) tempview.setView();
                if(oimgName.getText().equals("last"))
                    lineImage.setImageResource(R.drawable.line_sky_non_bottom);
                else
                    lineImage.setImageResource(R.drawable.line_sky);
                btns.setVisibility(View.VISIBLE);
                oTextTitle.setTextColor(Color.WHITE);
                //Log.d(DEBUG_TAG, "item: " +pos);
                Toast.makeText(getApplicationContext(),view+" "+data.get(i).getTitle()+" "+data.get(i).getLat(),Toast.LENGTH_SHORT).show();

                tempview.getView(view);
                count++;
            }
        });

        gotoPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.delete("delete from markerPoint;");
                dbHelper.delete("delete from tempSave;");
                Intent intent = new Intent(index.this, EditPlan.class);
                startActivity(intent);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.delete("delete from infos;");
                view.invalidate();
            }
        });

        //회화 화면 클릭리스터
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner1.setVisibility(View.VISIBLE);
                spinner1.performClick();
                spinner2.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                spinner9.setVisibility(View.GONE);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner2.performClick();
                spinner2.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                spinner9.setVisibility(View.GONE);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner4.performClick();
                spinner4.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.GONE);
                spinner2.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                spinner9.setVisibility(View.GONE);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner5.performClick();
                spinner5.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.GONE);
                spinner2.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                spinner9.setVisibility(View.GONE);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner6.performClick();
                spinner6.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.GONE);
                spinner2.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                spinner9.setVisibility(View.GONE);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner7.performClick();
                spinner7.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.GONE);
                spinner2.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                spinner9.setVisibility(View.GONE);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner8.performClick();
                spinner8.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.GONE);
                spinner2.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner9.setVisibility(View.GONE);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner9.performClick();
                spinner9.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.GONE);
                spinner2.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);

            }
        });

        //스피너 내용 삽입
        {

            arrayList = new ArrayList();
            arrayList.add("선택하세요");
            arrayList.add("인사");
            arrayList.add("부탁/요청");
            arrayList.add("감사/축하");
            arrayList.add("사과/용서");
            arrayList.add("질문/응답");


            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_spinner_dropdown_item, arrayList);
            spinner1.setAdapter(adapter1);


            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    dbHelper.delete("delete from spinnerSelect;");
                    selectedItem = (String) parent.getItemAtPosition(position);
                    if (selectedItem.equals("인사")) {
                        dbHelper.insert("insert into spinnerSelect values('" + "A1" + "');");
                        gotoLanguageView();
                    } else if (selectedItem.equals("부탁/요청")) {
                        dbHelper.insert("insert into spinnerSelect values('" + "A2" + "');");
                        gotoLanguageView();
                    } else if (selectedItem.equals("감사/축하")) {
                        dbHelper.insert("insert into spinnerSelect values('" + "A3" + "');");
                        gotoLanguageView();
                    } else if (selectedItem.equals("사과/용서")) {
                        dbHelper.insert("insert into spinnerSelect values('" + "A4" + "');");
                        gotoLanguageView();
                    } else if (selectedItem.equals("질문/응답")) {
                        dbHelper.insert("insert into spinnerSelect values('" + "A5" + "');");
                        gotoLanguageView();

                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });


        }
        {
            arrayList = new ArrayList();
            arrayList.add("선택하세요");
            arrayList.add("주문");
            arrayList.add("예약/출입구");
            arrayList.add("계산");
            arrayList.add("컴플레인");


            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_spinner_dropdown_item, arrayList);
            spinner2.setAdapter(adapter2);

            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    selectedItem = (String) parent.getItemAtPosition(position);
                    if (selectedItem.equals("주문")) {

                        Intent intent = new Intent(index.this, languageView.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("예약/출입구")) {

                        Intent intent = new Intent(index.this, languageView.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("계산")) {

                        Intent intent = new Intent(index.this, languageView.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("컴플레인")) {

                        Intent intent = new Intent(index.this, languageView.class);
                        startActivity(intent);
                        finish();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });

        }

        {
            arrayList = new ArrayList();
            arrayList.add("선택하세요");
            arrayList.add("택시");
            arrayList.add("버스");
            arrayList.add("지하철(모노레일)");
            arrayList.add("기차/배");
            arrayList.add("운전");


            ArrayAdapter<String> adapter4 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_spinner_dropdown_item, arrayList);
            spinner4.setAdapter(adapter4);

            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    selectedItem = (String) parent.getItemAtPosition(position);
                    if (selectedItem.equals("택시")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("버스")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("지하철(모노레일)")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("기차/배")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("운전")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });

        }
        {
            arrayList = new ArrayList();
            arrayList.add("선택하세요");

            arrayList.add("마트");
            arrayList.add("문구/서점");
            arrayList.add("의류상점");
            arrayList.add("물건 찾기");
            arrayList.add("가격/구매");
            arrayList.add("계산/포장/배달");
            arrayList.add("교환/환불");


            ArrayAdapter<String> adapter5 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_spinner_dropdown_item, arrayList);
            spinner5.setAdapter(adapter5);

            spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    selectedItem = (String) parent.getItemAtPosition(position);
                    if (selectedItem.equals("마트")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("문구/서점")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("의류상점")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("물건 찾기")) {
                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("가격/구매")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("계산/포장/배달")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("교환/환불")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });

        }
        {
            arrayList = new ArrayList();
            arrayList.add("선택하세요");
            arrayList.add("예약");
            arrayList.add("서비스/식사");
            arrayList.add("체크인/체크아웃");



            ArrayAdapter<String> adapter6 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_spinner_dropdown_item, arrayList);
            spinner6.setAdapter(adapter6);

            spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    selectedItem = (String) parent.getItemAtPosition(position);
                    if (selectedItem.equals("예약")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("서비스/식사")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("체크인/체크아웃")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });

        }
        {
            arrayList = new ArrayList();
            arrayList.add("선택하세요");
            arrayList.add("응급상황");
            arrayList.add("분실/도난");
            arrayList.add("재난");
            arrayList.add("교통 사고/위반");


            ArrayAdapter<String> adapter7 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_spinner_dropdown_item, arrayList);
            spinner7.setAdapter(adapter7);

            spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    selectedItem = (String) parent.getItemAtPosition(position);
                    if (selectedItem.equals("응급상황")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("분실/도난")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("재난")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("교통 사고/위반")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });

        }

        {
            arrayList = new ArrayList();
            arrayList.add("선택하세요");
            arrayList.add("예약/진찰");
            arrayList.add("약 구매/설명");


            ArrayAdapter<String> adapter9 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_spinner_dropdown_item, arrayList);
            spinner9.setAdapter(adapter9);

            spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    selectedItem = (String) parent.getItemAtPosition(position);
                    if (selectedItem.equals("예약/진찰")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("약 구매/설명")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });

        }
        {
            arrayList = new ArrayList();
            arrayList.add("선택하세요");
            arrayList.add("길 묻기");
            arrayList.add("소요시간 묻기");


            ArrayAdapter<String> adapter8 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_spinner_dropdown_item, arrayList);
            spinner8.setAdapter(adapter8);

            spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    selectedItem = (String) parent.getItemAtPosition(position);
                    if (selectedItem.equals("길 묻기")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    } else if (selectedItem.equals("소요시간 묻기")) {

                        Intent intent = new Intent(index.this, EditPlan.class);
                        startActivity(intent);
                        finish();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });

        }

    }

    public void onBackPressed()
    {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            finishAffinity();
        }
        else
        {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "한번 더 뒤로가기 누르면 꺼짐.", Toast.LENGTH_SHORT).show();
        }

    }
    public void gotoLanguageView()
    {
        Intent intent = new Intent(index.this, languageView.class);
        startActivity(intent);
        finish();
    }

}


