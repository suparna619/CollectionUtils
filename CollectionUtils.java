import java.util.*;


interface ListMapper<E, K> {
	K mapperCallback(E element, int index, List<E> list);
}

interface ListFilter<E> {
	boolean filterCallback(E element, int index, List<E> list);
}

public class CollectionUtils<E> {

	public static<E,K> List<K> map(List<E> list, ListMapper<E,K> mapper) {
		List<K> result = new ArrayList<K>();
		int index = 0;
		for(E element : list) {
			K returnElement = mapper.mapperCallback(element, index++, list);
			result.add(returnElement);
		}
		return result;
	}

	public static<E> List<E> filter(List<E> list, ListFilter filtration) {
		List<E> resultArray = new ArrayList();
		int index = 0;
		for (E element : list) {
			boolean isTrue = filtration.filterCallback(element, index++, list);
			if(isTrue)
				resultArray.add(element);
		}
		return resultArray;
	}
}