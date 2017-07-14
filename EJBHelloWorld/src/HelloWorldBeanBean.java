import com.ejb.HelloWorld;

import javax.ejb.Stateless;

/**
 * Created by pp on 2017/7/14.
 */
@Stateless(name = "HelloWorldBeanEJB")
public class HelloWorldBeanBean implements HelloWorld{
    public HelloWorldBeanBean() {
    }

    @Override
    public String sayHello(String world) {
        return "Hello" + world;
    }
}
