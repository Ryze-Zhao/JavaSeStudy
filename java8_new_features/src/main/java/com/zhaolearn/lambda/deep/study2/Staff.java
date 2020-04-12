package com.zhaolearn.lambda.deep.study2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Staff {
	private int id;
	private String name;
	private int age;
	private double salary;
	public Staff() {System.out.println("Staff().....");}
	public Staff(int id) {
		this.id = id;
		System.out.println("Staff(int id).....");
	}
	public Staff(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Staff(int id, String name, int age, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	/**
	 * 提供用于测试的数据
	 */
	public static List<Staff> listStaff(){
		List<Staff> list = new ArrayList<>();
		list.add(new Staff(1001, "普通家庭马化腾", 34, 6000.38));
		list.add(new Staff(1002, "悔创阿里杰克马", 12, 91));
		list.add(new Staff(1003, "不知妻美刘强东", 33, 3000.82));
		list.add(new Staff(1004, "北大还行撒贝宁", 26, 7657.37));
		list.add(new Staff(1005, "一无所有王健林", 65, 5555.32));
		list.add(new Staff(1006, "全家最丑刘亦菲", 42, 9500.43));
		list.add(new Staff(1007, "顺便赚钱丁三石", 26, 4333.32));
		list.add(new Staff(1008, "会打一点张继科", 35, 2500.32));
		return list;
	}
}
