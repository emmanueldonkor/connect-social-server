package com.connect.world.server.service;


import com.connect.world.server.model.Post;

import java.util.List;

public interface PostService {
  Post addPost(Post post) throws Exception;

  List<Post> getPost();
}
