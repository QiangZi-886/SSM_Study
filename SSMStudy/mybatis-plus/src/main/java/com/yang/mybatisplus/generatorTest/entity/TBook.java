package com.yang.mybatisplus.generatorTest.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yang
 * @since 2021-08-14
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class TBook implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String bookname;

    private String bookprice;


}
