package consumer;

import mycache.ICache;

/**
 * Created by Р on 05.06.2016.
 */
public class CacheFiller {
    public static <T extends ICache> void fillTheCache(T cache) {
        if (cache != null) {
            cache.setNote("Note1 from " + cache.toString(), 1);
        } else System.out.println("cache = null");
    }
}
