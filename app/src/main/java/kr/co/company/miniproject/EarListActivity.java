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

public class EarListActivity extends AppCompatActivity {

    ListView list;
    String[] pill_titles = {
            "게보린정",
            "이브퀵정",
            "그날엔정",
            "그날엔Q삼중정",
            "이즈펜정"
    };
    Integer[] pill_images = {
            R.drawable.pill2,
            R.drawable.pill6,
            R.drawable.pill10,
            R.drawable.pill31,
            R.drawable.pill46
    };

    String[] pill_sicks = {
            "두통, 치통, 귀통증, 인후통, 관절통, 생리통",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통",
            "두통, 치통, 인후통, 귀통증, 생리통",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통",
            "두통, 치통, 인후통, 귀통증, 관절통, 생리통 등"
    };

    String[] pill_hows = {
            "1회 1정 1일 3회까지 공복 피하여 복용",
            "15세 이상 1회 2정, 1일 3회 복용",
            "15세 이상 1회 2정 1일 3회 복용",
            "1회 2정, 1일 3회 복용",
            "1회 2정, 1일 2회까지 공복 피하여 복용"
    };

    String[] pill_shapes = {
            "모양 : 삼각형, 색 : 분홍색",
            "모양 : 원형, 색 : 백색",
            "모양 : 원형, 색 : 상하층 백색, 중간층 적색",
            "모양 : 원형, 색 : 상하층 백색, 중간층 연청색",
            "모양 : 타원형, 색 : 갈색"
    };

    String [] pill_companys = {
            "삼진제약",
            "사노피아벤티스코리아",
            "경동제약",
            "경동제약",
            "정우신약"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ear_list);

        CustomList adapter = new CustomList(EarListActivity.this);
        list = (ListView) findViewById(R.id.earlist);
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