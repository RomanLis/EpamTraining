package mycache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Р on 04.06.2016.
 */
@Cache(name = "CacheThree")
public class CacheThree implements ICache {

    private Map<Integer, String> hashMap = new HashMap<Integer, String>();

    public void setNote(String note, int key) {
        hashMap.put(key, note);
    }

    public String getNote(Integer key) {
        return hashMap.get(key);
    }

    @Override
    public String toString() {
        return "CacheThree";
    }
}