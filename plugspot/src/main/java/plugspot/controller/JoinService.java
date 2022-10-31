package plugspot.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

@WebServlet
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
System.out.println("[JoinService]");
		
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		System.out.println(email);
		System.out.println(pw);
		System.out.println(tel);
		System.out.println(address);
		
		 MemberDTO dto =new MemberDTO(email, pw, tel, address);
		 int row =new MemberDAO().join(dto);
		 String moveURL = null;
		 if(row>0) {
			 System.out.println("회원가입 성공");
			 moveURL="JoinSuccess.jsp";
			 request.setAttribute("email", email);
		 }
		 else {
			 System.out.println("회원가입 실패");
			 moveURL = "./Main.jsp";
		 }
		 
		 RequestDispatcher rd = request.getRequestDispatcher(moveURL);
		 rd.forward(request, response);
	}

}
	}

}
