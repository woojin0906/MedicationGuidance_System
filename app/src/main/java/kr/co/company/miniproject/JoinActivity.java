package kr.co.company.miniproject;
// 컴퓨터시스템과 A반 202145022 전우진 2022.06.10 Nexus 5X API 30
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DialerFilter;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class JoinActivity extends AppCompatActivity {
    private EditText name, id, pw, pwch, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        name = findViewById(R.id.join_name);
        id = findViewById(R.id.join_id);
        pw = findViewById(R.id.join_password);
        pwch = findViewById(R.id.join_passwordchange);
        phone = findViewById(R.id.join_phone);

        Button join_joinButton = (Button)findViewById(R.id.join_joinButton);
        join_joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String joinname = name.getText().toString();
                final String joinid = id.getText().toString();
                final String joinpw = pw.getText().toString();
                final String joinpwch = pwch.getText().toString();
                final String joinphone = phone.getText().toString();

                if(joinname.equals("") || joinid.equals("") ||
                        joinpw.equals("") || joinpwch.equals("") || joinphone.equals("")) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(JoinActivity.this);
                    dialog.setIcon(R.mipmap.ic_launcher);
                    dialog.setTitle("알림");
                    dialog.setMessage("모두 입력하시오.");
                    dialog.setNegativeButton("확인", null);
                    dialog.show();
                } else {
                    if(joinpw.equals(joinpwch)) {
                        if(joinid.length() >= 4 && joinpw.length() >= 6){
                            if(joinphone.length() >= 10 && joinphone.length() <= 11) {
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                Toast.makeText(getApplicationContext(), "회원가입 성공", Toast.LENGTH_SHORT).show();
                                intent.putExtra("joinid", joinid);
                                intent.putExtra("joinpw", joinpw);
                                intent.putExtra("joinname", joinname);
                                intent.putExtra("joinpwch", joinpwch);
                                intent.putExtra("joinphone", joinphone);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "전화번호는 10자리 혹은 11자리입니다.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "아이디는 4자리 이상, 비밀번호는 6자리 이상으로 입력해주세요.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "비빌번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
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
                Intent intent1 = new Intent(getApplicationContext(), AgreeActivity.class);
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