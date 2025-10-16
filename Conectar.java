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

    public String salt(Usuario usuario) {
        return md5.getMd5("" + usuario.getIdUsuario() + usuario.getContraseniaUsuario());
    }
}
