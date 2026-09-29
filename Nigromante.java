public class Nigromante extends Personaje {
    private int mana;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        
        if (mana < 15) {
            throw new RecursoInsuficienteException("mana", mana);
        }
        
        mana -= 15;
        System.out.println("[" + getNombre() + "] lanza magia oscura. Mana restante: " + mana);
    }

    @Override
    public int calcularDanio() {
        return 55; // Ejemplo de cálculo
    }
}