public class Arquero extends Personaje {
    private String tipoArco;
    private int flechasDisponibles;
    private int agilidad;

    public Arquero(String nombre, int nivel, int puntosVida, String tipoArco, int flechasDisponibles, int agilidad) {
        super(nombre, nivel, puntosVida);
        this.tipoArco = tipoArco;
        this.flechasDisponibles = flechasDisponibles;
        this.agilidad = agilidad;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (flechasDisponibles <= 0) {
            throw new RecursoInsuficienteException("flechas", flechasDisponibles);
        }

        flechasDisponibles--;
        System.out.println("[" + getNombre() + "] dispara una flecha. Flechas restantes: " + flechasDisponibles);
    }

    @Override
    public int calcularDanio() {
        return agilidad * 2; // Ejemplo de cálculo
    }
}