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

public class AllListActivity extends AppCompatActivity {

    ListView list;
    String[] pill_titles = {
            "타이레놀정 500mg",
            "게보린정",
            "탁센연질캡슐",
            "이지엔6애니연질캡슐",
            "이지엔6이브연질캡슐",
            "이브퀵정",
            "배노신캡슐",
            "마이노신캡슐",
            "인플라정",
            "그날엔정",
            "모드콜에스연질캡슐",
            "모가프텐트로키",
            "타세놀정",
            "스트렙실허니앤레몬트로키",
            "그린노즈에스캡슐",
            "화이투벤큐노즈연질캡슐",
            "프리엔연질캡슐",
            "바로소펜연질캡슐",
            "티나케어점안액",
            "리토브라점안액",
            "리플루점안액",
            "후루손점안액",
            "텔비트점안액",
            "트리싹정",
            "위엔젤더블액션현탁액",
            "트리겔현탁액",
            "디마겐정",
            "굿모닝에스과립",
            "실콘정",
            "마그밀정",
            "그날엔Q삼중정",
            "부스코판플러스정",
            "테라플루데이타임건조시럽",
            "판콜에이내복액",
            "싸이베린정",
            "베아제정",
            "훼스탈플러스정",
            "바스코연고",
            "태극아즈렌에스크림",
            "마이드린캡슐",
            "알보칠콘센트레이트액",
            "아프니벤큐액",
            "콜대원코프에스시럽",
            "어린이부루펜시럽",
            "스피드펜연질캡슐",
            "이즈펜정",
            "모드코프시럽",
            "자이날",
            "프랜즈아이드롭점안액",
            "나스펜연질캡슐"
    };
    Integer[] pill_images = {
            R.drawable.pill1, R.drawable.pill2, R.drawable.pill3, R.drawable.pill4, R.drawable.pill5, R.drawable.pill6, R.drawable.pill7, R.drawable.pill8,
            R.drawable.pill9, R.drawable.pill10, R.drawable.pill11, R.drawable.pill12, R.drawable.pill13, R.drawable.pill14, R.drawable.pill15, R.drawable.pill16,
            R.drawable.pill17, R.drawable.pill18, R.drawable.pill19, R.drawable.pill20, R.drawable.pill21, R.drawable.pill22, R.drawable.pill23, R.drawable.pill24,
            R.drawable.pill25, R.drawable.pill26, R.drawable.pill27, R.drawable.pill28, R.drawable.pill29, R.drawable.pill30, R.drawable.pill31, R.drawable.pill32,
            R.drawable.pill33, R.drawable.pill34, R.drawable.pill35, R.drawable.pill36, R.drawable.pill37, R.drawable.pill38, R.drawable.pill39, R.drawable.pill40,
            R.drawable.pill41, R.drawable.pill42, R.drawable.pill43, R.drawable.pill44, R.drawable.pill45, R.drawable.pill46, R.drawable.pill47, R.drawable.pill48,
            R.drawable.pill49, R.drawable.pill50
    };

