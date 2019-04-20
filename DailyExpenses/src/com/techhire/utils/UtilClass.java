package com.techhire.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class UtilClass {
	
	public static void write(HttpServletResponse response, String message) {
		try {
			PrintWriter printWriter = response.getWriter();
			if(message!=null)
			printWriter.write(message);
			
			printWriter.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
