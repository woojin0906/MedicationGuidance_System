package kr.co.company.miniproject;
// 컴퓨터시스템과 A반 202145022 전우진 2022.06.10 Nexus 5X API 30
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sick);

        Button headache = (Button)findViewById(R.id.headache);
        headache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HeadListActivity.class);
                startActivity(intent);
            }
        });

        Button stomachache = (Button)findViewById(R.id.stomachache);
        stomachache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StomachacheListActivity.class);
                startActivity(intent);
            }
        });

        Button toothache = (Button)findViewById(R.id.toothache);
        toothache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ToothListActivity.class);
                startActivity(intent);
            }
        });

        Button joint = (Button)findViewById(R.id.joint);
        joint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JointListActivity.class);
                startActivity(intent);
            }
        });

        Button neck = (Button)findViewById(R.id.neck);
        neck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NeckListActivity.class);
                startActivity(intent);
            }
        });

        Button eye = (Button)findViewById(R.id.eye);
        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EyeListActivity.class);
                startActivity(intent);
            }
        });

        Button ear = (Button)findViewById(R.id.ear);
        ear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EarListActivity.class);
                startActivity(intent);
            }
        });

        Button all = (Button)findViewById(R.id.all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AllListActivity.class);
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