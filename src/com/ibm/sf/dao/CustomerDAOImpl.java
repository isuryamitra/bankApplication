
package com.ibm.sf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.ibm.sf.service.domain.User;
import com.ibm.sf.service.exception.BankException;
import com.ibm.sf.service.exception.BankException;

public class CustomerDAOImpl implements CustomerDAO{

	
	
private Logger daoLogger=Logger.getLogger(UserDaoImpl.class);
	
	@Override
	public Integer addNewUser(User user) throws BankException {
		
		Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.ADD_USER);
			populatePreparedStatement(user,preparedStatement);
			int status=preparedStatement.executeUpdate();
			if(status>0) {
				daoLogger.info("New user: "+user.getUserId()+" added to database");
				return user.getUserId();
			}else {
				throw new BankException("Unable to add user");
			}
		}catch(SQLException e) {
			daoLogger.error(e.getMessage());
			throw new BankException(e.getMessage());
		}catch(Exception e) {
			daoLogger.error(e.getMessage());
			throw new BankException(e.getMessage());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	@Override
	public Integer login(String uid, String password) {
		Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.VERIFY_USER);
			preparedStatement.setString(1,uid);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return 1;
			}else {
				return 0;
			}
		}catch(SQLException e) {
			daoLogger.error(e.getMessage());
			throw new BankException(e.getMessage());
		}catch(Exception e) {
			daoLogger.error(e.getMessage());
			throw new BankException(e.getMessage());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}
		

	@Override
	public Double getCurrentAmount(String uid) {
		
	}

	@Override
	public String getStatement(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer fundsTransfer(String name, Long accountno, Integer type, String ifsc, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer mobileTopUp(Long mobno, String operator, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer customerReg(String name, Long accountno, String email, LocalDate dob, String fname, Long mobile,
			String password) {
		/Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.NEW_USER_ID);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}else {
				throw new BankException("Unable to generate new userid");
			}
		}catch(SQLException e) {
			throw new BankException(e.getMessage());
		}catch(Exception e) {
			throw new BankException(e.getMessage());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}

	}

	@Override
	public Integer getCustomerDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double withdraw(Long accountno, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double deposit(Long accountno, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

}

