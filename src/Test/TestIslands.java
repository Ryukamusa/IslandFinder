package Test;

import Model.IslandFinder;

public class TestIslands {

	public static void main(String[] args) {
		int[][] array = {{0,0,0,1,0,0,1,1},
				 {0,0,1,1,1,0,1,1},
				 {0,0,0,0,0,0,1,0},
				 {0,0,0,1,0,0,1,1},
				 {0,0,0,1,0,0,1,1}};
		
		IslandFinder Ifnd = new IslandFinder();

		
		int[][][] tst = Ifnd.find(array);
		int cont = 1;
		for (int[][] is : tst) {
			System.out.println("============");
			System.out.println("Island number "+cont);
			for (int[] is2 : is) {
				System.out.println("[ "+is2[0]+","+is2[1]+"]");
			}
			cont++;
		}
	
	}

}
