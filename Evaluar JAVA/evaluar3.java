
public class GlobalMembers
{
	// funcion Expresion()
	public static arbolexp E()
	{
		arbolexp izq = null;
		arbolexp der = null;
		int operador;

		izq = T();
		if (izq == null)
		{
			return null;
		}
		else
		{
			Toma_Token();
			if (TipoOperacion == 1 || TipoOperacion == 2)
			{
				operador = TipoOperacion;
				der = E();

			 if (der == null)
			 {
				 DestruyeArbol(izq);
				return null;
			 }
					else
					{
						return CrearArbol(izq, der, operador, 0);
					}
			}
				else
				{
					if (TipoOperacion == 100)
					{
						DestruyeArbol(izq);
						return null;
					}
					else
					{
						TokenAnterior = true;
						return izq;
					}
				}
		}
	}

	//funcion que grafica el arbol
	public static void DiagramaArbol(arbolexp raizptr, int Nivel)
	{
		if (pizq != pder)
		{
			System.out.print("\n\n");
			System.out.print("Error cantidad de parentesis no valida");
			System.out.print("\n");
			system("pause");
			System.exit(0);
		}

		if (raizptr != null)
		{
			DiagramaArbol(raizptr.der, Nivel + 1);
			for (int i = 0; i < Nivel; i++)
			{
				System.out.print("    ");
			}
			switch (raizptr.info)
			{
				case 1:
					System.out.print("+");
					break;
				case 2:
					System.out.print("-");
					break;
				case 3:
					System.out.print("*");
					break;
				case 4:
					System.out.print("/");
					break;
				default:
					System.out.printf("%f", raizptr.dato);
			}
			System.out.print("\n\n\n");
			DiagramaArbol(raizptr.izq, Nivel + 1);
		}
	}

}