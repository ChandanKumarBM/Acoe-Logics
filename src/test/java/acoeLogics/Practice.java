package acoeLogics;

public class Practice {
	public static void main(String[] args) {
		String adharNumber="4444 5555 6666".trim();
    	String adharLastNum=adharNumber.substring(adharNumber.length()-4);
    	System.out.println(adharLastNum);
	}

}
