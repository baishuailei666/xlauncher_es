package PropertyUtil.util;

import java.util.*;

/**
 * 重写Properties方法，使其能够按照顺序保存
 * @author baishuailei
 * @date 2018-1-25
 */
public class OrderedProperties extends Properties {

    private static final long serialVersionUID = -4627607243846121965L;

    private final LinkedHashSet<Object> keys = new LinkedHashSet<Object>();

    public Enumeration<Object> keys() {
        return Collections.<Object> enumeration(keys);
    }

    public Object put(Object key, Object value) {
        keys.add(key);
        return super.put(key, value);
    }

    public Set<Object> keySet() {
        return keys;
    }

    public Set<String> stringPropertyNames() {
        Set<String> set = new LinkedHashSet<String>();

        for (Object key : this.keys) {
            set.add((String) key);
        }

        return set;
    }
}