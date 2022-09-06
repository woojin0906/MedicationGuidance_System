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

public class NeckListActivity extends AppCompatActivity {

    ListView list;
    String[] pill_titles = {
            "게보린정",
            "이지엔6이브연질캡슐",
            "이브퀵정",
            "그날엔정",
            "모드콜에스연질캡슐",
            "모가프텐트로키",
            "스트렙실허니앤레몬트로키",
            "그린노즈에스캡슐",
            "화이투벤큐노즈연질캡슐",
            "그날엔Q삼중정",
            "테라플루데이타임건조시럽",
            "판콜에이내복액",
            "콜대원코프에스시럽",
            "어린이부루펜시럽",
            "이즈펜정",
            "모드코프시럽"
    };

    Integer[] pill_images = {
            R.drawable.pill2,
            R.drawable.pill5,
            R.drawable.pill6,
            R.drawable.pill10,
            R.drawable.pill11,
            R.drawable.pill12,
            R.drawable.pill14,
            R.drawable.pill15,
            R.drawable.pill16,
            R.drawable.pill31,
            R.drawable.pill33,
            R.drawable.pill34,
            R.drawable.pill43,
            R.drawable.pill44,
            R.drawable.pill46,
            R.drawable.pill47
    };

    String[] pill_sicks = {
            "두통, 치통, 귀통증, 인후통, 관절통, 생리통",
            "두통, 치통, 근육통, 생리통, 인후통",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통",
            "두통, 치통, 인후통, 귀통증, 생리통",
            "콧물, 코막힘, 재채기, 인후통, 기침, 가래, 발열",
            "콧물, 코막힘, 재채기, 인후통, 기침, 가래, 발열",
            "인후염",
            "코감기, 비염, 코막힘, 콧물, 재채기, 인후통",
            "콧물, 콤막힘, 재채기, 인후통, 기침, 가래, 두통",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통",
            "콧물, 코막힘, 재채기, 인후통, 두통, 관절통 등",
            "콧물, 코막힘, 재채기, 인후통, 두통, 관절통 등",
            "콧물, 코막힘, 재채기, 인후통, 두통, 관절통 등",
            "감기, 생리통, 두통, 치통, 발열 등",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통 등",
            "기침, 가래, 콧물, 코막힘, 재채기"
    };

    String[] pill_hows = {
            "1회 1정 1일 3회까지 공복 피하여 복용",
            "1일 1~3회, 1회 1~2캡슐",
            "15세 이상 1회 2정, 1일 3회 복용",
            "15세 이상 1회 2정 1일 3회 복용",
            "1일 3회, 1회 2캡슐 식후 30분에 복용",
            "약 1개를 입안에서 서서히 녹여서 복용(최대 5개)",
            "약 1개를 입안에서 서서히 녹여서 복용(최대 5개)",
            "1회 1캡슐씩 1이 3회 매 식후에 복용",
            "1일 3회, 1회 2캡슐 식후 30분에 복용",
            "1회 2정, 1일 3회 복용",
            "매 4~6시간마다 1포씩 복용(최대 4포)",
            "성인 1회 30ml 1일 3회 식후 30분에 복용",
            "1일 3회 1포 식후 30분에 복용",
            "1회 200~400mg 1일 3-4회 경구투여",
            "1회 2정, 1일 2회까지 공복 피하여 복용",
            "11세 이상 14ml, 8세 이상 10ml, 5세이상 8ml 등"
    };

    String[] pill_shapes = {
            "모양 : 삼각형, 색 : 분홍색",
            "모양 : 타원형, 색 : 연한 청색",
            "모양 : 원형, 색 : 백색",
            "모양 : 원형, 색 : 상하층 백색, 중간층 적색",
            "모양 : 타원형, 색 : 노란색",
            "모양 : 타원형, 색 : 연한 노란색",
            "모양 : 원형, 색 : 백색",
            "모양 : 장방형, 색 : 불투명한 초록색",
            "모양 : 타원형, 색 : 노란색",
            "모양 : 원형, 색 : 상하층 백색, 중간층 연청색",
            "백색, 레몬향",
            "미황색 액체",
            "빨간색의 시럽제",
            "연한노란색의 시럽성 현탁액",
            "모양 : 타원형, 색 : 갈색",
            "갈색 유리병에 든 시럽제"
    };

    String[] pill_companys = {
            "삼진제약",
            "대웅제약",
            "사노피아벤티코리아",
            "경동제약",
            "종근당",
            "동화약품",
            "옥시레킷벤키저",
            "맥널티제약",
            "알피바이오",
            "경동제약",
            "글락소스미스클라인컨슈 ",
            "동화약품",
            "대원제약",
            "삼일제약",
            "정우신약",
            "종근당",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neck_list);

        CustomList adapter = new CustomList(NeckListActivity.this);
        list = (ListView) findViewById(R.id.necklist);
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
            ImageView imageView = (ImageView) rowView.findViewById(R.id.pill_image);
            TextView title = (TextView) rowView.findViewById(R.id.pill_title);
            TextView rating = (TextView) rowView.findViewById(R.id.pill_sick);
            TextView genre = (TextView) rowView.findViewById(R.id.pill_how);
            TextView releaseYear = (TextView) rowView.findViewById(R.id.pill_shape);
            TextView relaeaes = (TextView) rowView.findViewById(R.id.pill_company);
            title.setText(pill_titles[position]);
            imageView.setImageResource(pill_images[position]);
            rating.setText(pill_sicks[position]);
            genre.setText(pill_hows[position]);
            releaseYear.setText(pill_shapes[position]);
            relaeaes.setText(pill_companys[position]);
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