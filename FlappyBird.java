import java.util.ArrayList;

public class FlappyBird implements Jogo {
    static double vx = 200;
    double Y_interval = 200;/*Interval between obstacles*/
    ArrayList<Drawable> elements = new ArrayList<Drawable> ();
    ArrayList<Drawable> trash = new ArrayList<Drawable> ();
    Timer obstacle_manager, score_manager;
    Bird bird = new Bird();
    int score;
    
    public FlappyBird(){
        score = 0;
        elements.add(new Background());
        elements.add(new Obstacle(this));
        elements.add(new Floor(this));
        elements.add(bird);
        obstacle_manager = new Timer(1.4, true, 
        new Acao(){
            public void executa(){
                elements.add(new Obstacle(FlappyBird.this));
                elements.add(new Floor(FlappyBird.this));
                for(Drawable D:trash){
                    elements.remove(D);
                }
                trash.clear();
            }
        });
        score_manager = new Timer(3.06, false, 
        new Acao(){
            public void executa(){
                score++;
                score_manager = new Timer(1.4, true, 
                new Acao(){
                    public void executa(){
                        score++;
                    }
                });
            }
        });
    }

    
    
    public String getTitulo(){
        return "Flappy Bird";
    }
    public int getLargura(){
        return 712;
    }
    public int getAltura(){
        return 512;
    }
    
    
    
    public void tique(java.util.Set<String> teclas, double dt){
        for(Drawable D:elements){
            D.refresh(dt);
            if(D.remove()){trash.add(D);}
        }
        obstacle_manager.tique(dt);
        score_manager.tique(dt);
    }
    
    public void tecla(String tecla){
        bird.tecla(tecla);
    }
    
    public void desenhar(Tela tela){
        for(Drawable D:elements){
            D.print(tela);
        }
        tela.texto(String.format("%d", score),getLargura()/2, 70, 30, Cor.PRETO );
    }
    
    
    
    public static void main(String[] args){
        new Motor(new FlappyBird());
    }
}
