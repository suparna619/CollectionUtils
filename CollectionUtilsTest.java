import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.*;


class IntegerMapperUtil implements ListMapper<Integer> {
	public Integer mapperCallback(Integer element, int index, List<Integer> list) {
		return element.intValue()*2;
	}
}


public class CollectionUtilsTest {
	@Test
	public void map_returns_the_double_of_each_elements_of_a_intArray_list(){
		ListMapper listMapper = new IntegerMapperUtil();
		List<Integer> intArray = new ArrayList<Integer>();
		List<Integer> expectedArray = new ArrayList<Integer>();
		
		intArray.add(1);
		intArray.add(2);
		intArray.add(3);

		expectedArray.add(2);
		expectedArray.add(4);
		expectedArray.add(6);

		List<Integer> result = CollectionUtils.<Integer>map(intArray,listMapper);
		assertEquals(expectedArray.get(0),result.get(0));
		assertEquals(expectedArray.get(1),result.get(1));
		assertEquals(expectedArray.get(2),result.get(2));
	}
}