

import communal.util.param.ParameterUtil;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestUnit {

    @Test
    public void test() {
        String parameter = "  10 ";
        String defaultValue = "值";
        Integer defaultValueInt = null;

        System.out.println(ParameterUtil.integerCheck(parameter, defaultValueInt));
    }

    @Before
    public void before() throws Exception {System.out.println("before*******");}

    @After
    public void after() throws Exception {System.out.println("after*******");}

}
