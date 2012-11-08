package no.synth.resteasyinterceptordemo;

import org.jboss.resteasy.spi.Failure;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.logging.Logger;

@Provider
public class MyExceptionMapper implements ExceptionMapper<java.lang.RuntimeException> {

    private static final Logger log = Logger.getLogger(MyExceptionMapper.class.getName());

    @Context
    private HttpHeaders headers;

    @XmlRootElement(name = "error")
    public static class Error {
        public Integer status;
        public String message;

        public Error() {
            // required by jaxb
        }

        public Error(String msg, Integer status) {
            this.message = msg;
            this.status = status;
        }
    }

    public Response toResponse(RuntimeException exception) {
        int status = 500;
        String message = exception.getMessage();
        if (exception instanceof Failure) {
            status = ((Failure) exception).getErrorCode();
        }
        MediaType mediaType;
        try {
            mediaType = headers.getMediaType();
        } catch (Exception e) {
            mediaType = MediaType.APPLICATION_XML_TYPE;
        }
        return Response.status(status).type(mediaType).entity(new Error(message, status)).build();
    }

}
