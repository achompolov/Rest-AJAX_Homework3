package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/motorcycles")
@Api(value = "Api for querying motorcycles")
public class MotorcycleResource {

	@GET
	@ApiOperation(value = "Get all motorcycles")
	@Produces(MediaType.APPLICATION_JSON)
	public PagedResponse getMotorcycles(@QueryParam("page") int page,
			@QueryParam("perPage") int perPage, @QueryParam("withBrand") String withBrand) {

		MotorcycleService motorcycleService = MotorcycleService.getInstance();
		PagedResponse motorcyclesInPage = motorcycleService.getMotorcyclesInPagesFiltered(page, perPage, withBrand);

		return motorcyclesInPage;
	}

	@POST
	@ApiOperation(value = "Post new motorycle", response = Motorcycle.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMotorcycle(Motorcycle motorcycle) {
		MotorcycleService.getInstance().addMotorcycle(motorcycle);
		return Response.ok(motorcycle).status(Status.CREATED).build();
	}
}
