//Created By: Evan Williams
//For: CSE 274 HW-1
public class Word {
	private int count;
	private String word;
	Word(){
		this.word = "";
		this.count = 0;
	}
	
	Word(String value, int count){
		this.word = value;
		this.count = count;
	}
	
	public void setWord(String input) {
		this.word = input;
	}
	
	public void setCount(int input) {
		this.count = input;
	}
	
	public String getWord() {
		return this.word;
	}
	
	public int getCount() {
		return this.count;
	}
}
