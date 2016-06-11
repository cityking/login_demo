package com.example.login;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class GetSDSize extends Activity {

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_sdsize);
		TextView tv_total_size = (TextView) findViewById(R.id.tv_total_size);
		TextView tv_usable_size = (TextView) findViewById(R.id.tv_usable_size);
		
		//��ȡSD�����ܴ�С�Ϳ��ÿռ��С
		File file = Environment.getExternalStorageDirectory();
		long totalSpace = file.getTotalSpace();
		long usableSpace = file.getUsableSpace();
		
		//ת�����ݸ�ʽ
		String formatTotalSpace = Formatter.formatFileSize(this, totalSpace);
		String formatUsableSpace = Formatter.formatFileSize(this, usableSpace);
		
		tv_total_size.setText("�ܴ�С��"+formatTotalSpace);
		tv_usable_size.setText("���ô�С��"+formatUsableSpace);
	}


}
