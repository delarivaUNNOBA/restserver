package business;

import dto.UsuarioDTO;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class LoginBusiness {

    /**
     * Resuelve el login de un usuario en la aplicación
     * @return
     */
    public boolean login(UsuarioDTO usuarioDTO) {
        String email = usuarioDTO.getUsername();
        String password = usuarioDTO.getPassword();
        return (email != null && password != null && !"".equals(email) && !"".equals(password));
    }
}
