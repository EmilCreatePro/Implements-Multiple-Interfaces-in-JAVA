interface FactoriPrimi
{
	public void despartFactori(int numar);
}

interface CMMDC
{
	public void calculareDivizor(int n1, int n2);
}

class Operatii implements FactoriPrimi,CMMDC
{
	private String afisare = new String("");
	private int[] factori = new int[20];
	
	public void despartFactori(int numar)
	{	
		
		int putere = 0, buffer = numar, indiceFactor = 0, primu = 0;
		afisare += numar + " = ";
		for(int i = 2; i <= buffer/2; i++)
		{
			if(numar%i==0)
			{
				factori[indiceFactor++] = i;
				while(numar%i==0) 
					{
						numar /= i;
						putere++;
					}
				if(primu == 0)
					{
						afisare += factori[indiceFactor - 1] + "^" + putere;
						primu = 1;
					}
					else afisare += " * " + factori[indiceFactor - 1] + "^" + putere ;
				putere = 0;
			}
		}
	}
	
	private int numar1, numar2, cmmdc;
	
	public void calculareDivizor(int n1, int n2)
	{
		if(n1 > n2)
		{	
			numar1 = n1;
			numar2 = n2;
		}
		else 
		{
			numar1 = n2;
			numar2 = n1;
		}
		for(int i = numar2; i >= 0; i--)
		if((numar1%i == 0) && (numar2%i == 0))
			{
				cmmdc = i;
				break;
			}
	}
	
	public String toString()
	{
		String rez = "Cel mai mare divizor comun intre " + numar1 +" si " + numar2 + " este: " + cmmdc;
		rez += "\n" + afisare;
		return rez;
	}
}

public class Program
{
	public static void main(String arg[])
	{
		Operatii nr = new Operatii();
		
		nr.despartFactori(72);
		nr.calculareDivizor(36, 84);
		System.out.println(nr);
	}
	
}
