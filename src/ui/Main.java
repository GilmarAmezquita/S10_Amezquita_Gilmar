package ui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Tower;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/Hanoi_output.txt"));
		int lines = Integer.parseInt(br.readLine());
		for(int i = 0; i<lines; i++) {
			int disks = Integer.parseInt(br.readLine());
			Tower originSpire = new Tower(1);
			Tower tempSpire = new Tower(2);
			Tower destinySpire = new Tower(3);
			originSpire.setDisks(disks);
			bw.write(originSpire.getDisks()+" "+tempSpire.getDisks()+" "+destinySpire.getDisks());
			bw.newLine();
			solveHanoi(disks, originSpire, tempSpire, destinySpire, bw);
			if(i <lines-1) {
				bw.newLine();
			}
		}
		br.close();
		bw.close();
	}
	
	public static void solveHanoi(int disks, Tower originSpire, Tower tempSpire, Tower destinySpire, BufferedWriter bw) throws IOException {
		if(disks == 1) {
			originSpire.passDisk(destinySpire);
			bw.write(getHanoiState(originSpire, tempSpire, destinySpire));
			return;
		}
		solveHanoi(disks-1, originSpire, destinySpire, tempSpire, bw);
		originSpire.passDisk(destinySpire);
		bw.write(getHanoiState(originSpire, tempSpire, destinySpire));
		solveHanoi(disks-1, tempSpire, originSpire, destinySpire, bw);
	}
	
	public static String getHanoiState(Tower originSpire, Tower tempSpire, Tower destinySpire) {
		Tower[] towers = new Tower[3];
		towers[originSpire.getNumber()-1] = originSpire;
		towers[tempSpire.getNumber()-1] = tempSpire;
		towers[destinySpire.getNumber()-1] = destinySpire;
		return towers[0].getDisks()+" "+towers[1].getDisks()+" "+towers[2].getDisks()+"\n";
	}
}
