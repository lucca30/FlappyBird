import java.util.ArrayList;

public class FlappyBird implements Jogo {
    static double vx = 200;
    double Y_interval = 200;/*Interval between obstacles*/
    ArrayList<Drawable> elements = new ArrayList<Drawable> ();
    ArrayList<Drawable> trash = new ArrayList<Drawable> ();
    Timer obstacle_manager, score_manager, floor_manager;
    Bird bird;
    int score;
    boolean menu, game_over;
    public FlappyBird(){
        elements.clear();
        trash.clear();
        score = 0;
        menu = true;
        game_over = false;
        bird = new Bird();
        elements.add(new Background());
        elements.add(new Floor(this, 0));
        elements.add(new Floor(this, 290));
        elements.add(new Floor(this, 580));
        elements.add(new Floor(this, 870));
        elements.add(bird);
        obstacle_manager = new Timer(1.4, true, 
        new Acao(){
            public void executa(){
                for(Drawable D:trash){
                    elements.remove(D);
                }
                trash.clear();
                elements.add(new Obstacle(FlappyBird.this));
                elements.add(new Floor(FlappyBird.this));
            }
        });
        floor_manager = new Timer(1.4, true, 
        new Acao(){
            public void executa(){
                elements.add(new Floor(FlappyBird.this));
            }
        });

        score_manager = new Timer(4.46, false, 
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
            D.refresh(dt, this);
            if(D.remove()){trash.add(D);}
            if(D.colision(bird) && !game_over){game_over = true; bird.speed = -300;}
        }
        if(!menu &&  !game_over){score_manager.tique(dt);obstacle_manager.tique(dt);}
        if(!game_over){floor_manager.tique(dt);}
    }
    
    public void tecla(String tecla){
        if(menu && tecla.contains(" ")){menu = !menu;}
        else if(game_over && tecla.contains(" ")){reset();}
        else{
            bird.tecla(tecla);
        }
    }
    
    public void desenhar(Tela tela){
        for(Drawable D:elements){
            D.print(tela);
        }
        bird.print(tela);
        tela.texto(String.format("%d", score),getLargura()/2, 80,30, Cor.PRETO );
        if(menu){
            tela.imagem("sprite.png", 291, 345, 193, 43, 0.0, 250, 10);
        }
        if(game_over){
            tela.imagem("sprite.png", 292, 397, 192, 44, 0.0, 250, 200);
        }
    }
    
    public void reset(){
        elements.clear();
        trash.clear();
        score = 0;
        menu = true;
        game_over = false;
        bird = new Bird();
        elements.add(new Background());
        elements.add(new Floor(this, 0));
        elements.add(new Floor(this, 290));
        elements.add(new Floor(this, 580));
        elements.add(new Floor(this, 870));
        elements.add(bird);
        obstacle_manager = new Timer(1.4, true, 
        new Acao(){
            public void executa(){
                for(Drawable D:trash){
                    elements.remove(D);
                }
                trash.clear();
                elements.add(new Obstacle(FlappyBird.this));
                elements.add(new Floor(FlappyBird.this));
            }
        });
        floor_manager = new Timer(1.4, true, 
        new Acao(){
            public void executa(){
                elements.add(new Floor(FlappyBird.this));
            }
        });

        score_manager = new Timer(4.46, false, 
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
    
    public static void main(String[] args){
        new Motor(new FlappyBird());
    }
}
