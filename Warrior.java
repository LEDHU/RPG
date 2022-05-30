public class Warrior extends Character{

    private int cura;

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }

    public void inicializacao(){
        this.setHP(20);
        this.setAtaque(3);
        this.setCura(1);
        this.setPoderMagico(5);
        this.setStatus("Normal");
    }

    // Ataque do monster
    // Aqui o atacado é o warrior
    @Override
    public int atacado() {
        this.setHP(this.getHP() - 4);
        return this.getHP();
    }

    public void tomarPocao(){
        if(this.getHP() >= 10)
            this.setHP(20);
        else
            this.setHP(this.getHP() + 10);
        this.setCura(this.getCura() - 1);
    }

    public void Fortificar(){
        this.setStatus("Fortificado");
        this.setAtaque(5);
        this.setPoderMagico(this.getPoderMagico() - 5);
    }
    public void Desfortificar(){
        this.setStatus("Normal");
        this.setAtaque(3);
    }


}
