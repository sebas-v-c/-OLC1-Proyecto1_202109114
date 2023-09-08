// Ya salio compi1 :)

void main ( ){
	int b = 2;
	int a =1;
	int c = -5.03;
	int var1 = 5+8*9;
	if (b > a){
		Console.Write("b mayor que a");
	}else if(a == b){
		Console.Write("a y b son iguales");
	}
	void DefinirGlobales(){
		string reporte1 = "Reporte 1";
		double pe1 = 0.8;
		double pe2 = 0.5;
		double pe3 = 0.2;
		double po1 = ${ NewValor, "ejemploJSON.json", "valor1"};
		double po2 = ${ NewValor, "ejemploJSON.json", "valor2"};
		string vart = "Valor Obtenido";
		string var2 = "Valor Esperado clase 1";
		string var22 = "Valor Obtenido clase 2";
		string var3 = "Valore Esperado clase 3";
	}
	void GraficaBarras(){
		string Titulo= reporte1;
		string [] Ejex= { "Probabilidad 1", "Probabilidad 1", vart, var2, var22, var3};
		double [] Valores= { pe1, po1, pe2, po2, pe3, ${ NewValor, "ejemploJSON.json", "valor2"} };
		string TituloX= "Atributo";
		string TituloY= "Puntaje";
	}
	while(a < 10){
		Console.Write("el valor de a es: " + a);
	}

	switch(a){
    	case 1:
    		Console.Write("a es 1");
    		a++;
    		break;
    	case 2:
    		Console.Write("a es 2");
    		a = c + a;
    		break;
    	default:
    	    Console.Write("sepa pvtas que es a");
    }

    	do{
    		int b = c;
    		Console.Write(b);
    	}while(a < 10);

}