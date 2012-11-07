package no.synth.resteasyinterceptordemo;

import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Path("/api")
public class Frontend {
    private static final Logger log = Logger.getLogger(Frontend.class.getName());

    @GET
    @Path("/name/{name}")
    @Produces({"application/json", "application/xml"})
    public String get(@PathParam("name") String name) {
        log.severe("Frontend.get()");
        System.err.println("Frontend.get()");

        throw new RuntimeException("name: " + name);
    }

    @POST
    @Path("/role")
    @Produces({"application/json", "application/xml"})
    public List<MyObject> post(MultivaluedMap<String, String> formParams) {
        log.severe("Frontend.post()");
        System.err.println("Frontend.post()");

        List<MyObject> list = new ArrayList<MyObject>();
        if (formParams != null && formParams.size() > 0) {
            for (String key : formParams.keySet()) {
                list.add(new MyObject(key, formParams.getFirst(key)));
            }
            return list;
        }
        list.add(new MyObject("empty", "empty"));
        return list;
    }

    @POST
    @Path("/roletest")
    @Produces({"application/json", "application/xml"})
    public List<MyObject> postTest(String formParams) {
        log.severe("Frontend.post()");
        System.err.println("Frontend.post()");

        List<MyObject> list = new ArrayList<MyObject>();
        list.add(new MyObject("empty", formParams));
        return list;
    }

    @POST
    @Path("/another")
    @Produces({"application/json", "application/xml"})
    public List<MyObject> postFail(MultivaluedMap<String, String> formParams) {
        log.severe("Frontend.postFail()");
        System.err.println("Frontend.postFail()");
	throw new RuntimeException("fail!");
    }
}
