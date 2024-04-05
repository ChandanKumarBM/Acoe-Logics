package acoeLogics;

public class Webbook {
	public static void main(String[] args) {
		String taskCount="2";
		String endpoints="1.1.2 , 1.2.2.1";
		String[] str= endpoints.split(",");
		for (String string : str) {
             String endpoint=string.replace(".","").trim();
             System.out.println(endpoint);

		}


	}
}
