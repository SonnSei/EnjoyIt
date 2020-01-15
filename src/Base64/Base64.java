package Base64;

/**
 * @Classname Base64
 * @Description
 * @Date 2020/1/15 20:10
 * @Author SonnSei
 */
public class Base64 {
    static char[] map = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    public static String encode(String s) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            tmp.append(getBinaryCode(s.charAt(i)));
        }
        int originSize = tmp.length();
        while (tmp.length() % 6 != 0)
            tmp.append("00000000");
        System.out.println(tmp.toString());
        int equalCnt = (tmp.length() - originSize) / 6;
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < originSize; i += 6) {
            ret.append(map[Integer.parseInt(tmp.subSequence(i, i + 6).toString(), 2)]);
        }
        for (int i = 0; i < equalCnt; i++) {
            ret.append('=');
        }
        System.out.println(ret.length());
        return ret.toString();
    }

    private static String getBinaryCode(char c) {
        String ret = Integer.toBinaryString(c);
        while (ret.length() < 8) {
            ret = "0" + ret;
        }
        return ret;
    }


    public static String decode(String s) {
        char[] chars = s.toCharArray();
        StringBuilder tmp = new StringBuilder();
        for (char c : chars) {
            if(c=='=')continue;
            tmp.append(get6s(Integer.toBinaryString(getIndex(c))));
        }
        System.out.println(tmp.toString());
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i + 8 < tmp.length(); i += 8) {
            ret.append((char) Integer.parseInt(tmp.subSequence(i, i + 8).toString(), 2));
        }
        return ret.toString();
    }

    private static int getIndex(char c) {
        for (int i = 0; i < map.length; i++) {
            if (c == map[i])
                return i;
        }
        return 0;
    }

    private static String get6s(String s) {
        while (s.length() < 6) {
            s = '0' + s;
        }
        return s;
    }
}
