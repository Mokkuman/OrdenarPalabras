import java.util.ArrayList;
import java.util.StringTokenizer;

public class OrdenPalabras {

    private String cadena;
    public ArbolBB abb;

    public OrdenPalabras(){ }

    //Método principal para dar formato a la oración previo a insertar en el arbol abb
    private void separarPalabras(){
        ArrayList<String> palabras=new ArrayList<>();
        StringTokenizer tokens=new StringTokenizer(cadena);

        while(tokens.hasMoreTokens())
            palabras.add(tokens.nextToken());

        //Hace todas las palabras en minúsculas y elimina las mal escritas
        for (int i = 0,j=0; i < palabras.size(); i++,j=0) {
            palabras.set(i,palabras.get(i).toLowerCase());
            palabras.set(i,compruebaPuntuacion(palabras.get(i)));
            palabras.set(i,compruebaPalabra(palabras.get(i)));
            while(j!=palabras.get(i).length()){
                if(!Character.isAlphabetic(palabras.get(i).charAt(j)) ){
                    System.out.println("Palabra '"+palabras.get(i)+"' mal escrita o no admitida");
                    palabras.remove(i);
                    i--;
                    break;
                }
                j++;
            }
        }
        creaArbol(palabras);
    }

    public String compruebaPalabra(String palabra){
        String aux="";
        int i=0;
        while(i!=palabra.length()){
            switch (palabra.charAt(i)){
                case 'á':
                    aux+="a";
                    break;
                case 'í':
                    aux+="i";
                    break;
                case 'ó':
                    aux+="o";
                    break;
                case 'ú':
                    aux+="u";
                    break;
                default:
                    aux+=String.valueOf(palabra.charAt(i));
            }
            i++;
        }
        return aux;
    }

    public String compruebaPuntuacion(String palabra){
        String aux="";
        int i=0;
        while(i!=palabra.length()){
            if(palabra.charAt(i)!='.'&&palabra.charAt(i)!=','&&palabra.charAt(i)!=':'&&palabra.charAt(i)!=';'&&palabra.charAt(i)!='"')
                aux+=String.valueOf(palabra.charAt(i));
            i++;
        }
        return aux;
    }

    public void setCadena(String cadena){
        this.cadena=cadena;
        abb=new ArbolBB();
        separarPalabras();
    }

    private void creaArbol(ArrayList<String> palabras){
        for (int i = 0; i < palabras.size(); i++)
            abb.insertaNodo(palabras.get(i));
    }

    public void mostrarOrden(){
        System.out.println("Palabra\t\tFrecuencia");
        abb.enOrden(abb.raiz);
    }
}
