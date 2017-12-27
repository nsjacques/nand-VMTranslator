/*

VMTranslator.java

Author: Noah Jacques
Date created: 2017/12/27
Date modified: 2017/12/27

Compiler backend VM translator for the Hack Assembly Language and VM language
	described in Elements of Computing Systems by Nisan, Schocken


*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
//io.PrintStream??

public class VMTranslator{

	/*
	Argument is either the name of a directory containing .vm files or of a .vm file
	*/
	public static void main(String[] args){

		//Determine if it's a directory or a .vm file
		//If directory make list of all vm files
		//If vm file then list is size one of that vm file
		//Debatable whether or not to keep a list for single elements?

		//Create parser for each vm file. One at a time or all at once? Multi-thread this if >1?
		//Parse them all into command lists and write code for them all? Forget how this works.

		FilenameFilter vmFilter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name){
				//Do I need to make sure the last index of "." is greater than 0?
				if (name.substring(name.lastIndexOf(".")).equals(".vm")){
					return true;
				}
				return false;
			}
		};

		File input = new File(args[0]); //Does this compiling guarantee either direc. or file?
				//if so should I add exception for file not found? ya
		if (input.isFile()){
			Parser parser = new Parser(input);
		}
		else{
			File[] listOfFiles = input.listFiles(vmFilter);
			for (File file : listOfFiles){
				Parser parser = new Parser(file);
			}
		}

		System.out.println("Success");

		//CodeWriter cw = new CodeWriter(args[0] + ".asm");

	}

}