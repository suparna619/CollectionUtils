import java.util.*;


interface ListMapper<E> {
	E mapperCallback(E element, int index, List<E> list);
}

interface ListFilter<E> {
	boolean filterCallback(E element, int index, List<E> list);
}

public class CollectionUtils<E> {
	
	public static<E> List<E> map(List<E> list, ListMapper mapper) {
		List<E> resultArray = new ArrayList();
		int index = 0;
		for(E element : list) {
			E returnElement = (E)mapper.mapperCallback(element, index++, list);
			resultArray.add(returnElement);
		}
		return resultArray;
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