package matrixCal;
import java.util.Scanner;

public class Jacobi {
	public static void main(String[] args){
		int order;
		double threshold;
		double flag;
		int iterations;
		
		Trigonometric tri = new Trigonometric();
		Scanner reader = new Scanner(System.in); 
		
		System.out.println("Please enter the order of matrix：");
		order = reader.nextInt();
		System.out.println("Please enter the threshold: ");
		threshold = reader.nextDouble();
		Matrix matrix = new Matrix(order);
		matrix.enterMatrix();
		System.out.println("Please wait for a moment. ^_^");
		
		flag = Math.abs(matrix.findMax());
		System.out.println(matrix.max);
		
		for(int i = 1; ;i++){
			
			tri.trigonometric(matrix.app, matrix.aqq, matrix.apq);
			tri.show();
			matrix.rotation(tri.cosTheta, tri.sinTheta);
			//System.out.println(matrix.app);
			//System.out.println(matrix.aqq);
			//System.out.println(matrix.apq);
			//matrix.show();
			flag = Math.abs(matrix.findMax());
			//System.out.println(matrix.max);
			//System.out.println(flag);
			if(flag < threshold){ iterations = i; break; }
		}
		
		System.out.println("\n\nProgram finish!");
		System.out.println("The matrix after rotation :\n ");
		matrix.show();
		System.out.println("\nThe eigenvalue : ");
		matrix.showDiag();
		System.out.println("\nThe number of iterations : " + iterations);
		
	}
}
