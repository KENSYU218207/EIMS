package dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {  
  // 自インスタンス
  private static ConnectionManager instance = null;
  
  private DataSource ds = null;

  /*
   * インスタンス生成、取得（singleton）
   */
  public static ConnectionManager getConnectionManager() {
    if (instance==null) {
      instance = new ConnectionManager();
    }
    return instance;
  }

  /*
   * データソースのロード
   */
  private ConnectionManager() {
    try {
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc/MySQLDB");
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  /*
   * コネクション取得
   */
  public synchronized Connection getConnection() throws SQLException {
    Connection conn = null;
    
    try {
      conn = ds.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
    return conn;
  }
}
