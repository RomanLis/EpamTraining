import consumer.InjectCache;
import myCache.Cache;
import myCache.CacheOne;
import myCache.CacheThree;
import myCache.CacheTwo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Р on 04.06.2016.
 */
public class Injector {


    public static void inject(Object inputObject)  {

        ArrayList<Class> cacheClasses;
        cacheClasses = getAllCacheAnnotatedClasses();
        ArrayList<Field> consumerFields;
        consumerFields = getAllCacheAnnotatedFields(getAllParents(inputObject.getClass()));
        String annotationName;
        try {
            for(Field field: consumerFields) {
                field.setAccessible(true);
                annotationName = field.getAnnotation(InjectCache.class).name();
                boolean cacheAnnotationNotFound = true;
                for(Class<?> cacheClass: cacheClasses) {
                    if (annotationName.equals(cacheClass.getAnnotation(Cache.class).name())){
                        cacheAnnotationNotFound = false;
                        field.set(inputObject,cacheClass.newInstance());
                    }
                }
                if (cacheAnnotationNotFound){
                    throw new TypeNotPresentException(Cache.class.toString(),null);
                }
            }
        }catch (TypeNotPresentException | IllegalAccessException | InstantiationException  e){
            e.printStackTrace();
        }
    }

    private static ArrayList<Class> getAllCacheAnnotatedClasses() {
        ArrayList<Class> caches = new ArrayList<Class>();
        caches.add(CacheOne.class);
        caches.add(CacheTwo.class);
        caches.add(CacheThree.class);

        return caches;
    }

    private static ArrayList<Class> getAllParents(Class inputClass) {
        ArrayList<Class> parentsList= new ArrayList<Class>();
        parentsList.add(inputClass);

        while(true) {
            inputClass = inputClass.getSuperclass();
            if(inputClass==null) {
                break;
            } else {
                parentsList.add(inputClass);
            }
        }
        //System.out.println("Parents List: "+parentsList);
        return parentsList;
    }
    private static  ArrayList<Field> getAllCacheAnnotatedFields(ArrayList<Class> inputList) {

        ArrayList<Field> allParentsFields = new ArrayList<Field>();
        for(int i=0;i<inputList.size();i++) {
            allParentsFields.addAll((Arrays.asList(inputList.get(i).getDeclaredFields())));
        }
        for(int i =0;i<allParentsFields.size();i++) {
            if(!allParentsFields.get(i).isAnnotationPresent(InjectCache.class)) {
                allParentsFields.remove(i);
            }
        }
        //System.out.println("Parents Fields: "+allParentsFields+"\n");
        return allParentsFields;
    }
}
