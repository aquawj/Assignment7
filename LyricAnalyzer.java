/*
Since you have not learned File class yet, I have written the main method for you
to test your written code. Please don't forget to change the file path
"/Users/luqifei/IdeaProjects/untitled/Paint/test1.txt" to test 4 test txt
files. The 4 test txt files are already saved in assignment 7 zip. The deadline
for this assignment is 15 Mach 2017.
*/

package assignment7;

import java.io.*;
import java.util.*;

public class LyricAnalyzer {

	public static void add(HashMap<String, ArrayList<Integer>> map, String lyricWord, int wordPosition) {

		if (map.containsKey(lyricWord)) {
			map.get(lyricWord).add(wordPosition);
		} else {
			ArrayList<Integer> arrList = new ArrayList<Integer>();
			arrList.add(wordPosition);
			map.put(lyricWord, arrList);
		}

	}

	public static void displayWords(HashMap<String, ArrayList<Integer>> map) {

		Set<String> wordSet = map.keySet();
		for (String word : wordSet) {
			System.out.println(word + " " + map.get(word));
		}
	}

	public static void displayLyrics(HashMap<String, ArrayList<Integer>> map) {

		// Complete this method.
	}

	public static int count(HashMap<String, ArrayList<Integer>> map) {

		return map.size();
	}

	public static String mostFrequentWord(HashMap<String, ArrayList<Integer>> map) {
		/*
		Set<String> wordSet = map.keySet();

		for(String word:wordSet){
			int positionNums=map.get(word).size();
		}*/
		return "not done!";
	}

	public static void main(String[] args) throws IOException {
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		int position = 1; // word position index start from 1

		String pathname = "..\test\test1.txt";
		File f = new File(pathname);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		String line = "";
		while (true) {
			line = br.readLine();
			if (line == null || line.length() == 0) {
				break;
			}
			String[] arr = line.trim().split(" ");
			for (int i = 0; i < arr.length; i++) {
				if (i != arr.length - 1) {
					add(map, arr[i].toUpperCase(), position++);
				} else {
					add(map, arr[i].toUpperCase(), (-1) * position);
					position++;
				}
			}
		}
		br.close();

		displayLyrics(map);
		displayWords(map);
		System.out.println();
		System.out.println("The number of unique words in the lyric is: " + count(map));
		System.out.println();
		System.out.println("Most frequent word: " + mostFrequentWord(map));
	}

}
