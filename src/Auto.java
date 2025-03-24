public class Auto extends Vehiculo{
    private int numPuertas;

    public Auto(String marca, String modelo, int anio, double precioxDia, boolean disp, int numPuertas) {
        super(marca, modelo, anio, precioxDia, disp);
        this.numPuertas = numPuertas;

    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "numPuertas=" + numPuertas +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precioxDia=" + precioxDia +
                ", disp=" + disp +
                '}';
    }

}
