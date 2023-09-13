package com.connect.world.server.controller;



import com.connect.world.server.model.Post;
import com.connect.world.server.model.Post;
import com.connect.world.server.service.PostService;
import com.connect.world.server.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/post")
public class PostController {

  private PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @PostMapping
  public Post addPost(@RequestParam Map<String,String> requestParams
  ) throws Exception {
    String strPost = requestParams.get("post");
    String email = requestParams.get("email");
    String name = requestParams.get("name");
    String file = requestParams.get("file");
    String profilePic = requestParams.get("profilePic");

    Post post = Post.builder()
      .file(file)
      .name(name)
      .email(email)
      .post(strPost)
      .profilePic(profilePic)
      .timeStamp(new Date().toString())
      .build();
    post = postService.addPost(post);
    return post;
  }

  @GetMapping
  public List<Post> getPost() {
    return postService.getPost();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTodoById(@PathVariable UUID id) throws Exception {
    postService.deletePostById(id);
    return ResponseEntity.noContent().build();
  }
}
