package kr.co.hk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbpkg.MemberDAO;
import dbpkg.MemberVO;

@WebServlet("/memberJoin")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = MemberDAO.getMaxCustNo();
		request.setAttribute("vo", vo);
		
		
		Utils.dispatcher("memberJoin", request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		int a = Integer.parseInt(request.getParameter("custno"));
		int custno = a; 
		String custname =  request.getParameter("custname");
		String phone =  request.getParameter("phone");
		String address =  request.getParameter("address");
		String joindata =  request.getParameter("joindata");
		String grade =  request.getParameter("grade");
		String city =  request.getParameter("city");
		
		MemberVO vo = new MemberVO(custno,custname,phone,address,joindata,grade,city);
					
		MemberDAO.inselt(vo);
		
		request.setAttribute("vo", vo);

		Utils.dispatcher("memberJoin", request, response);
		/*
		RequestDispatcher rd = request.getRequestDispatcher("memberFind.jsp");
		rd.forward(request, response);
		*/
		
		
		
	
	}

}
