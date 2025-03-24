public class Cliente {
    private String nombre;
    private String cedula;
    private String licencia;

    public Cliente(String nombre, String cedula, String licencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.licencia = licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", licencia='" + licencia + '\'' +
                '}';
    }

    public boolean Disp() {
        return false;
    }
}
