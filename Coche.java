public class Coche {
    private double miVelocidad;
    private double miDireccion;
    private double posX;
    private double posY;
    private String piloto;
    
    public Coche() {
        this.miVelocidad = 0;
        this.miDireccion = 0;
        this.posX = 0;
        this.posY = 0;
        this.piloto = "piloto0";
    }

    public Coche(double velocidad, double direccion, double x, double y, String piloto) {
        this.miVelocidad = velocidad;
        this.miDireccion = direccion;
        this.posX = x;
        this.posY = y;
        this.piloto = piloto;
    }

    public double getMiVelocidad() {
        return miVelocidad;
    }

    public void setMiVelocidad(double miVelocidad) {
        this.miVelocidad = miVelocidad;
    }

    public double getMiDireccion() {
        return miDireccion;
    }

    public void setMiDireccion(double miDireccion) {
        this.miDireccion = miDireccion;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    @Override
    public String toString() {
        return "Coche [miVelocidad=" + miVelocidad + ", miDireccion=" + miDireccion + ", posX=" + posX + ", posY=" + posY + ", piloto=" + piloto + "]";
    }

    public void acelerar(int aceleracion) {
        this.miVelocidad += aceleracion;
    }

    public void girar(int direccion) {
        this.miDireccion += direccion;
    }

    public void mover() {
        double velocidadX = Math.cos(Math.toRadians(miDireccion)) * miVelocidad;
        double velocidadY = Math.sin(Math.toRadians(miDireccion)) * miVelocidad;
        this.posX += velocidadX/10;
        this.posY += velocidadY/10;
    }
}