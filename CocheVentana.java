public class CocheVentana extends Coche{
    protected SpriteCoche sprite;

    public CocheVentana(double velocidad, double direccion, double x, double y, String piloto) {
        super(velocidad, direccion, x, y, piloto);
        this.sprite = new SpriteCoche((int) x,(int) y);
    }

    public SpriteCoche getSpriteCoche() {
        return this.sprite;
    }
}
