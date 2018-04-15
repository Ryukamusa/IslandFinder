package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IslandFinder {

	public int[][][] find(int[][] arr) {
		int code = 2;
		Map<Integer, List<int[]>> PreReturnable = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int val = arr[i][j];
				if (val != 1) {
					continue;					
				} else {
					Integer surroundIsland = aroundIsland(arr, i, j);
					// previous line checks whether the current position has any surrounding land
					// if so, which is the numerical code of this land
					if (surroundIsland == null) {
						PreReturnable.put(code, new ArrayList<>());
						PreReturnable.get(code).add(new int[] { i, j });
						arr[i][j] = code;
						putpositions(arr, i, j, code, PreReturnable);
						code++;
					} else {
						Integer islandCode = surroundIsland;
						arr[i][j] = islandCode;
						PreReturnable.get(islandCode).add(new int[] { i, j });
						putpositions(arr, i, j, islandCode, PreReturnable);
					}
					
				}
				

			}
		}

		int[][][] finalReturnable = standardizeMatrix(PreReturnable);

		return finalReturnable;

	}

	private int[][][] standardizeMatrix(Map<Integer, List<int[]>> preReturnable) {
		List<int[][]> finalReturn = new ArrayList<int[][]>();
		for (Integer iterable_element : preReturnable.keySet()) {
			List<int[]> novaIlha = preReturnable.get(iterable_element);
			if(novaIlha.size()<2) {
				// ignorar ilhas que são representadas por apenas um elemento na matriz inicial
				continue;
			}
			int[][] arr = new int[0][0];
			int[][] o = novaIlha.toArray(arr);
			finalReturn.add(o);
		}
		int[][][] ret = new int[0][0][0];
		return finalReturn.toArray(ret);
	}

	private void putpositions(int[][] arr, int i, int j, int code, Map<Integer, List<int[]>> preReturnable) {
		if (i > 0) {
			int newI = i - 1;
			int temp = arr[newI][j];
			if (temp == 1) {
				arr[newI][j] = code;
				preReturnable.get(code).add(new int[] { newI, j });
			}
		}
		if (i < arr.length - 1) {
			int newI = i + 1;
			int temp = arr[newI][j];
			if (temp == 1) {
				arr[newI][j] = code;
				preReturnable.get(code).add(new int[] { newI, j });
			}
		}
		if (j > 0) {
			int newJ = j - 1;
			int temp = arr[i][newJ];
			if (temp == 1) {
				arr[i][newJ] = code;
				preReturnable.get(code).add(new int[] { i, newJ });
			}
		}
		if (j < arr[0].length - 1) {
			int newJ = j + 1;
			int temp = arr[i][newJ];
			if (temp == 1) {
				arr[i][newJ] = code;
				preReturnable.get(code).add(new int[] { i, newJ });
			}
		}
	}

	public Integer aroundIsland(int[][] arr, int i, int j) {
		Integer teste = null;
		if (i > 0) {
			int temp = arr[i - 1][j];
			if (temp > 1) {
				teste = temp;
			}
		}
		if (i < arr.length - 1) {
			int temp = arr[i + 1][j];
			if (temp > 1) {
				teste = temp;
			}
		}
		if (j > 0) {
			int temp = arr[i][j - 1];
			if (temp > 1) {
				teste = temp;
			}
		}
		if (j < arr[0].length - 1) {
			int temp = arr[i][j + 1];
			if (temp > 1) {
				teste = temp;
			}
		}

		return teste;
	}

}
