package kr.co.company.miniproject;
// 컴퓨터시스템과 A반 202145022 전우진 2022.06.10 Nexus 5X API 30
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class AppCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_check);

        Button submit = (Button)findViewById(R.id.submit);
        TextView ratingBarScore = (TextView) findViewById(R.id.ratingBarScore);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                ratingBarScore.setText(String.valueOf("SCORE = " + rating));
                Toast.makeText(getBaseContext(), "만족도 조사 " + rating + "으로 제출되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        Button CheckButton = (Button)findViewById(R.id.CheckButton);
        CheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Toast.makeText(getApplicationContext(),"만족도 조사가 확인되었습니다.", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        Button cancelButton = (Button)findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
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
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
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