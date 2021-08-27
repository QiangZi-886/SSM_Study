package com.yang.mybatisplus.generatorTest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
    public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String username;

    private String password;

    private LocalDateTime creatTime;

    private LocalDateTime updateTime;

    private Integer version;

    private Integer status;

    private Integer deleted;


}
