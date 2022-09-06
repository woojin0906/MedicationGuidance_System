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

public class EyeListActivity extends AppCompatActivity {

    ListView list;
    String[] pill_titles = {
            "배노신캡슐",
            "마이노신캡슐",
            "인플라정",
            "티나케어점안액",
            "리토브라점안액",
            "리플루점안액",
            "후루손점안액",
            "텔비트점안액",
            "프랜즈아이드롭점안액"
    };
    Integer[] pill_images = {
            R.drawable.pill7,
            R.drawable.pill8,
            R.drawable.pill9,
            R.drawable.pill19,
            R.drawable.pill20,
            R.drawable.pill21,
            R.drawable.pill22,
            R.drawable.pill23,
            R.drawable.pill49
    };

    String[] pill_sicks = {
            "다래끼, 화농증, 부기, 화농성질환",
            "다래끼, 화농증, 부기, 화농성질환",
            "염증완화제, 염증성 부기",
            "결막염, 다래끼, 눈의 가려움",
            "다래끼, 결막염, 각막염, 안검염",
            "결막염, 공막염, 홍채염, 안건염",
            "결막염, 각막염, 공막염, 안검염, 홍채염",
            "결막염, 각막염, 안검염, 맥립종",
            "눈물 보충, 눈의 건조, 눈의 피로, 눈의 흐림"
    };

    String[] pill_hows = {
            "1회 2캡슐을 1일 3회 식전 또는 식사할 때 복용",
            "1회 2캡슐을 1일 3회 식전 또는 식사할 때 복용",
            "첫날 1회 2정, 1일 4회, 이후 1회 1정, 1일 4회",
            "1일 3~6회, 1회 1~3방울 점안함",
            "4시간마다 감염부위에 1~2방울씩 점안함",
            "1회 1~2방울, 1일 2~4회 점안함",
            "1회 1~2방울 1일 2~4회 점안함",
            "1회 1방울 1일 3회 점안함",
            "1회 2~3방울, 1일 5~6회 점안",
    };

    String[] pill_shapes = {
            "모양 : 장방형, 색 : 옅은 파랑색",
            "모양 : 장방형, 색 : 노란색",
            "모양 : 원형, 색 : 백색",
            "안약",
            "안약",
            "안약",
            "안약",
            "안약",
            "안약",
    };

    String[] pill_companys = {
            "광동제약",
            "경방신약",
            "넥스팜코리아",
            "한솔신약",
            "휴온스메디케어",
            "휴온스메디케어",
            "대우제약",
            "대우제약",
            "제이더블유중외제약"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_list);

        CustomList adapter = new CustomList(EyeListActivity.this);
        list = (ListView) findViewById(R.id.eyelist);
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