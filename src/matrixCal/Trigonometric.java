package matrixCal;

public class Trigonometric {
	
	double tan2Theta;
	double sinTheta;
	double cosTheta;

	Trigonometric(double app, double aqq, double apq){
		tan2Theta = (2*apq)/(app-aqq);
	}
	
	Trigonometric(){}
	
	void trigonometric(double app, double aqq, double apq){
		if(app==aqq){
			tan2Theta = 1;
			cosTheta = sinTheta = Math.sqrt(2)/2;
		}else{
				tan2Theta = (2*apq)/(app-aqq);
				cosTheta = Math.sqrt(0.5*(1+1/Math.sqrt(1+Math.pow(tan2Theta,2))));
				sinTheta = Math.sqrt(1 - Math.pow(cosTheta, 2));
				if(tan2Theta < 0){
					sinTheta = -sinTheta;
				}
		}
	}
	
	void show(){
		System.out.println(this.tan2Theta);
		System.out.println(Math.pow(this.sinTheta,2));
		System.out.println(Math.pow(this.cosTheta,2));
	}
}
