
import com.ejb.HelloWorld;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
/**
 * Created by pp on 2017/7/14.
 */
public class HelloWorldClient {


    public static void main(String[] args) throws NamingException {
        HelloWorld helloWorld = lookupRemoteStatelessEjbBean();
        System.out.println(helloWorld);
        String s = helloWorld.sayHello("world");
        System.out.println(s);
    }


    private static HelloWorld lookupRemoteStatelessEjbBean() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        final String appName = "";
        final String moduleName = "EJBHelloWorld_war_exploded";
        final String distinctName = "";
        final String beanName = "HelloWorldBeanEJB";
        final String viewClassName = HelloWorld.class.getName();
        final String namespace = "ejb:" + appName + "/" + moduleName
                + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println(namespace);
        return (HelloWorld) context.lookup(namespace);
        /*
           return (RemoteCounter) context.lookup("ejb:" + appName + "/" + moduleName
            + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful");
        */
    }
}
