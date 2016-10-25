/*
 * Sprite 0 -> 529, 180, 32, 24
 * Sprite 1 -> 447, 261, 32, 24
 * Sprite 2 -> 528, 137, 32, 24
 * 
 * Rotation interval -> -1.2|1.2
 */
public class Bird implements Drawable{
    int sprite= 0;
    final double x = 100, Rotate_constant = 0.003;
    double speed= 0, gravity=500, y = 100;

    //Colision Variables
    double x0 =100.0, y0 = 100, x1 = 132, y1=124;
    
    Timer sprite_switch=new Timer(0.1, true, 
    new Acao(){
        public void executa(){
            sprite = (sprite+1)%3;
        }
    });
    public void print(Tela t){
        double rotation = speed * Rotate_constant;
        switch (sprite){
            case 0:
                t.imagem("sprite.png", 527, 179, 32, 24, rotation, 100 , y);
                break;
            case 1:
                t.imagem("sprite.png", 445, 246, 32, 24, rotation, 100 , y);
                break;
            case 2:
                t.imagem("sprite.png", 527, 127, 32, 24, rotation, 100 , y);
                break;
        }
    }
    public void refresh(double dt, FlappyBird j){
        sprite_switch.tique(dt);
        if(j.menu){return;}
        speed += gravity*dt;
        y+=speed*dt;
        y = y<0?0:y;
        y0 = y;
        y1 = y0+24;
    }
    public boolean remove(){return false;}
    public void tecla(String tecla){
        if(tecla.contains(" ")){
            speed = -250;
        }
    }
    public boolean colision(Bird B){return false;}

}
