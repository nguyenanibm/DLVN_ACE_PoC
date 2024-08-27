package vn.com.dlvn.db;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import vn.com.dlvn.utils.getPolicies;
import vn.com.dlvn.utils.logger;

public class ConnectionFactory {
	// init database constants
	private static final String DATABASE_DRIVER = getPolicies.getUserDefVal("database","driver_name");
	private static final String DATABASE_URL = getPolicies.getUserDefVal("database","jdbc_url");
	private static final String USERNAME = getPolicies.getUserDefVal("database","username");
	private static final String PASSWORD = getPolicies.getUserDefVal("database","password");
	private static final String MAX_POOL = getPolicies.getUserDefVal("database","max_pool_size");
	private static ConnectionFactory instance;
	
	// init connection object
	private Connection connection;
	
	// init properties object
	private Properties properties;

	private ConnectionFactory() {
		super();
	}
	
	public static ConnectionFactory getInstance() {
		if (instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}
	
	// create properties
	private Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			properties.setProperty("user", USERNAME);
			properties.setProperty("password", PASSWORD);
			properties.setProperty("MaxPooledStatements", MAX_POOL);
		}
		return properties;
	}
	
	// connect database
	public Connection connect() {
		if (connection == null) {
			try {
				Class.forName(DATABASE_DRIVER);
				connection = DriverManager.getConnection(DATABASE_URL, getProperties());
			} catch (Exception e) {
				e.printStackTrace();
				logger.log("ConnectionFactory", "ERROR", ExceptionUtils.getStackTrace(e));
			}
		}
		return connection;
	}

	// disconnect database
	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
				logger.log("ConnectionFactory", "ERROR", ExceptionUtils.getStackTrace(e));
			}
		}
	}
}
