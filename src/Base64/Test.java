package Base64;

/**
 * @Classname Test
 * @Description
 * @Date 2020/1/15 20:20
 * @Author SonnSei
 */
public class Test {
    public static void main(String[] args) {
        Base64 base64 = new Base64();
        String s = "Aladdin:open sesame";
        System.out.println(base64.decode(base64.encode(s)));
        System.out.println(new String(java.util.Base64.getEncoder().encode(s.getBytes())));
    }
}
