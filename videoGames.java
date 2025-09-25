package games;

public class videoGames{

    private int id; 
    private String titulo; 
    private String genero; 
    private String empresa; 
    private int fehaLanzamiento; 
    private int horasJugadas; 
    private boolean favorito;
    
    public videoGames(int id, String titulo, String genero, String empresa, int fehaLanzamiento, int horasJugadas,
            boolean favorito) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.empresa = empresa;
        this.fehaLanzamiento = fehaLanzamiento;
        this.horasJugadas = horasJugadas;
        this.favorito = favorito;
    } 
    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getEmpresa() {
        return empresa;
    }


    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }


    public int getFehaLanzamiento() {
        return fehaLanzamiento;
    }


    public void setFehaLanzamiento(int fehaLanzamiento) {
        this.fehaLanzamiento = fehaLanzamiento;
    }


    public int getHorasJugadas() {
        return horasJugadas;
    }


    public void setHorasJugadas(int horasJugadas) {
        this.horasJugadas = horasJugadas;
    }


    public boolean isFavorito() {
        return favorito;
    }


    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
    
}