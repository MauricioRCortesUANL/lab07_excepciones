public abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected boolean estaVivo;

    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = puntosVida > 0;
    }

    public abstract void atacar() throws RpgException;
    public abstract int calcularDanio();

    public void recibirDanio(int danio) throws AccionInvalidaException {
        if (danio < 0) {
            throw new AccionInvalidaException(
                "recibirDanio",
                "El daño no puede ser negativo: " + danio
            );
        }
        
        puntosVida -= danio;
        
        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
        }
        
        System.out.println(nombre + " recibe " + danio + " de daño. Vida: " + puntosVida);
        
        if (!estaVivo) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    public String getNombre() { return nombre; }
    public boolean isEstaVivo() { return estaVivo; }
}