package com.ibm.sf.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.ibm.sf.service.exception.BankException;
public class CustomerDAOImpl implements CustomerDAO{

	
	
	

	
	
private Logger daoLogger=Logger.getLogger(CustomerDAOImpl.class);
	@Override
	public Integer login(String uid, String password) throws BankException {
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
				return resultSet.getInt(4);
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
	public Double getCurrentAmount(String uid) throws BankException 
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
				return resultSet.getDouble(4);//specify index of avaliable balance field
				
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
		
	}

	
	@Override
	public List getStatement(String uid) throws BankException {	//get details from transfer table
		
		Connection connection=null;
		List<String> list=new ArrayList<>();
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.NEW_USER_ID);	
			preparedStatement.setString(1, uid);
			ResultSet resultSet=preparedStatement.executeQuery();
			list.add(resultSet.getString(1));
			list.add(resultSet.getString(2));
			list.add(resultSet.getString(3));
			
			return list;
			
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
	/*
	 * @Override public Integer fundsTransfer(String name, String bid, Integer type,
	 * String ifsc, Double amount,String remarks) { Connection connection=null; try
	 * { Context context= (Context)new InitialContext().lookup("java:comp/env");
	 * DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
	 * connection=dataSource.getConnection(); PreparedStatement preparedStatement=
	 * connection.prepareStatement(QueryMapper.NEW_USER_ID);
	 * preparedStatement.setDouble(3, amount); preparedStatement.setInt(4, type);
	 * preparedStatement.setString(5,bid); //date LocalDate date = LocalDate.now();
	 * preparedStatement.setDate(6, java.sql.Date.valueOf(date));
	 * preparedStatement.setString(7,remarks); preparedStatement.setString(8,ifsc);
	 * 
	 * if(preparedStatement.getDouble("checkbal")>amount) {
	 * 
	 * ResultSet resultSet=preparedStatement.executeQuery(); Double
	 * bal1=deposit(bid,amount); Double bal2=withdraw(uid,amount); return 1; } else
	 * {return 0;}
	 * 
	 * }catch(SQLException e) { throw new BankException(e.getMessage());
	 * }catch(Exception e) { throw new BankException(e.getMessage()); } finally {
	 * try { connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * }
	 */
	
	@Override
	public Integer mobileTopUp(Long mobno, String operator, Double amount) throws BankException {
	
		Connection connection=null;
		Double current_bal;
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
			current_bal=withdraw("1",amount);
			return 1;
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
			String password) throws BankException {
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
				throw new BankException("Unable to create new Bank Account");
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
	public Double withdraw(String uid, Double amount) throws BankException {
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
	public Double deposit(String uid, Double amount) throws BankException {
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
	public Integer fundsTransfer(String name, Long accountno, Integer type, String ifsc, Double amount)
			throws BankException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public List getCustomerDetails() throws BankException { // TODO
	 * Auto-generated method stub return null; }
	 */

	/*
	 * @Override public List getCustomerDetails() throws BankException { // TODO
	 * Auto-generated method stub return null; }
	 */


	@Override
	public Integer checkType(String uid) throws BankException {
		
		Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.VERIFY_USER);
			preparedStatement.setString(1,uid);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.getInt(4)==0) {
				return 0;}
				else{
					return 1;//column index of type in master table
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
	public List getCustomerDetails() throws BankException {
		// TODO Auto-generated method stub
		return null;
	}
}