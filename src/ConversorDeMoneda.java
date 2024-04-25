import java.util.Scanner;

public class ConversorDeMoneda {
    private ApiTasaCambio apiTasaCambio;

    public ConversorDeMoneda(ApiTasaCambio apiTasaCambio) {
        this.apiTasaCambio = apiTasaCambio;
    }

    public void ejecutar() {
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        while (opcion != 7) {
            mostrarMenu();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    convertirUSDToARS();
                    break;
                case 2:
                    convertirARSToUSD();
                    break;
                case 3:
                    convertirUSDToBRL();
                    break;
                case 4:
                    convertirBRLToUSD();
                    break;
                case 5:
                    convertirUSDToCOP();
                    break;
                case 6:
                    convertirCOPToUSD();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción del menú.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("Sea bienvenido/a al Conversor de Moneda =)");
        System.out.println("1) Dólar =>>> Peso argentino");
        System.out.println("2) Peso argentino =>>>>> Dólar");
        System.out.println("3) Dólar >>> Real brasileño");
        System.out.println("4) Real brasileño =>> Dólar");
        System.out.println("5) Dólar >>> Peso colombiano");
        System.out.println("6) Peso colombiano =>>> Dólar");
        System.out.println("7) Salir");
        System.out.println("Elija una opción válida:");
    }

    private void convertirUSDToARS() {
        double tasa = apiTasaCambio.obtenerTasa("USD", "ARS");
        System.out.println("Ingrese la cantidad de Dólares a convertir a Peso argentino:");
        double cantidadUSD = new Scanner(System.in).nextDouble();
        double resultado = cantidadUSD * tasa;
        System.out.println(cantidadUSD + " Dólares equivale a " + resultado + " Pesos argentinos.");
    }

    private void convertirARSToUSD() {
        double tasa = apiTasaCambio.obtenerTasa("ARS", "USD");
        System.out.println("Ingrese la cantidad de Pesos argentinos a convertir a Dólares:");
        double cantidadARS = new Scanner(System.in).nextDouble();
        double resultado = cantidadARS * tasa;
        System.out.println(cantidadARS + " Pesos argentinos equivale a " + resultado + " Dólares.");
    }

    private void convertirUSDToBRL() {
        double tasa = apiTasaCambio.obtenerTasa("USD", "BRL");
        System.out.println("Ingrese la cantidad de Dólares a convertir a Real brasileño:");
        double cantidadUSD = new Scanner(System.in).nextDouble();
        double resultado = cantidadUSD * tasa;
        System.out.println(cantidadUSD + " Dólares equivale a " + resultado + " Reales brasileños.");
    }

    private void convertirBRLToUSD() {
        double tasa = apiTasaCambio.obtenerTasa("BRL", "USD");
        System.out.println("Ingrese la cantidad de Reales brasileños a convertir a Dólares:");
        double cantidadBRL = new Scanner(System.in).nextDouble();
        double resultado = cantidadBRL * tasa;
        System.out.println(cantidadBRL + " Reales brasileños equivale a " + resultado + " Dólares.");
    }

    private void convertirUSDToCOP() {
        double tasa = apiTasaCambio.obtenerTasa("USD", "COP");
        System.out.println("Ingrese la cantidad de Dólares a convertir a Peso colombiano:");
        double cantidadUSD = new Scanner(System.in).nextDouble();
        double resultado = cantidadUSD * tasa;
        System.out.println(cantidadUSD + " Dólares equivale a " + resultado + " Pesos colombianos.");
    }

    private void convertirCOPToUSD() {
        double tasa = apiTasaCambio.obtenerTasa("COP", "USD");
        System.out.println("Ingrese la cantidad de Pesos colombianos a convertir a Dólares:");
        double cantidadCOP = new Scanner(System.in).nextDouble();
        double resultado = cantidadCOP * tasa;
        System.out.println(cantidadCOP + " Pesos colombianos equivale a " + resultado + " Dólares.");
    }

    public static void main(String[] args) {
        // Crear una instancia de ApiTasaCambio
        ApiTasaCambio apiTasaCambio = new ApiTasaCambio();
        // Crear una instancia de ConversorDeMoneda con la instancia de ApiTasaCambio
        ConversorDeMoneda conversorDeMoneda = new ConversorDeMoneda(apiTasaCambio);
        // Ejecutar el programa
        conversorDeMoneda.ejecutar();
    }
}