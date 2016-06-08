package consumer;

import myCache.ICache;

/**
 * Created by Р on 05.06.2016.
 */
public class CacheFiller {
    public static  <T extends ICache> void fillTheCache (T cache,Integer cacheMarker) {
        if(cache!=null){
            cache.setNote(1,"Note1, cache mark is "+cacheMarker);
        } else System.out.println("cache = null");
    }
}
