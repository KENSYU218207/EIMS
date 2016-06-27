package dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {  
  // ���C���X�^���X
  private static ConnectionManager instance = null;
  
  private DataSource ds = null;

  /*
   * �C���X�^���X�����A�擾�isingleton�j
   */
  public static ConnectionManager getConnectionManager() {
    if (instance==null) {
      instance = new ConnectionManager();
    }
    return instance;
  }

  /*
   * �f�[�^�\�[�X�̃��[�h
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
   * �R�l�N�V�����擾
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
