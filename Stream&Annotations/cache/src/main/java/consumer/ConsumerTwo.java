package consumer;

import myCache.ICache;

/**
 * Created by Р on 07.06.2016.
 */
public class ConsumerTwo extends Consumer
{
    @InjectCache(name = "CacheTwo")
    private ICache cacheTwo;

    public void printCacheTwo() {
        if(cacheTwo == null) {
            System.out.println("cache = null");
        } else {
            System.out.println("/*   printed inside printCache method   */");
            System.out.println("/*  cache is: \""+cacheTwo.getNote(1)+"\""+"  */");
        }
    }
}
