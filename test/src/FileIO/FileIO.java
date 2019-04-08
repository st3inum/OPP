/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileIO;

import java.util.*;
import java.io.*;
public class FileIO {
	public static void main(String[] args) throws Exception {
		File in = new File("input.txt");
		FileWriter out = new FileWriter("output.txt");
		String a;
		Scanner scan = new Scanner(in);
		Vector<String> v = new Vector();
		while (scan.hasNext()) {
			a = scan.next();
			v.add(a);
		}
		Collections.sort(v);
		int count = 1, uniqe = 1;
		for (int i = 0; i + 1 < v.size(); i++) {
			if (!v.get(i).equals(v.get(i + 1))) {
				out.write(v.get(i) + " " + count + "\n");
				count = 1;
				uniqe++;
			} else count++;
		}
		out.write(v.get(v.size() - 1) + " " + count + "\n");
		out.write("\n\ntotal word = " + v.size() + "\n");
		out.write("total unique word = " + uniqe + "\n");
		out.close();

	}
}