public class Sanador extends Personaje {
    private int mana;

    public Sanador(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        
        // Un ataque básico de luz gasta 5 de maná
        if (mana < 5) {
            throw new RecursoInsuficienteException("mana", mana);
        }
        
        mana -= 5;
        System.out.println("[" + getNombre() + "] lanza un destello castigador. Mana restante: " + mana);
    }

    @Override
    public int calcularDanio() {
        return 15; // Daño bajo, su rol principal es curar
    }

    // Método específico del Sanador (similar al del Druida)
    public void curarAliado(Personaje aliado) throws RpgException {
        if (aliado == null) {
            throw new PersonajeNuloException("curarAliado");
        }
        
        if (!aliado.isEstaVivo()) {
            throw new AccionInvalidaException("curarAliado", "No se puede curar a un personaje derrotado");
        }
        
        if (mana < 15) {
            throw new RecursoInsuficienteException("mana para curar", mana);
        }
        
        mana -= 15;
        System.out.println("[" + getNombre() + "] envuelve a " + aliado.getNombre() + " en luz sanadora. Mana restante: " + mana);
    }
}