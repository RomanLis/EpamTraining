package mycache;

/**
 * Created by Р on 03.06.2016.
 */
public interface ICache {
    void setNote(String note, int key);

    String getNote(Integer key);
}

