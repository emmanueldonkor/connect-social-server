package com.connect.world.server.service;


import com.connect.world.server.entity.PostEntity;
import com.connect.world.server.model.Post;
import com.connect.world.server.repository.PostEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

  private PostEntityRepository postEntityRepository;

  public PostServiceImpl(PostEntityRepository postEntityRepository) {
    this.postEntityRepository = postEntityRepository;
  }

  @Override
  public Post addPost(Post post) throws Exception {
    try {
      PostEntity postEntity = new PostEntity();
      BeanUtils.copyProperties(post, postEntity);
      if (post.getFile() != null && !post.getFile().equalsIgnoreCase("null"))
        postEntity.setImage(post.getFile());
      else
        postEntity.setImage(null);

      postEntity = postEntityRepository.save(postEntity);

      post.setId(postEntity.getId());
      post.setFile(null);
      post.setImage(postEntity.getImage());

    } catch (Exception e) {
      throw new Exception("Could not save Post: " + e);
    }
    return post;
  }

  @Override
  public List<Post> getPost() {
    List<PostEntity> postEntities
      = postEntityRepository.findAll();

    /*List<Post> posts = new ArrayList<>();
    posts = postEntities.stream()
      .map((postEntity) ->
        Post.builder()
          .id(postEntity.getId())
          .timeStamp(postEntity.getTimeStamp())
          .email(postEntity.getEmail())
          .name(postEntity.getName())
          .post(postEntity.getPost())
          .image(postEntity.getImage())
          .profilePic(postEntity.getProfilePic())
          .build()
      ).collect(Collectors.toList());*/
    return postEntities.stream()
      .map(postEntity -> Post.builder()
        .id(postEntity.getId())
        .timeStamp(postEntity.getTimeStamp())
        .email(postEntity.getEmail())
        .name(postEntity.getName())
        .post(postEntity.getPost())
        .image(postEntity.getImage())
        .profilePic(postEntity.getProfilePic())
        .build())
      .collect(Collectors.toList());
  }
  @Override
  public void deletePostById(UUID id) throws Exception {
    Optional<PostEntity> post= postEntityRepository.findById(id);
    if(post.isPresent()){
      postEntityRepository.delete(post.get());
    }
    else{
      throw new Exception("The post can not be found"+ post);
    }
  }
}
