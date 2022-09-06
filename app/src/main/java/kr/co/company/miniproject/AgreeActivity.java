package kr.co.company.miniproject;
// 컴퓨터시스템과 A반 202145022 전우진 2022.06.10 Nexus 5X API 30
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class AgreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree);

        final CheckBox cb1 = (CheckBox)findViewById(R.id.allAgree);
        final CheckBox cb2 = (CheckBox)findViewById(R.id.agreeone);
        final CheckBox cb3 = (CheckBox)findViewById(R.id.agreetwo);
        final CheckBox cb4 = (CheckBox)findViewById(R.id.agreethree);

        Button NextButton = (Button)findViewById(R.id.AgreeButton);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb1.isChecked() == true || (cb2.isChecked() == true && cb3.isChecked() == true)) {
                    Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                    Toast.makeText(getApplicationContext(), "동의 되었습니다.", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else if (cb2.isChecked() == true || cb3.isChecked() == true || cb4.isChecked() == true) {
                    Toast.makeText(getApplicationContext(), "필수 항목 동의 해주십시오.", Toast.LENGTH_SHORT).show();
                } else if ((cb2.isChecked() == true && cb4.isChecked() == true) || (cb3.isChecked() == true && cb4.isChecked() == true)) {
                    Toast.makeText(getApplicationContext(), "필수 항목 동의 해주십시오.", Toast.LENGTH_SHORT).show();
                } else if (cb2.isChecked() == false || cb3.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "필수 항목 동의 해주십시오.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CheckBox allAgree = findViewById(R.id.allAgree);
        allAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb1.isChecked() == true) {
                    cb2.setChecked(true);
                    cb3.setChecked(true);
                    cb4.setChecked(true);
                } else {
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                    cb4.setChecked(false);
                }
            }
        });

        CheckBox agreeone = findViewById(R.id.agreeone);
        agreeone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb2.isChecked() == false) {
                    cb1.setChecked(false);
                } else {
                    if(cb3.isChecked() == true && cb4.isChecked() == true){
                        cb1.setChecked(true);
                    }
                }
            }
        });

        CheckBox agreetwo = findViewById(R.id.agreetwo);
        agreetwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb3.isChecked() == false) {
                    cb1.setChecked(false);
                } else {
                    if(cb2.isChecked() == true && cb4.isChecked() == true){
                        cb1.setChecked(true);
                    }
                }
            }
        });

        CheckBox agreethree = findViewById(R.id.agreethree);
        agreethree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb4.isChecked() == false) {
                    cb1.setChecked(false);
                } else {
                    if(cb2.isChecked() == true && cb3.isChecked() == true){
                        cb1.setChecked(true);
                    }
                }
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
                Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent1);
                return true;
            case R.id.logout:
                Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent2);
                return true;
            case R.id.main:
                Intent intent3 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent3);
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}