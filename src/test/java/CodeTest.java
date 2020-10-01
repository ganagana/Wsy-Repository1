import com.wsy.util.BaseUtil;
import org.junit.Test;

/**
 * @author: wsy
 * Date: 2020/9/30
 * Time: 19:55
 * Description: No Description
 */
public class CodeTest {
    @Test
    public void test() {
        boolean ssdsd = BaseUtil.isChinaPhoneLegal("15815777836");
        System.out.println(ssdsd);
    }

    @Test
    public void test1() {
        String a = "       ";
        // if (a.isEmpty())
        if (a.trim().length()==0)
            System.out.println("It is empty");
        else
            System.out.println("It is not empty");

    }

    @Test
    public void test2() {
        String str=".";
        boolean b = BaseUtil.isContainChinese(str);
        System.out.println(b);
    }
}
