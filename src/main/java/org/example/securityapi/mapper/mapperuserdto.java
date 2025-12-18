package org.example.securityapi.mapper;

import org.example.securityapi.Entities.user;
import org.example.securityapi.dto.responsuserdto;

public class mapperuserdto {
 public static   responsuserdto userToDTO(user user)
   {
       responsuserdto DTo = new responsuserdto();
       DTo.setId(user.getId());
       DTo.setName(user.getUsername());
   return DTo;
   }
  public static user DTotouser(responsuserdto user)
   {
       user user1 = new user();
       user1.setId(user.getId());
       user1.setUsername(user.getName());
               return user1;
   }

}
