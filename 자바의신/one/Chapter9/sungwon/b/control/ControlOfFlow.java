package one.Chapter9.sungwon.b.control;

public class ControlOfFlow{
	public static void main(String[] args) {
		ControlOfFlow control=new ControlOfFlow();
		control.ifStatement();
	}
	public void ifStatement() {
		if(true);
		if(true) System.out.println("It's true");
		if(true)
			System.out.println("It's also true.");
		//if(false) System.out.println("It's false"); --> Doesn't works.
	}

}