package kr.co.company.miniproject;
// 컴퓨터시스템과 A반 202145022 전우진 2022.06.10 Nexus 5X API 30
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ToothListActivity extends AppCompatActivity {

    ListView list;
    String[] pill_titles = {
            "타이레놀정 500mg",
            "게보린정",
            "탁센연질캡슐",
            "이지엔6애니연질캡슐",
            "이지엔6이브연질캡슐",
            "이브퀵정",
            "그날엔정",
            "타세놀정 500mg",
            "디마겐정",
            "그날엔Q삼중정",
            "알보칠콘센트레이트액",
            "아프니벤큐액",
            "어린이부루펜시럽",
            "스피드펜연질캡슐",
            "이즈펜정"
    };

    Integer[] pill_images = {
            R.drawable.pill1,
            R.drawable.pill2,
            R.drawable.pill3,
            R.drawable.pill4,
            R.drawable.pill5,
            R.drawable.pill6,
            R.drawable.pill10,
            R.drawable.pill13,
            R.drawable.pill27,
            R.drawable.pill31,
            R.drawable.pill41,
            R.drawable.pill42,
            R.drawable.pill44,
            R.drawable.pill45,
            R.drawable.pill46
    };

    String[] pill_sicks = {
            "두통, 생리통, 치통",
            "두통, 치통, 귀통증, 인후통, 관절통, 생리통",
            "두통, 치통, 관절염, 척추염",
            "두통, 치통, 근육통, 신경통",
            "두통, 치통, 근육통, 생리통, 인후통",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통",
            "두통, 치통, 인후통, 귀통증, 생리통",
            "발열, 두통, 생리통, 치통, 관절통",
            "1회 2정을 1일 3회 식전 또는 식간에 복용",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통",
            "세균 감염, 구내염",
            "콧물, 코막힘, 재채기, 인후통, 두통, 관절통 등",
            "감기, 생리통, 두통, 치통, 발열 등",
            "발열, 생리통, 관절염, 두통, 치통 등",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통 등"
    };

    String[] pill_hows = {
            "1회 1~2정씩 1일 3~4회 필요시 복용",
            "1회 1정 1일 3회까지 공복 피하여 복용",
            "(성인) 750mg을 경구투여",
            "1회 200~400mg을 경구투여",
            "1일 1~3회, 1회 1~2캡슐",
            "15세 이상 1회 2정, 1일 3회 복용",
            "15세 이상 1회 2정 1일 3회 복용",
            "1회 1~2정씩 1일 3~4회 필요시 복용",
            "1회 2정을 1일 3회 식전 또는 식간에 복용",
            "1회 2정, 1일 3회 복용",
            "약을 적신 면봉을 이용해 여러번 반복하여 발라줌",
            "1일 3회 1포 식후 30분에 복용",
            "1회 200~400mg 1일 3-4회 경구투여",
            "1회 200~400mg 경구투여",
            "1회 2정, 1일 2회까지 공복 피하여 복용"

    };

    String[] pill_shapes = {
            "모양 : 장방형, 색 : 백색",
            "모양 : 삼각형, 색 : 분홍색",
            "모양 : 타원형, 색 : 불투명 초록색",
            "모양 : 타원형, 색 : 불투명 청록색",
            "모양 : 타원형, 색 : 연한 청색",
            "모양 : 원형, 색 : 백색",
            "모양: 원형, 색 : 상하층 백색, 중간층 적색",
            "모양 : 타원형, 색 : 백색",
            "모양 : 타원형, 색 : 녹색",
            "모양 : 원형, 색 : 상하층 백색, 중간층 연청색",
            "적갈색의 투명한 외용액제",
            "빨간 주황색의 액제",
            "연한노란색의 시럽성 현탁액",
            "모양 : 달걀형, 색 : 흰 노란색",
            "모양: 타원형, 색 : 갈색"

    };

    String[] pill_companys = {
            "한국얀센",
            "삼진제약",
            "녹십자",
            "대웅제약",
            "대웅제약",
            "사노피아벤티코리아",
            "경동제약",
            "부광약품",
            "정우신약",
            "경동제약",
            "셀트리온제약",
            "코오롱제약",
            "삼일제약",
            "한미약품",
            "정우신약"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tooth_list);

        CustomList adapter = new CustomList(ToothListActivity.this);
        list = (ListView) findViewById(R.id.toothlist);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), pill_titles[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;

        public CustomList(Activity context) {
            super(context, R.layout.listitem, pill_titles);
            this.context = context;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem, null, true);
            ImageView image = (ImageView) rowView.findViewById(R.id.pill_image);
            TextView title = (TextView) rowView.findViewById(R.id.pill_title);
            TextView sick = (TextView) rowView.findViewById(R.id.pill_sick);
            TextView how = (TextView) rowView.findViewById(R.id.pill_how);
            TextView shape = (TextView) rowView.findViewById(R.id.pill_shape);
            TextView company = (TextView) rowView.findViewById(R.id.pill_company);
            title.setText(pill_titles[position]);
            image.setImageResource(pill_images[position]);
            sick.setText(pill_sicks[position]);
            how.setText(pill_hows[position]);
            shape.setText(pill_shapes[position]);
            company.setText(pill_companys[position]);
            return rowView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.previous:
                Intent intent1 = new Intent(getApplicationContext(), SickActivity.class);
                startActivity(intent1);
                return true;
            case R.id.logout:
                Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent2);
                return true;
            case R.id.main:
                Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent3);
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}