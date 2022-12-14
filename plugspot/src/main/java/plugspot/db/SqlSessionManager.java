package plugspot.db;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class SqlSessionManager {

	static SqlSessionFactory sqlSessionFactory = null;
	static {
	try {
	String resource = "plugspot/db/config.xml";//xml파일 경로
	
	
	InputStream inputStream = Resources.getResourceAsStream(resource);
	
	 sqlSessionFactory =
	  new SqlSessionFactoryBuilder().build(inputStream);
	

}catch(Exception e) {
	e.printStackTrace();
}
	
}


public static SqlSessionFactory getSqlSession() {
	return sqlSessionFactory;
}
}