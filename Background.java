public class Background implements Drawable{
    final double y = 0 ;
    double x, vx;
    public Background(Jogo j){
        x = j.getLargura();
        vx = FlappyBird.vx;
    }
    public void print(Tela t){
        t.imagem("sprite.png", 0, 0, 287, 512, 0.0, x , y);
    }
    public void refresh(double dt){
        x -= vx*dt;
    }
    public boolean remove(){
        return x< -287;
    }

}
