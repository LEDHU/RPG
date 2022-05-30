import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior();
        Monster monster = new Monster();

        warrior.inicializacao();
        monster.inicializacao();

        Scanner teclado = new Scanner(System.in);
        Random gerador = new Random();

        int escolha;
        int fortiWarrior = -1 ;
        int endureMonster = -1;

        System.out.println("BEM-VINDO AO MELHOR JOGO DE RPG\n");
        System.out.println("VOCÊ SERÁ O WARRIOR E TERÁ QUE DERROTAR O MONSTER");
        System.out.println("BOA SORTE, VOCÊ VAI PRECISAR!!\n");

        System.out.println("AQUI ESTÃO AS CARTAS");
        System.out.println("\nWARRIOR-------------------MONSTER");
        System.out.println("HP: " + warrior.getHP() + " -------------------" + "HP: " + monster.getHP());
        System.out.println("ATAQUE: " + warrior.getAtaque() + " ----------------" + "ATAQUE: " + monster.getAtaque());
        System.out.println("STATUS: " + warrior.getStatus() + " -----------" + "STATUS: " + monster.getStatus());
        System.out.println("PODER MÁGICO: " + warrior.getPoderMagico() + " ----------" + "PODER MÁGICO: " + monster.getPoderMagico());
        System.out.println("POÇÃO DE CURA: " + warrior.getCura() + "\n");

        while (warrior.getHP() > 0 && monster.getHP() > 0){

            menu();
            escolha = teclado.nextInt();

            if (escolha == 1){
                monster.atacado();
                System.out.println("\nVOCÊ ATACOU O MONSTER");
            }

            else if (escolha == 2){
                if(warrior.getCura() >= 1) {
                    warrior.tomarPocao();
                    System.out.println("\nVOCÊ TOMOU A POÇÃO DE CURA!!");
                }else
                    System.out.println("\nVOCÊ NÃO TEM A POÇÃO DE CURA E PERDEU A RODADA!!");
            }

            else if (escolha == 3) {
                if(warrior.getPoderMagico() >= 5) {
                    warrior.Fortificar();
                    System.out.println("\nVOCÊ USOU O PODER MÁGICO!!");
                    monster.setDano(warrior.getAtaque());
                }else
                    System.out.println("\nVOCÊ NÃO TEM PODER MÁGICO E PERDEU A RODADA!!");
                fortiWarrior = 5;

            }

            else
                System.out.println("\nVOCÊ NÃO PRESTOU ATENÇÃO E PERDEU A RODADA!!");

            if(fortiWarrior == 0){
                warrior.Desfortificar();
                monster.setDano(3);
            }

            fortiWarrior--;

            escolha = gerador.nextInt(10);

            if(escolha <= 6) {
                warrior.atacado();
                System.out.println("O MONSTER ATACOU VOCÊ!!");

            }else if(escolha <= 8){

                if(monster.getPoderMagico() >= 1) {

                    monster.recuperacao();
                    System.out.println("O MONSTER SE RECUPEROU!!");

                }else
                    System.out.println("O MONSTER NÃO TEM PODER MÁGICO PARA RECUPERAÇÃO E PASSOU A VEZ!!");

            }else if (monster.getPoderMagico() >= 2) {

                monster.endurecer();
                System.out.println("O MONSTER SE ENDURECEU!!");
                endureMonster = 4;
                warrior.setAtaque(monster.getDano());

            }else
                System.out.println("O MONSTER NÃO TEM PODER MÁGICO PARA ENDURECEU E PASSOU A VEZ!!");

            if(endureMonster == 0) {
                monster.desendurecer();
                warrior.setAtaque(monster.getDano());
                if(Objects.equals(warrior.getStatus(), "Fortificado")){
                    warrior.setAtaque(5);
                    monster.setDano(5);
                }
            }

            if(Objects.equals(monster.getStatus(), "Fortificado")){
                warrior.setAtaque(1);
                monster.setDano(1);
            }
            endureMonster--;



            System.out.println("\nWARRIOR-------------------MONSTER");
            System.out.println("HP: " + warrior.getHP() + " -------------------" + "HP: " + monster.getHP());
            System.out.println("ATAQUE: " + warrior.getAtaque() + " ----------------" + "ATAQUE: " + monster.getAtaque());
            System.out.println("STATUS: " + warrior.getStatus() + " -----------" + "STATUS: " + monster.getStatus());
            System.out.println("PODER MÁGICO: " + warrior.getPoderMagico() + " ----------" + "PODER MÁGICO: " + monster.getPoderMagico());
            System.out.println("POÇÃO DE CURA: " + warrior.getCura() + "\n");

        }

        ganhador(warrior.getHP(), monster.getHP());

    }
    public static void menu(){
        System.out.println("AGORA É A SUA VEZ!!!\n");
        System.out.println("1. ATAQUE");
        System.out.println("2. POÇÃO DE CURA");
        System.out.println("3. PODER MÁGICO");
    }

    public static void ganhador(int warrior, int monster){
        if(monster <= 0){
            rostowarrior();
            System.out.println("\n\nVOCÊ GANHOU!!");
        }else if(warrior <= 0) {
            System.out.println("\n\nO MONSTER DERROTOU VOCÊ!!");
            rostoMonster();
        }
    }

    public static void rostowarrior(){
        System.out.println("          lll       ---------         ///");
        System.out.println("           lll    --------------     ///");
        System.out.println("            lll   ----O-----O----   ///");
        System.out.println("             lll   ------v-----    ///");
        System.out.println("              lll    ----()---    ///");
        System.out.println("               lll      ----     ///");
    }
    public static void rostoMonster(){
        System.out.println("|||      |||       ///lll        |||      |||       ///lll");
        System.out.println("|||      |||      ///  lll       |||      |||      ///  lll");
        System.out.println("|||------|||     ///----lll      |||------|||     ///----lll");
        System.out.println("|||------|||    ///------lll     |||------|||    ///------lll");
        System.out.println("|||      |||   ///        lll    |||      |||   ///        lll");
        System.out.println("|||      |||  ///          lll   |||      |||  ///          lll");
    }

}
