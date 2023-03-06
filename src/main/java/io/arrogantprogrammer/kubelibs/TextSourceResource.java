package io.arrogantprogrammer.kubelibs;

import io.arrogantprogrammer.kubelibs.domain.TextSourceService;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;

import static org.slf4j.LoggerFactory.getLogger;

@Path("/textsource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TextSourceResource {

    private static final Logger LOGGER = getLogger(TextSourceResource.class);

    @Inject
    TextSourceService textSourceService;

    @POST
    public Response addTextSource(final TextSourceDTO textSource) {

        LOGGER.info("adding: {}", textSource);
        URI uri = null;
        try {
            uri = new URI("/" + 01);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        TextSourceDTO result = textSourceService.addTextSource(textSource);
        return Response.created(uri).entity(result).build();
    }
}
