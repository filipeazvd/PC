/*
// ver como threads funcionam(basico)

class MyThread extends Thread{
	public void run(){
			for (int i = 0;i<10 ;i++ ) 
				
			
			System.out.println("Print na thread ");
	}
}




class MyRunnable implements Runnable{


	int i;

	public void run(){
		for (int i=0;i<10 ;i++) 
			System.out.println("Print na thread2");
	

	}

class MyRunnable implements Runnable{


	

	public void run(){

		try {
		//bloqueia o programa por 1 seg
		Thread.sleep(1000);
		System.out.println("Print na thread2");
		}catch(InterruptedException ignored){}

	}
			
		


}


//throws InterruptedException para deixar a exception acontecer
class Main{
	public static void main(String[] args) throws InterruptedException{

		MyThread t = new MyThread();
		//nunca fazer t.run() !!!!
		//meter uma thread a correr
		t.start();



		//MyRunnable r = new MyRunnable();
		//Thread t2 = new Thread(r);
		//t2.start();



		//assim nao se partilha runnable entre threads
		Thread t2 = new Thread(new MyRunnable());
		t2.start();
		//corre em paralelo com a thread
		System.out.println("Print no main");
		//faz com que o que aconteca abaixo aconteca depois da thread terminar
		//normalmente uma exceçao. Temos de tratar dela ou deixa-la acontecer. Em vez de usar trycatch print para dizer que acontece, declaramos e tratamos dela
		t2.join();
		//tenho que terminar thread a thread se quiser dar print no fim
		t.join();
		//quero correr depois da thread terminar. Bloquear ate a thread terminar para dar print
		System.out.println("Print no main no final");

	}
}


*/
//class para threads
class Printer extends Thread{


	final int I;
	final int N;

	//construtor
	Printer(int I, int n){this.I = I; this.n = n;}

	public void run(){
		for (int i = 0;i <= I ;i++ ) {
			System.out.println("Thread "+ N + "escreve" + i );
		

		}
		
			
		


	}

}

class Main{

	public static void main(String[] args)throws InterruptedException{

		final int N = Integer.parseInt(args[0]);
		final int I = Integer.parseInt(args[1]);

		Thread[] a = new Thread[N];
		



		for (int i = 0; i<N ; ++i ) {
			
			
			a[i] = new Printer(I,i+1);
			a[i].start();
			//nao pode ser dentro do ciclo pq senao n occore em concurrencia
			//basicamente sempre que cria uma thread ele espera e nao e isso que queremos
			//t.join();
		
		}
		// ciclo que espera que cada thread acabe
		for (int i = 0;i<N ; ++i ) {
			a[i].join();
		}

	}

}


