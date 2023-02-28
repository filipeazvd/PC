//guiao2

// implementar sincronizacao

//java variaveis comecam a 0
//nao colocar extend Thread. Objeto passivo usado por thread.
class Counter{
	
	int value=0;


	//private int value=0;
	//void increment(){value+=1;}
	//int value(){return value;}
}
//representa uma thread. Objeto que usa o counter
class Incrementer extends Thread{
	final int I;
	final Counter c;
	//construtor
	Incrementer(int I, Counter c){this.I = I; this.c = c;}
	public void run(){
		for (int i = 1;i <= I ;++i ) {
			c.value+=1;
			//c.increment();
		}
	}
}
class Main{
	public static void main(String[] args)throws InterruptedException{
		final int N = Integer.parseInt(args[0]);
		final int I = Integer.parseInt(args[1]);
		//criar conter para as threads usarem
		Counter c = new Counter();
		Thread[] a = new Thread[N];
		for (int i = 0; i<N ; ++i ) a[i] = new Incrementer(I,c);
		for (int i = 0; i<N ; ++i ) a[i].start();
		//nao pode ser dentro do ciclo pq senao n occore em concurrencia
		//basicamente sempre que cria uma thread ele espera e nao e isso que queremos
		//t.join();		
		// ciclo que espera que cada thread acabe
		for (int i = 0;i<N ; ++i ) a[i].join();
		System.out.println(c.value);
		//System.out.println(c.value());
	}
}

