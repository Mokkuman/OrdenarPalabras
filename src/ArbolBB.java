import java.text.Collator;


public class ArbolBB {
    public Nodo raiz;
    public Collator collator;

    public ArbolBB(){
        collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
    }

    public void insertaNodo(String palabra){
        if(!recorre(palabra,raiz))
            newNodo(new Nodo(palabra));
    }

    private void newNodo(Nodo n){
        Nodo aux2=raiz, aux3=null;
        while(aux2!=null) {
            aux3=aux2;
            if((n.getDato()).compareTo(aux2.getDato())<0)
                aux2=aux2.getHijoIzq();
            else aux2=aux2.getHijoDer();
        }
        if (aux3==null)
            raiz=n;
        else {
            if(n.getDato().compareTo(aux3.getDato())<0)
                aux3.insertaHijoIzq(n.getDato());
            else aux3.insertaHijoDer(n.getDato());
        }
    }

    //Método para verificar que no haya una palabra repetida
    private boolean recorre(String palabra, Nodo n){
        if(n!=null){
            if (collator.compare(n.dato,palabra) == 0) {
                n.cont++;
                return true;
            }else{
                return recorre(palabra,n.getHijoIzq())||recorre(palabra,n.getHijoDer());
            }
        }
        return false;
    }

    public void enOrden(Nodo n)
    {
        if (n!=null)
        {
            enOrden(n.getHijoIzq());
            System.out.print((n.getDato()));
            if(n.getDato().length()<4)
                System.out.println("\t\t\t     "+n.cont);
            else if(n.getDato().length()<8)
                System.out.println("\t\t     "+n.cont);
            else
                System.out.println("\t     "+n.cont);
            enOrden(n.getHijoDer());
        }
    }
}
