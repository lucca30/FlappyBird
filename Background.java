public class Background implements Drawable{
    final double y = 0 ;
    public void print(Tela t){
        t.imagem("sprite.png", 0, 0, 287, 512, 0.0, 0 , y);
        t.imagem("sprite.png", 0, 0, 287, 512, 0.0, 287 , y);
        t.imagem("sprite.png", 0, 0, 287, 512, 0.0, 574 , y);
    }
    public void refresh(double dt){
    }
    public boolean remove(){
        return false;
    }

}
