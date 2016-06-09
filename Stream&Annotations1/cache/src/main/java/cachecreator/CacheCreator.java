package cachecreator;

import consumer.CacheFiller;
import mycache.CacheOne;
import mycache.CacheThree;
import mycache.CacheTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Р on 09.06.2016.
 */
public class CacheCreator {
    public static List<Object> getAllCaches() {
        List<Object> caches = new ArrayList<Object>();
        CacheOne cacheOne = new CacheOne();
        CacheTwo cacheTwo = new CacheTwo();
        CacheThree cacheThree = new CacheThree();
        CacheFiller.fillTheCache(cacheOne);
        CacheFiller.fillTheCache(cacheTwo);
        CacheFiller.fillTheCache(cacheThree);
        caches.add(cacheOne);
        caches.add(cacheTwo);
        caches.add(cacheThree);
        return caches;
    }

}
