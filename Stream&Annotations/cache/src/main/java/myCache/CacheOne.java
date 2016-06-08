package myCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Р on 03.06.2016.
 */
@Cache(name = "CacheOne")
public class CacheOne implements ICache {

    private static Map<Integer, String> hashMap = new HashMap<Integer, String>();

    public void setNote(Integer key, String note) {
        hashMap.put(key, note);
    }

    public String getNote(Integer key) {
        return hashMap.get(key);
    }
}
