public class Principal {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "admin", "admin");
        Conectar conectar = new Conectar();
        System.out.println("Contraseña encriptada: " + conectar.bcrypt(usuario, 10));
    }
}
