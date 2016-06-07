package myCache;

/**
 * Created by Р on 03.06.2016.
 */
public interface ICache {
    void setNote(Integer key, String note);
    String getNote(Integer key);
}

