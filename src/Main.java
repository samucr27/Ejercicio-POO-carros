import java.util.*;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    static List<Vehiculo> lstVeh = new ArrayList<>();
    static List<Cliente> lstCli = new ArrayList<>();

    public static void main(String[] args) {
        int op;

        do {
            System.out.println("MENÚ DE ALQUILER DE VEHÍCULOS");
            System.out.println("1. Registrar nuevo vehículo");
            System.out.println("2. Registrar nuevo cliente");
            System.out.println("3. Realizar alquiler");
            System.out.println("4. Mostrar vehículos disponibles");
            System.out.println("5. Registrar devolución de vehículo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            op = teclado.nextInt();
            teclado.nextLine();

            switch (op) {
                case 1:
                    System.out.print("¿Qué tipo de vehículo desea registrar? (1. Auto / 2. Camioneta): ");
                    int tipo = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Marca: ");
                    String marca = teclado.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = teclado.nextLine();
                    System.out.print("Año: ");
                    int año = teclado.nextInt();
                    System.out.print("Precio por día: ");
                    double precio = teclado.nextDouble();

                    if (tipo == 1) {
                        System.out.print("Número de puertas: ");
                        int puertas = teclado.nextInt();
                        Vehiculo auto = new Auto(marca, modelo, año, precio, true, puertas);
                        lstVeh.add(auto);
                        System.out.println("Auto registrado correctamente.");
                    } else if (tipo == 2) {
                        System.out.print("Capacidad de carga (kg): ");
                        double carga = teclado.nextDouble();
                        Vehiculo camioneta = new Camioneta(marca, modelo, año, precio, true, carga);
                        lstVeh.add(camioneta);
                        System.out.println("Camioneta registrada correctamente.");
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 2:
                    System.out.print("Nombre del cliente: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Cédula: ");
                    String cedula = teclado.nextLine();

                    System.out.print("Licencia de conducir: ");
                    String licencia = teclado.nextLine();

                    Cliente cliente = new Cliente(nombre, cedula, licencia);
                    lstCli.add(cliente);

                    System.out.println("Cliente registrado correctamente.");
                    break;

                case 3:
                    if (lstCli.isEmpty()) {
                        System.out.println("No hay clientes registrados. Registre un cliente primero.");
                        break;
                    }

                    if (lstVeh.isEmpty()) {
                        System.out.println("No hay vehículos registrados. Registre un vehículo primero.");
                        break;
                    }

                    System.out.print("Nombre del cliente: ");
                    String nombreCliente = teclado.nextLine();
                    Cliente clienteEncontrado = null;

                    for (Cliente c : lstCli) {
                        if (c.getNombre().equalsIgnoreCase(nombreCliente)) {
                            clienteEncontrado = c;
                            break;
                        }
                    }

                    if (clienteEncontrado == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }

                    List<Integer> indicesDisponibles = new ArrayList<>();
                    System.out.println("Vehículos disponibles:");
                    for (int i = 0; i < lstVeh.size(); i++) {
                        if (lstVeh.get(i).Disp()) {
                            System.out.println(i + ". " + lstVeh.get(i).getInfo());
                            indicesDisponibles.add(i);
                        }
                    }

                    if (indicesDisponibles.isEmpty()) {
                        System.out.println("No hay vehículos disponibles para alquilar.");
                        break;
                    }

                    System.out.print("Seleccione el número del vehículo a alquilar: ");
                    int indice = teclado.nextInt();
                    teclado.nextLine();

                    if (!indicesDisponibles.contains(indice)) {
                        System.out.println("Índice inválido o el vehículo no está disponible.");
                        break;
                    }

                    System.out.print("Cantidad de días a alquilar: ");
                    int dias = teclado.nextInt();
                    teclado.nextLine();

                    Vehiculo vehiculo = lstVeh.get(indice);
                    double total = dias * vehiculo.getPrecioxDia();
                    if (dias > 7) {
                        total *= 0.9;
                        System.out.println("Se aplicó un 10% de descuento por más de 7 días.");
                    }

                    vehiculo.setDisponible(false);
                    System.out.printf("Alquiler registrado. Total a pagar: $%.2f\n", total);
                    break;

                case 4:
                    System.out.println("Vehículos disponibles:");
                    int disponibles = 0;
                    for (Vehiculo v : lstVeh) {
                        if (v.Disp()) {
                            System.out.println(v.getInfo());
                            disponibles++;
                        }
                    }
                    if (disponibles == 0) {
                        System.out.println("No hay vehículos disponibles.");
                    } else {
                        System.out.println("Cantidad total de vehículos disponibles: " + disponibles);
                    }
                    break;

                case 5:
                    // REGISTRAR DEVOLUCIÓN DE VEHÍCULO
                    System.out.println("Vehículos alquilados:");
                    List<Integer> indicesAlquilados = new ArrayList<>();
                    for (int i = 0; i < lstVeh.size(); i++) {
                        if (!lstVeh.get(i).Disp()) {
                            System.out.println(i + ". " + lstVeh.get(i).getInfo());
                            indicesAlquilados.add(i);
                        }
                    }
                    if (indicesAlquilados.isEmpty()) {
                        System.out.println("No hay vehículos alquilados actualmente.");
                        break;
                    }
                    System.out.print("Seleccione el número del vehículo a devolver: ");
                    int devolver = teclado.nextInt();
                    teclado.nextLine();

                    if (!indicesAlquilados.contains(devolver)) {
                        System.out.println("Índice inválido o el vehículo ya está disponible.");
                    } else {
                        lstVeh.get(devolver).setDisponible(true);
                        System.out.println("Vehículo devuelto correctamente.");
                    }
                    break;

                case 6:
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 6);
    }
}