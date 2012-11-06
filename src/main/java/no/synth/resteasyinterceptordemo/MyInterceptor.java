package no.synth.resteasyinterceptordemo;

import org.jboss.resteasy.annotations.interception.Precedence;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.spi.interception.MessageBodyReaderContext;
import org.jboss.resteasy.spi.interception.MessageBodyReaderInterceptor;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Provider
@ServerInterceptor
@Precedence("SECURITY")
public class MyInterceptor implements MessageBodyReaderInterceptor {
    private static final Logger log = Logger.getLogger(MessageBodyReaderInterceptor.class.getName());

    public Object read(MessageBodyReaderContext context) throws IOException, WebApplicationException {
        log.severe("MyInterceptor was intercepted");
        System.err.println("MyInterceptor was intercepted");
        return context.proceed();
    }
}