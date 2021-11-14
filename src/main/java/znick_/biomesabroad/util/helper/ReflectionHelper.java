package znick_.biomesabroad.util.helper;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;

public class ReflectionHelper {

	public static <T> T[] getTypeFields(Class clazz, Class<T> generic) {
		try {
			Set<T> ts = new LinkedHashSet<T>();
			for (Field field : clazz.getDeclaredFields()) {
				Object obj = field.get(null);
				if (generic.isInstance(obj)) {
					ts.add((T) obj);
				}
			}
			return ts.toArray((T[]) Array.newInstance(generic, 0));
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
