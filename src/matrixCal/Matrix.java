package matrixCal;

import java.util.Scanner;

public class Matrix{

	int rowOfMat, colOfMat;
	int orderOfMat;
	double [][] mat;
	double  max;
	double  app,aqq,apq;
	
	Matrix(int order){
		orderOfMat = order;
		this.mat = new double[order][order];
		for(int i = 0; i < order; i++){
			this.mat[i][i] = 1;
		}
	}

	void enterMatrix(){

		boolean ifStop = true;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Plese input your matrix line by line.");
		
		while(ifStop){
			for(int i = 0; i < this.orderOfMat; i++){
				System.out.println("Enter row " + (i+1) + " :");
				for(int j = 0; j < this.orderOfMat; j++){
					this.mat[i][j] = in.nextFloat();
				}
			}
			ifStop = false;
		}
		in = null;
	}

	double findMax(){
		double maxTemp = 0;
		for(int i = 0; i < orderOfMat; i++){
			for(int j = i+1; j < orderOfMat; j++){
				if(i == j){continue;}
				if(Math.abs(this.mat[i][j]) > maxTemp){
					this.rowOfMat = i;
					this.colOfMat = j;
					maxTemp = Math.abs(mat[i][j]);
				}
			}
		}
		this.app = this.mat[rowOfMat][rowOfMat];
		this.aqq = this.mat[colOfMat][colOfMat];
		this.apq = this.mat[rowOfMat][colOfMat];
		this.max = maxTemp;
		return this.max;
	}

	void rotation(double cosVal, double sinVal){
		double temp;
		
		for(int j = 0; j < this.orderOfMat; j++){
			
			temp = this.mat[rowOfMat][j]*cosVal + this.mat[colOfMat][j]*sinVal;
			this.mat[colOfMat][j] = -this.mat[rowOfMat][j]*sinVal + 
					this.mat[colOfMat][j]*cosVal;
			this.mat[rowOfMat][j] = temp;
		}
		
		for(int i = 0; i < this.orderOfMat; i++){
			
			temp = this.mat[i][rowOfMat]*cosVal + this.mat[i][colOfMat]*sinVal;
			this.mat[i][colOfMat] = -this.mat[i][rowOfMat]*sinVal + 
					this.mat[i][colOfMat]*cosVal;
			this.mat[i][rowOfMat] = temp;
		}
 
		this.mat[rowOfMat][rowOfMat] = (app*Math.pow(cosVal,2) +
			aqq*Math.pow(sinVal,2) + 2*apq*sinVal*cosVal);
		this.mat[colOfMat][colOfMat] = (app*Math.pow(sinVal,2) +
			aqq*Math.pow(cosVal,2) - 2*apq*sinVal*cosVal);
		this.mat[rowOfMat][colOfMat] = (apq*(Math.pow(cosVal,2)-
			Math.pow(sinVal,2)) + (aqq - app)*sinVal*cosVal);
		this.mat[colOfMat][rowOfMat] = this.mat[rowOfMat][colOfMat];
	}
	
	void show(){
		for(int i = 0; i < orderOfMat; i++){
			for(int j = 0; j< orderOfMat; j++){
				System.out.printf("%20.18f\t",this.mat[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	void showDiag(){
		for(int i = 0; i < orderOfMat; i++){
			System.out.printf("%20.10f\t", this.mat[i][i]);
		}
	}
	
}
