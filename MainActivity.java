package com.example.login;

import java.io.File;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_name;
	private EditText et_pwd;
	private CheckBox check;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et_name = (EditText) findViewById(R.id.et_name);
		et_pwd = (EditText) findViewById(R.id.et_pwd);
		check = (CheckBox) findViewById(R.id.check);
		
		Map<String, String> maps = UserInfoUtils.readInfo();
		if(maps!=null){
			String name = maps.get("name");
			String password = maps.get("password");
			
			et_name.setText(name);
			et_pwd.setText(password);
			
		}

		

	}

	public void login(View v) {
		String userName = et_name.getText().toString().trim();
		String password = et_pwd.getText().toString().trim();
		if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){
			Toast.makeText(MainActivity.this, "�û��������벻��Ϊ��", Toast.LENGTH_LONG).show();
		}else{
			System.out.println("�����½�߼�");
			if (check.isChecked()) {
				boolean result = UserInfoUtils.saveInfo(userName, password);
				if(result){
					Toast.makeText(MainActivity.this, "����ɹ�", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(MainActivity.this, "����ʧ��", Toast.LENGTH_LONG).show();
				}
			}else{
				Toast.makeText(MainActivity.this, "�빴ѡ����", Toast.LENGTH_LONG).show();
			}
		}
	}

}
