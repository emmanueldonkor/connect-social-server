package com.connect.world.server.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "posts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
  @Id
  @GeneratedValue
  private UUID id;
  @Lob
  private String post;
  private String name;
  private String email;
  @Lob
  private String image;
  private String profilePic;
  private String timeStamp;
  private String imageName;

}

