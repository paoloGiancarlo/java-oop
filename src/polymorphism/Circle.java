package polymorphism;

public class Circle extends BasicShape implements ShapeConstants, ShapeComparator {
	
	public Circle(){
		this(0.0);
	}
	public Circle(double width){
		super(width);
	}
	
	public Circle(Circle circle) {
		super(circle.getWidth());
	}
	
	@Override
	public double getArea() {
		return (Math.PI* getWidth() * getWidth())/4;
	}

	@Override
	public double getPerimeter() {
		return ( Math.PI* getWidth());
	}
	@Override
	public String toString() {
		return ("Circle extends " + super.toString());
	}
	
	public boolean equals(Object obj) {
		return (obj instanceof Circle) && (this.getWidth() == ((Circle) obj).getWidth());
	}
	
	@Override
	public boolean isIdenticalTo(Object o) {
		return equals(o);
			
	}
	@Override
	public boolean isGreaterThan(Object o) {
		return (o instanceof Circle)&&(this.getWidth()>((Circle)o).getWidth());
	}
	@Override
	public boolean isSmallerThan(Object o) {
		return (o instanceof Circle)&&(this.getWidth()<((Circle)o).getWidth());
	}
}
