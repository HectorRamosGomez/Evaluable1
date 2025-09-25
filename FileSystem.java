import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileSystem {

    //Metodo para crear los archivos
    public void crearArchivo(String nombreUsuario) {
        try {
            File archivo = new File(nombreUsuario + ".txt"); //Creamos el archivo con el nombre que queremos que tenga
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado en: " + archivo.getAbsolutePath());
            } else {
                System.out.println("El archivo ya existe: " + archivo.getAbsolutePath()); // Si el archivo ya existe no nos lo crea, solo nos indica la ruta
            }
        } catch (Exception e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    //Metodo para poder ver el archivo
    public void verArchivo(String nombreUsuario) {
        try {
            File archivo = new File(nombreUsuario + ".txt"); //LLamamos al file que alberga la información del archivo creado
            Scanner reader = new Scanner(archivo); //Creamos un Scanner para leer el archivo

            System.out.println("Contenido del archivo:");
            // Con este bucle vamos leyendo linea por linea hasta que no haya mas lineas
            while (reader.hasNextLine()) { 
                String linea = reader.nextLine();
                System.out.println(linea);
            }
            reader.close();
        }catch (Exception e) {
            System.out.println("El archivo no existe o no se puede leer");
        }
    }

    public void agregarJuegos() throws IOException{
        Scanner sc = new Scanner(System.in);

        System.out.println("Cual es tu nombre de archivo: ");
        String ruta = sc.nextLine();
        
        System.out.println("Agrege el juego que quiera: ");
        System.out.println("Titulo: ");
        String titulo = sc.nextLine();

        System.out.println("Genero: ");
        String genero = sc.nextLine();

        System.out.println("Empresa: ");
        String empresa = sc.nextLine();

        System.out.println("Fecha de lanzamiento: ");
        int fechaLanzamiento = sc.nextInt();

        System.out.println("Horas jugadas: ");
        int horasJugadas = sc.nextInt();

        sc.nextLine(); 

        System.out.println("Favorito (true/false): ");
        boolean favorito = sc.nextBoolean();

        FileWriter escribir = new FileWriter(ruta + ".txt", true);
        escribir.write(titulo + ", " + genero + ", " + empresa + ", " + fechaLanzamiento + ", " + horasJugadas + ", " + favorito + "\n");
        escribir.close();
        
        System.out.println("Juego agregado correctamente!");
    }

    public void buscarJuego(String nombreArchivo, String tituloBuscado) {
        try {
            File archivo = new File(nombreArchivo + ".txt");
            Scanner reader = new Scanner(archivo);
            boolean encontrado = false;
            
            System.out.println("Buscando juego: " + tituloBuscado);
            System.out.println("-----------------------------------");
            
            while (reader.hasNextLine()) {
                String linea = reader.nextLine();
                // Verificar si la línea contiene el título buscado
                if (linea.toLowerCase().contains(tituloBuscado.toLowerCase())) {
                    System.out.println("Juego encontrado: " + linea);
                    encontrado = true;
                }
            }
            
            if (!encontrado) {
                System.out.println("No se encontró ningún juego con el título: " + tituloBuscado);
            }
            
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al buscar el juego: " + e.getMessage());
        }
    }

    public void editarJuego(String nombreArchivo, String tituloBuscado) {
        try {
            File archivo = new File(nombreArchivo + ".txt");
            File archivoTemp = new File("temp.txt");
            
            Scanner reader = new Scanner(archivo);
            FileWriter writer = new FileWriter(archivoTemp);
            Scanner sc = new Scanner(System.in);
            
            boolean encontrado = false;
            
            while (reader.hasNextLine()) {
                String linea = reader.nextLine();
                
                if (linea.toLowerCase().contains(tituloBuscado.toLowerCase())) {
                    encontrado = true;
                    System.out.println("Juego encontrado: " + linea);
                    System.out.println("Ingresa los nuevos datos (mismo formato):");
                    String nuevosDatos = sc.nextLine();
                    writer.write(nuevosDatos + "\n");
                } else {
                    writer.write(linea + "\n");
                }
            }
            
            reader.close();
            writer.close();
            
            // Reemplazar archivo original
            archivo.delete();
            archivoTemp.renameTo(archivo);
            
            if (encontrado) {
                System.out.println("Juego editado correctamente");
            } else {
                System.out.println("Juego no encontrado");
            }
            
        } catch (Exception e) {
            System.out.println("Error al editar: " + e.getMessage());
        }

    }

    public void eliminarJuego(String nombreArchivo, String tituloBuscado) {
    try {
        File archivo = new File(nombreArchivo + ".txt");
        File archivoTemp = new File("temp.txt");
        
        Scanner reader = new Scanner(archivo);
        FileWriter writer = new FileWriter(archivoTemp);
        
        boolean encontrado = false;
        
        while (reader.hasNextLine()) {
            String linea = reader.nextLine();
            if (!linea.toLowerCase().contains(tituloBuscado.toLowerCase())) {
                writer.write(linea + "\n");
            } else {
                encontrado = true;
            }
        }
        
        reader.close();
        writer.close();
        
        archivo.delete();
        archivoTemp.renameTo(archivo);
        
        if (encontrado) {
            System.out.println("Juego eliminado");
        } else {
            System.out.println("Juego no encontrado");
        }
        
    } catch (Exception e) {
        System.out.println("Error al eliminar: " + e.getMessage());
    }
}
    public void importarArchivo(String archivoOrigen, String archivoDestino) {
    try {
        File origen = new File(archivoOrigen);
        File destino = new File(archivoDestino + ".txt");
        
        Scanner reader = new Scanner(origen);
        FileWriter writer = new FileWriter(destino, true);
        
        while (reader.hasNextLine()) {
            writer.write(reader.nextLine() + "\n");
        }
        
        reader.close();
        writer.close();
        System.out.println("Archivo importado correctamente");
        
    } catch (Exception e) {
        System.out.println("Error al importar: " + e.getMessage());
    }
}
    public void exportarArchivo(String archivoOrigen, String archivoDestino) {
    try {
        File origen = new File(archivoOrigen + ".txt");
        File destino = new File(archivoDestino);
        
        Scanner reader = new Scanner(origen);
        FileWriter writer = new FileWriter(destino);
        
        while (reader.hasNextLine()) {
            writer.write(reader.nextLine() + "\n");
        }
        
        reader.close();
        writer.close();
        System.out.println("Archivo exportado correctamente");
        
    } catch (Exception e) {
        System.out.println("Error al exportar: " + e.getMessage());
    }
}
    public void copiaSeguridad(String nombreArchivo) {
    try {
        File original = new File(nombreArchivo + ".txt");
        File copia = new File(nombreArchivo + "_backup.txt");
        
        Scanner reader = new Scanner(original);
        FileWriter writer = new FileWriter(copia);
        
        while (reader.hasNextLine()) {
            writer.write(reader.nextLine() + "\n");
        }
        
        reader.close();
        writer.close();
        System.out.println("Copia de seguridad creada: " + copia.getName());
        
    } catch (Exception e) {
        System.out.println("Error al crear copia: " + e.getMessage());
    }
}
}
