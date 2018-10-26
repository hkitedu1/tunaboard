package dbpkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.xml.ws.Response;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class MemberDAO {
	public static MemberVO getMaxCustNo() {

		MemberVO vo = new MemberVO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " select nvl(max(cust_no),100000)+1 "
				+ " , TO_CHAR(sysdate,'yyyymmdd') " + " from member_tbl_02 ";

		try {
			con = DBConn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int maxCustNo = rs.getInt(1);
				String toDay = rs.getString(2);

				System.out.println("maxno : " + maxCustNo);
				System.out.println("today : " + toDay);

				vo.setCustno(maxCustNo);
				vo.setJoindate(toDay);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		System.out.println("getMaxCustNo [end]");

		return vo;
	}

	public static void inselt(MemberVO vo) {

		MemberVO vo2 = new MemberVO();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " INSERT INTO member_tbl_02  "
				+ " (CUST_NO,CUST_NAME,PHONE,ADDRESS,JOINDATA,GRADE,CITY) "
				+ " VALUES " + " (?,?,?,?,?,?,?) ";
		try {
			con = DBConn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getCustno());
			ps.setString(2, vo.getCustname());
			ps.setString(3, vo.getphone());
			ps.setString(4, vo.getAddress());
			ps.setString(5, vo.getJoindate());
			ps.setString(6, vo.getGrade());
			ps.setString(7, vo.getCity());

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		System.out.println("getMaxCustNo [end]");

	}

	public static ArrayList<MemberVO> find() {

		ArrayList<MemberVO> vo = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " select * " + "  from member_tbl_02 ";

		try {
			con = DBConn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				int custno = rs.getInt(1);

				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				String joindate = rs.getString(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);

				vo.add(new MemberVO(custno, custname, phone, address, joindate,
						grade, city));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		System.out.println("getMaxCustNo [end]");

		return vo;
	}

	public static MemberVO modify(int custno) {

		MemberVO vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " select * " + "  from member_tbl_02 "
				+ " where cust_no = ? ";

		try {
			con = DBConn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, custno);

			rs = ps.executeQuery();

			while (rs.next()) {

				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				String joindate = rs.getString(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);

				vo = new MemberVO(custno, custname, phone, address, joindate,
						grade, city);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		System.out.println("modify [end]");

		return vo;
	}

	public static void modifyIn(MemberVO vo) {

		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " UPDATE member_tbl_02  "
				+ " SET cust_name = ?, phone = ? ,address = ?, grade =?, city =? "
				+ " WHERE cust_no = ? ";
				
		try {
			con = DBConn.getConnection();
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, vo.getCustname());
			ps.setString(2, vo.getphone());
			ps.setString(3, vo.getAddress());
			ps.setString(4, vo.getGrade());
			ps.setString(5, vo.getCity());
			ps.setInt(6, vo.getCustno());
			
			ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		System.out.println("modifyIn [end]");

	}
	
	public static ArrayList<MemberVO> sale() {

		ArrayList<MemberVO> vo = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " select a.cust_no,a.CUST_NAME, "
				+ " sum(b.price),max(b.PRICE) "
				+ " from MEMBER_TBL_02 a"
				+ " inner join MONEY_TBL_02 b "
				+ " on a.CUST_NO = b.CUSTNO "
				+ " GROUP BY a.CUST_NO ,a.CUST_NAME"
				+ " ORDER BY a.CUST_NO " ;

		try {
			con = DBConn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				int custno = rs.getInt(1);

				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				String joindate = rs.getString(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);

				vo.add(new MemberVO(custno, custname, phone, address, joindate,
						grade, city));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		System.out.println("getMaxCustNo [end]");

		return vo;
	}
}
