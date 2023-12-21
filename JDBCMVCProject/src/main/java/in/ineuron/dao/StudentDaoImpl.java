package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JDBCConnection;

public class StudentDaoImpl implements IStudentDao {

	Connection conn = null;
	@Override
	public String save(Student student) {
		
		PreparedStatement pstmt=null;
		String sqlInsertQuery= "insert into student2(age, name, address) values(?,?,?)";
		String status=null;
		try {
			
			conn = JDBCConnection.getConnection();
			
			if(conn!=null) {
				pstmt = conn.prepareStatement(sqlInsertQuery);
				pstmt.setString(1, student.getSage());
				pstmt.setString(2, student.getSname());
				pstmt.setString(3, student.getSaddress());
				
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected==1) {
					status = "success";
				}
				else {
					status = "failure";
				}
			}
			
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		// TODO Auto-generated method stub
		
		Student student=null;
		PreparedStatement pstmt=null;

		String sqlSelectQuery= "select age, name, address from student2 where id =?";
		try {
			
			conn = JDBCConnection.getConnection();
			
			if(conn!=null) {
				pstmt = conn.prepareStatement(sqlSelectQuery);
				pstmt.setInt(1, sid);
				ResultSet rs = pstmt.executeQuery();
				if(rs!=null) {
					student=new Student();
					student.setSid(sid);
				}
				while(rs.next()) {
					
					
//					student.setSid(sid);
					student.setSage(rs.getString(1));
					student.setSname(rs.getString(2));
					student.setSaddress(rs.getString(3));
				
				}
				System.out.println(rs.getString(1));
			}
			
			
			
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			return student;
		
		}
		
		
		return student;
	}

	@Override
	public String updateById(Student student) {
		
		PreparedStatement pstmt=null;
		String sqlUpdateQuery= "update student2 set age=?, name=?, address=? where id=?";
		String status=null;
		try {
			
			
	
			
		
				conn = JDBCConnection.getConnection();
				
				if(conn!=null) {
					pstmt = conn.prepareStatement(sqlUpdateQuery);
					pstmt.setString(1, student.getSage());
					pstmt.setString(2, student.getSname());
					pstmt.setString(3, student.getSaddress());
					pstmt.setInt(4, student.getSid());
					
					int rowAffected = pstmt.executeUpdate();
//					
//					if(rowAffected==1) {
//						status = "success";
//					}
//					else {
//						status = "failure";
//					}
				}
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			status = "failure";
		}
		
		return "success";
	
		
		
		
	
	}

	@Override
	public String deleteById(Integer sid) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt=null;
		String sqlDeleteQuery= "delete from student2 where id = ?";
		String status=null;
		try {
			
			Student student= findById(sid);
			if(student.getSname()!=null) {
				conn = JDBCConnection.getConnection();
				
				if(conn!=null) {
					pstmt = conn.prepareStatement(sqlDeleteQuery);
					pstmt.setInt(1, sid);
					
					
					int rowAffected = pstmt.executeUpdate();
					
					if(rowAffected==1) {
						status = "success";
					}
					else {
						status = "failure";
					}
				}
			
			}
			
			else {
				return "notFound";
			}
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		
		return status;
		
		
	}

}
