package com.briup.gui.mousework;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		String str = "1+3*4+1-3*5+(2+3)*5";
		//Script 脚本
		//javascript
		//eval('1+1');
		//JDK6.0
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		
		Object result = engine.eval("eval('"+str+"');");
		
		System.out.println(result);
	}
	
}
