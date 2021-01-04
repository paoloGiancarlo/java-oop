package polymorphism;

/**
 * with this project we are learning to handle OOP such polymorphism
 * abstraction, interfaces, and how to use equals method.
 */
public class BasicShapeLauncher {


	public static void main(String[] args){

		Circle circle = new Circle(4.0);
		System.out.println(circle.toString());
		System.out.printf("The circumference of the circle is %.3f", circle.getPerimeter());
		System.out.printf(" and its area is %.3f \n\n", circle.getArea());

		Square square = new Square(3.0);
		Square square1 = new Square(7.5);
		Square square2 = new Square(4.0);
		System.out.println(square.toString());
		System.out.printf("The circumference of the square is %.3f", square.getPerimeter());
		System.out.printf(" and its area is %.3f \n\n", square.getArea());

		Triangle triangle = new Triangle(6.0);
		System.out.println(triangle.toString());
		System.out.printf("The circumference of the triangle is %.3f", triangle.getPerimeter());
		System.out.printf(" and its area is %.3f \n\n", triangle.getArea());

		Square defaultSquare = new Square();
		Triangle triangle1 = new Triangle(triangle);
		Triangle triangle2 = new Triangle(6.0);
		Triangle triangle3 = new Triangle(8.0);

		System.out.println("A square & circle are " + (square.equals(circle)?"":"NOT ") + "equal");
		System.out.println("The default square is " + (defaultSquare.equals(square)?"":"NOT ") + "equal to a square of width 2.0");

		System.out.println("\nA triangle is " + (triangle.equals(triangle)?"":"NOT ") + "equal to itself");
		System.out.println("The copy constructor triangle is " + (triangle.equals(triangle1)?"":"NOT ") + "equal to its source triangle");
		System.out.println("triangle1 is " + (triangle1.equals(triangle2)?"":"NOT ") + "equal to triangle2");


		System.out.println("\nsquare1 is " + (square1.isIdenticalTo(square2)?"":"NOT ") + "identical to square2");
		System.out.println("square1 is " + (square1.isGreaterThan(square2)?"":"NOT ") + "greater than square2");
		System.out.println("square1 is " + (square1.isSmallerThan(square2)?"":"NOT ") + "smaller than square2");

		System.out.println("\ntriangle3 is " + (triangle3.isIdenticalTo(circle)?"":"NOT ") + "identical to circle");
		System.out.println("triangle3 is " + (triangle3.isGreaterThan(triangle1)?"":"NOT ") + "greater than triangle1");
		System.out.println("defaultSquare is " + (defaultSquare.isSmallerThan(square2)?"":"NOT ") + "smaller than square2");


	}
}
