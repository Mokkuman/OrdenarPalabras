public class Nodo {
    public String dato;
    public int cont;
    public Nodo[] hijo;

    public Nodo(String dato) {
        this.dato = dato;
        cont=1;
        hijo = new Nodo[2];
        hijo[0] = null;
        hijo[1] = null;
    }
    public Nodo insertaHijoIzq(String dato)
    {
        Nodo tempNodo = new Nodo(dato);
        hijo[0] = tempNodo;
        return tempNodo;
    }

    public Nodo insertaHijoDer(String dato)
    {
        Nodo tempNodo = new Nodo(dato);
        hijo[1] = tempNodo;
        return tempNodo;
    }

    public String getDato(){
        return dato;
    }

    public Nodo getHijoIzq(){
        return hijo[0];
    }

    public Nodo getHijoDer(){
        return hijo[1];
    }
}
