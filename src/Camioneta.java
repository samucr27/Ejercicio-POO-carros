public class Camioneta extends Vehiculo{
    public double capCarga;

    public Camioneta(String marca, String modelo, int anio, double precioxDia, boolean disp, double capCarga) {
        super(marca, modelo, anio, precioxDia, disp);
        this.capCarga = capCarga;
    }

    public double getCapCarga() {
        return capCarga;
    }

    public void setCapCarga(double capCarga) {
        this.capCarga = capCarga;
    }

    @Override
    public String toString() {
        return "Camioneta{" +
                "capCarga=" + capCarga +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precioxDia=" + precioxDia +
                ", disp=" + disp +
                '}';
    }
}
