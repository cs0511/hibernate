package com.csong.hibernate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class Session {
	String tableName = "_Student";
	Map<String, String> cfs = new HashMap<String, String>();
	String[] methodNames;

	public Session() {
		cfs.put("_id", "id");
		cfs.put("_name", "name");
		cfs.put("_age", "age");
		methodNames = new String[cfs.size()];
	}

	public void save(Student s) throws ClassNotFoundException,
										SQLException,
										NoSuchMethodException,
										SecurityException,
										IllegalAccessException,
										IllegalArgumentException,
										InvocationTargetException {
		String sql = createSQL();

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/chensong", "root", "chensong");
	    PreparedStatement ps = conn.prepareStatement(sql);
	    for(int i=0;i<methodNames.length;i++) {
	    	String mName = methodNames[i];
	    	Method m = s.getClass().getMethod(mName);
	    	Class r = m.getReturnType();

    		if(r.getName().equals("java.lang.String")) {
        		String returnValue = (String) m.invoke(s);
	    		ps.setString(i+1, returnValue);
	    	}

       		if(r.getName().equals("int")) {
        		Integer returnValue = (Integer) m.invoke(s);

	    		ps.setInt(i+1, returnValue);
	    	}

			System.out.println(m.getName() + "|" + r.getName());

	    }
	    ps.executeUpdate();
	    ps.close();
	    conn.close();
	}

	private String createSQL() {
		String str1 = "";
		int index = 0;
		for(String s : cfs.keySet()) {
			String v = cfs.get(s);
			v = Character.toUpperCase(v.charAt(0)) + v.substring(1);
			methodNames[index] = "get" + v;
			str1 += s + ",";
			index++;
		}
		for(String m : methodNames) {
			System.out.println(m);
		}

		str1 = str1.substring(0, str1.length()-1);
		System.out.println(str1);

		String str2 = "";
		for(int i=0;i<cfs.size();i++) {
			str2 += "?,";
		}
		str2 = str2.substring(0, str2.length()-1);
		System.out.println(str2);

		String sql = "insert into " + tableName + " ( " + str1 + " ) " + "values ( " + str2 + " ) ";
		System.out.println(sql);
		return sql;
	}
}
