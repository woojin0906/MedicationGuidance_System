package kr.co.company.miniproject;
// 컴퓨터시스템과 A반 202145022 전우진 2022.06.10 Nexus 5X API 30
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MypageActivity extends AppCompatActivity {
    private Context mContext;
    private ArrayList<Data> mArrayList;
    private Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private EditText edit_name, edit_week;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_mypage);
        mContext = getApplicationContext ();
        edit_name = findViewById (R.id.edit_name);
        edit_week = findViewById (R.id.edit_week);
        btn_save = findViewById (R.id.btn_save);

        mRecyclerView = findViewById (R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager (mContext, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager (layoutManager);

        mArrayList = new ArrayList<>();
        mAdapter = new Adapter (mContext, mArrayList);
        mRecyclerView.setAdapter (mAdapter);
        mAdapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                mArrayList.remove(position);
                mAdapter.notifyItemRemoved (position);
            }
        });

        btn_save.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if(edit_name.getText ().length ()==0 && edit_week.getText ().length ()==0) {
                    Toast.makeText (mContext,"약 이름과 요일, 시간을 입력해주세요", Toast.LENGTH_SHORT).show ();
                }else{
                    String name = edit_name.getText ().toString ();
                    String number = edit_week.getText ().toString ();

                    edit_name.setText ("");
                    edit_week.setText ("");

                    Data data = new Data (name, number);

                    mArrayList.add (data);
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