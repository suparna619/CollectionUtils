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

class IntegerSquarMapperUtil implements ListMapper<Integer> {
	public Integer mapperCallback(Integer element, int index, List<Integer> list) {
		return element.intValue()*element.intValue();
	}
}

class ToLowerCaseMapperUtil implements ListMapper<String> {
	public String mapperCallback(String element, int index, List<String> list){
		return element.toLowerCase();
	}
}

class IntergerFilterForEvenUtil implements ListFilter<Integer> {
	public boolean filterCallback(Integer element, int index, List<Integer> list) {
		return (element.intValue()%2 == 0);
	}
}

class StringFilterForEvenUtil implements ListFilter<String> {
	public boolean filterCallback(String element, int index, List<String> list) {
		return ((int)element.charAt(0) > 97);
	}
}


public class CollectionUtilsTest {
	@Test
	public void map_returns_the_double_of_each_elements_of_a_intArray_list(){
		ListMapper listMapper = new IntegerMapperUtil();
		List<Integer> intArray = new ArrayList<Integer>();
		
		intArray.add(1);
		intArray.add(2);
		intArray.add(3);

		List<Integer> result = CollectionUtils.<Integer>map(intArray,listMapper);
		assertEquals((Integer)2,result.get(0));
		assertEquals((Integer)4,result.get(1));
		assertEquals((Integer)6,result.get(2));
	}

	@Test
	public void map_returns_the_squar_of_each_elements_of_a_intArray_list(){
		ListMapper listMapper = new IntegerSquarMapperUtil();
		List<Integer> intArray = new ArrayList<Integer>();
		
		intArray.add(1);
		intArray.add(4);
		intArray.add(9);

		List<Integer> result = CollectionUtils.<Integer>map(intArray,listMapper);
		assertEquals((Integer)1,result.get(0));
		assertEquals((Integer)16,result.get(1));
		assertEquals((Integer)81,result.get(2));
	}

	@Test
	public void map_returns_the_lowerCase_of_each_elements_of_a_stringArray_list(){
		ListMapper listMapper = new ToLowerCaseMapperUtil();
		List<String> stringArray = new ArrayList<String>();
		
		stringArray.add("AbcDEf");
		stringArray.add("abcdef");
		stringArray.add("AbcdeF");

		List<String> result = CollectionUtils.<String>map(stringArray,listMapper);
		assertEquals((String)"abcdef",result.get(0));
		assertEquals((String)"abcdef",result.get(1));
		assertEquals((String)"abcdef",result.get(2));
	}

	@Test
	public void filter_returns_only_the_even_elements_of_a_intArray_list(){
		ListFilter listFilter = new IntergerFilterForEvenUtil();
		List<Integer> intArray = new ArrayList<Integer>();
		
		intArray.add(1);
		intArray.add(2);
		intArray.add(3);

		List<Integer> result = CollectionUtils.<Integer>filter(intArray,listFilter);
		assertEquals((Integer)2,result.get(0));
	}

	@Test
	public void filter_returns_only_the_String_elements_started_with_small_letters_stringArray_list(){
		ListFilter<String> listFilter = new StringFilterForEvenUtil();
		List<String> stringArray = new ArrayList<String>();
		
		stringArray.add("under world authority");
		stringArray.add("Bhumi");
		stringArray.add("chandrabindu");

		List<String> result = CollectionUtils.<String>filter(stringArray,listFilter);
		assertEquals((String)"under world authority",result.get(0));
		assertEquals((String)"chandrabindu",result.get(1));
	}	
}