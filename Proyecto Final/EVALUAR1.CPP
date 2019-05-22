//funcion para obtener tokens de la expresion, reconoce si es simbolo o numero lo que se ingreso
void obtenerToken()
{
	while (expresion[contador] != '\0')
   {
   	if (expresion[contador] == '+')
      {
			cout << "se encontro una suma " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			TipoOperacion = 1;
			break;
		}
		else if (expresion[contador] == '-')
      {
			cout << "Se encontro una resta " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			TipoOperacion = 2;
			break;
		}
		else if (expresion[contador] == '*')
      {
			cout << "Se encontro una multiplicacion " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			TipoOperacion = 3;
			break;   		
		}
		else if (expresion[contador] == '/')
      {
			cout << "Se encontro una division " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			TipoOperacion = 4;
			break;
		}
		else if (expresion[contador] == '(')
      {
			cout << "se encontro un parentesis izq " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			pizq++;
			TipoOperacion = 6;
			break;
		}
		else if (expresion[contador] == ')')
      {
			cout << "se encontro un parentesis der " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			pder++;
			TipoOperacion = 7;
			break;    			
		}

		else if(expresion[contador]>=48 && expresion[contador]<=57||expresion[contador]=='.')
      {
      	contadorLexema = 0;
			punto = 0;
         limpiar_cadenas(lexema, 50);
         TipoOperacion = 123;

         do
         {
         	lexema [contadorLexema] = expresion[contador];
            contador++;
            contadorLexema++;

            if (expresion[contador] == '.')
            {
            	punto++;
            }
         }while(expresion[contador] >= 48 && expresion[contador] <= 57||expresion[contador]=='.');
				

				if (punto > 1) {
					cout << "----------Error ha ingresado una cantidad de punto no valido-----------"<<endl;
					system("pause");
					exit(0);
				}


			break;
		
		}

		else {
			cout << "Error" << endl;
			TipoOperacion = 100;
			system("pause");
			exit(0);
			break;
		}
   }
}
