package com.hcy.ssm.javaType;

import java.util.List;


public class JavaBoolean extends JavaType {

	
	public JavaBoolean(){
		this.setName("Boolean");
	}

	@Override
	public String getJdbcType() {
	
		return "BIT";
	}
}
