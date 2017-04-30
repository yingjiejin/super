package test;

import com.alibaba.fastjson.JSON;
import com.supermarket.generator.utils.TableUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Driver;
import java.sql.SQLException;

public class GeneratorUtilsTest {

	SimpleDriverDataSource dataSource;

	@Before
	public void init() throws ClassNotFoundException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/supermarket?useUnicode=true&characterEncoding=utf8&useSSL=false";
		String user = "root";
		String password = "123456";
		dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass((Class<? extends Driver>) Class.forName(driver));
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
	}

	@Test
	public void load() throws SQLException {

		System.err.println(JSON.toJSONString(TableUtils.loadTables(dataSource.getConnection(), "root")));
	}
}
