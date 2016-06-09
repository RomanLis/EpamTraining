package consumer;

import mycache.ICache;

/**
 * Created by Р on 04.06.2016.
 */
public class Consumer {
    @InjectCache(name = "CacheOne")
    private ICache cache;

    public void printCache() {
        if (cache == null) {
            System.out.println("cache = null");
        } else {
            System.out.println("/*   printed inside printCache method   */");
            System.out.println("/*    cache is: \"" + cache.getNote(1) + "\"" + "   */");
        }
    }
}
