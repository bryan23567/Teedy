package com.sismics.docs.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * Simple resource for testing purposes.
 * 
 * @author YourName
 */
@Path("/simple")
public class SimpleResource extends BaseResource {
    
    /**
     * Returns a simple message.
     *
     * @api {get} /simple Get a simple message
     * @apiName GetSimpleMessage
     * @apiGroup Simple
     * @apiSuccess {String} message Simple message
     * @apiVersion 1.0.0
     *
     * @return Response
     */
    @GET
    public Response getSimpleMessage() {
        String message = "This is a simple message.";
        return Response.ok().entity(message).build();
    }
}
