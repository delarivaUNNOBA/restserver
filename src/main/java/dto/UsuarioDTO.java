package dto;

import java.util.Date;

public class UsuarioDTO {

    private String username;
    private String password;
    private Date fechaLogin;

    public UsuarioDTO() {
        super();
        setFechaLogin(new Date());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaLogin() {
        return fechaLogin;
    }

    public void setFechaLogin(Date fechaLogin) {
        this.fechaLogin = fechaLogin;
    }
}
