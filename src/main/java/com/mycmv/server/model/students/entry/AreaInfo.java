package com.mycmv.server.model.students.entry;


import com.mycmv.server.model.base.vo.PageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 地区
 * @author oudi
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AreaInfo extends PageVo {
	
	private Integer		areaCode;
	private String	areaName;
	private Integer		parentCode;
	private Integer		orderBy;
}
