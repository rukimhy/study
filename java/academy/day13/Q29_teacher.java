package day13;

class pencil
{
	String pencilcolor;
	
	String getColor()
	{
		return pencilcolor;
	}
	void setColor(String color)
	{
		pencilcolor = color;
	}
	
	public void pencilmake()
	{
		System.out.println(pencilcolor+"색 연필로 적습니다.");
	}
}
class Eraser
{
	String EraserFrom;
	String getForm()
	{
		return EraserFrom;
	}
	void setForm(String form)
	{
		EraserFrom = form;
	}
	public void Erasermake() 
	{
		System.out.println("지우개를 "+EraserFrom+"의 제품으로 지웁니다.");
	}
}
class pen 
{
	String penColor;
	String penFrom;
	
	
	String getColor()
	{
		return penColor;
	}
	void setColor(String color)
	{
		penColor = color;
	}
	String getForm()
	{
		return penFrom;
	}
	void setForm(String form)
	{
		penFrom = form;
	}
	public void penmake()
	{
		System.out.println("펜을 "+penFrom+" 제품의 "+penColor+"색으로 씁니다.");
	}
}

class piltong
{
	pencil p1;
	pencil p2;
}


public class Q29_teacher{

	public static void main(String[] args) 
	{
		
		piltong pt = new piltong();
		pencil pencil1 = new pencil();
		pencil pencil2 = new pencil();
		pencil pencil3 = new pencil();
		pencil pencil4 = new pencil();

		pencil1.setColor("빨간");
		pencil2.setColor("파란");
		pencil3.setColor("주황");
		pencil4.setColor("노란");

		pt.p1 = pencil2;
		pt.p2 = pencil4;
		
//		pencil1.pencilcolor = "빨간";
//		pencil2.pencilcolor = "파란";
//		pencil3.pencilcolor = "주황";
//		pencil4.pencilcolor = "노란";	
		
		Eraser Eraser1 = new Eraser();
		Eraser Eraser2 = new Eraser();

		Eraser1.EraserFrom = "잠자리";
		Eraser2.EraserFrom = "모닝글로리";	
		
		pen pen1 = new pen();
		pen pen2 = new pen();
		pen pen3 = new pen();

		pen1.penColor = "검정";
		pen2.penColor = "초록";
		pen3.penColor = "베이비블루";
		
		pen1.penFrom = "모나미";
		pen2.penFrom = "제트스트림";
		pen3.penFrom = "워터맨";
		
		pencil1.pencilmake();
		pencil2.pencilmake();
		pencil3.pencilmake();
		pencil4.pencilmake();
		
		Eraser1.Erasermake();
		Eraser2.Erasermake();
		
		pen1.penmake();
		pen2.penmake();
		pen3.penmake();
	
	}
}
