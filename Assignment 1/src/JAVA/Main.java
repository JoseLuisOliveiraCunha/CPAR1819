import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		char c;
		int lin, col, nt=1;
		int op;
		
		long values[] = new long[2];
		int ret;
		

		op=1;
		do {
			System.out.println("\n1. Multiplication");
			System.out.println("2. Line Multiplication");
			System.out.print("Selection?: ");
			Scanner sc = new Scanner(System.in);
			op = sc.nextInt();
			
			if (op == 0)
				break;
			System.out.print("Dimensions: lins cols ? ");
			lin = sc.nextInt();
			col = sc.nextInt();
			sc.close();

			switch (op){
				case 1: 
					OnMult(lin, col);
					break;
				case 2:
					OnMultLine(lin, col);
		
					break;
			}

		}while (op != 0);
		
	}

	public static void OnMult(int m_ar, int m_br) 
	{
		
		SYSTEMTIME Time1, Time2;
		
		char st = new char[100];
		double temp;
		int i, j, k;

		double[] pha = new double[m_ar * m_ar];
		double[] phb = new double[m_ar * m_ar];
		double[] phc = new double[m_ar * m_ar];

		for(i=0; i<m_ar; i++)
			for(j=0; j<m_ar; j++)
				pha[i*m_ar + j] = (double)1.0;



		for(i=0; i<m_br; i++)
			for(j=0; j<m_br; j++)
				phb[i*m_br + j] = (double)(i+1);



		Time1 = clock();

		for(i=0; i<m_ar; i++)
		{	for( j=0; j<m_br; j++)
			{	temp = 0;
				for( k=0; k<m_ar; k++)
				{	
					temp += pha[i*m_ar+k] * phb[k*m_br+j];
				}
				phc[i*m_ar+j]=temp;
			}
		}


		Time2 = clock();
		sprintf(st, "Time: %3.3f seconds\n", (double)(Time2 - Time1) / CLOCKS_PER_SEC);
		System.out.print(st);

		System.out.println("Result matrix: ");
		for(i=0; i<1; i++)
		{	for(j=0; j<min(10,m_br); j++)
				System.out.print(phc[j] + " ");
		}
		System.out.println();		
		
	}


	public static void OnMultLine(int m_ar, int m_br)
	{
		
		
	}


	public static float produtoInterno(float[] v1, float[] v2, int col)
	{
		int i;
		float soma = 0.0f;	

		for(i=0; i<col; i++)
			soma += v1[i]*v2[i];
		
		return(soma);

	}

}
