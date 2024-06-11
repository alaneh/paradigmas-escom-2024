import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
N° cuenta   Contraseña  Nom de el usuario
2023028447  ELHLAN_g04  Elizalde Hernández Alan 
2023630858  RERLYN_a20  Reyes Ruiz Yoselyn Estefany 
2023947596  SOVTUR_q79  Solares Velasco Arturo Misael
2023867455  SOLYRA_y45  Solis Lugo Mayra
2023385947  TOHRDO_m32  Toral Hernández Leonardo Javier*/


// Excepciones personalizadas
class SaldoEfectivoInsuficiente extends Exception {
    public SaldoEfectivoInsuficiente(String mensaje) {
        super(mensaje);
    }
}

class SaldoCuentaInsuficiente extends Exception {
    public SaldoCuentaInsuficiente(String mensaje) {
        super(mensaje);
    }
}

// Clase para representar una cuenta bancaria
class Cuenta {
    private String numeroCuenta;
    private String password;
    private String nombre;
    private double saldo;

    public Cuenta(String numeroCuenta, String password, String nombre, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.password = password;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean autenticar(String password) {
        return this.password.equals(password);
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        this.saldo += monto;
    }

    public void retirar(double monto) throws SaldoCuentaInsuficiente {
        if (monto > this.saldo) {
            throw new SaldoCuentaInsuficiente("Saldo insuficiente en la cuenta.");
        }
        this.saldo -= monto;
    }

    public void transferir(Cuenta otraCuenta, double monto) throws SaldoCuentaInsuficiente {
        if (monto > this.saldo) {
            throw new SaldoCuentaInsuficiente("Saldo insuficiente en la cuenta para transferencia.");
        }
        this.saldo -= monto;
        otraCuenta.depositar(monto);
    }
}

// Clase para representar el cajero automático
class CajeroAutomatico {
    private double saldoEfectivo;
    private Map<String, Cuenta> cuentas;

    public CajeroAutomatico(double saldoEfectivoInicial) {
        this.saldoEfectivo = saldoEfectivoInicial;
        this.cuentas = new HashMap<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
    }

