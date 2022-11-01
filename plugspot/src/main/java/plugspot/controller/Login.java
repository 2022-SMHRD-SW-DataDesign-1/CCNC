package plugspot.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import plugspot.model.MemberDAO;
import plugspot.model.MemberDTO;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String member_num = request.getParameter("member_num");
		String password = request.getParameter("password");

		System.out.println("member_num :" + member_num);
		System.out.println("password :" + password);

		MemberDTO dto = new MemberDTO(member_num, password);

		MemberDAO dao = new MemberDAO();
		member_num = dao.Login(dto);
		
		String moveURL = "";
		if(member_num==null) {
			System.out.println("로그인 실패");
		
		}else {
			System.out.println("로그인 성공");
			
			

			
			HttpSession session = request.getSession();
			session.setAttribute("member_num",member_num);
			
			moveURL= "Main.jsp";
		}
		response.sendRedirect(moveURL);

		}
		

	}