    String[] pill_sicks = {
            "두통, 생리통, 치통",
            "두통, 치통, 귀통증, 인후통, 관절통, 생리통",
            "두통, 치통, 관절염, 척추염",
            "두통, 치통, 근육통, 신경통",
            "두통, 치통, 근육통, 생리통, 인후통",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통",
            "다래끼, 화농증, 부기, 화농성질환",
            "다래끼, 화농증, 부기, 화농성질환",
            "염증완화제, 염증성 부기",
            "두통, 치통, 인후통, 귀통증, 생리통",
            "콧물, 코막힘, 재채기, 인후통, 기침, 가래, 발열",
            "콧물, 코막힘, 재채기, 인후통, 기침, 가래, 발열",
            "감기로 인한 발열, 두통, 생리통, 치통, 관절통 등",
            "인후염",
            "코감기, 비염, 코막힘, 콧물, 재채기, 인후통",
            "콧물, 콤막힘, 재채기, 인후통, 기침, 가래,두통",
            "관절염, 통증성 부종, 통증성 염증",
            "관절염, 통증성 부종, 통증성 염증",
            "결막염, 다래끼, 눈의 가려움",
            "다래끼, 결막염, 각막염, 안검염",
            "결막염, 공막염, 홍채염, 안건염",
            "결막염, 각막염, 공막염, 안검염, 홍채염",
            "결막염, 각막염, 안검염, 맥립종",
            "두통, 치통, 인후통, 귀통증, 생리통",
            "발열, 두통, 생리통, 치통, 관절통",
            "복통, 소화불량, 구토",
            "산 역류, 속쓰림, 소화불량",
            "위염, 십이지궤양, 식도염, 소화불량",
            "구토, 식욕부진, 소화불량, 위염,구내염, 속쓰림",
            "변비, 식욕부진, 복부팽만, 치질",
            "만성변비, 과민대장증후군",
            "위염, 위산과다, 심이지장궤양",
            "콧물, 코막힘, 재채기, 인후통, 두통, 관절통 등",
            "콧물, 코막힘, 재채기, 인후통, 두통, 관절통 등",
            "위통, 복통, 산통, 속쓰림",
            "소화불량, 체함, 위부팽만감",
            "소화불량, 식욕감퇴, 과식, 체함, 위부팽만감",
            "베인 상처, 긁힌 상처, 화상",
            "습진, 화상",
            "두통",
            "세균 감염, 구내염",
            "치은염, 구내염, 인두염",
            "콧물, 코막힘, 재채기, 인후통, 두통, 관절통 등",
            "감기, 생리통, 두통, 치통, 발열 등",
            "발열, 생리통, 관절염, 두통, 치통 등",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통 등",
            "기침, 가래, 콧물, 코막힘, 재채기",
            "관절염, 척추염, 생리통 등",
            "눈물 보충, 눈의 건조, 눈의 피로, 눈의 흐림",
            "두통, 생리통, 발열 등"
    };

    String[] pill_hows = {
            "1회 1~2정씩 1일 3~4회 필요시 복용",
            "1회 1정 1일 3회까지 공복 피하여 복용",
            "(성인) 750mg을 경구투여",
            "1회 200~400mg을 경구투여",
            "1일 1~3회, 1회 1~2캡슐",
            "15세 이상 1회 2정, 1일 3회 복용",
            "1회 2캡슐을 1일 3회 식전 또는 식사할 때 복용",
            "1회 2캡슐을 1일 3회 식전 또는 식사할 때 복용",
            "첫날 1회 2정, 1일 4회, 1회 1정, 1일 4회 복용",
            "15세 이상 1회 2정 1일 3회 복용",
            "1일 3회, 1회 2캡슐 식후 30분에 복용",
            "약 1개를 입안에서 서서히 녹여서 복용(최대 5개)",
            "1회 1~2정씩 1일 3~4회 필요시 복용",
            "약 1개를 입안에서 서서히 녹여서 복용(최대 5개)",
            "1회 1캡슐씩 1이 3회 매 식후에 복용",
            "1일 3회, 1회 2캡슐 식후 30분에 복용",
            "1회 300mg을 1일 2~4회 경구투여",
            "1회 1캡슐을 1일 2~4회 경구투여",
            "1일 3~6회, 1회 1~3방울 점안함",
            "4시간마다 감염부위에 1~2방울씩 점안함",
            "1회 1~2방울, 1일 2~4회 점안함",
            "1회 1~2방울 1일 2~4회 점안함",
            "1회 1방울 1일 3회 점안함",
            "15세 이상 1회 2정 1일 3회 복용",
            "1회 1~2정씩 1일 3~4회 필요시 복용",
            "1회 100mg-200mg 1일 3회 식전에 경구투여함",
            "1회 10~20ml을 1일 4회 복용(식후 및 취침전)",
            "성인 1일 4회, 1회 1/2~1포씩 복용",
            "1회 2정을 1일 3회 식전 또는 식간에 복용",
            "15세 이상 성인 1회 1포, 공복에 복용",
            "1회 1,250mg 1일 1~4회 경구투여",
            "1일 1~2.5g을 수회 분할 경구투여",
            "매 4~6시간마다 1포씩 복용(최대 4포)",
            "성인 1회 30ml 1일 3회 식후 30분에 복용",
            "1회 2정, 1일 2~3회(식후 또는 식간)",
            "1회 1정 1일 3회 식후 복용",
            "1회 1-2정, 소아 1회 1정 1일 3회 식사 후 복용",
            "상처부위를 깨끗이 하고 1일 1~3회 적당량 바름",
            "1일 수회 환부에 도포",
            "1회 1~2캡슐을 1일 3회 복용",
            "약을 적신 면봉을 이용해 여러번 반복하여 발라줌",
            "1회 15ml 1일 2~3회 가글 후 뱉음",
            "3회 1포 식후 30분에 복용",
            "1회 200~400mg 1일 3-4회 경구투여",
            "1회 200~400mg 경구투여",
            "1회 2정, 1일 2회까지 공복 피하여 복용",
            "11세 이상 14ml, 8세 이상 10ml 등",
            "1회 275-550mg 경구투여",
            "1회 2~3방울, 1일 5~6회 점안",
            "1회 2캡슐씩 1일 3~4회 복용"
    };

