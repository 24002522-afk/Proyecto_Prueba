package carreravisual; // o el nombre de tu paquete

public class MiniRunner {
    private String name;
    private int speed;       // Tiempo para terminar la carrera (en segundos)
    private int position;    // Posición actual (pixeles)

    public MiniRunner(String name) {
        this.name = name;
        this.speed = (int)(Math.random() * 6 + 3); // Entre 3 y 8 segundos
        this.position = 0;
    }

    public String getName() { return name; }
    public int getSpeed() { return speed; }
    public int getPosition() { return position; }
    public void setPosition(int p) { position = p; }
}
