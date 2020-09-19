package com.stephen.learning.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author jack
 * @description
 * @date 2020/9/15 21:36
 */
@Data
@Builder
@AllArgsConstructor
public class UserVO {
   private String name;
   private String gender;
   private Date birthDate;
   private String email;
   private String address;
}
