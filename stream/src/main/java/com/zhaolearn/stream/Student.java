package com.zhaolearn.stream;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer num;
    private String name;
    public Student mapStudentDemo(){
        this.name=this.name+":mapStudentDemo";
        return this;
    }
    public String mapNameDemo(){
        this.name=this.name+":mapNameDemo";
        return this.name;
    }
}
