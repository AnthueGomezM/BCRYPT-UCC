import java.nio.charset.StandardCharsets;
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
        StringBuilder hexBuilder = new StringBuilder();
        for (byte b : base64cript.getBytes(StandardCharsets.UTF_8)) {
            hexBuilder.append(String.format("%02x", b));
        }
        return hexBuilder.toString();
    }

    public String salt(Usuario usuario) {
        String encript = crpit(usuario);
        return md5.getMd5("" + encript + usuario.getContraseniaUsuario());
    }

}
