package myCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Р on 04.06.2016.
 */
@Cache(name = "CacheThree")
public class CacheThree implements ICache {

    private static Map<Integer, String> hashMap = new HashMap<Integer, String>();

    public void setNote(Integer key, String note) {
        hashMap.put(key, note);
    }

    public String getNote(Integer key) {
        return hashMap.get(key);
    }
}