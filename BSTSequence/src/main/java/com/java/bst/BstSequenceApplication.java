package com.java.bst;

import java.util.LinkedList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.bst.controller.BSTController;
import com.java.bst.model.TreeNode;

@SpringBootApplication
public class BstSequenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BstSequenceApplication.class, args);
		BSTController obj=new BSTController();
		TreeNode head;
		Scanner kb=new Scanner(System.in);
		int n=kb.nextInt();
		head=obj.insert(null, kb.nextLong());
		while(n-- > 1) {
			obj.insert(head, kb.nextLong());
		}
		
		 for (LinkedList<Long> l:obj.inputSequencesForBst(head)) {
	            System.out.println(l);
	}

}
}
