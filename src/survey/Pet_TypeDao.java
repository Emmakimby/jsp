package survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Pet_TypeDao {
//	private JdbcTemplate JdbcTemplate;
//	Scanner in = new Scanner(System.in);
//
//	public Pet_TypeDao() {
//		JdbcTemplate = pet_project.JdbcTemplate.getInstance();
//	}
	private static Pet_TypeDao instance = null;
	private Pet_TypeDao() {
	}

	public static Pet_TypeDao getInstance() {
		if (instance == null) {
			synchronized (Pet_TypeDao.class) {
				instance = new Pet_TypeDao();
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
	
	public boolean insertPet_Type(String name) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"PET_TYPE\" values (\"SEQ_PTYPE\".nextval, ?)";
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
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
	
	public boolean insertPet_Type(Pet_TypeDto Tvo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into \"PET_TYPE\" values (\"SEQ_PTYPE\".nextval, ?)";
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Tvo.getType());
			pstmt.executeUpdate();
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
	public int searchNumber(Pet_TypeDto Tvo) {
		int number = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select \"TYPE_NO\"\n" + "from \"PET_TYPE\"\n"
				+ "where \"PET_TYPE\" = ?";
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Tvo.getType());

			rs = pstmt.executeQuery();

			if (rs.next())
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
	public List<Pet_TypeDto> selsctAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Pet_TypeDto> ls = new ArrayList<>();

		String sql = "select \"TYPE_NO\", \"PET_TYPE\" from PET_TYPE";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				Pet_TypeDto tmp = new Pet_TypeDto();
				tmp.setTypeNo(rs.getLong("TYPE_NO"));
				tmp.setType(rs.getString("PET_TYPE"));
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
