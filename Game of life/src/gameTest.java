import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class gameTest {
 private static game a=new game();
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSettable() 
	{
		a.settable(false, 0, 0);
		assertEquals(false,a.gettable(0, 0));
	}
	@Ignore("gettable() Not yet implemented")

	@Test
	void testGetNeighbors() // 测试得到细胞周围活细胞数目
	{
		for(int i=0;i<30;i++)
			for(int j=0;j<30;j++)
		{
			if((i+j)%2==0)
			{
				a.settable(false, i, j);
			}
			else a.settable(true, i, j);
		}
		a.getNeighbors();
		
		assertEquals(2,a.getneighbor(0, 0));
		
	}

	@Test
	void testNextWorld()  //测试细胞下一时刻的状态
	{
		for(int i=0;i<30;i++)
			for(int j=0;j<30;j++)
		{
			if((i+j)%2==0)
			{
				a.settable(false, i, j);
			}
			else a.settable(true, i, j);
		}
		a.getNeighbors();
		a.nextWorld();
		assertEquals(false,a.gettable(5,5));

	}

}
