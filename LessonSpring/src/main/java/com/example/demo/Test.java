package com.example.demo;

import java.util.Enumeration;
import java.util.List;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.websocket.Session;

import com.example.db.Dbutil;

public class Test {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//        Dbutil util = new Dbutil();
//        //util.addLogInfo("hhh", "666");
//        List<LogInfo> logInfos = util.getLogInfos();
//        System.out.println(logInfos);
	
//	    for (int i = 0; i < 10; i++) {
//			SingleObject singleObject = SingleObject.getInstance();
//			System.out.println(singleObject.getCount());
//		}
	     
		HttpSession session = new HttpSession() {
			
			@Override
			public void setMaxInactiveInterval(int interval) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setAttribute(String name, Object value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeValue(String name) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeAttribute(String name) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void putValue(String name, Object value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isNew() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void invalidate() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String[] getValueNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getValue(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public HttpSessionContext getSessionContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ServletContext getServletContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getMaxInactiveInterval() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getLastAccessedTime() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getId() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getCreationTime() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Enumeration<String> getAttributeNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getAttribute(String name) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		session.setAttribute("logInfo","name");
		System.out.println(session.getValue("logInfo"));
	}

}
