
public class Floor implements Drawable{
    final static double floor_height = 100; 
    double y, x;
    public Floor(FlappyBird f){
        this.y = f.getAltura() - Floor.floor_height;
        this.x = f.getLargura();
    }
    public void print(Tela t){
        t.imagem("sprite.png", 296, 0, 294, 112, 0.0, x, y);
    }
    public void refresh(double dt){
        x-=FlappyBird.vx*dt;
    }
    public boolean remove(){
        return x<-294;
    }
}
