
public class game {
	private final int SIZE = 30;//��ά��Ϸ����Ĵ�С,��SIZE*SIZE������  
    private final int CELL_Size =10;//ÿ����ʽ�ı߳���Java����ϵ��λ��  
    private boolean[][] table = new boolean[SIZE][SIZE];  
    private int[][] neighbors = new int[SIZE][SIZE];  
    public void settable(boolean x,int i,int j)
    {
    	table[i][j]=x;
    	
    }
    public void settable1()//�����ֵ
    {
    	for(int i=0;i<30;i++)
			for(int j=0;j<30;j++)
			{
				table[i][j]=Math.random()>0.5?true:false;
			}
    }
    public boolean gettable(int i,int j)
    {
    	return table[i][j];
    }
    public int getneighbor(int i,int j)
    {
    	return neighbors[i][j];
    }
    public void getNeighbors() //�õ�ϸ����Χ��ϸ����
    {   
        for (int r = 0; r < SIZE; r++){//row  
            for (int c = 0; c < SIZE; c++){//col  
                if(r-1 >= 0 && c-1 >= 0   && table[r-1][c-1] )neighbors[r][c]++;  
                if(r-1 >= 0     && table[r-1][c])             neighbors[r][c]++;  
                if(r-1 >= 0 && c+1 < SIZE && table[r-1][c+1])neighbors[r][c]++;  
                if(c-1 >= 0   && table[r][c-1]) neighbors[r][c]++;  
                if(c+1 < SIZE && table[r][c+1]) neighbors[r][c]++;  
                if(r+1 < SIZE && table[r+1][c]) neighbors[r][c]++;  
                if(r+1 < SIZE && c+1 < SIZE && table[r+1][c+1])    neighbors[r][c]++;  
                if(r+1 < SIZE && c-1 >=0 && table[r+1][c-1])       neighbors[r][c]++;  
            }  
}
}
   
    public void nextWorld() //�õ�ϸ����һ��
    {  
        for (int r = 0; r < SIZE; r++){
            for (int c = 0; c < SIZE; c++){
                if (neighbors[r][c] == 3){  
                    table[r][c] = true;  
                } 
                if (neighbors[r][c] < 2)  
                    table[r][c] = false;   
                if (neighbors[r][c] >= 4)  
                    table[r][c] = false;                   
                neighbors[r][c] = 0;                  
            }             
        }  
    }  



}