package plugspot.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import plugspot.model.MemberDAO;
import plugspot.model.MemberDTO;

public class JoinService extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[JoinService]");

		request.setCharacterEncoding("UTF-8");

		String savePath = request.getServletContext().getRealPath("image");
		System.out.println(savePath);

		int maxSize = 10 * 1024 * 1024;

		String encoding = "UTF-8";

		DefaultFileRenamePolicy rename = new DefaultFileRenamePolicy();

		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, savePath, maxSize, encoding, rename);


		String member_num = multi.getParameter("member_num");
		String password = multi.getParameter("password");
		String member_type = multi.getParameter("member_type");
		String filename = multi.getFilesystemName("filename");
		
		filename = URLEncoder.encode(filename, "UTF-8");


		System.out.println("member_num : " + member_num);
		System.out.println("password : "+ password);
		System.out.println("member_type" + member_type);
		System.out.println("filename : " + filename);

		MemberDTO dto = new MemberDTO(member_num, password, member_type, filename);
		System.out.println(dto.getFilename());
		System.out.println(dto.getMember_num());
		System.out.println(dto.getMember_type());
		System.out.println(dto.getPassword());
		
		int row = new MemberDAO().upload(dto);

		if (row > 0) {
			System.out.print("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		} catch (IOException e) {

			e.printStackTrace();
		}
		response.sendRedirect("MemberJoin.jsp");
	}
}
