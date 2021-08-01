import java.util.Scanner;
public class main {
    public static void main(String[] args){
        OrdenPalabras ord=new OrdenPalabras();
        Scanner in = new Scanner(System.in);
        int op=0;
        String cadena;
        do{
            System.out.print("Bienvenido! :D\n" +
                    "[0] Salir\n" +
                    "[1] Ingresar cadena\n" +
                    "[2] Mostrar orden\n" +
                    "Opcion: ");
            op = in.nextInt();
            System.out.println();
            switch (op){
                case 0:
                    System.out.println("Adios . . .");
                    break;
                case 1:
                    System.out.print("Ingrese la cadena: ");
                    in.nextLine();
                    cadena = in.nextLine();
                    ord.setCadena(cadena);
                    break;
                case 2:
                    if(ord.abb!=null) {
                        System.out.println("El orden queda de la siguiente manera");
                        ord.mostrarOrden();
                    }else
                        System.out.println("La cadena aun no ha sido ingresada");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
            System.out.println();
        }while(op!=0);
    }
}
