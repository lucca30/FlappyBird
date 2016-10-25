
public class Obstacle implements Drawable{
    final double Y_between_interval = 100;

    //Colision Variables
    double x00, y00, x10, y10;
    double x01, y01, x11, y11;

    double x, y;
    /*
     * Y interval -> 120|310
     */
    public Obstacle(FlappyBird f){
        this.x = f.getLargura();
        this.y = Math.round(Math.random()*190)+120;
        y00 = y - (Y_between_interval/2) - 270;
        y10 = y00+270;
        y01 = y + (Y_between_interval/2);
        y11 = y+242;
        x00 = x;
        x01 = x;
        x10 = x+52;
        x11 = x+52;
    }
    public Obstacle(FlappyBird f, double x){
        this.x = x;
        this.y = Math.round(Math.random()*190)+120;
    }
    public void refresh(double dt,FlappyBird j){
        if(j.menu||j.game_over){return;}
        x-=FlappyBird.vx*dt;
        x00 = x01 = x;
        x10 = x11 = x+52;
    }
    
    /*X represents the left side, but y represents the center*/
    public void print(Tela t){
        t.imagem("sprite.png", 604, 0, 52, 270, 0.0, x , y - (Y_between_interval/2) - 270);
        t.imagem("sprite.png", 660, 0, 52, 242, 0.0, x , y + (Y_between_interval/2));
    }
    public boolean remove(){
        return x<0;
    }
    public boolean colision(Bird B){
        double w = ((x10-x00) + (B.x1 - B.x0)) / 2;
        double h = ((y10-y00) + (B.y1 - B.y0)) / 2;
        double dx = ((x10 + x00) - (B.x1 + B.x0)) / 2;
        double dy = ((y10 + y00) - (B.y1 + B.y0)) / 2;
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
        w = ((x11-x01) + (B.x1 - B.x0)) / 2;
        h = ((y11-y01) + (B.y1 - B.y0)) / 2;
        dx = ((x11 + x01) - (B.x1 + B.x0)) / 2;
        dy = ((y11 + y01) - (B.y1 + B.y0)) / 2;
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
