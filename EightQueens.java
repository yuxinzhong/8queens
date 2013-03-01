
public class EightQueens {

	/**
	 * @param args
	 */
	
	static int solutions=0;
	static void calc(int[] array,int level){
		if (level==8){
			printChess(array);
		}
		else{
			boolean p[]=new boolean[8];
			for (int i = 0; i < p.length; i++) {
				p[i]=true;
			}
			
			for (int i = 0; i < array.length; i++) {
				p[array[i]]=false;
				int a=array[i]+level-i;
				int b=array[i]-level+i;
				if(a<=7) p[a]=false;
				if(b>=0) p[b]=false;
			}
			
			for (int i = 0; i < p.length; i++) {
				if(p[i]){
					int[] array_next_level=new int[array.length+1];
					for (int j = 0; j < array.length; j++) {
						array_next_level[j]=array[j];
					}
					array_next_level[array_next_level.length-1]=i;
					calc(array_next_level,level+1);
				}
			}
		}
		
	}
	
	static void printChess(int[] array){
		for(int i=0;i<8;i++){
			for (int j = 0; j < array[i]; j++) {
				System.out.print("[ ]");
			}
			System.out.print("[X]");
			for (int j = array[i]+1; j < 8; j++) {
				System.out.print("[ ]");			
			}
			System.out.println();
			//System.out.println(array[i]);
		}
		System.out.println("===============");
		solutions++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 8; i++) {
			int[] array = new int[1];
			array[0]=i;
			int level=0;
			calc(array, level+1);		
		}
		System.out.println(solutions);
	}

}
