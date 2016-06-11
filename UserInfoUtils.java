package com.example.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.R.string;
import android.content.Context;

public class UserInfoUtils {

	//�����û����������ҵ���߼�
	public static boolean saveInfo(Context context,String name,String password){
		try {
			String result = name + "##" + password;
			//ͨ�������Ļ�ȡ�ļ�·��
			String path = context.getFilesDir().getPath();
			File file = new File(path,"info.txt");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(result.getBytes());
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Map<String, String> readInfo(Context context){
		Map<String, String> maps;
		try {
			maps = new HashMap<String, String>();
			String path = context.getFilesDir().getPath();
			File file = new File(path,"info.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedReader bfr = new BufferedReader(new InputStreamReader(fis));
			String content = bfr.readLine();
			String[] splits = content.split("##");
			String name = splits[0];
			String password = splits[1];
			maps.put("name", name);
			maps.put("password", password);
			return maps;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}
}
