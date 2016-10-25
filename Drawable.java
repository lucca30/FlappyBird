
public interface Drawable{
	void print(Tela t);/*Draw on screen*/
	void refresh(double dt, FlappyBird j);/*Move*/
	boolean remove();
	boolean colision(Bird B);
}
