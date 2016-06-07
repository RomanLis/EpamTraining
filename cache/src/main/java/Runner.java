import consumer.CacheFiller;
import consumer.ConsumerTwo;
import myCache.CacheOne;
import myCache.CacheThree;
import myCache.CacheTwo;

/**
 * Created by Р on 03.06.2016.
 */
public class Runner {
    public static void run()  {
        CacheOne cacheOne = new CacheOne();
        CacheTwo cacheTwo = new CacheTwo();
        CacheThree cacheThree = new CacheThree();
        CacheFiller.fillTheCache(cacheOne,1);
        CacheFiller.fillTheCache(cacheTwo,2);
        CacheFiller.fillTheCache(cacheThree,3);
        ConsumerTwo consumerTwo = new ConsumerTwo();
        Injector.inject(consumerTwo);
        System.out.println("This Cache field Declared in ConsumerTwo class");
        consumerTwo.printCacheTwo();
        System.out.println("\nThis Cache field inherited from Consumer class");
        consumerTwo.printCache();
    }
}
