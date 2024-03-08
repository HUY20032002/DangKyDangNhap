package com.example.loginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Username, Password;
    Button Sign_in;
    TextView txtDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.id_username);
        Password = findViewById(R.id.id_password);
        Sign_in = findViewById(R.id.id_Sign_in);
        txtDangKy = findViewById(R.id.id_txtDangKy);

        txtDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DangKy.class);
                startActivity(intent);
                finish(); // đóng activity hiện tại
            }
        });
        Sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();
            }
        });

    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    boolean isCheckPass(EditText text) {
        CharSequence str = text.getText().toString();
        return str.length() >= 8;
    }
    void checkDataEntered(){
        if(isEmpty(Username)){
            Toast t = Toast.makeText(this, "Vui lòng nhập tên người dùng", Toast.LENGTH_SHORT);
            t.show();
        }else if(isEmpty(Password)){
            Toast t = Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT);
            t.show();
        }else if(!isCheckPass(Password)){
            Toast t = Toast.makeText(this, "Mật khẩu phải nhập trên 8 ký tự", Toast.LENGTH_SHORT);
            t.show();
        }else{
            // Mã thực thi khi đã nhập đầy đủ thông tin
            Toast t = Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}