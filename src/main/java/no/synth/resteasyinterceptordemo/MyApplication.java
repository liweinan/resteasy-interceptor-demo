package no.synth.resteasyinterceptordemo;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * 11 08 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class MyApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public MyApplication() {
        classes.add(Frontend.class);
        classes.add(MyExceptionMapper.class);
        classes.add(SecurityInterceptor.class);
        classes.add(MyInterceptor.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
