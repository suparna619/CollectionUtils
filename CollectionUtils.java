import java.util.*;



interface ListMapper<E> {
	E mapperCallback(E element, int index, List<E> list);
}

public class CollectionUtils<E> {
	public static<E> List<E> map(List<E> list, ListMapper mapper) {
		List<E> result = new ArrayList();
		int index = 0;
		for(E element : list) {
			E returnElement = (E)mapper.mapperCallback(element,index++,list);
			result.add(returnElement);
		}
		return result;
	}
}