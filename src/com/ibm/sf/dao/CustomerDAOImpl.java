package com.ibm.sf.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.ibm.sf.service.exception.BankException;
public class CustomerDAOImpl implements CustomerDAO{

	
	
	

	
	
private Logger daoLogger=Logger.getLogger(CustomerDAOImpl.class);
	@Override
	public Boolean login(String uid, String password) throws BankException {
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
			System.out.println(preparedStatement.toString()+"prep stmnt");
			System.out.println("uid and pwd"+uid+" "+password);
			ResultSet resultSet=preparedStatement.executeQuery();
//			System.out.println(resultSet.getInt("ROLE")+""+resultSet.getInt("REG_ID"));
//			System.out.println(resultSet.toString()+" out");
//			System.out.println("hvbhbvh"+resultSet.next());
			if(resultSet.next()) {
				System.out.println(resultSet.getString(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
				
				return true;
				
			}else {
				return false;
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
	public Integer fundsTransfer(Integer type, Integer amount,Integer uid,Date d,String remarks)
			throws BankException {
	
	Connection connection=null;
	try {
		Context context= 
				(Context)new InitialContext().lookup("java:comp/env");
		DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
		connection=dataSource.getConnection();
		PreparedStatement preparedStatement= 
				connection.prepareStatement(QueryMapper.TRANSACT_ADD);
		/* populatePreparedStatement(user,preparedStatement); */
		preparedStatement.setInt(1,11);
		preparedStatement.setInt(2,amount);
		preparedStatement.setInt(3,type);
		preparedStatement.setInt(4,uid);
		preparedStatement.setDate(5,d);
		preparedStatement.setString(6,remarks);
		
		int status=preparedStatement.executeUpdate();
		if(status>0) {
			//daoLogger.info("New user: "+.getUserId()+" added to database");
			return status;
		}else {
			throw new BankException("Unable to transfer");
		}
	}catch(SQLException e) {
		/*
		 * daoLogger.error(e.getMessage()); throw new BankException(e.getMessage());
		 */
	}catch(Exception e) {
		/*
		 * daoLogger.error(e.getMessage()); throw new BankException(e.getMessage());
		 */}
	finally {
		try {
			connection.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
	}
	// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	//TO BE UPDATED//
	
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
	/*
	 * @Override public List getCustomerDetails() throws BankException { // TODO
	 * Auto-generated method stub return null; }
	 */

	/*
	 * @Override public List getCustomerDetails() throws BankException { // TODO
	 * Auto-generated method stub return null; }
	 */



	@Override
	public List getCustomerDetails() throws BankException {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	//withdraw from current balance
	// reg_id
	
	
	//deposit
	
	// update trnsfrd user account balance
	
	
}
		
