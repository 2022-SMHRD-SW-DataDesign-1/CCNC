package plugspot.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import plugspot.db.SqlSessionManager;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	public int upload(MemberDTO dto) {
		System.out.println("dao in");
		SqlSession session = sqlSessionFactory.openSession(true);
		System.out.println("dao open");
		int row = session.insert("upload",dto);
		System.out.println("dao insert");
		session.close();
		
		return row;
	}
	
	public boolean numCheck(String inputE) {
		SqlSession session=sqlSessionFactory.openSession(true);
		boolean checkE  = session.selectOne("numCheck", inputE);
		session.close();
		return checkE; 
}
	public String Login(MemberDTO dto) {
		
		SqlSession session = sqlSessionFactory.openSession(true);
		String num = session.selectOne("Login", dto);
		session.close();
		
		return num;
		
		
	}
	
}