    public Cuenta autenticar(String numeroCuenta, String password) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && cuenta.autenticar(password)) {
            return cuenta;
        }
        return null;
    }

    public Cuenta obtenerCuentaPorNumero(String numeroCuenta) {
        return cuentas.get(numeroCuenta);
    }

    public void retirarEfectivo(Cuenta cuenta, double monto) throws SaldoEfectivoInsuficiente, SaldoCuentaInsuficiente {
        if (monto > this.saldoEfectivo) {
            throw new SaldoEfectivoInsuficiente("Saldo insuficiente en el cajero.");
        }
        cuenta.retirar(monto);
        this.saldoEfectivo -= monto;
    }

    public void mostrarDatosCuenta(Cuenta cuenta) {
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Nombre: " + cuenta.getNombre());
        System.out.println("Saldo: " + cuenta.getSaldo());
    }

    public void depositarEnPropiaCuenta(Cuenta cuenta, double monto) {
        cuenta.depositar(monto);
    }

    public void depositarEnOtraCuenta(Cuenta cuentaDestino, double monto) {
        cuentaDestino.depositar(monto);
    }

    public void transferir(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) throws SaldoCuentaInsuficiente {
        cuentaOrigen.transferir(cuentaDestino, monto);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CajeroAutomatico cajero = new CajeroAutomatico(100000);

        // Creación de cuentas de ejemplo
        cajero.agregarCuenta(new Cuenta("2023028447", "ELHLAN_g04", "Elizalde Hernández Alan", 5000));
        cajero.agregarCuenta(new Cuenta("2023630858", "RERLYN_a20", "Reyes Ruiz Yoselyn Estefany", 3000));
        cajero.agregarCuenta(new Cuenta("2023947596", "SOVTUR_q79", "Solares Velasco Arturo Misael", 7000));
        cajero.agregarCuenta(new Cuenta("2023867455", "SOLYRA_y45", "Solis Lugo Mayra", 2000));
        cajero.agregarCuenta(new Cuenta("2023385947", "TOHRDO_m32", "Toral Hernández Leonardo Javier", 6000));

        Cuenta cuentaAutenticada = null;

        // Menú de opciones
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Autenticar cuentahabiente");
            System.out.println("2. Mostrar datos de cuenta y saldos");
            System.out.println("3. Depósito en efectivo a cuenta propia");
            System.out.println("4. Depósito en efectivo a otras cuentas");
            System.out.println("5. Transferencias a otras cuentas");
            System.out.println("6. Retiro de efectivo");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            try {
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese su número de cuenta:");
                        String numeroCuenta = scanner.nextLine();
                        System.out.println("\nIngrese su contraseña:");
                        String password = scanner.nextLine();

                        cuentaAutenticada = cajero.autenticar(numeroCuenta, password);
                        if (cuentaAutenticada != null) {
                            System.out.println("\nAutenticación exitosa. Bienvenido, " + cuentaAutenticada.getNombre() + ".\n");
                        } else {
                            System.out.println("\nAutenticación fallida:(\n");
                        }
                        break;
                    case 2:
                        if (cuentaAutenticada != null) {
                            cajero.mostrarDatosCuenta(cuentaAutenticada);
                        } else {
                            System.out.println("Debe autenticarse primero\n");
                        }
                        break;
                    case 3:
                        if (cuentaAutenticada != null) {
                            System.out.println("Ingrese el monto a depositar: \n");
                            double montoDeposito = scanner.nextDouble();
                            scanner.nextLine();
                            cajero.depositarEnPropiaCuenta(cuentaAutenticada, montoDeposito);
                            System.out.println("Depósito exitoso!!\n");
                        } else {
                            System.out.println("Debe autenticarse primero.\n");
                        }
                        break;
                    case 4:
                        if (cuentaAutenticada != null) {
                            System.out.println("Ingrese el número de cuenta destino: \n");
                            String cuentaDestinoDep = scanner.nextLine();
                            Cuenta cuentaDestino = cajero.obtenerCuentaPorNumero(cuentaDestinoDep);  // Obtener cuenta por número
                            if (cuentaDestino != null) {
                                System.out.println("Ingrese el monto a depositar: \n");
                                double montoDepositoOtraCuenta = scanner.nextDouble();
                                scanner.nextLine();
                                cajero.depositarEnOtraCuenta(cuentaDestino, montoDepositoOtraCuenta);
                                System.out.println("Depósito exitoso a la cuenta de " + cuentaDestino.getNombre() + ".");
                            } else {
                                System.out.println("Cuenta destino no encontrada:(.\n");
                            }
                        } else {
                            System.out.println("Debe autenticarse primero.\n");
                        }
                        break;
                    case 5:
                        if (cuentaAutenticada != null) {
                            System.out.println("Ingrese el número de cuenta destino: \n");
                            String cuentaDestinoTrans = scanner.nextLine();
                            Cuenta cuentaDestino = cajero.obtenerCuentaPorNumero(cuentaDestinoTrans);  // Obtener cuenta por número
                            if (cuentaDestino != null) {
                                System.out.println("Ingrese el monto a transferir: \n");
                                double montoTransferencia = scanner.nextDouble();
                                scanner.nextLine();
                                cajero.transferir(cuentaAutenticada, cuentaDestino, montoTransferencia);
                                System.out.println("Transferencia exitosa a la cuenta de " + cuentaDestino.getNombre() + ".");
                            } else {
                                System.out.println("Cuenta destino no encontrada.\n");
                            }
                        } else {
                            System.out.println("Debe autenticarse primero.\n");
                        }
                        break;
                    case 6:
                        if (cuentaAutenticada != null) {
                            System.out.println("Ingrese el monto a retirar: \n");
                            double montoRetiro = scanner.nextDouble();
                            scanner.nextLine();
                            cajero.retirarEfectivo(cuentaAutenticada, montoRetiro);
                            System.out.println("Retiro exitoso.\n");
                        } else {
                            System.out.println("Debe autenticarse primero.\n");
                        }
                        break;
                    case 7:
                        System.out.println("Gracias por usar el cajero automático, hasta pronto!!\n");
                        return;
                    default:
                        System.out.println("Opción no válida!!\n");
                }
            } catch (SaldoEfectivoInsuficiente | SaldoCuentaInsuficiente e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
