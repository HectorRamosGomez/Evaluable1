import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void menuFinal(int opcion) throws IOException{
        Scanner sc = new Scanner(System.in);

        while(opcion != 9){
            System.out.println("1. Ver los videojuegos guardados. ");
            System.out.println("2. Añadir un nuevo juego. ");
            System.out.println("3. Buscar juego por nombre. ");
            System.out.println("4. Editar información del juego guardado. ");
            System.out.println("5. Eliminar juego registrado. ");
            System.out.println("6. Importar la lista de juegos. ");
            System.out.println("7. Exportar la lista de juegos. ");
            System.out.println("8. Crear una copia de seguridad del archivo. ");
            System.out.println("9. Salir");

            System.out.println("Selecciona una opción: ");
            opcion = sc.nextInt();

            FileSystem archivos = new FileSystem();

            switch (opcion) {
                case 1:
                    System.out.println("Escribe tu nombre de usuario: ");
                    String nombreUsuario = sc.next();
                    archivos.verArchivo(nombreUsuario);
                    break;
                case 2:
                    archivos.agregarJuegos();
                    break;
                case 3:
                    System.out.println("Escribe tu nombre de archivo: ");
                    String archivoBuscar = sc.next();
                    sc.nextLine(); // Limpiar buffer
                    System.out.println("Ingresa el título a buscar: ");
                    String tituloBuscar = sc.nextLine();
                    archivos.buscarJuego(archivoBuscar, tituloBuscar);
                    break;
                case 4:
                    System.out.println("Nombre de archivo: ");
                    String archivoEditar = sc.next();
                    sc.nextLine();
                    System.out.println("Título del juego a editar: ");
                    String tituloEditar = sc.nextLine();
                    archivos.editarJuego(archivoEditar, tituloEditar);
                    break;
                case 5: 
                    System.out.println("Nombre de archivo: ");
                    String archivoEliminar = sc.next();
                    sc.nextLine();
                    System.out.println("Título a eliminar: ");
                    String tituloEliminar = sc.nextLine();
                    archivos.eliminarJuego(archivoEliminar, tituloEliminar);
                    break;
                case 6:
                    System.out.println("Archivo a importar (con extensión): ");
                    String origenImportar = sc.next();
                    System.out.println("Nombre para tu archivo: ");
                    String destinoImportar = sc.next();
                    archivos.importarArchivo(origenImportar, destinoImportar);
                    break;
                case 7:
                    System.out.println("Nombre de tu archivo: ");
                    String origenExportar = sc.next();
                    System.out.println("Nombre para exportar (con extensión): ");
                    String destinoExportar = sc.next();
                    archivos.exportarArchivo(origenExportar, destinoExportar);
                    break;
                case 8:
                    System.out.println("Nombre de archivo para copia: ");
                    String archivoCopia = sc.next();
                    archivos.copiaSeguridad(archivoCopia);
                    break;
                case 9:
                    System.out.println("Vas a salir del programa. ");
                    return;
            }
        }
    }
}