    String[] pill_shapes = {
            "모양 : 장방형, 색 : 백색",
            "모양 : 삼각형, 색 : 분홍색",
            "모양 : 타원형, 색 : 불투명 초록색",
            "모양 : 타원형, 색 : 불투명 청록색",
            "모양 : 타원형, 색 : 연한 청색",
            "모양 : 원형, 색 : 백색",
            "모양 : 장방형, 색 : 옅은 파랑색",
            "모양 : 장방형, 색 : 노란색",
            "모양 : 원형, 색 : 백색",
            "모양 : 원형, 색 : 상하층 백색, 중간층 적색",
            "모양 : 타원형, 색 : 노란색",
            "모양 : 타원형, 색 : 연한 노란색",
            "모양 : 타원형, 색 : 백색",
            "모양 : 원형, 색 : 백색",
            "모양 : 장방형, 색 : 불투명한 초록색",
            "모양 : 타원형, 색 : 노란색",
            "모양 : 타원형, 색 : 초록색",
            "모양 : 타원형, 색 : 노랑, 백색",
            "안약", "안약", "안약",
            "안약", "안약",
            "모양: 원형, 색 : 상하층 백색, 중간층 적색",
            "모양 : 타원형, 색 : 백색",
            "모양 : 원형, 색 : 연한 노란색",
            "미황색~크림색, 페퍼민트향",
            "색 : 백색",
            "모양 : 타원형, 색 : 녹색",
            "모양 : , 색 : 갈색",
            "모양 : 장방형, 색 : 갈색 반점이 있는 백색",
            "모양 : 원형, 색 : 백색",
            "백색, 레몬향",
            "미황색 액체",
            "모양 : 원형, 색 : 백색",
            "모양 : 장방형, 색 : 연녹색",
            "모양 : 달걀형, 색 : 백색",
            "백색~담갈색의 연고제",
            "연한 파란색의 크림제",
            "모양 : 캡슐, 색 : 청색",
            "적갈색의 투명한 외용액제",
            "빨간 주황색의 액제",
            "빨간색의 시럽제",
            "연한노란색의 시럽성 현탁액",
            "모양 : 달걀형, 색 : 흰 노란색",
            "모양: 타원형, 색 : 갈색",
            "갈색 유리병에 든 시럽제",
            "모양 : 타원형, 색 : 청색",
            "무색투명한 액",
            "모양 : 장방형, 색 : 주황색",
            "모양: 타원형, 색 : 갈색",
            "모양 : 장방형, 색 : 주황색",
            "모양 : 타원형, 색 : 청색"
    };

    String[] pill_companys = {
            "한국얀센", "삼진제약", "녹십자", "대웅제약", "대웅제약", "사노피아벤티코리아", "광동제약", "경방신약", "경동제약", "종근당", "동화약품", "부광약품", "옥시레킷벤키저", "맥널티제약",
            "알피바이오", "동국제약", "유유제약", "한솔신약", "휴온스메디케어", "휴온스메디케어", "대우제약", "대우제약", "경동제약", "부광약품", "제일헬스사이언스", "제이더블유중외제약",
            "대원제약", "정우신약", "한풍제약", "명문제약", "삼남제약", "글락소스미스클라인컨슈 ", "동화약품", "미래제약", "대웅제약", "한독", "녹십자", "태극제약", "녹십자", "셀트리온제약",
            "코오롱제약", "대원제약", "삼일제약", "한미약품", "정우신약", "종근당", "고려제약", "제이더블유중외제약", "조아제약", "동화약품"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_list);

        CustomList adapter = new CustomList(AllListActivity.this);
        list = (ListView) findViewById(R.id.alllist);
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