package injector;

import cachecreator.CacheCreator;
import consumer.InjectCache;
import mycache.Cache;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Р on 04.06.2016.
 */
public class Injector {


    public static void inject(Object inputObject) throws TypeNotPresentException {

        List<Object> cacheObjects = CacheCreator.getAllCaches();
        List<Field> consumerFields = getAllCacheAnnotatedFields(getAllParents(inputObject.getClass()));
        String annotationName;
        try {
            for (Field field : consumerFields) {
                field.setAccessible(true);
                annotationName = field.getAnnotation(InjectCache.class).name();
                boolean cacheAnnotationNotFound = true;
                for (Object cacheObject : cacheObjects) {
                    if (annotationName.equals(cacheObject.getClass().getAnnotation(Cache.class).name())) {
                        cacheAnnotationNotFound = false;
                        field.set(inputObject, cacheObject);
                    }
                }
                if (cacheAnnotationNotFound) {
                    throw new TypeNotPresentException(Cache.class.getTypeName(), null);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Class> getAllParents(Class inputClass) {
        List<Class> parentsList = new ArrayList<Class>();

        for (; inputClass != null; inputClass = inputClass.getSuperclass()) {
            parentsList.add(inputClass);
        }
        System.out.println("Parents List: " + parentsList);
        return parentsList;
    }

    private static List<Field> getAllCacheAnnotatedFields(List<Class> inputList) {

        List<Field> allParentsFields = new ArrayList<Field>();
        for (int i = 0; i < inputList.size(); i++) {
            allParentsFields.addAll((Arrays.asList(inputList.get(i).getDeclaredFields())));
        }
        for (int i = 0; i < allParentsFields.size(); i++) {
            if (!allParentsFields.get(i).isAnnotationPresent(InjectCache.class)) {
                allParentsFields.remove(i);
            }
        }
        System.out.println("Parents Fields: " + allParentsFields + "\n");
        return allParentsFields;
    }
}
