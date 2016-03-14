# Counterfeit

Requirements :
1. A Place Holder For Manufacturer to Upload the Product And Batch Data
2. Validate and Clean Up Data given by Manufacturer
3. Fetch and store data from manufacturer into Server side remote storage

API's:
API 1: Boolean FetchItemData(String itemDataExcelSheet)
API 2: Boolean UploadProductBatchData(String productBatchDataExcelSheet)


Tools :
GIT, Maven, MySQL


ERRORS:

com.microsoft.sqlserver.jdbc.SQLServerException: Cannot open server 'pax' requested by the login. Client with IP address '73.71.98.8' is not allowed to access the server.  To enable access, use the Windows Azure Management Portal or run sp_set_firewall_rule on the master database to create a firewall rule for this IP address or address range.  It may take up to five minutes for this change to take effect.
	at com.microsoft.sqlserver.jdbc.SQLServerException.makeFromDatabaseError(SQLServerException.java:196)
	at com.microsoft.sqlserver.jdbc.TDSTokenHandler.onEOF(tdsparser.java:246)
	at com.microsoft.sqlserver.jdbc.TDSParser.parse(tdsparser.java:83)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.sendLogon(SQLServerConnection.java:2532)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.logon(SQLServerConnection.java:1929)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.access$000(SQLServerConnection.java:41)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection$LogonCommand.doExecute(SQLServerConnection.java:1917)
	at com.microsoft.sqlserver.jdbc.TDSCommand.execute(IOBuffer.java:4026)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.executeCommand(SQLServerConnection.java:1416)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.connectHelper(SQLServerConnection.java:1061)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.login(SQLServerConnection.java:833)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.connect(SQLServerConnection.java:716)
	at com.microsoft.sqlserver.jdbc.SQLServerDriver.connect(SQLServerDriver.java:841)
	at java.sql.DriverManager.getConnection(Unknown Source)
	at java.sql.DriverManager.getConnection(Unknown Source)
	at com.paxport.data.collector.ConnectDB.getConnection(ConnectDB.java:19)
	at com.paxport.data.collector.ConnectDB.main(ConnectDB.java:43)
Error Trace in getConnection() : Cannot open server 'pax' requested by the login. Client with IP address '73.71.98.8' is not allowed to access the server.  To enable access, use the Windows Azure Management Portal or run sp_set_firewall_rule on the master database to create a firewall rule for this IP address or address range.  It may take up to five minutes for this change to take effect.

