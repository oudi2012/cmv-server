package com.mycmv.server.model.students.entry;


import lombok.Data;


/***
 * 班级
 * @author oudi
 *
 */
@Data
public class ClassInfo {
	private Integer classId;
	private String name;
	private Integer type;
}
