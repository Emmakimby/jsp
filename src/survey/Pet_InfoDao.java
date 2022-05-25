package survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Pet_InfoDao {

//	private JdbcTemplate JdbcTemplate;
//	Scanner in = new Scanner(System.in);
//
//	public Pet_InfoDao() {
//		JdbcTemplate = pet_project.JdbcTemplate.getInstance();
//	}
	private static Pet_InfoDao instance = null;

	private Pet_InfoDao() {
	}

	public static Pet_InfoDao getInstance() {
		if (instance == null) {
			synchronized (Pet_InfoDao.class) {
				instance = new Pet_InfoDao();
			}
		}
		return instance;
	}

	private static DataSource ds = null;
	{
		try {
			Context init = new InitialContext();
			ds = (DataSource) (init).lookup("java:comp/env/jdbc/myOracle");
		} catch (Exception e) {
			System.err.println("Connection 실패");
		}
	}

	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public boolean insertPet_Info(long manNum, Pet_InfoDto Pvo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"PET_INFO\" values (?, ?, ?, ?)";
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, manNum);
			pstmt.setLong(2, Pvo.getTypeNo());
			pstmt.setObject(3, Pvo.getName());
			pstmt.setLong(4, Pvo.getPetAge());

			// System.out.println(sql);
			int result = pstmt.executeUpdate();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	
	public boolean insertPet_Info(int manNum, String PetNum,String name, String Petage) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into \"PET_INFO\" values (?, ?, ?, ?)";
		try {
			conn = getConnection();
System.out.print(manNum+PetNum+name+Petage);
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, manNum);
			pstmt.setString(2, PetNum);
			pstmt.setString(3, name);
			pstmt.setString(4, Petage);

			// System.out.println(sql);
			int result = pstmt.executeUpdate();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	public List<Pet_InfoDto> selsctAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Pet_InfoDto> ls = new ArrayList<>();

		String sql = "select \"MAN_INFO_PET_NO\", \"PET_TYPE_PET_NO\", \"PET_NAME\", \"PET_AGE\" from PET_INFO";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Pet_InfoDto tmp = new Pet_InfoDto();
				tmp.setNumber(rs.getLong("MAN_INFO_PET_NO"));
				tmp.setTypeNo(rs.getLong("PET_TYPE_PET_NO"));
				tmp.setName(rs.getString("PET_NAME"));
				tmp.setPetAge(rs.getLong("PET_AGE"));
				ls.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (ls.size() == 0) ? null : ls;

	}

	public int manNum() {
		int num = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select \"NUMBER\" from (select \"NUMBER\" from \"MAN_INFO\" order by \"NUMBER\"desc) where rownum<2";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, age);
//			pstmt.setString(2, House);
//			pstmt.setString(3, Pet);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt("NUMBER");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			
		return num;
	}
	
	public int petNum(String type) {
		int num = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select \"TYPE_NO\" from \"PET_TYPE\" where \"PET_TYPE\"= ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt("TYPE_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			
		return num;
	}
}
