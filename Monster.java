public class Monster extends Character{

    private int dano;

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void inicializacao(){
        this.setHP(24);
        this.setAtaque(4);
        this.setPoderMagico(6);
        this.setStatus("Normal");
        this.setDano(3);
    }

    @Override
    public int atacado() {
        this.setHP(this.getHP() - this.getDano());
        return this.getHP();
    }

    public void recuperacao(){
        if(this.getHP() >= 22)
            this.setHP(24);
        else
            this.setHP(this.getHP() + 2);
        this.setPoderMagico(this.getPoderMagico() - 1);
    }

    public void endurecer(){
        this.setStatus("Fortificado");
        this.setPoderMagico(this.getPoderMagico() - 2);
        this.setDano(1);
    }

    public void desendurecer(){
        this.setStatus("Normal");
        this.setDano(3);
    }

}
