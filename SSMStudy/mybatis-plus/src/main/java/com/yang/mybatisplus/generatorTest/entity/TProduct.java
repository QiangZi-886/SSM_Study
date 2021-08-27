package com.yang.mybatisplus.generatorTest.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
    public class TProduct implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    private Integer category;

    private Integer count;

    private String description;

    @TableField("userId")
    private Integer userid;


}
