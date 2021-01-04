package polymorphism;

public class Square extends BasicShape implements ShapeConstants, ShapeComparator {

	public Square() {
		this(0.0);
	}
	
	public Square(double width) {
		super(width);
	}
	public Square(Square square) {
		super(square.getWidth());
	}
	
	@Override
	public double getArea() {
		return (getWidth() * getWidth());
	}

	@Override
	public double getPerimeter() {
		return (4 * getWidth());
		
	}
	@Override
	public String toString() {
		return ("Square extends " + super.toString());
	}
	public boolean equals(Object obj) {
		return (obj instanceof Square) && (this.getWidth() == ((Square)obj).getWidth());
	}

	@Override
	public boolean isIdenticalTo(Object o) {
		return equals(o);
	}

	@Override
	public boolean isGreaterThan(Object o) {
		return (o instanceof Square) && (this.getWidth() > ((Square)o).getWidth());
	}

	@Override
	public boolean isSmallerThan(Object o) {
		return (o instanceof Square) && (this.getWidth() < ((Square)o).getWidth());
	}
}
