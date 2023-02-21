package io.arrogantprogrammer.kubelibs;

import org.slf4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;

import static org.slf4j.LoggerFactory.getLogger;

@Path("/paragraph")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ParagraphResource {

    private static final Logger LOGGER = getLogger(ParagraphResource.class);

    @POST
    public Response addParagraph(final Paragraph paragraph) {

        LOGGER.info("adding: {}", paragraph);
        URI uri = null;
        try {
            uri = new URI("/" + 01);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return Response.created(uri).build();
    }
}
