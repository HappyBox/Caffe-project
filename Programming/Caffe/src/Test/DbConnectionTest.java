package Test;

import static org.junit.Assert.fail;

import org.junit.Test;

import DataBase.DbConnection;

public class DbConnectionTest {

	@Test
	public void test() {
		DbConnection dbCon = DbConnection.getInstance();
		if (dbCon != null) {
			System.out.println("Conecction to DB is ok");
		} else {
			fail("Can not connect to the DB");
		}
	}

}
