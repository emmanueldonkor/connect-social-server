package com.connect.world.server.service;


import com.connect.world.server.model.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
  Post addPost(Post post) throws Exception;

  List<Post> getPost();

  void deletePostById(UUID id) throws Exception;
}
