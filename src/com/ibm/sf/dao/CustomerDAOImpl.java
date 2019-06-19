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

	
	
	

	
	
private Logger daoLogger=Logger.getLogger(CustomerDAOImpl.class);
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
	public Double getCurrentAmount(String uid) 
	{
		Connection connection=null;
		Double currentBal;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.VERIFY_USER);
			preparedStatement.setString(1,uid);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				currentBal=((ResultSet) preparedStatement).getDouble(currentBal);//currentBal->db field
			}else {
				return 0.0;
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
		
		return currentBal;
		
	}

	
	@Override
	public String getStatement(String uid) {		
	
	}
	@Override
	public Integer fundsTransfer(String name, Long accountno, Integer type, String ifsc, Double amount) { 
		Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.NEW_USER_ID);	
			preparedStatement.setDouble(2, amount);
			preparedStatement.setInt(3, type);
			preparedStatement.setString(4,uid);
			//date
			LocalDate date = LocalDate.now();
			preparedStatement.setDate(5, java.sql.Date.valueOf(date));
			preparedStatement.setString(6, "");
			ResultSet resultSet=preparedStatement.executeQuery();
			Double bal1=deposit(bid,amount);
			Double bal2=withdraw(uid,amount);
			
			
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
	public Integer mobileTopUp(Long mobno, String operator, Double amount) {
	
		Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.NEW_USER_ID);
			preparedStatement.setDouble(1, amount);
			if(((ResultSet) preparedStatement).getDouble("currentbal") > amount)
			{
			ResultSet resultSet=preparedStatement.executeQuery();
			}else {
				throw new BankException("Insufficient Balance");
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
	public Integer customerReg(String name, Long accountno, String email, LocalDate dob, String fname, Long mobile,
			String password) {
		Connection connection=null;
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
	public Double withdraw(String uid, Double amount) {
		Connection connection=null;
		Double currentBal;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.VERIFY_USER);
			preparedStatement.setString(1,uid);
			preparedStatement.setDouble(2, amount);
			ResultSet resultSet=preparedStatement.executeQuery();
			currentBal=getCurrentAmount(uid);//uid from session
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
		return currentBal;
	}

	@Override
	public Double deposit(String uid, Double amount) {
		Connection connection=null;
		Double currentBal;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.VERIFY_USER);
			preparedStatement.setString(1,uid);
			preparedStatement.setDouble(2, amount);
			ResultSet resultSet=preparedStatement.executeQuery();
			currentBal=getCurrentAmount(uid);//uid from session
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
		return currentBal;
	}
	}


