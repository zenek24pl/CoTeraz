package now.zaliczto.coteraz.main.models;

/**
 * Created by zeno on 2016-12-21.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.internal.LinkedTreeMap;

import java.util.Iterator;

/**
 * Just root for all request it handles common pattern for all request that is present in all
 * AppSoup responses.
 * <p/>
 * success - whatever this request was successful
 * error - list of error for specified fields in request or app state, with erroc
 */
public class BaseAnswer {
    protected boolean success;
    //protected HashMap<String, List<String>> error;

    @Expose
    private Object error;

    public boolean isSuccess() {
        return success;
    }

    public LinkedTreeMap getErrorsAsTree() {
        if (isErrorListATree()) {
            return (LinkedTreeMap) error;
        }
        return null;
    }

    public String getErrorString() {
        if (isErrorListAString()) {
            return (String) error;
        }

        if (isErrorListATree()) {
            LinkedTreeMap errors = getErrorsAsTree();
            if (errors != null && errors.size() > 0) {
                try {
                    return getFirstRawErrorFor((String) errors.keySet().iterator().next());
                } catch (Exception ex) {
                    return null;
                }
            }
        }
        return null;
    }

    public boolean isErrorListATree() {
        return error != null && error instanceof LinkedTreeMap;
    }

    public boolean isErrorListAString() {
        return error != null && error instanceof String;
    }

    public String getFirstRawErrorFor(String key) {
        LinkedTreeMap errors = getErrorsAsTree();
        if (errors != null) {
            Object error = errors.get(key);
            if (error == null) {
                return null;
            }

            if (error instanceof String) {
                return (String) error;
            }

            if (error instanceof Iterable) {
                Iterator iterator = (Iterator) error;
                if (iterator.hasNext()) {
                    return String.valueOf(iterator.next());
                }
            }
        }
        return null;
    }

    public Object getError() {
        return error;
    }
}