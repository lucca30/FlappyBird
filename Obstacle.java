
public class Obstacle implements Drawable{
	final double Y_between_interval = 100;

	double x, y;
	/*
	 * Y interval -> 120|310
	 */
	public Obstacle(FlappyBird f){
		this.x = f.getLargura();
		this.y = Math.round(Math.random()*190)+120;
	}
	public void refresh(double dt){
		x-=FlappyBird.vx*dt;
	}
	
	/*X represents the left side, but y represents the center*/
	public void print(Tela t){
		t.imagem("sprite.png", 604, 0, 52, 270, 0.0, x , y - (Y_between_interval/2) - 270);
		t.imagem("sprite.png", 660, 0, 52, 242, 0.0, x , y + (Y_between_interval/2));
	}
    public boolean remove(){
        return x<0;
    }

}
