package kr.co.hk;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbpkg.MemberDAO;
import dbpkg.MemberVO;

@WebServlet("/memberFind")
public class MemberFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<MemberVO> list = MemberDAO.find();
		String grade = "";
		for (int i = 0; i < list.size(); i++) {
			
			grade = list.get(i).getGrade();
		 
			if(grade == null){
		    	grade = "";
		    }
		    else if (grade.equals("A")) {
				grade = "VIP";
				list.get(i).setGrade(grade);
			} else if (grade.equals("B")) {
				grade = "일반";
				list.get(i).setGrade(grade);
			} else if (grade.equals("C")) {
				grade = "직원";
				list.get(i).setGrade(grade);
			}
		   
			
		}
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("memberFind.jsp");
		rd.forward(request, response);

	}

}
