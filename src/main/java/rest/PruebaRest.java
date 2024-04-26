package rest;

import business.LoginBusiness;
import com.google.gson.Gson;
import dto.UsuarioDTO;
import org.primefaces.json.JSONObject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/prueba")
public class PruebaRest {

    @Inject
    LoginBusiness loginBusiness;

    @GET
    @Path("/healthcheck")
    public Response healthcheck() {
        return Response.ok("app working").build();
    }

    @POST
    @Produces({"application/json;charset=utf-8"})
    @Consumes({"application/json;charset=utf-8"})
    @Path("/login")
    public Response login(String datos) {
        System.out.println(datos);
        JSONObject json = new JSONObject(datos);
        Gson gson = new Gson();
        UsuarioDTO usuarioDTO = gson.fromJson(json.toString(), UsuarioDTO.class);
        if (loginBusiness.login(usuarioDTO)) {
            //debe generar y retornar el token para que se incluya en las subsiguientes peticiones
            return Response.ok(usuarioDTO).build();
        }
        else
            return Response.status(Response.Status.UNAUTHORIZED).entity("Usuario y clave incorrectas").build();
    }

    @POST
    @Produces({"application/json;charset=utf-8"})
    @Consumes({"application/json;charset=utf-8"})
    @Path("/recibir")
    public Response recibir(String datos) {
        //chequear por el token
        System.out.println(datos);
        if (!datos.contains("nombre"))
            return Response.status(Response.Status.BAD_REQUEST).entity("te falta el nombre").build();
        else
            return Response.ok("Recibido correctamente").build();
    }


}
