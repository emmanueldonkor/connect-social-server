package com.connect.world.server.model;

import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Post {

  private UUID id;
  private String post;
  private String name;
  private String email;
  private String image;
  private String file;
  private String profilePic;
  private String timeStamp;
  private String imageName;
}
