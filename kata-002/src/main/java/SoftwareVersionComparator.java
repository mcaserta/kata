import java.util.Comparator;

public class SoftwareVersionComparator implements Comparator<String> {

    /**
     * Compares two software version strings. Software versions are made of
     * a maximum of 5 integers separated by dots. For example these are all
     * allowed version numbers:
     *
     * <ul>
     *     <li>3</li>
     *     <li>1.9.2</li>
     *     <li>3.0.678.34.9</li>
     * </ul>
     *
     * @param version1 first version String
     * @param version2 second version String
     * @return a negative integer if version1 is smaller than version2,
     *         zero if version1 equals version2, a positive integer
     *         if version1 is greater than version 2
     */
    @Override
    public int compare(String version1, String version2) {
        final String[] version1Array = version1.split("\\.");
        final String[] version2Array = version2.split("\\.");

        int index = 0;

        do {
            int v1 = safeGet(version1Array, index);
            int v2 = safeGet(version2Array, index);

            if (v1 < v2) {
                return -1;
            }
            if (v1 > v2) {
                return 1;
            }

            index++;
        } while (index < version1Array.length || index < version2Array.length);

        return 0;
    }

    private int safeGet(String[] version, int index) {
        if (index < version.length) {
            return Integer.parseInt(version[index]);
        }
        return 0;
    }

}
