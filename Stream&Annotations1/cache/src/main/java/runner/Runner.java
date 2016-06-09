package runner;

import consumer.ConsumerTwo;
import injector.Injector;

/**
 * Created by Р on 03.06.2016.
 */
public class Runner {
    public static void run() {
        ConsumerTwo consumerTwo = new ConsumerTwo();
        Injector.inject(consumerTwo);
        System.out.println("This Cache field Declared in ConsumerTwo class");
        consumerTwo.printCacheTwo();
        System.out.println("\nThis Cache field inherited from Consumer class");
        consumerTwo.printCache();
    }
}
