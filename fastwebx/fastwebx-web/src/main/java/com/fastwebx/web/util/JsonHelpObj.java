package com.fastwebx.web.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.function.Supplier;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fastwebx.common.util.DateUtil;
import com.fastwebx.web.inf.IToJSON;
import com.fastwebx.web.json.JsonParserContext;
/**
 * 
 * @author mj
 *
 */
public class JsonHelpObj implements IToJSON{
	private JSONObject json = null;
	
	public JSONObject get(){
		return json;
	}
	
	public void add2Obj(JSONObject obj ,String key){
		if(obj!=null && key!=null)
			obj.put(key, get());
	}
	
	public JsonHelpObj(){
		this.json = new JSONObject();
	}
	
	public JsonHelpObj(JSONObject json){
		this.json = json;
	}
	public JsonHelpObj build(String name){
		JSONObject obj = new JSONObject();
		json.put(name, obj);
		return new JsonHelpObj(obj);
	}
	
	public JSONArray buildArray(String name){
		JSONArray array = new JSONArray();
		json.put(name, array);
		return array;
	}
	
	
	public JsonHelpObj put(String key,Object obj){
		this.json.put(key, obj);
		return this;
	}
	/**
	 * 将日期型以毫秒数存到json
	 * @param key
	 * @param obj
	 * @return
	 */
	public JsonHelpObj putDate(String key,Date obj){
		if(obj!=null)
			this.json.put(key, obj.getTime());
		return this;
	}
	/**
	 * 将日期以格式化字符串存到json
	 * @param key
	 * @param date
	 * @return
	 */
	public JsonHelpObj putFmtDay(String key, Date date) {
		if(date != null){
			this.json.put(key, DateUtil.format(date));
		}
		return this;
	}

	@Override
	public String toString() {
	
		return this.get().toString();
	}

	public JsonHelpObj putIfExist(String key, Object obj, Supplier s) {
		if(key!=null && obj!=null && s!=null)
			this.json.put(key,s.get());
		return this;
		
	}

	public JsonHelpObj putArray(String key, Collection array) {
		JSONArray json = new JSONArray();
		JsonParserContext jp = JsonParserContext.get();
		array.forEach(obj->json.add(jp.parse(obj)));
		this.json.put(key,json);
		return this;  
	}

	@Override
	public JSON toJson() {
		return json;
	}
	
	public JsonHelpObj set2Obj(JSONObject obj,String key){
		if(obj!=null){
			obj.put(key, this.get());
		}
		return this;
	}
	
}
