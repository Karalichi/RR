package com.baosight.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private Button btn;
    private EditText account;
    private EditText password;
    private CheckBox rememberPass;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        account = (EditText)findViewById(R.id.account);
        password=(EditText) findViewById(R.id.pwd);
        btn=(Button)findViewById(R.id.login);
        rememberPass=(CheckBox)findViewById(R.id.checkBox);
        pref=getSharedPreferences("account",MODE_PRIVATE);
        if(pref.getBoolean("isRemember",false)){
            account.setText(pref.getString("account",""));
            password.setText(pref.getString("pwd",""));
            rememberPass.setChecked(true);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String acc=account.getText().toString();
                String pwd=password.getText().toString();
                if("admin".equals(acc)&&"123456".equals(pwd)){
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    editor=pref.edit();
                    if (rememberPass.isChecked()){
                        editor.putBoolean("isRemember",true);
                        editor.putString("account",account.getText().toString());
                        editor.putString("pwd",password.getText().toString());
                    }else{
                        editor.clear();
                    }
                    editor.apply();
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"account or password is invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
