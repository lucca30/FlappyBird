
public class Floor implements Drawable{
    final static double floor_height = 100; 
    double y, x;
    
    //Colision Variables
    double x0 =0.0, y0, x1, y1;
    
    public Floor(FlappyBird f){
        this.y = f.getAltura() - Floor.floor_height;
        this.x = f.getLargura();
        x1 = x;
        y0 = y;
        y1 = f.getAltura();
    }
    public Floor(FlappyBird f, double x){
        this.y = f.getAltura() - Floor.floor_height;
        this.x = x;
    }
    public void print(Tela t){
        t.imagem("sprite.png", 296, 0, 294, 112, 0.0, x, y);
    }
    public void refresh(double dt, FlappyBird j){
        if(j.game_over){return;}
        x-=FlappyBird.vx*dt;
    }
    public boolean remove(){
        return x<-294;
    }
    public boolean colision(Bird B){
        double w = ((x1-x0) + (B.x1 - B.x0)) / 2;
        double h = ((y1-y0) + (B.y1 - B.y0)) / 2;
        double dx = ((x1 + x0) - (B.x1 + B.x0)) / 2;
        double dy = ((y1 + y0) - (B.y1 + B.y0)) / 2;
        if (Math.abs(dx) <= w && Math.abs(dy) <= h) {
            double wy = w * dy; double hx = h * dx;
            if (wy > hx) {
                if (wy > -hx) return true;
                else return true;
            } else {
                if (wy > -hx) return true;
                else return true;
            }
        }
        return false;

    }
}
