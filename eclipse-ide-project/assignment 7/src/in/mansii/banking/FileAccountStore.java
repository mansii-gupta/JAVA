package in.mansii.banking;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileAccountStore {
	
	final String filePath="C:\\current-training-name\\JAVA\\my-work\\mansii-gupta\\JAVA\\eclipse-ide-project\\assignment 7\\src\\in\\mansii\\banking\\DataStorage.txt";
	FileWriter writer;
	FileReader reader;
	

	public void createFile() {
		
		try {
			writer=new FileWriter(filePath,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addAccountDetails(BankAccount account) {
		
		try {
			writer.write(String.format("%d\t%s\t%f\n", account.getAccountNumber(),account.getName(),account.getBalance()));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showInfo() throws IOException {
		
		try {
			reader=new FileReader(filePath);
			int i;
			while ((i=reader.read()) != -1) {
				System.out.print((char)i);			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
