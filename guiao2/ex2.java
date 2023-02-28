


public class NotEnoughFundsException extends Exception{
	//criar um construtor para customizar excecao
	public NotEnoughFundsException(){}
	public NotEnoughFundsException(String msg){
		super(msg);
	}

}

public class InvalidAccountException extends Exception{
	
	public InvalidAccountException(){}
	public InvalidAccountException(String msg){
		super(msg);
	}


}

class Banco{

	private class Account{

		private int balance;
		public int balance(){
			return balance;
		}

		public void deposit(int val){
			return balance += val;
		}

		public void withdraw(int val)throws NotEnoughFundsException{
			if (val >= val ){ 
				balance -= val;
			} else throws new NotEnoughFundsException("Sem fundos suficientes ");
		}


	}

	public Account[] accounts;
	private Account get(int id) throws InvalidAccountException{
		if (id <0 || > accounts.length) throws InvalidAccountException();
		return accounts[id];

	}

	//criar contas para o banco, para cada i cria uma acc
	public Bank(int n){
		accounts = new account[n];
		for(int i = 0; i<accounts.length;i++) account[i] = new Account();
	}




	

}



class Main{

	public void main(String[] args)throws InterruptedException{

		contas = new int[5];


	}
}