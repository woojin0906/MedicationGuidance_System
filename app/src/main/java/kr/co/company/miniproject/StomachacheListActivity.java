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

public class StomachacheListActivity extends AppCompatActivity {

    ListView list;
    String[] pill_titles = {
            "타이레놀정",
            "게보린정",
            "이지엔6이브연질캡슐",
            "이브퀵정",
            "그날엔정",
            "타세놀정500mg",
            "트리싹정",
            "위엔젤더블액션현탁액",
            "트리겔현탁액",
            "디마겐정",
            "굿모닝에스과립",
            "실콘정",
            "마그밀정",
            "그날엔Q삼중정",
            "부스코판플러스정",
            "싸이베린정",
            "베아제정",
            "훼스탈플러스정",
            "어린이부루펜시럽",
            "스피드펜연질캡슐",
            "이즈펜정",
            "자이날",
            "나스펜연질캡슐"
    };

    Integer[] pill_images = {
            R.drawable.pill1,
            R.drawable.pill2,
            R.drawable.pill5,
            R.drawable.pill6,
            R.drawable.pill10,
            R.drawable.pill13,
            R.drawable.pill24,
            R.drawable.pill25,
            R.drawable.pill26,
            R.drawable.pill27,
            R.drawable.pill28,
            R.drawable.pill29,
            R.drawable.pill30,
            R.drawable.pill31,
            R.drawable.pill32,
            R.drawable.pill35,
            R.drawable.pill36,
            R.drawable.pill37,
            R.drawable.pill44,
            R.drawable.pill45,
            R.drawable.pill46,
            R.drawable.pill48,
            R.drawable.pill50,
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
            "복통, 소화불량, 구토",
            "산 역류, 속쓰림, 소화불량",
            "위염, 십이지궤양, 식도염, 소화불량",
            "구토, 식욕부진, 소화불량, 위염,구내염, 속쓰림",
            "변비, 식욕부진, 복부팽만, 치질",
            "만성변비, 과민대장증후군",
            "위염, 위산과다, 심이지장궤양",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통",
            "복통, 생리통",
            "위통, 복통, 산통, 속쓰림",
            "소화불량, 체함, 위부팽만감",
            "소화불량, 식욕감퇴, 과식, 체함, 위부팽만감",
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
            "1회 100mg-200mg 1일 3회 식전에 경구투여함",
            "1회 10~20ml을 1일 4회 복용(식후 및 취침전)",
            "성인 1일 4회, 1회 1/2~1포씩 복용",
            "1회 2정을 1일 3회 식전 또는 식간에 복용",
            "15세 이상 성인 1회 1포, 공복에 복용",
            "1회 1,250mg 1일 1~4회 경구투여",
            "1일 1~2.5g을 수회 분할 경구투여",
            "1회 2정, 1일 3회 복용",
            "1회 1-2정씩 1일 3회 경구투여, 최대용량 6정",
            "1회 2정, 1일 2~3회(식후 또는 식간)",
            "1회 1정 1일 3회 식후 복용",
            "1회 1-2정, 소아 1회 1정 1일 3회 식사 후 복용",
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
            "모양 : 원형, 색 : 연한 노란색",
            "색 : 미황색~크림색, 페퍼민트향",
            "색 : 백색",
            "모양 : 타원형, 색 : 녹색",
            "색 : 갈색",
            "모양 : 장방형, 색 : 갈색 반점이 있는 백색",
            "모양 : 원형, 색 : 백색",
            "모양 : 원형, 색 : 상하층 백색, 중간층 연청색",
            "모양 : 장방형, 색 : 백색",
            "모양 : 원형, 색 : 백색",
            "연한노란색의 시럽성 현탁액",
            "모양 : 장방형, 색 : 연녹색",
            "모양 : 달걀형, 색 : 백색",
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
            "제일헬스사이언스",
            "제이더블유중외제약",
            "대원제약",
            "정우신약",
            "한풍제약",
            "명문제약",
            "삼남제약",
            "경동제약",
            "오펠라헬스케어코리아",
            "미래제약",
            "대웅제약",
            "한독",
            "삼일제약",
            "한미약품",
            "정우신약"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stomachache_list);

        CustomList adapter = new CustomList(StomachacheListActivity.this);
        list = (ListView) findViewById(R.id.stomachachelist);
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