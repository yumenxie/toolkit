package com.fastwebx.codeAuto.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.fastwebx.codeAuto.context.Context;

public class FileUtil {
	static public void write(String path,String content){
		File file = new File(buildPath(path));
		if(!file.exists()){
			file.mkdirs();
		}
		try{
			FileOutputStream out = new FileOutputStream(buildFileName(path));
			out.write(content.getBytes());
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static public void write(String path,File file){
		if(file==null) return;
		String content =readContent(file);
		if(content!=null)
			write(path,content);
	}
	
	static private String readContent(File file){
		String ret = null;
		try {
			FileInputStream input = new FileInputStream(file);
			
			ByteArrayOutputStream  out = new ByteArrayOutputStream();
			int i=0;
			while((i=input.read())!=-1)
				out.write(i);
			input.close();
			ret = new String(out.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	static private String buildPath(String path){
		String ret = buildFileName(path);
		while(ret.indexOf("\\")!=-1)
			ret = ret.replace('\\', '/');
		int index = ret.lastIndexOf("/");
		
		
		return ret.substring(0,index);
	}
	
	static private String buildFileName(String path){
		StringBuffer sb = new StringBuffer();
		sb.append(Context.getOutPath());
		if(!Context.getOutPath().endsWith("/")
				&& !Context.getOutPath().endsWith("\\"))
			sb.append("/");
		sb.append(path);
		return sb.toString();
	}
}
