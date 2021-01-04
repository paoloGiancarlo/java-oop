package polymorphism;

public class Triangle extends BasicShape implements ShapeConstants, ShapeComparator {
	
	public Triangle() {
		this(0.0);
	}
	
	public Triangle(double width) {
		super(width);
	}
	public Triangle(Triangle triangle) {
		super(triangle.getWidth());
	}
	
	@Override
	public double getArea() {
		return Math.sqrt(3)*Math.pow(getWidth(), 2)/4;
	}

	@Override
	public double getPerimeter() {
		return (3 * getWidth());
	}
	@Override
	public String toString() {
		return ("Triangle extends " + super.toString());
	}
	public boolean equals(Object obj) {
		return (obj instanceof Triangle) && (this.getWidth() == ((Triangle)obj).getWidth());
	}

	@Override
	public boolean isIdenticalTo(Object o) {
		equals(o);
		return false;
	}

	@Override
	public boolean isGreaterThan(Object o) {
		return (o instanceof Triangle) && (this.getWidth() > ((Triangle)o).getWidth());
	}

	@Override
	public boolean isSmallerThan(Object o) {
		return (o instanceof Triangle) && (this.getWidth() < ((Triangle)o).getWidth());
	}
}
