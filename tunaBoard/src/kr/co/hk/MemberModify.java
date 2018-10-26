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


@WebServlet("/memberModify")
public class MemberModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String a = request.getParameter("Custno");
		int Custno = Integer.parseInt(a);
		System.out.println(Custno);
		
		MemberVO vo = MemberDAO.modify(Custno);
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("memberModify.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		request.setCharacterEncoding("utf-8");
		System.out.println("modifypost");
		int a = Integer.parseInt(request.getParameter("custno"));
		int custno = a; 
		String custname =  request.getParameter("custname");
		String phone =  request.getParameter("phone");
		String address =  request.getParameter("address");
		String joindata =  request.getParameter("joindata");
		String grade =  request.getParameter("grade");
		

		String city =  request.getParameter("city");
		MemberVO vo = new MemberVO(custno,custname,phone,address,joindata,grade,city);
					
		MemberDAO.modifyIn(vo);
		
		request.setAttribute("vo", vo);

		Utils.dispatcher("memberModify", request, response);
		
	}


}
