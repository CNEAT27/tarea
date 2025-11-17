package ProyectoBD;

import java.util.Scanner;

public class ConexionRestaurante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();

        int opcion;

        do {
            System.out.println("\n===================================");
            System.out.println("   MENU DE CLIENTES - RESTAURANTE");
            System.out.println("===================================");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Mostrar clientes");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- AGREGAR CLIENTE ---");
                    System.out.print("Codigo del cliente: ");
                    int cod = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Telefono: ");
                    int telefono = sc.nextInt();

                    clienteDAO.insertarCliente(cod, nombre, telefono);
                }

                case 2 -> {
                    System.out.println("\n--- ACTUALIZAR CLIENTE ---");
                    System.out.print("Codigo del cliente: ");
                    int cod = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();

                    clienteDAO.actualizarCliente(cod, nuevoNombre);
                }

                case 3 -> {
                    System.out.println("\n--- LISTA DE CLIENTES ---");
                    clienteDAO.mostrarClientes();
                }

                case 4 -> {
                    System.out.println("\n--- ELIMINAR CLIENTE ---");
                    System.out.print("Codigo del cliente: ");
                    int cod = sc.nextInt();
                    sc.nextLine();
                    clienteDAO.eliminarCliente(cod);
                }

                case 5 -> System.out.println("\nSaliendo del sistema...");

                default -> System.out.println("\nOpcion no valida. Intente nuevamente.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
```

4. Guarda (Ctrl + S)

---

## Al final deberías tener en la carpeta `app`:
```
app/
├── Conexion.java          ← Ya lo tienes
├── ClienteDAO.java        ← Crear este
├── ConexionRestaurante.java  ← Crear este
└── lib/
    └── ojdbc8.jar