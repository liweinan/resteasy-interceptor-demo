package no.synth.resteasyinterceptordemo;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.AcceptedByMethod;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;
import java.util.logging.Logger;

@Provider
@ServerInterceptor
public class SecurityInterceptor implements PreProcessInterceptor, AcceptedByMethod {
    private static final Logger log = Logger.getLogger(SecurityInterceptor.class.getName());

    @SuppressWarnings("rawtypes")
    public boolean accept(Class c, Method m) {
        log.severe("SecurityInterceptor.accept()");
        System.err.println("SecurityInterceptor.accept()");

        // run on all methods
        return true;
    }

    public ServerResponse preProcess(HttpRequest request, ResourceMethod method)
            throws Failure, WebApplicationException {
        log.severe("SecurityInterceptor.preProcess()");
        System.err.println("SecurityInterceptor.preProcess()");

        ServerResponse response = null;

        String username = null;
        try {
            username = request.getFormParameters().get("username").get(0);
        } catch (NullPointerException e) {}

        if (username == null) {
            try {
                username = request.getUri().getQueryParameters().getFirst("username");
            } catch (NullPointerException e) {}
        }
        // very simple security validation
        if (username == null || username.isEmpty()) {
            throw new Failure("To access this method you need to inform an username",
                    401);
        } else if (!"john".equals(username)) {
            throw new Failure("User \"" + username
                    + "\" is not authorized to access this method.", 403);
        }
        return response;
    }
}

