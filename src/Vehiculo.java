public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int anio;
    protected double precioxDia;
    protected boolean disp;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int anio, double precioxDia, boolean disp) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioxDia = precioxDia;
        this.disp = disp;

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecioxDia() {
        return precioxDia;
    }

    public void setPrecioxDia(double precioxDia) {
        this.precioxDia = precioxDia;
    }

    public boolean isDisp() {
        return disp;
    }

    public void setDisp(boolean disp) {
        this.disp = disp;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precioxDia=" + precioxDia +
                ", disp=" + disp +
                '}';
    }

    public int getInfo() {
        return 0;
    }

    public boolean Disp() {
        return false;
    }

    public void setDisponible(boolean b) {
    }
}
