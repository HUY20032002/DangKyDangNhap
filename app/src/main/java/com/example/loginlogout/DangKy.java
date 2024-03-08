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

public class DangKy extends AppCompatActivity {

    TextView  txtDangNhap;
    EditText Username1, Password2, Password3;
    Button btnDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        txtDangNhap = findViewById(R.id.id_txtDangNhap);
        Username1 = findViewById(R.id.id_username);
        Password2 = findViewById(R.id.id_password2);
        Password3 = findViewById(R.id.id_password3);
        btnDangKy = findViewById(R.id.id_btnDangKy);


        txtDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangKy.this, MainActivity.class);
                startActivity(intent);
                finish(); // đóng activity hiện tại
            }
        });


        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered2();
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
    void checkDataEntered2(){
        if(isEmpty(Username1)){
            Toast t = Toast.makeText(this, "Vui lòng nhập tên người dùng", Toast.LENGTH_SHORT);
            t.show();
        }else if(isEmpty(Password2)){
            Toast t = Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT);
            t.show();
        }else if(!isCheckPass(Password2)){
            Toast t = Toast.makeText(this, "Mật khẩu phải nhập trên 8 ký tự", Toast.LENGTH_SHORT);
            t.show();
        }else if(!Password2.getText().toString().equals(Password3.getText().toString())){
            Toast t = Toast.makeText(this, "Vui lòng nhập lại mật khẩu", Toast.LENGTH_SHORT);
            t.show();
        }else if(isEmpty(Password3)){
            Toast t = Toast.makeText(this, "Vui lòng nhập xác nhận mật khẩu", Toast.LENGTH_SHORT);
            t.show();
        }else{
            // Mã thực thi khi đã nhập đ
            Toast t = Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}