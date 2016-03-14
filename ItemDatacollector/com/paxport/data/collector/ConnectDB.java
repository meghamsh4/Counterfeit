package com.paxport.data.collector;

public class ConnectDB {
   
	    private java.sql.Connection con = null;
	    private final String url = "jdbc:sqlserver://pax.database.windows.net";
	    private final String portNumber = "1433";
	    private final String databaseName = "PAX";
	    private final String userName = "Paxadmin@pax";
	    private final String password = "@Kingmaker2u";

	    private String getConnectionUrl() {
	        return url  + ":" + portNumber + ";databaseName=" + databaseName + "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
	    }

	    private java.sql.Connection getConnection() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = java.sql.DriverManager.getConnection(getConnectionUrl(), userName, password);
	            if (con != null) {
	                System.out.println("Connection Successful!");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Error Trace in getConnection() : " + e.getMessage());
	        }
	        return con;
	    }
	    
	    private void closeConnection() {
	        try {
	            if (con != null) {
	                con.close();
	            }
	            con = null;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static void main(String[] args) throws Exception {
	        ConnectDB myDbTest = new ConnectDB();
	        myDbTest.getConnection();
	        myDbTest.closeConnection();
	    }
	}