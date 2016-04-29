package proyecto;

/**
 * Saved as GaussJordan.java
 * @author Kevin Oswaldo Cabrera Navarro A01227157
 * @author Mark Octavio Rivera Acosta A01630250
 * 
 * Started in April 6th, 2016
 * Last modified in April 25th, 2016
 */

import java.io.*;
import java.util.StringTokenizer;

class GaussJordan{

	private double i1, i2;

	/**
	 * swap()
	 * swap row i with row k
	 * pre: A[i][q]==A[k][q]==0 for 1<=q<j
	 * @param a 
	 * @param i
	 * @param k
	 * @param j
	 */
	static void swap(double[][] a, int i, int k, int j){
		int m = a[0].length - 1;
		double temp;
		for(int q=j; q<=m; q++){
			temp = a[i][q];
			a[i][q] = a[k][q];
			a[k][q] = temp;
		}
	}

	/**
	 * divide()
	 * divide row i by A[i][j]
	 * pre: A[i][j]!=0, A[i][q]==0 for 1<=q<j
	 * post: A[i][j]==1;
	 * @param a
	 * @param i
	 * @param j
	 */
	static void divide(double[][] a, int i, int j){
		int m = a[0].length - 1;
		for(int q=j+1; q<=m; q++) a[i][q] /= a[i][j];
		a[i][j] = 1;
	}

	/**
	 * eliminate()
	 * subtract an appropriate multiple of row i from every other row
	 * pre: A[i][j]==1, A[i][q]==0 for 1<=q<j
	 * post: A[p][j]==0 for p!=i
	 * @param a
	 * @param i
	 * @param j
	 */
	static void eliminate(double[][] a, int i, int j){
		int n = a.length - 1;
		int m = a[0].length - 1;
		for(int p=1; p<=n; p++){
			if( p!=i && a[p][j]!=0 ){
				for(int q=j+1; q<=m; q++){
					a[p][q] -= a[p][j]*a[i][q];
				}
				a[p][j] = 0;
			}
		}
	}

	/**
	 * printMatrix()
	 * print the present state of Matrix A to file out
	 * @param out receive the file where the matrix will be written on
	 * @param a receives the present state of the matrix
	 */
	static void printMatrix(PrintWriter out, double[][] a){
		int n = a.length - 1;
		int m = a[0].length - 1;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++) out.print(a[i][j] + "  ");
			out.println();
		}
		out.println();
		out.println();
	}
	
	/**
	 * read the matrix
	 * get the value for the electrical currents
	 * @throws IOException
	 */
	public void leeMatrix() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("outfile"));
		String valor_i1, valor_i2;
		this.i1 = this.i2 = 0;
		valor_i1 = valor_i2 = "";

		try {
			String sCurrentLine = br.readLine();

			for (int i = 0; i < 20; i++) {
				sCurrentLine = br.readLine();
				if (i == 15) {
					valor_i1 = sCurrentLine;
				}if(i == 16){
					valor_i2 = sCurrentLine;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		StringTokenizer string = new StringTokenizer(valor_i1);
		while(string.hasMoreTokens()){

			valor_i1 = string.nextToken(" ");
		}
		StringTokenizer string2 = new StringTokenizer(valor_i2);
		while(string2.hasMoreTokens()){

			valor_i2 = string2.nextToken(" ");
		}
		i1 = Double.parseDouble(valor_i1);
		i2 = Double.parseDouble(valor_i2);


	}

	/**
	 * matrices()
	 * read input file, initialize matrix, perform Gauss-Jordan Elimination,
	 * and write resulting matrices to output file
	 * @param fileReader read the matrix
	 * @param fileWriter write the solution of the matrix by Gauss-Jordan
	 * @throws IOException
	 */
	public void matrices(FileReader fileReader, FileWriter fileWriter) throws IOException{
		int n, m, i, j, k;
		String line;
		StringTokenizer st;

		// check command line arguments, open input and output files
		BufferedReader in = new BufferedReader(fileReader);
		PrintWriter out = new PrintWriter(fileWriter);


		// read first line of input file
		line = in.readLine();
		st = new StringTokenizer(line);
		n = 2;
		m = 3;

		// declare A to be of size (n+1)x(m+1) and do not use index 0
		double[][] A = new double[n+1][m+1];

		// read next n lines of input file and initialize array A
		for(i=1; i<=n; i++){
			line = in.readLine();
			st = new StringTokenizer(line);
			for(j=1; j<=m; j++){
				A[i][j] = Double.parseDouble(st.nextToken());
			}
		}

		// close input file
		in.close();

		// print array A to output file
		printMatrix(out, A);

		// perform Gauss-Jordan Elimination algorithm
		i = 1;
		j = 1;
		while( i<=n && j<=m ){

			//look for a non-zero entry in col j at or below row i
			k = i;
			while( k<=n && A[k][j]==0 ) k++;

			// if such an entry is found at row k
			if( k<=n ){

				//  if k is not i, then swap row i with row k
				if( k!=i ) {
					swap(A, i, k, j);
					printMatrix(out, A);
				}

				// if A[i][j] is not 1, then divide row i by A[i][j]
				if( A[i][j]!=1 ){
					divide(A, i, j);
					printMatrix(out, A);
				}

				// eliminate all other non-zero entries from col j by subtracting from each
				// row (other than i) an appropriate multiple of row i
				eliminate(A, i, j);
				printMatrix(out, A);
				i++;
			}
			j++;
		}

		// print rank to output file
		out.println("rank = " + (i-1));

		// close output file
		out.close();
		leeMatrix();
	}
	/**
	 * Return the value of the first electrical current  
	 * @return i1
	 */
	public double geti1(){
		return this.i1;
	}
	/**
	 * Return the value of the second electrical current  
	 * @return i2
	 */
	public double geti2(){
		return this.i2;
	}
}