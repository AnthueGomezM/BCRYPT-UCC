import java.util.Base64;

public class Conectar {
    private MD5 md5;

    public Conectar() {
        md5 = new MD5();
    }

    public String bcrypt(Usuario usuario, int cost) {
        if (cost >= 1) {
            // System.out.println("cost:"+cost);
            usuario.setContraseniaUsuario(salt(usuario));
            bcrypt(usuario, cost - 1);
        }
        return usuario.getContraseniaUsuario();
    }

    public String crpit(Usuario usuario){
        String nombre = usuario.getNombreUsuario();
        StringBuilder sb = new StringBuilder(nombre);
        String cadenaInvertida = sb.reverse().toString();
        String base64cript = Base64.getEncoder().encodeToString(cadenaInvertida.getBytes());
        return base64cript;
    }

    public String salt(Usuario usuario) {
        return md5.getMd5("" + usuario.getIdUsuario() + usuario.getContraseniaUsuario());
    }

}
