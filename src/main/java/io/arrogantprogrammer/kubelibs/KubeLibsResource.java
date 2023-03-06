package io.arrogantprogrammer.kubelibs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class KubeLibsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(KubeLibsResource.class);

    @Inject
    KubeLibsService kubeLibsService;

    @GET
    public Response getKubeLib() {

        KubeLibDTO kubeLib = kubeLibsService.randomKubeLib();
        return Response.ok(kubeLib).build();
    }
}
