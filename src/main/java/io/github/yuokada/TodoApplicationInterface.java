package io.github.yuokada;

import io.github.yuokada.model.TodoCreateRequest;
import io.github.yuokada.model.TodoDetail;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@ApplicationScoped
@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
public interface TodoApplicationInterface {

    @GET
    @Path("/todos")
    @Operation(
        summary = "Return a list of todos",
        description = "Return a list of todos"
    )
    @APIResponses({
        @APIResponse(
            responseCode = "200",
            description = "Returns a list of todos",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(type = SchemaType.ARRAY, implementation = TodoDetail.class)
            )
        ),
    })
    Response getListOfTodo();

    @GET
    @Path("/todos/{id}")
    @Operation(
        summary = "Return a list of todos",
        description = "Return a list of todos"
    )
    @APIResponses({
        @APIResponse(
            responseCode = "200",
            description = "Returns a list of todos",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(type = SchemaType.OBJECT, implementation = TodoDetail.class)
            )
        ),
    })
    Response getTaskDetail(@PathParam("id") Long id);

    @POST
    @Path("/todos")
    @Operation(
        summary = "Create a new todo"
    )
    @APIResponses({
        @APIResponse(
            responseCode = "201",
            description = "Returns a new todos",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(type = SchemaType.OBJECT, implementation = TodoDetail.class)
            )
        ),
    })
    Response createTodo(@Valid TodoCreateRequest requestBody);
    // Response createTodo(TodoCreateRequest requestBody);

    @PUT
    @Path("/todos/{id}")
    @Operation(
        summary = "Update an existing todo"
    )
    @APIResponses({
        @APIResponse(
            responseCode = "200",
            description = "Returns an updated todo",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(type = SchemaType.OBJECT, implementation = TodoDetail.class)
            )
        ),
    })
    Response updateTodoDetail(@PathParam("id") Long id, TodoDetail todoDetail);

    @PUT
    @Path("/todos/{id}/complete")
    @Operation(
        summary = "Complete an existing todo"
    )
    @APIResponses({
        @APIResponse(
            responseCode = "200",
            description = "Complete an existing todo",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(type = SchemaType.OBJECT, implementation = TodoDetail.class)
            )
        ),
    })
    Response completeTodo(@PathParam("id") Long id);

    @DELETE
    @Path("/todos/{id}")
    @Operation(
        summary = "Delete an existing todo"
    )
    @APIResponses({
        @APIResponse(
            responseCode = "204",
            description = "Returns an updated todo"
        ),
    })
    Response deleteTodo(@PathParam("id") Long id);
}
