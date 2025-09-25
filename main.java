import java.io.IOException;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        FileSystem archivo = new FileSystem();

        System.out.println("Introduce tu nombre: ");
        String nombreUsuario = sc.next();
        archivo.crearArchivo(nombreUsuario);

        Menu indice = new Menu();
        indice.menuFinal(opcion);

        



        

        
    }
}
