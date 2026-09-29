public class Hechicero extends Personaje {
    private int mana;

    public Hechicero(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        
        // Asumimos que el Hechicero gasta 20 de maná por ataque
        if (mana < 20) {
            throw new RecursoInsuficienteException("mana", mana);
        }
        
        mana -= 20;
        System.out.println("[" + getNombre() + "] lanza una bola de fuego devastadora. Mana restante: " + mana);
    }

    @Override
    public int calcularDanio() {
        return 70; // Daño mágico alto
    }
}