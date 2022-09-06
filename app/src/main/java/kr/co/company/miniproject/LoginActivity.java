package kr.co.company.miniproject;
// 컴퓨터시스템과 A반 202145022 전우진 2022.06.10 Nexus 5X API 30
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText login_id;
    private EditText login_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_id = findViewById(R.id.login_id);
        login_pw = findViewById(R.id.login_password);

        Button login_loginButton = (Button)findViewById(R.id.login_loginButton);
        login_loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent receiveIntent = getIntent();
                final String id = receiveIntent.getStringExtra("joinid");
                final String pw = receiveIntent.getStringExtra("joinpw");
                final String name = receiveIntent.getStringExtra("joinname");

                final String loginid = login_id.getText().toString();
                final String loginpw = login_pw.getText().toString();

                    if(loginid.equals(id)) {
                        if(loginpw.equals(pw)) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            Toast.makeText(getApplicationContext(),name + "님 안녕하세요.", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "비빌번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "아이디가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
        });

        Button login_joinButton = (Button)findViewById(R.id.login_joinButton);
        login_joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AgreeActivity.class);
                startActivity(intent);
            }
        });

        Button password_change = (Button)findViewById(R.id.login_password_change);
        password_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle("알림");
                dialog.setMessage("고객센터에 전화해주세요. (032-123-4567)");
                dialog.setNegativeButton("확인", null);
                dialog.show();
            }
        });
    }
}