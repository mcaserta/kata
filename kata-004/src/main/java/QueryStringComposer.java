public class QueryStringComposer {

    private StringBuffer myQueryString = new StringBuffer();

    /**
     * This method use a fluent interface (see: http://en.wikipedia.org/wiki/Fluent_interface)
     * to accept couples key-value useful for create a queryString.
     * <p/>
     * if we call addPair(k1, v1) the result must be "?k1=v1"
     * if we call addPair(k1,v1).addPAir(k2,v2) the result must be "?k1=v1&k2=v2
     * and so on.
     * <p/>
     * Remember to handle null and empty value, see test class for more.
     *
     * @return a well formed queryString
     */
    public QueryStringComposer addPair(String key, String value) {
        if (isInputValid(key, value)) {
            if (myQueryString.length() == 0) {
                myQueryString.append('?');
            } else {
                myQueryString.append('&');
            }
            myQueryString.append(key);
            myQueryString.append('=');
            myQueryString.append(value);
        }

        return this;
    }

    private boolean isInputValid(String key, String value) {
        return key != null && !key.isEmpty() && value != null && !value.isEmpty();
    }

    @Override
    public String toString() {
        return myQueryString.toString();
    }

}
