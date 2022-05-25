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

public class Man_InfoDao {
//	private JdbcTemplate JdbcTemplate;
//	Scanner in = new Scanner(System.in);
//
//	public Man_InfoDao() {
//		JdbcTemplate = pet_project.JdbcTemplate.getInstance();
//	}
	private static Man_InfoDao instance = null;

	private Man_InfoDao() {
	}

	public static Man_InfoDao getInstance() {
		if (instance == null) {
			synchronized (Man_InfoDao.class) {
				instance = new Man_InfoDao();
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

	public boolean insertMan_Info(Man_InfoDto Mvo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"MAN_INFO\" values (\"PET_INFONO\".nextval, ?, ?, ?)";
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, Mvo.getAge());
			pstmt.setLong(2, Mvo.getHouse());
			pstmt.setString(3, Mvo.getPet());

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
	
	public boolean insertMan_Info(String age, String House, String Pet) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"MAN_INFO\" values (\"PET_INFONO\".nextval, ?, ?, ?)";
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, age);
			pstmt.setString(2, House);
			pstmt.setString(3, Pet);

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

	public long searchNumber(Man_InfoDto Mvo) {
		long number = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select \"NUMBER\"\n" + "from \"MAN_INFO\"\n"
				+ "where \"AGE\" = ? and \"PET_HOUSE\" = ? and \"PET_YN\" = ?";
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, Mvo.getAge());
			pstmt.setLong(2, Mvo.getHouse());
			pstmt.setString(3, Mvo.getPet());

			rs = pstmt.executeQuery();

			while (rs.next())
				number = rs.getInt(1);

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
		return number;
	}

	public List<Man_InfoDto> selsctAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Man_InfoDto> ls = new ArrayList<>();

		String sql = "select \"NUMBER\", \"AGE\", \"PET_HOUSE\", \"PET_YN\" from MAN_INFO";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Man_InfoDto tmp = new Man_InfoDto();
				tmp.setAge(rs.getInt("AGE"));
				tmp.setNumber(rs.getInt("NUMBER"));
				tmp.setHouse(rs.getInt("PET_HOUSE"));
				tmp.setPet(rs.getString("PET_YN"));

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

}
