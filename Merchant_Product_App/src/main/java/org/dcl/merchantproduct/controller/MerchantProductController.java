package org.dcl.merchantproduct.controller;

import java.util.Scanner;
import org.dcl.merchantproduct.dao.MerchantDao;
import org.dcl.merchantproduct.dto.Merchant;

public class MerchantProductController {
	static Scanner sc=new Scanner(System.in);
	static MerchantDao mdao=new MerchantDao();
	public static void main(String[] args) {
		System.out.println("1. Save Merchant.");
		System.out.println("2. Update Merchant.");
		System.out.println("3. Find Merchant by ID.");
		System.out.println("4. Verify Mechant by emailId and Password.");
		System.out.println("5. Verify Merchant by Phone and Password.");
		System.out.println("Enter your choice ? ");
		int choice=sc.nextInt();
		switch (choice) {
			case 1:
				saveMerchant();
				break;
			case 2:
				updateMerchant();
				break;
			case 3:
				findMerchantById();
				break;
			case 4:
				verifyMerchantByEmailAndPassword();
				break;
			case 5:
				verifyMerchantByPhoneAndPassword();
				break;

			default:
				break;
		}
	}
	private static void saveMerchant() {
		System.out.println("Enter Merchant Name, GST number, Phone number, Email & Password :");
		Merchant m=new Merchant();
		m.setName(sc.next());
		m.setGstNum(sc.next());
		m.setPhone(sc.nextLong());
		m.setEmail(sc.next());
		m.setPassword(sc.next());
		Merchant mdb=mdao.saveMerchant(m);
		if(mdb!=null) {
			System.out.println("Merchant is saved with an id "+mdb.getId());
		}
		else {
			System.err.println("Error.");
		}
	}
	private static void updateMerchant() {
		System.out.println("Enter Merchant info(ID, Name, GST number, Phone number, Email & Password) to update :");
		Merchant m=new Merchant();
		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setGstNum(sc.next());
		m.setPhone(sc.nextLong());
		m.setEmail(sc.next());
		m.setPassword(sc.next());
		Merchant mdb=mdao.updateMerchant(m);
		if(mdb!=null) {
			System.out.println("Merchant updated with the credentials as "+mdb );
		}else {
			System.err.println("Unable to update since Merchant ID is invalid.");
		}
	}
	private static void findMerchantById() {
		System.out.println("Enter Merchant ID ? ");
		Merchant mdb=mdao.findMerchantById(sc.nextInt());
		if(mdb!=null) {
			System.out.println("Merchant Info : "+mdb);
		}else {
			System.err.println("No Merchant found since Merchant ID is invalid.");
		}
	}
	private static void verifyMerchantByEmailAndPassword() {
		System.out.println("Enter Merchant Email : ");
		String emailId=sc.next();
		System.out.println("Enter Merchant Password : ");
		String pwd=sc.next();
		Merchant mdb=mdao.verifyMerchantByEmailAndPassword(emailId,pwd);
		if(mdb!=null) {
			System.out.println("Merchant Info : "+mdb);
		}else {
			System.err.println("Invalid credentials.");
		}
	}
	private static void verifyMerchantByPhoneAndPassword() {
		System.out.println("Enter Merchant Phone Number : ");
		long phone=sc.nextLong();
		System.out.println("Enter Merchant Password : ");
		String pwd=sc.next();
		Merchant mdb=mdao.verifyMerchantByPhoneAndPassword(phone,pwd);
		if(mdb!=null) {
			System.out.println("Merchant Info : "+mdb);
		}else {
			System.err.println("Invalid credentials.");
		}
	}
}
