package plugspot.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import plugspot.model.MemberDAO;


public class numCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String member_num = request.getParameter("inputE");
		
		MemberDAO dao = new MemberDAO();
		boolean num1 = dao.numCheck(member_num);
		
		PrintWriter out = response.getWriter();
		out.print(num1);
		
		
		
	}
	

	}


