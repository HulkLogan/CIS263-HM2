package mmPack;

public class Main {
	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int MatrixChainOrder(int p[], int n)
    {
        /* For simplicity of the program, one extra row and one
        extra column are allocated in m[][].  0th row and 0th
        column of m[][] are not used */
        int m[][] = new int[n][n];
      
        int i, j, k, L, q;
 
        /* m[i,j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */
        String output = "";
        for(int x = 0; x < m.length; x++){
        	for(int y = 0; y < m.length; y++){
        		output = output.concat("{");
        		output = output.concat(Integer.toString(m[x][y]));
        		output = output.concat("}");
        		if(y == m.length-1){
        			output = output.concat("\n");
        		}
        	}
        }
        System.out.println(output);
        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;
        
        output = "";
        for(int x = 0; x < m.length; x++){
        	for(int y = 0; y < m.length; y++){
        		output = output.concat("{");
        		output = output.concat(Integer.toString(m[x][y]));
        		output = output.concat("}");
        		if(y == m.length-1){
        			output = output.concat("\n");
        		}
        	}
        }
        System.out.println(output);
        // L is chain length.
        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                if(j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
	                    output = "";
	                    for(int x = 0; x < m.length; x++){
	                    	for(int y = 0; y < m.length; y++){
	                    		output = output.concat("{");
	                    		output = output.concat(Integer.toString(m[x][y]));
	                    		output = output.concat("}");
	                    		if(y == m.length-1){
	                    			output = output.concat("\n");
	                    		}
	                    	}
	                    }
	                    System.out.println(output);
                }
            }
        }
        output = "";
        for(int x = 0; x < m.length; x++){
        	for(int y = 0; y < m.length; y++){
        		output = output.concat("{");
        		output = output.concat(Integer.toString(m[x][y]));
        		output = output.concat("}");
        		if(y == m.length-1){
        			output = output.concat("\n");
        		}
        	}
        }
        System.out.println(output);
        return m[1][n-1];
    }
 
    // Driver program to test above function
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 2, 3, 4};
        int size = arr.length;
 
        System.out.println("Minimum number of multiplications is "+
                           MatrixChainOrder(arr, size));
    }
}