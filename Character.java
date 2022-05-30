public abstract class Character {

    private int HP;
    private int ataque;
    private int poderMagico;
    private String status;

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract int atacado();
}
